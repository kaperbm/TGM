package kbohaczyk.figuren;

import javax.swing.*;
import java.awt.*;

/**
 * Erzeugt das Layout für das Figuren-Zeichenprogramm
 * @author Kacper Bohaczyk
 * @version 19-01-2023
 */
public class FigurPanel extends JPanel {
    private FigurGraphics graphic;
    private JLabel[] lWerte;
    private JTextField[] textWerte;
    private JList lRechtecke; // Warnung ignorieren (außer du kennst dich mit Generics aus)
    private DefaultListModel lmodRechtecke; // Warnung ignorieren (außer du kennst dich mit Generics aus)
    private JComboBox cbFarben; // Warnung ignorieren (außer du kennst dich mit Generics aus)
    private JComboBox cbArt;
    private JButton bAdd, bClear;

    /**
     * Erzeugt ein Layout, welches die Rechtecke darstellen kann und
     * entsprechende Komponenten beinhaltet, um die Daten für die Rechtecke
     * eingeben zu können.
     * @param figList das Model zur Verwaltung der Rechtecke
     * @param controller der Controller zur Ablaufsteuerung
     */
    public FigurPanel(FigurenListe figList, FigurController controller) {
        this.setLayout(new BorderLayout());

        graphic = new FigurGraphics(figList);
        this.add(graphic);

        // Bereich für die Eingabe-Werte
        JPanel pWerte = new JPanel(new GridLayout(7, 2));
        lWerte = new JLabel[]{new JLabel("x"), new JLabel("y"),
                new JLabel("Breite"), new JLabel("Höhe"), new JLabel("Farbe")};
        textWerte = new JTextField[lWerte.length-1];
        int i;
        for(i = 0; i < textWerte.length; i++) {
            textWerte[i] = new JTextField();
            pWerte.add(lWerte[i]);
            pWerte.add(textWerte[i]);
        }
        pWerte.add(lWerte[i]); // Beschriftung für die Farben
        // Warnung fürs erste ignorieren (außer du kennst dich mit Generics aus)
        cbFarben = new JComboBox(Konstanten.FARBNAMEN);
        pWerte.add(cbFarben);
        this.cbArt = new JComboBox(Konstanten.FORMEN);
        this.cbArt.addActionListener(e -> controller.dropDownListener());
        pWerte.add(new JLabel("Figur"));
        pWerte.add(this.cbArt);
        bAdd = new JButton("Hinzufügen");
        bAdd.setActionCommand("add");
        bAdd.addActionListener(controller);
        pWerte.add(bAdd);
        bClear = new JButton("Zurücksetzen");
        bClear.setActionCommand("clear");
        bClear.addActionListener(controller);
        pWerte.add(bClear);

        // rechter Bereich
        JPanel pRechts = new JPanel(new BorderLayout());
        pRechts.add(pWerte, BorderLayout.PAGE_START);
        // Warnungen fürs erste ignorieren (außer du kennst dich mit Generics aus)
        lRechtecke = new JList();
        lRechtecke.setLayoutOrientation(JList.VERTICAL);
        lmodRechtecke = new DefaultListModel();
        lRechtecke.setModel(lmodRechtecke);
        pRechts.add(lRechtecke);
        this.add(pRechts, BorderLayout.LINE_END);
    }

    /**
     * Wandelt einen im textWerte-Array gespeicherten Wert in eine int-Zahl um
     * @param index der Index des Textfeldes im textWerte-Array, dessen Eingabe
     * umgewandelt werden soll.
     * @return die Eingabe als int oder -1 im Fehlerfall
     */
    private int intInput(int index) {
        int i = -1;
        try {
            i = Integer.parseInt(textWerte[index].getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Nur numerische Werte bei Eingabe-Feldern erlaubt!");
        }
        return i;
    }

    /**
     * Gibt den eingegebenen x-Wert als int zurück.
     * @return die Eingabe als int oder -1 im Fehlerfall
     */
    public int getXEingabe() {
        return this.intInput(0);
    }

    /**
     * Gibt den eingegebenen y-Wert als int zurück.
     * @return die Eingabe als int oder -1 im Fehlerfall
     */
    public int getYEingabe() {
        return this.intInput(1);
    }

    /**
     * Gibt die eingegebene Breite als int zurück.
     * @return die Eingabe als int oder -1 im Fehlerfall
     */
    public int getBreite() {
        return this.intInput(2);
    }

    /**
     * Gibt die eingegebene Höhe als int zurück.
     * @return die Eingabe als int oder -1 im Fehlerfall
     */
    public int getHoehe() {
        return this.intInput(3);
    }

    /**
     * Gibt die ausgewählte Farbe zurück
     * @return die ausgewählte Farbe
     */
    public Color getFarbe() {
        return Konstanten.FARBEN[cbFarben.getSelectedIndex()];
    }

    /**
     * Fügt einen Eintrag zur Rechteck-Auflistung hinzu
     * @param eintrag Text der zur Rechteck-Auflistung hinzugefügt wird
     */
    public void eintragHinzufuegen(String eintrag) {
        lmodRechtecke.addElement(eintrag); // Warnung ignorieren (außer du kennst dich mit Generics aus)
    }



    public void setGraphic(FigurGraphics graphic) {
        this.graphic = graphic;
    }

    public JLabel[] getlWerte() {
        return lWerte;
    }

    public void setlWerte(JLabel[] lWerte) {
        this.lWerte = lWerte;
    }

    public JTextField[] getTextWerte() {
        return textWerte;
    }

    public void setTextWerte(JTextField[] textWerte) {
        this.textWerte = textWerte;
    }

    public JList getlRechtecke() {
        return lRechtecke;
    }

    public void setlRechtecke(JList lRechtecke) {
        this.lRechtecke = lRechtecke;
    }

    public DefaultListModel getLmodRechtecke() {
        return lmodRechtecke;
    }

    public void setLmodRechtecke(DefaultListModel lmodRechtecke) {
        this.lmodRechtecke = lmodRechtecke;
    }

    public JComboBox getCbFarben() {
        return cbFarben;
    }

    public void setCbFarben(JComboBox cbFarben) {
        this.cbFarben = cbFarben;
    }

    public JComboBox getCbArt() {
        return cbArt;
    }

    public void setCbArt(JComboBox cbArt) {
        this.cbArt = cbArt;
    }

    public JButton getbAdd() {
        return bAdd;
    }

    public void setbAdd(JButton bAdd) {
        this.bAdd = bAdd;
    }

    public JButton getbClear() {
        return bClear;
    }

    public void setbClear(JButton bClear) {
        this.bClear = bClear;
    }

    /**
     * Setzt die Oberfläche zurück
     */
    public void clear() {
        for(int i = 0; i < textWerte.length; i++) {
            textWerte[i].setText("");
        }
        cbFarben.setSelectedIndex(0);
        lmodRechtecke.clear();
    }
}
