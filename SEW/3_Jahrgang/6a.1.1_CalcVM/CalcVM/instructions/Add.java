package sew6.calcvm.instructions;
import sew6.calcvm.ExceptionEmpty;
import sew6.calcvm.Interpreter;

/**
 * Klasse die Addiert
 * @author Kacper Bohaczyk
 * @version 12-03-2023
 */
public class Add implements Instruction {

    /**
     * überschreibt execute
     * @param inter
     */
    @Override
    public void execute(Interpreter inter) throws ExceptionEmpty {
        if(!inter.getStack().isEmpty()) {
            inter.getStack().push(inter.getStack().pop() + inter.getStack().pop());
        }
        else {
            throw new ExceptionEmpty();
        }



    }

}
