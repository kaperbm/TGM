package kbohaczyk;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Panel vom Trainer
 * @author Kacper Bohaczyk
 * @version 04-01-2023
 */
public class TrainerPanel extends JPanel {

    private JTextField text;
    private int richtig = 0;
    private int anzahl = 0;


    private JLabel label3 = new JLabel(String.valueOf(richtig));
    private JLabel label4 = new JLabel(String.valueOf(anzahl));

    private JLabel lImage;

    /**
     * Panel zum WortTrainer
     * @throws MalformedURLException
     */
    public TrainerPanel(Controller cont, WortTrainer model) throws MalformedURLException {
        this.setLayout(new BorderLayout());
        JPanel grid = new JPanel();
        JPanel grid2 = new JPanel();
        grid2.setLayout(new GridLayout(2,1));
        grid.setLayout(new GridLayout(3,3));



        //-------------------Erstellen der Komponente----------------------
        JButton button1 = new JButton("zurücksetzen");
        JButton button2 = new JButton("Wort hinzufügen");
        JButton button3 = new JButton("Speichern");
        JButton button4 = new JButton("Laden");
        JLabel label1 = new JLabel("Richtige Wörter");
        JLabel label2 = new JLabel("Anzahl Wörter");

        JLabel label5 = new JLabel("Welches Wort wird unten dargestellt (Eingabe zum Überprüfen)");
        text = new JTextField();

        //-------------------------Listeners-----------------------------

        button1.addActionListener(cont);
        button2.addActionListener(cont);
        button3.addActionListener(cont);
        button4.addActionListener(cont);
        text.addActionListener(cont);


        ImageIcon icon = new ImageIcon(new URL(model.WortZufall().getURL()));
        Image image = icon.getImage(); // umwandeln in ein Image-Objekt
        image = image.getScaledInstance(250, 250,  Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe
        lImage = new JLabel(new ImageIcon(image)); // anzeigen in einem JLabel

        //---------------------Hinzufügen der Komponente--------------------
        grid2.add(label5);
        grid2.add(text);
        this.add(grid2,BorderLayout.PAGE_START);
        this.add(lImage);
        grid.add(label1);
        grid.add(label3);
        grid.add(button1);
        grid.add(label2);
        grid.add(label4);
        grid.add(button2);
        grid.add(button3);
        grid.add(button4);
        this.add(grid,BorderLayout.PAGE_END);
    }
    public String getText() {
        return text.getText();
    }

    public void ifRichtig(){
        richtig++;
        anzahl++;
    }
    public void ifFalsch() {
        anzahl++;
    }
    public void zurücksetzen() {
        richtig = 0;
        anzahl = 0;
        this.label3.setText("" + richtig);
        this.label4.setText("" + anzahl);
    }

    public String getJText() {

        return text.getText();
    }

    public void update(String url) throws MalformedURLException {
        this.label3.setText("" + richtig);
        this.label4.setText("" + anzahl);

        ImageIcon icon = new ImageIcon(new URL(url));
        Image image = icon.getImage(); // umwandeln in ein Image-Objekt
        image = image.getScaledInstance(250, 250,  Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe
        this.lImage.setIcon(new ImageIcon(image));


    }

}
