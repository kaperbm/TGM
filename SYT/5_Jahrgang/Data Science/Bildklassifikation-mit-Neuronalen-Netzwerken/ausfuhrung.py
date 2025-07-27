import torch
import torch.nn as nn
import torch.optim as optim
from torchvision import transforms
from torch.utils.data import DataLoader, Dataset
from PIL import Image
import os

# Hilfsfunktion zur Erstellung eines PyTorch-Datensatzes
class EigenerDatensatz(Dataset):
    def __init__(self, ordner, anzahl_bilder, transformationen=None):
        self.bild_dateien = [f for f in os.listdir(ordner) if f.endswith(('.png', '.jpg', '.jpeg'))][:anzahl_bilder]
        self.ordner = ordner
        self.label = 0 if '0' in ordner else 1
        self.transformationen = transformationen

    def __len__(self):
        return len(self.bild_dateien)

    def __getitem__(self, index):
        bild_pfad = os.path.join(self.ordner, self.bild_dateien[index])
        bild = Image.open(bild_pfad).convert('RGB')
        if self.transformationen:
            bild = self.transformationen(bild)
        return bild, self.label

# Pfade zu den Ordnern mit den Bildern definieren
ordner1 = '/home/kacper/Desktop/dasi1/extracted_images/+'
ordner2 = '/home/kacper/Desktop/dasi1/extracted_images/0'

# Transformationen definieren
transformationen = transforms.Compose([
    transforms.Resize((150, 150)),
    transforms.ToTensor(),
])

# Trainingsdaten laden
datensatz1_train = EigenerDatensatz(ordner1, 20, transformationen)
datensatz2_train = EigenerDatensatz(ordner2, 20, transformationen)

# Validierungsdaten laden
datensatz1_val = EigenerDatensatz(ordner1, 10, transformationen)
datensatz2_val = EigenerDatensatz(ordner2, 10, transformationen)

# Datensätze kombinieren
train_datensatz = torch.utils.data.ConcatDataset([datensatz1_train, datensatz2_train])
val_datensatz = torch.utils.data.ConcatDataset([datensatz1_val, datensatz2_val])

# DataLoader für Training und Validierung
batch_size = 1
train_loader = DataLoader(train_datensatz, batch_size=batch_size, shuffle=True)
val_loader = DataLoader(val_datensatz, batch_size=batch_size, shuffle=False)

# Definition des neuronalen Netzwerks
class EinfachCNN(nn.Module):
    def __init__(self):
        super(EinfachCNN, self).__init__()
        self.conv_schichten = nn.Sequential(
            nn.Conv2d(3, 32, kernel_size=3),
            nn.ReLU(),
            nn.MaxPool2d(2, 2),
            nn.Conv2d(32, 64, kernel_size=3),
            nn.ReLU(),
            nn.MaxPool2d(2, 2),
            nn.Conv2d(64, 64, kernel_size=3),
            nn.ReLU()
        )
        self.fc_schichten = None

    def forward(self, x):
        x = self.conv_schichten(x)
        x = torch.flatten(x, 1)  # Flatten, wobei die Batch-Größe beibehalten wird
        if self.fc_schichten is None:
            self.fc_schichten = nn.Sequential(
                nn.Linear(x.size(1), 64),  # Dynamische Bestimmung der Eingabegröße
                nn.ReLU(),
                nn.Linear(64, 1),
                nn.Sigmoid()
            ).to(x.device)
        x = self.fc_schichten(x)
        return x

# Modell, Verlustfunktion und Optimierer initialisieren
geraet = torch.device('cuda' if torch.cuda.is_available() else 'cpu')
modell = EinfachCNN().to(geraet)
kriterium = nn.BCELoss()
optimierer = optim.Adam(modell.parameters(), lr=0.001)

# Trainingsschleife
epoche_anzahl = 150
for epoche in range(epoche_anzahl):
    modell.train()
    train_verlust = 0.0
    for bilder, labels in train_loader:
        bilder, labels = bilder.to(geraet), labels.to(geraet).float().view(-1, 1)

        optimierer.zero_grad()
        ausgaben = modell(bilder)
        verlust = kriterium(ausgaben, labels)
        verlust.backward()
        optimierer.step()

        train_verlust += verlust.item()

    print(f"Epoche {epoche+1}/{epoche_anzahl}, Trainingsverlust: {train_verlust / len(train_loader):.4f}")

# Validierungsschleife
modell.eval()
val_verlust = 0.0
korrekt = 0
gesamt = 0
with torch.no_grad():
    for bilder, labels in val_loader:
        bilder, labels = bilder.to(geraet), labels.to(geraet).float().view(-1, 1)
        ausgaben = modell(bilder)
        verlust = kriterium(ausgaben, labels)
        val_verlust += verlust.item()

        vorhersagen = (ausgaben > 0.5).float()
        korrekt += (vorhersagen == labels).sum().item()
        gesamt += labels.size(0)

val_genauigkeit = korrekt / gesamt
print(f"\nEndgültige Validierungsgenauigkeit: {val_genauigkeit:.4f}, Endgültiger Validierungsverlust: {val_verlust / len(val_loader):.4f}")
