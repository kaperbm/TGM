package ArrayMethoden;
/**
 * Ist eine Testklasse zum austesten der Methoden aus "ArrayMethoden"
 * Die "2-Version" wurde um die Methoden "fillArray", fillZufallArray und vertausche erweitert
 * Die "3-Version" wurde um die Methoden "kopiere"(1D-Array) und "kopiere"(2D-Array) erweitert
 * @author Kacper Bohaczyk
 * @date 29-04-2022
 * @version 3-Version
 */
public class EinAusgabe {
    /** 
     * Ist die main Klasse
	 * @param args Argumente
	 */
    public static void main(String[]args){
    	int[] array = ArrayMethoden.zufallsArray(5);
    	System.out.println(ArrayMethoden.arrayToText(array));
    	/**
    	 * Test zur neu hinzugefügten Methoden aus der "1-Version"
    	 */
    	
    	ArrayMethoden.fillArray(array, -2);				// Test bei einem Fehler
    	System.out.println(ArrayMethoden.arrayToText(array));
    	ArrayMethoden.fillArray(array, 2);				// Testet ob sich das Array mit dem 2 parameter überschreiben/befüllen lässt
    	System.out.println(ArrayMethoden.arrayToText(array));
    	ArrayMethoden.fillZufallArray(array, -2, 2); 			// Testet bei einem Fehler
    	System.out.println(ArrayMethoden.arrayToText(array));
    	ArrayMethoden.fillZufallArray(array, 2, 6);			// Testet ob sich ein zufälliger Inhalt erstellen lässt
    	System.out.println(ArrayMethoden.arrayToText(array));	
    	ArrayMethoden.vertausche(array, -2, 20);			// Test bei einem Fehler
    	System.out.println(ArrayMethoden.arrayToText(array));
    	ArrayMethoden.vertausche(array, 2, 3);				// Testet aus ob sich der Inhalt vertauschen lässt
    	System.out.println(ArrayMethoden.arrayToText(array));
    	/**
    	 * Test zur neu hinzugefügten Methoden aus der "2-Version"
    	 */
    	
    	int [] arrayTest = {1,2,3,4,5};
    	int [] []  arrayTest2 = {{5,4,3,2,1 } ,{1,2,3,4,5}};
    	int [] kopieTest = ArrayMethoden.kopiere(arrayTest);
    	int [] [] kopieTest2 = ArrayMethoden.kopiere(arrayTest2);
    	System.out.println("Die Originale Referenz: " + arrayTest );			// Zeigt die Referenz, damit wird gezeigt das eine Deepcopy gemacht wurde
    	System.out.println("Die Referenz vom Kopierten Objekt: " + kopieTest );		// Zeigt die Referenz, damit wird gezeigt das eine Deepcopy gemacht wurde
    	System.out.println("Die Originale Referenz: " + arrayTest2 );			// Zeigt die Referenz, damit wird gezeigt das eine Deepcopy gemacht wurde
    	System.out.println("Die Referenz vom Kopierten Objekt: " + kopieTest2 );	// Zeigt die Referenz, damit wird gezeigt das eine Deepcopy gemacht wurde
    	System.out.println(ArrayMethoden.arrayToText(kopieTest));			// Zeigt den Inhalt der Kopie
    	for(int x = 0; x<kopieTest2.length;x++) {					// Die for-Schleifen szeigt den Inhalt des kopierten 2D-Array
			for(int y = 0; y<kopieTest2[0].length;y++) {		
				System.out.print(kopieTest2[x][y]);
				}
			}
    	/**
    	 * Test zur neu hinzugefügten Methoden aus der "3-Version"
    	 */
    	}
}
