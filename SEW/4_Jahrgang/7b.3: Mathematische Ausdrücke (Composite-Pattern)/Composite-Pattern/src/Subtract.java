/**
 * Klasse fürs Subtrahieren
 * @author kacper bohaczyk
 * @version 2023-11-30
 */
public class Subtract extends Dual{

    /**
     * Konstrukor zum links rechts definieren.
     * @param left Linke Expression.
     * @param right Rechte Expression.
     */
    public Subtract(Expression left, Expression right){
        super(left, right);
    }

    @Override


/**
 * Rechnung wird ausgeführt
 * @return Ergebnis
 */
    public double evaluate() {
        return getLeft().evaluate() - getRight().evaluate();
    }

    @Override

/**
 * Rechnung als Text
 * @return Text
 */
    public String toString() {
        return "("+ getLeft().toString() + " - " + getRight().toString() + ")";
    }
}
