package kbohaczyk;
/**
 * @author Kacper Bohaczyk
 * @version 16-02-2023
 */
public class StackFullException extends Exception{
    /**
     * konstruktor
     */
    public StackFullException() {
        System.err.println("Der Stack ist voll");
    }

    /**
     * Konstruktor
     * @param msg Message
     */
    public StackFullException(String msg) {
        super(msg);
    }
}
