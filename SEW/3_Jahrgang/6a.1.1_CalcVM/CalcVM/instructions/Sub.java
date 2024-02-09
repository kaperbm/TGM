package sew6.calcvm.instructions;
import sew6.calcvm.ExceptionEmpty;
import sew6.calcvm.Interpreter;

/**
 * @author Kacper Bohaczyk
 * @version 12-03-2023
 */
public class Sub implements Instruction {
    /**
     * Überschreibt execute
     * @param inter
     */
    @Override
    public void execute(Interpreter inter) throws ExceptionEmpty {
        if(!inter.getStack().isEmpty()) {
            inter.getStack().push( inter.getStack().pop() - inter.getStack().pop());
        }
        else {
            System.err.println("Der Stack ist leer :(");
        }
    }
}
