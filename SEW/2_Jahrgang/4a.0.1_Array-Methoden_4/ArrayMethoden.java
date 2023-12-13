package ArrayMethoden;
/**
 * Diese Klasse enth�lt Methoden zur generation und der Ausgabe eine zuf�lligen Array.
 * In der Version: "2-Version" wurden Methoden f�r das f�llen und vertauschen des Arrays hinzugefuegt
 * In der Version: "3-Version" wurden Methoden f�r das Kopieren der Arrays hinzugefuegt
 * In der Version: "4-Version" wurden Methoden zur verkleinerung sowie vergr��erung eines Arrays hinzugefuegt
 * @author Kacper Bohaczyk
 * @date 29-04-2022
 * @version 4-Version
 */
public class ArrayMethoden {
	
    /**
     * Macht aus dem Array ein String
     * @param array Ist das Array aus welchem der String kreirt wird
     * @return gibt den Inhalt des Arrays in einem String zur�ck
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
	 * Erstellt ein Array mit einer �bergegebnen gr��e. Dieser wird bef�llt mir zuf��ligen Zahlen von 0 bis zur groesse des arrays *2
	 * @param zahl Ist die gr��e des Arrays und gleichzeitig der Bereich in welchem die Zahlen f�r das Array generiert werden sollen.
	 * @return gibt das neu erstellte Array zur�ck.(Dieses ist mit zuf�lligen Zahlen bef�llt)
	 */
	public static int[] zufallsArray(int zahl) {
		int[] array = new int[zahl];
		for(int x = 0; x<= array.length -1; x++) {
			array[x] = (int)(Math.random() * (zahl * 2));
		}
		return array;
	}
	
	/**
	 * f�llt das �bergegebene Array mit der �bergegebenen Zahl
	 * @param array ist das Array welches bef�llt werden soll
	 * @param zahl ist die Zahl mit welcher der Array bef�llt werden soll
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
	 * f�llt das Array mit zuf�lligen Zahlen
	 * wobei man den Bereich in dem die Zahlen generiert werden sollen bestimmen kann
	 * @param array ist das Array welches bef�llt werden soll
	 * @param von ist der Anfang vom Bereich wo der Inhalt f�r das Array generiert werden soll
	 * @param bis ist das Ende vom Bereich wo der Inhalt f�r das Array generiert werden soll
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
	 * Vertauscht im Array zwei ausgew�hlte Stellen
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
	/**
	 * Kopiert das Array mit einer Deepcopy
	 * @param array ist das Array
	 * @return gibt das kopierte Array zur�ck
	 */
	public static int[] kopiere(int array[]) {
			int[] array2 = new int[array.length];
			for(int x = 0; x<array.length;x++) {		
				array2[x] = array[x];
			}
		return array2;
	}
	
	/**
	 * Kopiert ein zweidimensionales Array mit einer Deepcopy
	 * @param array ist das Array
	 * @return gibt das kopierte Array zur�ck
	 */
		public static int[][] kopiere(int array[][]) {
			int[][] array2 = new int[array.length][array[0].length];
			for(int x = 0; x<array.length;x++) {
				for(int y = 0; y<array[0].length;y++) {
				array2[x][y] = array[x][y];
			}
			}
		return array2;
		}
		/**
		 * Vergr��ert das Array um den r�bergegebenen Parameter
		 * @param array ist das Array welches vergr��ert werden soll
		 * @param add ist die Gr��e um die das Array vergr��ert werden soll
		 * @return gibt das vergr��erte Array zur�ck
		 */
		
    public static int[] vergroessern(int array[] , int add ) {
			int[] array2 = new int[array.length+add];
			for(int x = 0; x<array.length;x++) {		
				array2[x] = array[x];
			}
		return array2;
	}
    
    /**
     * Verkleiner das Array um den gegebenen Parameter
     * @param array ist das Array welches verkleinert werden soll
     * @param add ist die Gr��e um die das Array verkleinert werden soll
     * @return gibt das verkleinerte Array zur�ck
     */
		public static int[] verkleinern(int array[], int add) {
			int[] array2 = new int[array.length-add];
			for(int x = 0; x< array2.length;x++) {		
				array2[x] = array[x];
			}
		return array2;
		}
}