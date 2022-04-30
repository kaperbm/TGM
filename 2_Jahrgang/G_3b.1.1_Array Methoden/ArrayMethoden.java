package ArrayMethoden;
/**
 * Diese Klasse enthält Methoden zur generation und der Ausgabe eine zufälligen Array.
 * @author Kacper Bohaczyk
 * @date 29-04-2022
 * @version 1-Version
 */
public class ArrayMethoden {
	
    /**
     * Macht aus dem Array ein String
     * @param array Ist das Array aus welchem der String kreirt wird
     * @return gibt den Inhalt des Arrays in einem String zurück
     */
	public static String arrayToText(int[] array) {
		String text = "";
		for(int x = 0; x< array.length; x++) {
			if(x< array.length-1) {
			text = text + array[x] + ", " ;
			}
			else {
				text = text + array[x];
			}
		}
		return text;
	}
	
	/**
	 * Erstellt ein Array mit einer übergegebnen größe. Dieser wird befüllt mir zufääligen Zahlen von 0 bis zur groesse des arrays *2
	 * @param zahl Ist die größe des Arrays und gleichzeitig der Bereich in welchem die Zahlen für das Array generiert werden sollen.
	 * @return gibt das neu erstellte Array zurück.(Dieses ist mit zufälligen Zahlen befüllt)
	 */
	public static int[] zufallsArray(int zahl) {
		int[] array = new int[zahl];
		for(int x = 0; x<= array.length -1; x++) {
			array[x] = (int)(Math.random() * (zahl * 2));
		}
		return array;
	}
}