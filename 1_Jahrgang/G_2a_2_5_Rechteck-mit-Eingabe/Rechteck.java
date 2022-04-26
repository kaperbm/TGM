package sew_1chit; // Das package einfach löschen falls in BlueJ programmiert werden muss
import javax.swing.JOptionPane;
/**
 * Diese Klasse erstellt ein Rechteck welches vom User optimiert werden kann
 * @author Kacper Bohaczyk
 * @date 22-04-2022
 */
public class Rechteck{
	
    /**
     * Die main Klasse nimmt einen Userinput auf. Dieser beinhalten welche breite das Rechteck haben soll, welche länge und aus welchem Zeichen es gebaut werden soll
     * @param args Argumente
     */
    public static void main(String[] args){
        String breiteEing = JOptionPane.showInputDialog(null, "breite: ");     	// Nimmt einen Userinput auf für die Breite
        String hoeheEing = JOptionPane.showInputDialog(null,"höhe: ");			// Nimmt einen Userinput auf für die Hoehe
        String zeichen = JOptionPane.showInputDialog(null,"zeichen: ");			// Nimmt einen Userinput auf für das Zeichen
        for(int hoehe = Integer.parseInt(hoeheEing); hoehe>0; hoehe--){			
            for(int breite = Integer.parseInt(breiteEing); breite>0; breite--){	
                System.out.print(zeichen);										// gibt ein Zeichen aus
            }
            System.out.println();												// wechselt die Zeile (geht auch mit \n)
        }
    }
}