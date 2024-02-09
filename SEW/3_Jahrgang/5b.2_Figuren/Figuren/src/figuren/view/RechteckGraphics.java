package figuren.view;

import figuren.model.FigurenListe;

import javax.swing.*;
import java.awt.*;

/**
 * Dieses Panel zeichnet die Figuren.
 * @author Lisa Vittori
 * @version 2019-11-25
 */
public class RechteckGraphics extends JPanel {
  private FigurenListe figList; // Da das Model mit der draw Methode extra
                                // für das Zeichnen ausgelegt ist, gibt es
                                // hier ausnahmsweise eine direkte Verbindung
                                // von View zu Model

  /**
   * Erzeugt eine neue Zeichenumgebung ohne Rechtecke
   * @param figList Die FigurenListe, die für das Zeichnen
   * der Rechtecke herangezogen wird.
   */
  public RechteckGraphics(FigurenListe figList) {
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
