/**
 * Klasse fürs Maximale
 * @author kacper bohaczyk
 * @version 2023-11-30
 */
public class Max extends Multi {


/**
 * Konstruktor um Liste zu definieren
 * @param numbers Liste der Nummern
 */
    public Max(Expression... numbers) {
        super(numbers);
    }

    @Override

/**
 * Rechnet die maximale Zahl aus
 * @return Großter Wert
 */
    public double evaluate() {
        double x = -Double.MAX_VALUE;
        for (Expression y:
                getArgs()) {
            x = x < y.evaluate() ? y.evaluate() : x;
        }
        return x;
    }

    @Override

/**
 * Rechnung als Text
 * @return Text
 */
    public String toString() {
        String x = "Max(";
        for (Expression y:
             getArgs()) {
            x = x + y.toString();
        }
        x  = x + ")";
        return x;
    }
}
