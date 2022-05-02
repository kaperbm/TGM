package ArrayMethoden;
/**
 * Diese Klasse enthält Methoden zur generation und der Ausgabe eine zufälligen Array.
 * In der Version: "2-Version" wurden Methoden für das füllen und vertauschen des Arrays hinzugefuegt.
 * @author Kacper Bohaczyk
 * @date 29-04-2022
 * @version 2-Version
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
	
	/**
	 * füllt das übergegebene Array mit der übergegebenen Zahl
	 * @param array ist das Array welches befüllt werden soll
	 * @param zahl ist die Zahl mit welcher der Array befüllt werden soll
	 */
    public static void fillArray(int array[], int zahl) {
		if(zahl<0) {
		}
		else {
		for(int x = 0; x< array.length; x++) {
			array[x] = zahl;
		}
		}
	}
    
	/**
	 * füllt das Array mit zufälligen Zahlen
	 * wobei man den Bereich in dem die Zahlen generiert werden sollen bestimmen kann
	 * @param array ist das Array welches befüllt werden soll
	 * @param von ist der Anfang vom Bereich wo der Inhalt für das Array generiert werden soll
	 * @param bis ist das Ende vom Bereich wo der Inhalt für das Array generiert werden soll
	 */
	public static void fillZufallArray(int array[],int von, int bis) {
		if(von<0 || bis<0) {
		}
		else {
			int bereich = bis-von+1;
		for(int x = 0; x< array.length; x++) {
			array[x] = (int)(Math.random() * bereich) + von;
		}
		}
	}
	
	/**
	 * Vertauscht im Array zwei ausgewählte Stellen
	 * @param array ist das Array im welchen die Stellen vertauscht werden sollen
	 * @param index1 stelle Ist die erste Stelle
	 * @param index2 stelle Ist die zweite Stelle
	 */
	public static void vertausche(int array[], int index1,int index2) {
		if(index1 <0 ||index1>array.length-1 || index2 <0 ||index2>array.length-1 ) {
			
		}
		else {
		int derzeit = array[index1];
		array[index1] = array[index2];
		array[index2] = derzeit;
		}
	}
	
}