package figuren.model;

import java.awt.*;

/**
 * Diese Klasse speichert ein Rechteck-Objekt
 * @author Lisa Vittori
 * @version 2019-11-25
 */
public class Rechteck {
    private int x;
    private int y;
    private int w;
    private int h;
    private Color farbe;

    /**
     * Erstellt ein neues Rechteck-Objekt.
     * @param x Abstand vom linken Rand
     * @param y Abstand von oben
     * @param w Breite des Rechtecks
     * @param h Höhe des Rechtecks
     * @param farbe Farbe des Rechtecks
     */
    public Rechteck(int x, int y, int w, int h, Color farbe) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.farbe = farbe;
    }

    /**
     * Setzt eine neuen Abstand vom linken Rand
     * @param x Abstand vom linken Rand
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gibt den Abstand vom linken Rand zurück
     * @return Der Abstand vom linken Rand.
     */
    public int getX() {
        return x;
    }

    /**
     * Setzt einen neuen Abstand vom oberen Rand
     * @param y Abstand vom oberen Rand
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gibt den Abstand vom oberen Rand zurück
     * @return Der Abstand vom oberen Rand
     */
    public int getY() {
        return y;
    }
    
    /**
     * Gibt die Breite des Rechtecks zurück
     * @return die Breite des Rechtecks
     */
    public int getWidth() {
      return w;
    }

    /**
     * Legt eine neue Breite für das Rechteck fest
     * @param w die neue Breite
     */
    public void setWidth(int w) {
      this.w = w;
    }

    /**
     * Gibt die Höhe des Rechtecks zurück
     * @return die Höhe des Rechtecks
     */
    public int getHeight() {
      return h;
    }

    /**
     * Legt eine neue Höhe für das Rechteck fest
     * @param h die neue Höhe
     */ 
    public void setHeight(int h) {
      this.h = h;
    }

    /**
     * Setzt eine neue Farbe
     * @param farbe eine neue Farbe für das Rechteck
     */
    public void setFarbe(Color farbe) {
        this.farbe = farbe;
    }

    /**
     * Gibt das gespeicherte Farb-Objekt zurück
     * @return die gespeicherte Farbe
     */
    public Color getFarbe() {
        return farbe;
    }

    /**
     * Zeichnet ein Rechteck entsprechend den gespeicherten Attributen 
     * @param g eine Zeichenumgebung
     */
    public void draw(Graphics g) {
      g.setColor(farbe);
      g.fillRect(x, y, w, h);
    }

    /**
     * Gibt eine Beschreibung der Klasse als String zurück.
     * @return Die Beschreibung der Klasse
     */
    @Override
    public String toString() {
        String s = "(" + x + " / " + y + ") " + w + " x " + h+ " Farbe: 0x" + Integer.toHexString(farbe.getRGB());
        return s;
    }
}