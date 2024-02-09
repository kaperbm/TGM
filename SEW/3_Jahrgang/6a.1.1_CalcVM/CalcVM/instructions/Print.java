package sew6.calcvm.instructions;
import sew6.calcvm.ExceptionEmpty;
import sew6.calcvm.Interpreter;

/**
 * @author Kacper Bohaczyk
 * @version 12-03-2023
 */
public class Print implements Instruction {
    /**
     *
     * @param interpreter
     */
    @Override
    public void execute(Interpreter interpreter) throws ExceptionEmpty {
        System.out.println(interpreter.getStack().pop());
    }
}
