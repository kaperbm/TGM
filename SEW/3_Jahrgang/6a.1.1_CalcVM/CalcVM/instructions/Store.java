package sew6.calcvm.instructions;
import sew6.calcvm.Interpreter;

/**
 * @author Kacper Bohaczyk
 * @version 12-03-2023
 */
public class Store implements Instruction {
    private final int value;

    /**
     * Konstruktor der Klasse Store
     * @param value
     */
    public Store(int value) {
        this.value = value;
    }

    /**
     *
     * @param interpreter
     */
    @Override
    public void execute(Interpreter interpreter) {
        interpreter.getStack().push(value);
    }
}
