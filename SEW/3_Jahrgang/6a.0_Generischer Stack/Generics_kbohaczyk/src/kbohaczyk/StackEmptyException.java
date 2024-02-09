package kbohaczyk;

/**
 *
 * @author Kacper Bohaczyk
 * @version 16-02-2023
 */
public class StackEmptyException extends Exception{
    /**
     * Konstruktor
     */
    public StackEmptyException() {
        System.err.println("Der Stack ist leer");
    }

    /**
     * Konstruktor
     * @param msg Message
     */
    public StackEmptyException(String msg) {
        super(msg);
    }
}
