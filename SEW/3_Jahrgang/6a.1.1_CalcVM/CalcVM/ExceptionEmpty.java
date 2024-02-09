package sew6.calcvm;

/**
 * Exception die bei einer Leeren ArrayList
 */
public class ExceptionEmpty extends Exception{

    /**
     * Exception
     */
    public ExceptionEmpty() {
        System.err.println("Das Array ist leer");
    }

}
