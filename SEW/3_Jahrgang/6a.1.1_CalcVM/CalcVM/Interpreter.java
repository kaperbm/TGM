package sew6.calcvm;
import sew6.calcvm.instructions.Instruction;
/**
 * @author Kacper Bohaczyk
 * @version 02-03-2023
 */
public class Interpreter {
    private final Stack stack;
    private final Program program;

    /**
     * Konstruktor
     * @param program
     */
    public Interpreter(Program program) {
        this.program = program;
        this.stack = new Stack();
    }

    /**
     * This method implements the actual interpreter.
     * Iterate over all instructions of the program and execute them, the end of the program is reached
     * when all instructions have been executed.
     */
    public void run() throws ExceptionEmpty {
        for(int i = 0; i < program.size(); i++) {
            Instruction inst = program.getInstruction(i);
            inst.execute(this);

        }
    }

    /**
     * Ist ein getter für den Stack
     * @return Stack
     */
    public Stack getStack() {
        return stack;
    }
}
