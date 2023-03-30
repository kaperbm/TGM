package arraySearch;
/**
 * ist die Testklasse zu "ArraySearch"
 * Es werden die Methoden:
 * @author Kacper Bohaczyk
 * @date 01-05-2022
 */
public class ArrayTest {
	/**
	 * Ist die main Methode zur testung der Klasse ArraySearch
	 * @param args Argumente
	 */
	public static void main(String[]args) {
	int[] array = {1 , 4, 3 , 2 , 5, 6, 9, 8 ,7};
	System.out.println("Die Aussage \" der Array ist Sortiert\" ist:" + ArraySearch.isSorted(array));	// Testet ob das Array sortiert ist
	System.out.println("Der index ist: " + ArraySearch.linearSearch(array, 3));		// Macht eine lineare suche der Zahl 3
	System.out.println("Der index ist: " +ArraySearch.binarySearch(array, 4));		// Macht eine binaere Suche der Zahl 4
	System.out.println("Der index ist: " +ArraySearch.searchMax(array));			// Sucht die groestmoegliche Zahl im Array
	System.out.println("Der index ist: " +ArraySearch.searchMin(array));			// Sucht die kleinstmoegliche Zahl im Array
	System.out.println("Der index ist: " +ArraySearch.searchMax(array, 1, 3));		// Sucht die groestmoegliche Zahl im einem bestimmten Bereich im Array
	System.out.println("Der index ist: " +ArraySearch.searchMin(array, 1, 3));		// Sucht die kleinstmoegliche Zahl im einem bestimmten Bereich im Array
	}
}
