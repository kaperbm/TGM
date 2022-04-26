package sew_1chit; // Das package einfach löschen falls in BlueJ programmiert werden muss
/**
 * 
 * @author Kacper Bohaczyk
 * @date 22-04-2022
 */
public class SternchenRechteck {
	/**
	 * Die Main Klasse gibt ein SternchenRechteck aus
	 * @param args Argumente
	 */
	 public static void main(String[] args) {
	     int laenge;							// Die Variable wird deklariert
	     int breite;							// Die Variable wird deklariert
	     for(breite=0; breite<5; breite++) {	// Der Vorgang wird solange wiederhollt bis 5 erreicht wird
	     for(laenge=0; laenge<9; laenge++) {	// Der Vorgang wird solange wiederhollt bis 9 erreicht wird
	      System.out.print('*');				// Ein Sternchen wird ausgegeben
	    }
	    System.out.println();					// Die Zeile wird gewechselt (geht auch mit einem \n)
	}
	}
}
