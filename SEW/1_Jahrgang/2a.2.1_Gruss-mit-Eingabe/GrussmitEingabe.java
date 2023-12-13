package sew_1chit;	// Das package einfach löschen falls in BlueJ programmiert werden muss
import javax.swing.JOptionPane;	// Das JOptionPane package wird importiert um es verwenden zu können
/**
 * Diese Klasse soll einem beibringen wie eine Usereingabe mittel JOptionPane funktioniert
 * @author Kacper Bohaczyk
 * @date 22-04-2022
 */
public class GrussmitEingabe {
	/**
	 * 
	 * @param args Argumente
	 */
	public static void main(String[] args) {
		   String name;			// Deklaration vom Namen
		   String tagesZeit;		// Deklaration der TagesZeit
		   tagesZeit = JOptionPane.showInputDialog(null,"Gib eine Tageszeit ein");	// Initialisation der Zeit mittels einer User-Eingabe per JOptionPane
		   name = JOptionPane.showInputDialog(null,"Gib einen Namen ein");		// Initialisation des Namen mittels einer User-Eingabe per JOptionPane
		   System.out.print("Guten " + tagesZeit + ",\n" + name);			// Gibt eine Message aus in der der User begrüßt wird
		 }
}
