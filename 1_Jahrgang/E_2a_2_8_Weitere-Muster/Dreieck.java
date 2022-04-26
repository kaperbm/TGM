package sew_1chit;	// Das package einfach l�schen falls in BlueJ programmiert werden muss
import javax.swing.JOptionPane;
/**
 * Das Programm erstellt ein Dreieck mit einer vom User eingegebenen gr��e und ausgew�hltem Zeichen
 * @author Kacper Bohaczyk 
 * @version 22-04-2022
 */
public class Dreieck{
    /**
     * Nimmt den Userinput auf und erstellt das Dreieck
     * @param args Argumente
     */
    public static void main(String [] args){
        String eingabe = JOptionPane.showInputDialog(null, "Zeilenanzahl: ");
        int anzahl=Integer.parseInt(eingabe);  
        String zeichen = JOptionPane.showInputDialog(null, "Zeichen: ");
        /*
         * Der Input wird aufgenommen und umgewandelt
         */
        
        for (int a = 1; a <= anzahl; ++a) {		// Die Schleife erstellt die H�he der Dreiecks
            for (int b = 1; b <= a; ++b) {		// Die Schleife erstellt die Breite des Dreiecks. Besonders wichtig ist das immer 1 dazu addiert wird, dammit sich das Dreieck vergr��ert
                System.out.print(zeichen);
            }
            System.out.println();				// Ist zum Zeilenwechsel dar. K�nnte mit einem (\n) ersetzt werden
        }
    }
}