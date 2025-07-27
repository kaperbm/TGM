# README

**author** Kacper Bohaczyk
**version** 18 Sep 2024

---
## Rechtschreibtrainer

Ein Java-basiertes Rechtschreibtrainer-Programm, das Benutzern hilft, ihre Rechtschreibfähigkeiten zu verbessern, indem es sie auffordert, das richtige Wort zu einem angezeigten Bild einzugeben. Das Programm verwendet eine grafische Benutzeroberfläche (GUI) und speichert die Benutzerstatistiken in einer JSON-Datei.
Inhaltsverzeichnis

    Projektbeschreibung
    Funktionen
    Code-Struktur
    Verwendung
    JUnit Tests
    Technologien
    Installation
    Lizenz

## Projektbeschreibung

Der Rechtschreibtrainer zeigt zufällig ausgewählte Wort-Bild-Paare an, z. B. Pokémon-Namen und deren Bilder. Benutzer müssen das korrekte Wort eingeben, und das Programm überprüft die Eingabe und aktualisiert die Statistik über richtige und falsche Versuche. Bei jedem Programmstart werden die Statistiken aus einer JSON-Datei geladen und am Ende des Programms gespeichert.
Funktionen

    Zufällige Auswahl von Wort-Bild-Paaren: Das Programm wählt zufällig ein Wort-Bild-Paar aus einer Liste aus.
    Benutzereingabe: Benutzer geben das Wort ein, das zum Bild gehört.
    Statistik: Das Programm verfolgt die Anzahl der Versuche, richtigen Antworten und falschen Antworten.
    Datenpersistenz: Die Benutzerdaten werden in einer JSON-Datei gespeichert, sodass sie bei zukünftigen Starts wiederhergestellt werden können.
    Grafische Benutzeroberfläche: Die Anwendung bietet eine intuitive GUI, die die Interaktion erleichtert.

## Code-Struktur

Hier ist eine Übersicht der wichtigsten Klassen im Projekt:
1. Main

Die Hauptklasse des Programms, die die Benutzeroberfläche erstellt und den Rechtschreibtrainer initialisiert.

java

public class Main {
    public static void main(String[] args) {
        Rechtschreibtrainer trainer = new Rechtschreibtrainer();
        // Code zur Initialisierung und GUI-Einrichtung
    }
}

2. Rechtschreibtrainer

Diese Klasse verwaltet die Wort-Bild-Paare und die Benutzerstatistiken. Sie enthält Methoden zum Hinzufügen von Paaren, Überprüfen der Eingaben und Auswählen zufälliger Paare.

java

public class Rechtschreibtrainer {
    private List<TrainingsDaten> trainingsDatenListe;
    // Methoden wie addWortBildPaar(), waehleZufall(), pruefeAntwort(), etc.
}

3. TrainingsDaten

Eine einfache Datenklasse, die ein Wort und die zugehörige Bild-URL speichert.

java

public class TrainingsDaten {
    private String wort;
    private URL url;
    // Getter und Setter für wort und url
}

4. JsonPersistenceStrategy

Diese Klasse ist verantwortlich für das Speichern und Laden von Daten in/from einer JSON-Datei. Sie implementiert die Schnittstelle PersistenceStrategy.

java

public class JsonPersistenceStrategy {
    public void save(Rechtschreibtrainer trainer, String filePath) throws IOException {
        // Implementierung zur Speicherung der Daten in einer JSON-Datei
    }

    public Rechtschreibtrainer load(String filePath) throws Exception {
        // Implementierung zum Laden der Daten aus einer JSON-Datei
    }
}

5. PersistenceStrategy

Eine Schnittstelle, die die Methoden für das Speichern und Laden von Daten definiert.

java

public interface PersistenceStrategy {
    void save(Rechtschreibtrainer trainer, String fileName) throws IOException;
    Rechtschreibtrainer load(String fileName) throws IOException;
}

Verwendung

    Programm starten: Führen Sie die Main-Klasse aus, um das Programm zu starten. Die GUI öffnet sich.
    Wort eingeben: Sehen Sie sich das angezeigte Bild an und geben Sie das korrekte Wort in das Eingabefeld ein.
    Ergebnisse überprüfen: Klicken Sie auf die Schaltfläche „Überprüfen“, um zu sehen, ob Ihre Antwort korrekt ist.
    Statistiken einsehen: Die Anwendung zeigt die Anzahl der gesamten Versuche, richtigen und falschen Antworten an.

JUnit Tests

Das Projekt enthält auch JUnit-Tests zur Sicherstellung der Funktionalität des Rechtschreibtrainer. Die Tests überprüfen folgende Punkte:

    Hinzufügen von Wort-Bild-Paaren
    Überprüfung der Benutzerantworten
    Statistiken nach mehreren Versuchen

Die Tests sind in der Klasse RechtschreibtrainerTest implementiert.
Technologien

    Java: Programmiersprache, die für die Entwicklung verwendet wird.
    JUnit: Test-Framework für Unit-Tests.
    JSON: Format zur Datenpersistenz.
    Swing: Bibliothek für die Erstellung der grafischen Benutzeroberfläche.

Installation

    Repository klonen:

    bash

git clone https://github.com/DeinBenutzername/rechtschreibtrainer.git
cd rechtschreibtrainer

Maven-Abhängigkeiten installieren (falls verwendet): Wenn Sie Maven verwenden, führen Sie den folgenden Befehl aus:

bash

    mvn clean install

    Programm starten: Kompilieren und führen Sie die Main-Klasse aus, um das Programm zu starten.

Lizenz

Dieses Projekt ist unter der MIT-Lizenz lizenziert. Weitere Informationen finden Sie in der LICENSE-Datei.
