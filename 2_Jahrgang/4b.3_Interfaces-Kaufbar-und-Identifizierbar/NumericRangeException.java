package src;
/**
 * Die Klasse ist eine Exception
 * Ihr Zweck ist es nachzuschauen ob die Variable in einem gültigen Bereich ist
 * @author Kacper Bohaczyk
 * @date 23-04-2022
 */
public class NumericRangeException extends Exception {
	/**
	 * Diese Methode ruft die Superklasse auf
	 */
	public NumericRangeException() {
		super();
	}
	
	/**
	 *  Diese Methode ruft die Superklasse auf und gibt ihr eine Nachricht mit
	 * @param message Ist die Nachricht die an die Superklasse (Exception) weitergeleitet wird
	 */
	public NumericRangeException(String message) {
		super(message);
	}
}
