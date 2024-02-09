/**
 * Klasse fürs Dividieren
 * @author kacper bohaczyk
 * @version 2023-11-30
 */
public class Divide extends Dual{


    /**
     * Konstrukor zum links rechts definieren.
     * @param left Linke Expression.
     * @param right Rechte Expression.
     */
    public Divide(Expression left, Expression right) {
        super(left, right);
    }

    @Override


/**
 * Rechnung wird ausgeführt
 * @return Ergebnis
 */
    public double evaluate() throws  IllegalArgumentException{
        if (getRight().evaluate()!=0){
            return getLeft().evaluate() / getRight().evaluate();
        } else {
            throw new IllegalArgumentException("Dividiert durch null");
        }
    }

    @Override
/**
 * Rechnung als Text
 * @return Text
 */
    public String toString() {
        return "("+ getLeft().toString() + " / " + getRight().toString() + ")";
    }
}
