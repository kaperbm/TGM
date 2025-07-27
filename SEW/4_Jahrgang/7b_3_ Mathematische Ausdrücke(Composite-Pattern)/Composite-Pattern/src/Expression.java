/**
 * Interface für Expressions
 * @author kacper bohaczyk
 * @version 2023-11-30
 */
public interface Expression {
    /**
     * Ausrechnen der Rechnung
     * @return Ergebis
     */
    double evaluate();

    /**
     * Rechnung als Text
     * @return Text
     */
    String toString();
}
