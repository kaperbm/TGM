package kbohaczyk.figuren;

import java.awt.Color;

/**
 * Stellt Konstanten zur Verwendung in der GUI für das
 * Rechteck-Beispiel zur Verfügung
 * @author Kacper Bohaczyk
 * @version 19-01-2023
 */
public interface Konstanten {
    /**
     * Eine Liste an Standard-Farben zur Verwendung in der GUI
     */
    Color[] FARBEN = {Color.BLACK, Color.BLUE, Color.RED,
            Color.GREEN, Color.YELLOW, Color.WHITE};
    /**
     * Eine Liste an Farbnamen. Die Namen stimmen mit den im
     * FARBEN-Array gespeicherten Farben überein.
     */
    String[] FARBNAMEN = {"schwarz", "blau", "rot",
            "grün", "gelb", "weiß"};
    String[] FORMEN = {"Rechteck","Dreieck","Kreis","Linie"};
    int ECKEN = 3;
}