package kbohaczyk.figuren;

import java.awt.*;

/**
 * Diese Klasse speichert ein Rechteck-Objekt
 * @author Kacper Bohaczyk
 * @version 19-01-2023
 */
public class Rechteck extends Figur{
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
