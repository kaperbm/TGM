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


# Bildtransformationen definieren
transformationen = transforms.Compose([
    transforms.Resize((150, 150)),
    transforms.ToTensor(),
])

# Pfade zu den Ordnern mit den Bildern definieren
ordner1 = '/home/kacper/Desktop/dasi1/extracted_images/+'
ordner2 = '/home/kacper/Desktop/dasi1/extracted_images/0'

# Trainingsdaten laden: 20 Bilder aus Ordner 1 und Ordner 2
datensatz1_train = EigenerDatensatz(ordner1, 20, transformationen=transformationen)
datensatz2_train = EigenerDatensatz(ordner2, 20, transformationen=transformationen)

# Validierungsdaten laden: 10 Bilder aus Ordner 1 und Ordner 2
datensatz1_val = EigenerDatensatz(ordner1, 10, transformationen=transformationen)
datensatz2_val = EigenerDatensatz(ordner2, 10, transformationen=transformationen)

# Datensätze kombinieren
train_datensatz = torch.utils.data.ConcatDataset([datensatz1_train, datensatz2_train])
val_datensatz = torch.utils.data.ConcatDataset([datensatz1_val, datensatz2_val])

# DataLoader für Training und Validierung
batch_size = 1
train_loader = DataLoader(train_datensatz, batch_size=batch_size, shuffle=True)
val_loader = DataLoader(val_datensatz, batch_size=batch_size, shuffle=False)


# Definition des neuronalen Netzwerks
class EigeneCNN(nn.Module):
    def __init__(self, versteckte_schichten):
        super(EigeneCNN, self).__init__()
        self.conv_schichten = nn.Sequential(
            nn.Conv2d(3, 32, kernel_size=3),
            nn.ReLU(),
            nn.MaxPool2d(2, 2),
            nn.Conv2d(32, 64, kernel_size=3),
            nn.ReLU(),
            nn.MaxPool2d(2, 2),
            nn.Conv2d(64, 64, kernel_size=3),
            nn.ReLU(),
        )
        self.flatten = nn.Flatten()
        self.fc_schichten = None
        self.versteckte_schichten = versteckte_schichten
        self.ausgabeschicht = nn.Linear(64, 1)
        self.sigmoid = nn.Sigmoid()

    def _initialisiere_fc_schichten(self, x):
        eingabe_merkmale = x.size(1)
        schichten = nn.Sequential()
        for i in range(self.versteckte_schichten):
            schichten.add_module(f"fc_{i}", nn.Linear(eingabe_merkmale, 64))
            schichten.add_module(f"relu_{i}", nn.ReLU())
            eingabe_merkmale = 64
        return schichten

    def forward(self, x):
        x = self.conv_schichten(x)
        x = self.flatten(x)
        if self.fc_schichten is None:
            self.fc_schichten = self._initialisiere_fc_schichten(x)
            self.fc_schichten = self.fc_schichten.to(
                x.device)  # Sicherstellen, dass die Schichten auf dem gleichen Gerät sind
        x = self.fc_schichten(x)
        x = self.ausgabeschicht(x)
        return self.sigmoid(x)


# Trainings- und Evaluationsschleife
def trainiere_und_bewerte(versteckte_schichten, train_loader, val_loader, geraet):
    print(f"\nModell mit {versteckte_schichten} versteckten Schicht(en) trainieren...")

    # Modell, Verlustfunktion und Optimierer initialisieren
    modell = EigeneCNN(versteckte_schichten).to(geraet)
    kriterium = nn.BCELoss()
    optimierer = optim.Adam(modell.parameters(), lr=0.001)

    # Trainingsschleife
    for epoche in range(10):  # 10 Epochen trainieren
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

        print(f"Epoche {epoche + 1}, Trainingsverlust: {train_verlust / len(train_loader):.4f}")

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
    print(f"Validierungsverlust: {val_verlust / len(val_loader):.4f}, Validierungsgenauigkeit: {val_genauigkeit:.4f}\n")


# Hauptausführung
geraet = torch.device('cuda' if torch.cuda.is_available() else 'cpu')

# Nur 5 versteckte Schichten verwenden
versteckte_schichten = 5
trainiere_und_bewerte(versteckte_schichten, train_loader, val_loader, geraet)
