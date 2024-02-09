package sew6.calcvm;
import sew6.calcvm.instructions.Add;
import sew6.calcvm.instructions.Print;
import sew6.calcvm.instructions.Store;
import sew6.calcvm.instructions.Sub;

/**
 * @author Kacper Bohaczyk
 * @version 12-03-2023
 */
public class Main {
    /**
     * Ist die Main Methode
     * @param args Argumente
     * @throws ExceptionEmpty Diese Exception sagt ob die ArrayList Leer
     */
    public static void main(String[] args) throws ExceptionEmpty {
        Program program = new Program();
        Interpreter interpreter = new Interpreter(program);

        program.addInstruction(new Store(2));
        program.addInstruction(new Store(2));
        program.addInstruction(new Add());
        program.addInstruction(new Print());
        interpreter.run();
    }
}
