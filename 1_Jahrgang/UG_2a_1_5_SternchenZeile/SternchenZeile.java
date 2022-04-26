package sew_1chit;		// Das Package einfach löschen falls die Aufgabe ohne einen Package sein soll
/**
 * Diese Klasse soll eine Zeile aus 9 Sternchen ausgeben
 * @author Kacper Bohaczyk
 * @date 22-04-2022
 */
public class SternchenZeile {
	/**
	 * Die main Klassse gibt die Sternchenzeile aus
	 * @param args
	 */
	 public static void main(String[] args) {
	     int laenge;							// Die Variable wird deklariert
	     for(laenge=0; laenge<9; laenge++) {	// Der Vorgang wird mitels einer for Schleife 9x wiederholt
	      System.out.print('*');				// Ein Sternchen wird ausgegeben
	    }
	}
}