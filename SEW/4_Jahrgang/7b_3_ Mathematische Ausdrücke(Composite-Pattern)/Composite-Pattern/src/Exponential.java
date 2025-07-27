/**
 * Klasse fürs Exponenzieren
 * @author Kacper Bohaczyk
 * @version 30-11-2023
 */
public class Exponential extends Dual{

    /**
     * Konstrukor zum links rechts definieren.
     * @param left Linke Expression.
     * @param right Rechte Expression.
     */
    public Exponential(Expression left, Expression right) {
        super(left, right);
    }

    @Override
/**
 * Rechnung wird ausgeführt
 * @return Ergebnis
 */
    public double evaluate() throws IllegalArgumentException{
        if (getRight().evaluate() > 0 || getRight().evaluate() < -1){
            return Math.pow(getLeft().evaluate(), getRight().evaluate());
        } else {
            throw new IllegalArgumentException("Keine Negative Wurzel");
        }
    }

    @Override

/**
 * Rechnung als Text
 * @return Text
 */
    public String toString() {
        return "("+ getLeft().toString() + " ^ " + getRight().toString() + ")";
    }
}
