/**
 * Klasse fürs Addieren
 * @author kacper bohaczyk
 * @version 2023-11-30
 */
public class Add extends Dual{


/**
 * Konstrukor zum links rechts definieren.
 * @param left Linke Expression.
 * @param right Rechte Expression.
 */
    public Add(Expression left, Expression right){
        super(left, right);
    }



/**
 * Rechnung wird ausgeführt
 * @return Ergebnis
 */
    @Override
    public double evaluate() {
        return getLeft().evaluate() + getRight().evaluate();
    }


/**
 * Rechnung als Text
 * @return Text
 */
    @Override
    public String toString() {
        return "("+ getLeft().toString() + " + " + getRight().toString() + ")";
    }
}
