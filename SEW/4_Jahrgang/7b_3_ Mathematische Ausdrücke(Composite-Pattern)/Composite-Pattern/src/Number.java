/**
 * Zahl zum Rechnen
 * @author kacper bohaczyk
 * @version 2023-11-30
 */
public class Number implements Expression {
    double value;


/**
 * Konstruktor für die Zahl mit value
 * @param value Der Wert der Zahl
 */
    public Number(double value){
        this.value = value;
    }

    @Override


/**
 * Rechnung wird ausgeführt
 * @return Ergebnis
 */
    public double evaluate() {
        return value;
    }

    @Override

/**
 * Rechnung als Text
 * @return Text
 */
    public String toString() {
        return "" + value;
    }
}
