import java.util.ArrayList;
import java.util.Arrays;

/**
 * Klasse für mehrere Expressions
 * @author kacper bohaczyk
 * @version 2023-11-30
 */
public abstract class Multi implements Expression {
    ArrayList<Expression> args;


/**
 * Konstruktor für mehrere Expressions.
 * @param numbers Liste der Expressions.
 */
    public Multi(Expression... numbers){
        this.args = new ArrayList<>(Arrays.asList(numbers));
    }


/**
 * Liste zurückgeben
 * @return die Liste
 */
    public ArrayList<Expression> getArgs() {
        if(args.isEmpty() == true){
            throw new IllegalStateException("Leere Liste");
        }
        return args;
    }

}
