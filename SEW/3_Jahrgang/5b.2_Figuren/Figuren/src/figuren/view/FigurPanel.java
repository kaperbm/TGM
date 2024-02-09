package figuren.view;

import figuren.controller.FigurController;
import figuren.model.*;
import javax.swing.*;
import java.awt.*;

/**
 * Erzeugt das Layout für das Figuren-Zeichenprogramm
 * @author Lisa Vittori
 * @version 2019-11-25
 */
public class FigurPanel extends JPanel {
  private RechteckGraphics graphics;
  private JLabel[] lWerte;
  private JTextField[] tfWerte;
  private JList lRechtecke; // Warnung ignorieren (außer du kennst dich mit Generics aus)
  private DefaultListModel lmodRechtecke; // Warnung ignorieren (außer du kennst dich mit Generics aus)
  private JComboBox cbFarben; // Warnung ignorieren (außer du kennst dich mit Generics aus)
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

    graphics = new RechteckGraphics(figList);
    this.add(graphics);

    // Bereich für die Eingabe-Werte
    JPanel pWerte = new JPanel(new GridLayout(6, 2));
    lWerte = new JLabel[]{new JLabel("x"), new JLabel("y"), 
        new JLabel("Breite"), new JLabel("Höhe"), new JLabel("Farbe")};
    tfWerte = new JTextField[lWerte.length-1];
    int i;
    for(i = 0; i < tfWerte.length; i++) {
      tfWerte[i] = new JTextField();
      pWerte.add(lWerte[i]);
      pWerte.add(tfWerte[i]);
    }
    pWerte.add(lWerte[i]); // Beschriftung für die Farben
    // Warnung fürs erste ignorieren (außer du kennst dich mit Generics aus)
    cbFarben = new JComboBox(Konstanten.FARBNAMEN); 
    pWerte.add(cbFarben);
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
   * Wandelt einen im tfWerte-Array gespeicherten Wert in eine int-Zahl um
   * @param index der Index des Textfeldes im tfWerte-Array, dessen Eingabe
   *  umgewandelt werden soll.
   * @return die Eingabe als int oder -1 im Fehlerfall
   */
  private int intInput(int index) {
    int i = -1;
    try {
      i = Integer.parseInt(tfWerte[index].getText());
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

  /**
   * Setzt die Oberfläche zurück
   */
  public void clear() {
    for(int i = 0; i < tfWerte.length; i++) {
      tfWerte[i].setText("");
    }
    cbFarben.setSelectedIndex(0);
    lmodRechtecke.clear();
  }
}
