import java.util.StringJoiner;

/**
 * Klasse fürs Minimum
 * @author kacper bohaczyk
 * @version 2023-11-30
 */
public class Min extends Multi {


    /**
     * Konstruktor um Liste zu definieren
     * @param numbers Liste der Nummern
     */
    public Min(Expression... numbers){
        super(numbers);
    }
    @Override

/**
 * Rechnet die kleinste Zahl aus
 * @return Kleinste Wert
 */
    public double evaluate() {
        double x = Double.MAX_VALUE;
        for (Expression y:
             getArgs()) {
            x = x > y.evaluate() ? y.evaluate() : x;
        }
        return x;
    }

    @Override

/**
 * Rechnung als Text
 * @return Text
 */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Min(");


        if (!getArgs().isEmpty()) {
            appendExpressions(stringBuilder);
        }

        stringBuilder.append(")");

        return stringBuilder.toString();
    }

    private void appendExpressions(StringBuilder stringBuilder) {
        StringJoiner joiner = new StringJoiner(", ");
        for (Expression expression : getArgs()) {
            joiner.add(expression.toString());
        }
        stringBuilder.append(joiner.toString());
    }
}
