package ArrayMethoden;
/**
 * Ist eine Testklasse zum austesten der Methoden aus "ArrayMethoden"
 * @author Kacper Bohaczyk
 * @date 29-04-2022
 */
public class EinAusgabe {
    /** 
     * Ist die main Klasse
	 * @param args Argumente
	 */
    public static void main(String[]args){
    	int[] array = ArrayMethoden.zufallsArray(5);
    	System.out.println(ArrayMethoden.arrayToText(array));
    }
}