/**
 * Klasse für linke und rechte Expression
 * @author kacper bohaczyk
 * @version 2023-11-30
 */
public abstract class Dual implements Expression {

    private Expression left;

    private Expression right;


    /**
     * Konstrukor zum links rechts definieren.
     * @param left Linke Expression.
     * @param right Rechte Expression.
     */
    public Dual(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }


/**
 * linke Expression zurückgeben
 * @return linke Expression
 */
    public Expression getLeft() {
        return left;
    }



    /**
     * rechte Expression zurückgeben
     * @return rechte Expression
     */
    public Expression getRight() {
        return right;
    }



}
