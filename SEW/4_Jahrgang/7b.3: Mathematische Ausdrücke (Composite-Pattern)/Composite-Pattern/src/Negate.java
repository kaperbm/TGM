/**
 * Klasse fürs Negieren
 * @author kacper bohaczyk
 * @version 2023-11-30
 */
public class Negate extends Mono {


/**
 * Konstruktor für einzelne Expression.
 * @param mono Negierbare Expression
 */
    public Negate(Expression mono) {
        super(mono);
    }

    @Override


/**
 * Rechnung wird ausgeführt
 * @return Ergebnis
 */
    public double evaluate() {
        return -this.getMono().evaluate();
    }

    @Override

/**
 * Rechnung als Text
 * @return Text
 */
    public String toString() {
        return "-("+this.getMono().toString()+")";
    }
}
