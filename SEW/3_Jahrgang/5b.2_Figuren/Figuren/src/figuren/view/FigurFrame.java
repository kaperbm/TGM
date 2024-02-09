package figuren.view;

import javax.swing.*;
import java.awt.*;

/**
 * Basis-Darstellungsfenster für das Figuren-Programm
 * @author Lisa Vittori
 * @version 2019-11-25
 */
public class FigurFrame extends JFrame {
  /**
   * Initialisert ein Basis-Fenster mit dem angegebenen Titel und einem
   * Container, der den Inhalt repräsentiert. Die Größe wird an den Inhalt
   * angepasst. Dabei kann über resizable angegeben werden, ob die Größe
   * noch nachträglich verändert werden kann.
   * @param titel Der Titel des Fensters
   * @param content Der im Fenster angezeigte Inhalt
   * @param resizable Gibt an, ob die Größe verändert werden kann.
   */
  public FigurFrame(String titel, Container content, boolean resizable) {
    super(titel);
    this.add(content);
    this.setResizable(resizable); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
  
  /**
   * Initialisert ein Basis-Fenster mit dem angegebenen Titel und einem
   * Container, der den Inhalt repräsentiert. Die Größe wird an den Inhalt
   * angepasst. Dabei kann die Größe noch nachträglich verändert werden.
   * @param titel Der Titel des Fensters
   * @param content Der im Fenster angezeigte Inhalt
   */
  public FigurFrame(String titel, Container content) {
    this(titel, content, true);
  }
  
  /**
   * Initialisert ein Basis-Fenster mit dem angegebenen Titel und einem
   * Container, der den Inhalt repräsentiert. Die Größe wird über width
   * und height bestimmt. Dabei kann über resizable angegeben werden, ob 
   * die Größe noch nachträglich verändert werden kann.
   * @param titel Der Titel des Fensters
   * @param content Der im Fenster angezeigte Inhalt
   * @param resizable Gibt an, ob die Größe verändert werden kann.
   * @param width Die Breite des Fensters
   * @param height Die Höhe des Fensters
   */
  public FigurFrame(String titel, Container content, boolean resizable, int width, int height) {
    this(titel, content, resizable);
    this.setSize(width, height);
    this.setLocationRelativeTo(null);
  }
  
  /**
   * Initialisert ein Basis-Fenster mit dem angegebenen Titel und einem
   * Container, der den Inhalt repräsentiert. Die Größe wird über width
   * und height bestimmt. Dabei kann die Größe noch nachträglich verändert 
   * werden.
   * @param titel Der Titel des Fensters
   * @param content Der im Fenster angezeigte Inhalt
   * @param width Die Breite des Fensters
   * @param height Die Höhe des Fensters
   */
  public FigurFrame(String titel, Container content, int width, int height) {
    this(titel, content, true, width, height);
  }
}
