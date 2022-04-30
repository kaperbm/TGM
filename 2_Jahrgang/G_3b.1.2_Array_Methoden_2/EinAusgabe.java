package ArrayMethoden;
/**
 * Ist eine Testklasse zum austesten der Methoden aus "ArrayMethoden"
 * Die "2-Version" wurde um die Methoden "fillArray", fillZufallArray und vertausche erweitert
 * @author Kacper Bohaczyk
 * @date 29-04-2022
 * @version 2-Version
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
    	
    	ArrayMethoden.fillArray(array, -2);						// Test bei einem Fehler
    	System.out.println(ArrayMethoden.arrayToText(array));
    	ArrayMethoden.fillArray(array, 2);						// Testet ob sich das Array mit dem 2 parameter überschreiben/befüllen lässt
    	System.out.println(ArrayMethoden.arrayToText(array));
    	ArrayMethoden.fillZufallArray(array, -2, 2); 			// Testet bei einem Fehler
    	System.out.println(ArrayMethoden.arrayToText(array));
    	ArrayMethoden.fillZufallArray(array, 2, 6);				// Testet ob sich ein zufälliger Inhalt erstellen lässt
    	System.out.println(ArrayMethoden.arrayToText(array));	
    	ArrayMethoden.vertausche(array, -2, 20);				// Test bei einem Fehler
    	System.out.println(ArrayMethoden.arrayToText(array));
    	ArrayMethoden.vertausche(array, 2, 3);					// Testet aus ob sich der Inhalt vertauschen lässt
    	System.out.println(ArrayMethoden.arrayToText(array));
    	/**
    	 * Test zur neu hinzugefügten Methoden aus der "2-Version"
    	 */
    	
    	}
}