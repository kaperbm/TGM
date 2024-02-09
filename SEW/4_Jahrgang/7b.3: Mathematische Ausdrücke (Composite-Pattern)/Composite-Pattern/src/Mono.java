/**
 * Klasse für einzelne Expression
 * @author kacper bohaczyk
 * @version 2023-11-30
 */
public abstract class Mono implements Expression {

    private Expression mono;


/**
 * Konstruktor für einzelne Expressions.
 * @param mono die einzige Expressions
 */
    public Mono(Expression mono){
        this.mono = mono;
    }


/**
 * Wert zurückgeben
 * @return Gibt die Expression zurück
 */
    public Expression getMono() {
        return mono;
    }

}
