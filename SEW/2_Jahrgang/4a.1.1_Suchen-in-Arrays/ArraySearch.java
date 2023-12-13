package arraySearch;
/**
 * Die Klasse ArraySearch beinhaltet verschiedene Suchalgorythmen wie zum Beispiel linearSearch oder binarySearch
 * man kann auch den Index vom Minimum und Maximum suchen
 * auserdem gibt es eine Methode zum nachschauen ob das ArraySortiert.
 * @author Kacper Bohaczyk
 * @date 01-05-2022
 */
public class ArraySearch {
	/**
	 * Diese Klasse gibt den Index einer gesuchten Zahl zurück.
	 * Falls die Zahl nicht gefunden wird, wird ein -1 zurückgegeben.
	 * Als Suchalgorithmus wird die lineare Suche benutzt.
	 * Sie hat den vorteil, dass der Array nicht sortiert werden muss.
	 * Er ist am effektivsten bei kleineren Arrays.
	 * @param array		Ist das Array in welchem der Index der rübergegebenen Zahl gesucht wird
	 * @param gesucht	Ist die Zahl die gesucht wird
	 * @return			Gibt den Index der rübergegebenen Zahl im Array zurück oder -1 bei einem Fehlschlag
	 */
	public static int linearSearch(int[]array, int gesucht) {
		for(int x = 0; x< array.length;x++) {
			if(array[x] == gesucht) {
			return x;		// Gibt den Index der gesuchten Zahl zurück
			}
		}
		return -1;			// Gibt ein -1 zurück,falls das Gesuchte Element sich nicht im Array befindets
	}
	/**
	 * Diese Klasse gibt den Index einer gesuchten Zahl zurück.
	 * Falls die Zahl nicht gefunden wird, wird ein -1 zurückgegeben.
	 * Als Suchalgorithmus wird die binäre Suche benutzt.
	 * Der Array muss sortiert werden um diese Suche anwenden zu können
	 * Desto größer der Array desto effektiver ist der Algorithmus.
	 * 
	 * @param array		Ist das Array in welchem der Index der rübergegebenen Zahl gesucht wird
	 * @param gesucht	Ist die Zahl die gesucht wird
	 * @return			Gibt den Index der rübergegebenen Zahl im Array zurück oder -1 bei einem Fehlschlag
	 */
	public static int binarySearch(int []array, int gesucht) {
		if(true == isSorted(array)) {
			int l = 0, r = array.length - 1;
	        while (l <= r) {
	            int m = l + (r - l) / 2;
	  
	            if (array[m] == gesucht) {
	                return m;
	            }
	            if (array[m] < gesucht) {
	                l = m + 1;
	            }
	            else {
	                r = m - 1;
	            }
	        }
	            return -1;
	        	}
	        else {
			return -1;
		}
	}
	
	/**
	 * Schaut nach ob das Array sortiert ist
	 * @param 	array	Ist das Array welches geckect wird
	 * @return	gibt zurück ob das Array sortiert wird oder ned
	 */
	public static boolean isSorted(int array[]) {
		for (int x=1; x<array.length; x++) {
            if (array[x-1] <= array[x]) {
            }
            else{
                return false;
            }
        }
        return true;
    }
	
	/**
	 * Sucht die kleinste Zahl im Array und gibt den Index zurueck
	 * @param array	Ist das Array in welchem die kleinste Zahl gesucht wird
	 * @return		Gibt den Index der kleinsten Zahl zurück (Wichtig!!! Index nicht die Kleinste Zahl)
	 */
	public static int searchMin(int[] array) {
		int min = array[0];
		int index = 0;
		for(int x = 0; x<array.length;x++) {
			if(min>array[x]) {
				min = array[x];
				index = x;
			}
		}
		return index;
	}
	
	/**
	 * Sucht die groesste Zahl im array und gibt den Index zuruek
	 * @param array	Ist das Array in welchem die groesste Zahl gesucht wird
	 * @return		Gibt den Index der groessten Zahl zurück (Wichtig!!! Index nicht die Kleinste Zahl)
	 */
	public static int searchMax(int[] array) {
		int max = array[0];
		int index = 0;
		for(int x = 0; x<array.length;x++) {
			if(max<array[x]) {
				max = array[x];
				index = x;
			}
		}
		return index;
	}
	
	/**
	 * Sucht die kleinste Zahl im Array und gibt deren Index zurueck
	 * Es gibt zusätzlich noch eine Bereichsangabe
	 * @param array	Ist das Array in dem der die kleinste Zahl gesucht werden soll
	 * @param unten	Ist die untere Grenze bis in der der Index der kleinsten Zahl gesucht werden soll
	 * @param oben	Ist die obere Grenze bis in der der Index der kleinsten Zahl gesucht werden soll
	 * @return		Gibt den Index der kleinsten Zahl zurück (Wichtig!!! Index nicht die Kleinste Zahl)
	 */
	public static int searchMin(int[]array , int unten , int oben) {
		int min = array[unten];
		int index = unten;
		for(int x = unten; x< oben;x++) {
			if(min>array[x]) {
				min = array[x];
				index = x;
			}
		}
		return index;
	}
	
	/**
	 * Sucht die groesste Zahl im Array und gibt deren Index zurueck
	 * Es gibt zusätzlich noch eine Bereichsangabe
	 * @param array	Ist das Array in dem der die kleinste Zahl gesucht werden soll
	 * @param unten	Ist die untere Grenze bis in der der Index der groesste Zahl gesucht werden soll
	 * @param oben	Ist die obere Grenze bis in der der Index der kleinste Zahl gesucht werden soll
	 * @return		Gibt den Index der groessten Zahl zurück (Wichtig!!! Index nicht die Kleinste Zahl)
	 */
	public static int searchMax(int[] array, int unten, int oben) {
		int max = array[unten];
		int index = unten;
		for(int x = unten; x< oben;x++) {
			if(max<array[x]) {
				max = array[x];
				index = x;
			}
		}
		return index;
	}
}
