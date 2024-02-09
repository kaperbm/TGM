package kbohaczyk.figuren;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

/**
 * Ablaufsteuerung für das Rechteck-Zeichen-Beispiel
 * @author Kacper Bohaczyk
 * @version 19-01-2023
 */
public class FigurController implements ActionListener {
    private FigurPanel panel;
    private FigurenListe liste;

    /**
     * Erzeugt die Objekte für View und Model
     */
    public FigurController() {
        liste = new FigurenListe();
        panel = new FigurPanel(liste, this);
        new FigurFrame("Figuren", panel, 1000, 700);

    }

    public void dropDownListener(){
        String x = panel.getCbArt().getSelectedItem().toString();
        switch (x){
            case ("Rechteck"):
                JLabel[] f = panel.getlWerte();
                f[2].setText("Breite");
                f[3].setText("Höhe");
                panel.setlWerte(f);
                JTextField[] h = panel.getTextWerte();
                h[3].setEditable(true);
                panel.setTextWerte(h);
                break;
            case ("Dreieck"):
                JLabel[] k = panel.getlWerte();
                k[2].setText("Breite");
                k[3].setText("Höhe");
                panel.setlWerte(k);
                JTextField[] t = panel.getTextWerte();
                t[3].setEditable(true);
                panel.setTextWerte(t);
                break;
            case ("Kreis"):
                JLabel[] j = panel.getlWerte();
                j[2].setText("Radius");
                j[3].setText("");
                panel.setlWerte(j);
                JTextField[] z = panel.getTextWerte();
                z[3].setEditable(false);
                panel.setTextWerte(z);
                break;
            case ("Linie"):
                JLabel[] d = panel.getlWerte();
                d[2].setText("X2");
                d[3].setText("Y2");
                panel.setlWerte(d);
                JTextField[] o = panel.getTextWerte();
                o[3].setEditable(true);
                panel.setTextWerte(o);
                break;
        }

    }

    /**
     * Ereignissteuerung für die Buttons "Hinzufügen" und "Zurücksetzen"
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        switch(ac) {
            case "add":
                String x = panel.getCbArt().getSelectedItem().toString();
                switch (x) {
                    case "Rechteck":
                        int x1 = panel.getXEingabe();
                        int y1 = panel.getYEingabe();
                        int b1 = panel.getBreite();
                        int h1 = panel.getHoehe();
                        if (x1 >= 0 && y1 >= 0 && b1 >= 0 && h1 >= 0) {
                            Rechteck r = new Rechteck(x1, y1, b1, h1, panel.getFarbe());
                            liste.addFigur(r);
                            panel.eintragHinzufuegen(liste.letzeFigur());
                            panel.repaint();
                        }
                        break;
                    case "Dreieck":
                        int x6 = panel.getXEingabe();
                        int y6 = panel.getYEingabe();
                        int b6 = panel.getBreite();
                        int h6 = panel.getHoehe();
                        if (x6 >= 0 && y6 >= 0 && b6 >= 0 && h6 >= 0) {
                            Dreieck d = new Dreieck(x6, y6, b6, h6, panel.getFarbe());
                            liste.addFigur(d);
                            panel.eintragHinzufuegen(liste.letzeFigur());
                            panel.repaint();
                        }
                        break;

                    case "Kreis":
                        int x2 = panel.getXEingabe();
                        int y2 = panel.getYEingabe();
                        int r = panel.getBreite();
                        if (x2 >= 0 && y2 >= 0 && r >= 0) {
                            Kreis kr = new Kreis(x2, y2, r, panel.getFarbe());
                            liste.addFigur(kr);
                            panel.eintragHinzufuegen(liste.letzeFigur());
                            panel.repaint();
                        }
                        break;
                    case "Linie":
                        int x3 = panel.getXEingabe();
                        int y3 = panel.getYEingabe();
                        int x4 = panel.getBreite();
                        int y4 = panel.getHoehe();
                        if (x3 >= 0 && y3 >= 0 && y4 >= 0 && y4 >= 0) {
                            Linie l = new Linie(x3, y3, x4, y4, panel.getFarbe());
                            liste.addFigur(l);
                            panel.eintragHinzufuegen(liste.letzeFigur());
                            panel.repaint();
                        }
                        break;

                }
                break;
            case "clear":
                liste.clear();
                panel.clear();
                panel.repaint();
        }
    }

    /**
     * Startet das Rechteck-Zeichenprogramm
     * @param args nicht verwendet
     */
    public static void main(String[] args) {
        new FigurController();
    }

}