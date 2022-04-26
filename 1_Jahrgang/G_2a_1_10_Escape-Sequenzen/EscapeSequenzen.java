package sew_1chit;	// Das package einfach l�schen falls in BlueJ programmiert werden muss
/**
 * Diese Klasse soll zeigen welche EscapeSequenzen es gibt und wie sie funktionieren
 * @author Kacper Bohaczyk
 * @date 22-04-2022
 */
public class EscapeSequenzen {
	/**
	  * Die main Klasse Zeigt wie EscapeSequenzen funktionieren
	  * @param args Argumente
	  */
	    public static void main (String[] args) { 
	    System.out.println(
	    "\\\\\tKann einen Backslash ausgeben\n"					//  \\  gibt ein Backslash (\) aus
	    + "\\\"\tZeigt ein doppeltes Anf�hrungszeichen an\n"	//	\"  gibt ein doppeltes Anf�hrungszeichen (") aus
	    + "\\'\tZeigt ein einfaches Anf�hrungszeichen an\n"		//  \'  gibt ein einfaches Anf�hrungszeichen (') aus
	    + "\\n\tWechselt in die neue Zeile\n"					//  \n	wechselt zu einer neuen Zeile
	    + "\\t\tMacht einen Tabulatorsprung"					//	\t	macht einen Tabulatorsprung
	    );
	  }
}
