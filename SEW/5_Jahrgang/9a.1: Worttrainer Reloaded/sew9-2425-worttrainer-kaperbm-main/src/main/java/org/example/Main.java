package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Rechtschreibtrainer trainer = new Rechtschreibtrainer();
        JsonPersistenceStrategy persistence = new JsonPersistenceStrategy();
        String filePath = "trainerData.json";

        // Überprüfen, ob die Datei existiert, um Daten zu laden
        File file = new File(filePath);
        if (file.exists()) {
            try {
                trainer = persistence.load(filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Initiale Wort-Bild-Paare hinzufügen, wenn keine Datei existiert
            trainer.addWortBildPaar("charmander", "https://assets.pokemon.com/assets/cms2/img/pokedex/full//004.png");
            trainer.addWortBildPaar("Bulbasaur", "https://assets.pokemon.com/assets/cms2/img/pokedex/full//001.png");
            trainer.addWortBildPaar("Squirtle", "https://assets.pokemon.com/assets/cms2/img/pokedex/full//007.png");
        }

        // Erstellen des Hauptfensters
        JFrame frame = new JFrame("Rechtschreibtrainer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel für die Anzeige des Bildes und der Eingabeaufforderung
        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);

        // Statistik-Panel erstellen und hinzufügen
        JPanel statistikPanel = new JPanel();
        statistikPanel.setLayout(new BoxLayout(statistikPanel, BoxLayout.Y_AXIS));
        JLabel gesamtVersucheLabel = new JLabel("Gesamte Versuche: " + trainer.getGesamteVersuche());
        JLabel richtigeVersucheLabel = new JLabel("Richtige Versuche: " + trainer.getRichtigeVersuche());
        JLabel falscheVersucheLabel = new JLabel("Falsche Versuche: " + trainer.getFalscheVersuche());
        statistikPanel.add(gesamtVersucheLabel);
        statistikPanel.add(richtigeVersucheLabel);
        statistikPanel.add(falscheVersucheLabel);
        frame.add(statistikPanel, BorderLayout.EAST); // Statistik auf der rechten Seite anzeigen

        // Eingabefeld und Bild anzeigen
        JLabel imageLabel = new JLabel();
        JTextField textField = new JTextField(10);
        panel.add(imageLabel);
        panel.add(textField);

        // Wähle ein zufälliges Wort-Bild-Paar und zeige es an
        trainer.waehleZufall();
        updateImageAndFields(trainer, imageLabel, textField);

        // Schaltfläche für die Überprüfung der Eingabe
        JButton pruefenButton = new JButton("Überprüfen");
        panel.add(pruefenButton);

        Rechtschreibtrainer finalTrainer = trainer;
        pruefenButton.addActionListener(e -> {
            String eingabe = textField.getText().trim(); // Eingabe des Benutzers

            if (eingabe.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bitte gib ein Wort ein."); // Warnung, wenn das Feld leer ist
                return;
            }

            // Überprüfen der Antwort und Aktualisieren der Statistik
            boolean isRichtig = finalTrainer.pruefeAntwort(eingabe);
            String nachricht = isRichtig ? "Richtig!" : "Falsch! Das richtige Wort ist: " + finalTrainer.getAktuellesPaar().getWort();
            JOptionPane.showMessageDialog(frame, nachricht);

            // Statistiklabels aktualisieren
            gesamtVersucheLabel.setText("Gesamte Versuche: " + finalTrainer.getGesamteVersuche());
            richtigeVersucheLabel.setText("Richtige Versuche: " + finalTrainer.getRichtigeVersuche());
            falscheVersucheLabel.setText("Falsche Versuche: " + finalTrainer.getFalscheVersuche());

            // Neues zufälliges Bild auswählen und anzeigen
            finalTrainer.waehleZufall();
            updateImageAndFields(finalTrainer, imageLabel, textField);
        });

        // Fenstergröße anpassen und anzeigen
        frame.pack();
        frame.setVisible(true);

        // Persistieren der Daten beim Programmende
        Rechtschreibtrainer finalTrainer1 = trainer;
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                persistence.save(finalTrainer1, filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }

    // Methode zum Aktualisieren des Bildes und Leeren des Eingabefelds
    private static void updateImageAndFields(Rechtschreibtrainer trainer, JLabel imageLabel, JTextField textField) {
        TrainingsDaten aktuellesPaar = trainer.getAktuellesPaar();
        ImageIcon imageIcon = new ImageIcon(aktuellesPaar.getUrl());
        imageLabel.setIcon(imageIcon);
        textField.setText("");
    }
}
