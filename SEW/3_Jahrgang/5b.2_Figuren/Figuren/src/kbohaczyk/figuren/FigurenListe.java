package kbohaczyk.figuren;
import java.awt.*;

/**
 * Verwaltet die Liste an figurenn
 * @author Kacper Bohaczyk
 * @version 19-01-2023
 */
public class FigurenListe {
    private Figur[] figuren;
    // um die Farben zu verwalten, static da diese für alle Panel-Objekte
    // ident sind, final damit sie nicht geändert werden können.
    public static final Color[] FARBEN = {Color.BLACK, Color.BLUE, Color.RED,
            Color.GREEN, Color.YELLOW, Color.WHITE};
    public static final String[] FARBNAMEN = {"schwarz", "blau", "rot",
            "grün", "gelb", "weiß"};

    /**
     * Erstellt eine neue FigurenListe ohne figuren
     */
    public FigurenListe() {
        figuren = new Rechteck[0];
    }

    /**
     * Fügt der Zeichenumgebung ein neues Rechteck hinzu
     * @param f das neue Rechteck
     */
    public void addFigur(Figur f) {
        boolean save = false;
        for(int i = 0; i < figuren.length && !save; i++) {
            if(figuren[i] == null) {
                figuren[i] = f;
                save = true;
            }
        }
        if(!save) {
            Figur[] temp = new Figur[figuren.length+1];
            for(int i = 0; i < figuren.length; i++) {
                temp[i] = figuren[i];
            }
            temp[temp.length-1] = f;
            figuren = temp;
        }
    }

    /**
     * Gibt die gespeicherten figuren als String-Array zurück.
     * @return die gespeicherten figuren
     */
    public String[] textListe() {
        String[] tl = new String[figuren.length];
        for(int i = 0; i < figuren.length; i++) {
            tl[i] = i + " " + figuren[i].toString();
        }
        return tl;
    }

    /**
     * Gibt das zuletzt gespeicherte Rechteck zurück
     * @return der Texteintrag mit vorangestelltem Index des zuletzt gespeicherten Rechtecks
     */
    public String letzeFigur() {
        return (figuren.length-1) + " " + figuren[figuren.length-1].toString();
    }

    /**
     * Zeichnet alle gespeicherten figuren auf das übergebene
     * Graphics-Objekt
     * @param g der Zeichenkontext
     */
    public void draw(Graphics g) {
        for(int i = 0; i < figuren.length; i++) {
            if(figuren[i] != null) {
                figuren[i].draw(g);
            }
        }
    }

    /**
     * Löscht alle Einträge in der Liste
     */
    public void clear() {
        figuren = new Figur[0];
    }
}