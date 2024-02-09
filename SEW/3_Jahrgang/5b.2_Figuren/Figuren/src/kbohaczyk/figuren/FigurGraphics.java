package kbohaczyk.figuren;

import javax.swing.*;
import java.awt.*;

/**
 * Dieses Panel zeichnet die Figuren.
 * @author Kacper Bohaczyk
 * @version 19-01-2023
 */
public class FigurGraphics extends JPanel {
    private FigurenListe figList; // Da das Model mit der draw Methode extra
    // für das Zeichnen ausgelegt ist, gibt es
    // hier ausnahmsweise eine direkte Verbindung
    // von View zu Model

    /**
     * Erzeugt eine neue Zeichenumgebung ohne Rechtecke
     * @param figList Die FigurenListe, die für das Zeichnen
     * der Rechtecke herangezogen wird.
     */
    public FigurGraphics(FigurenListe figList) {
        this.figList = figList;
    }


    /**
     * Wird aufgerufen, wenn der Zeichenkontext verändert wird.
     * @param g die Zeichenumgebung
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        figList.draw(g);
    }
}