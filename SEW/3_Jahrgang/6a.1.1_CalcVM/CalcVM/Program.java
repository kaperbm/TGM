
package sew6.calcvm;
import java.util.ArrayList;
import sew6.calcvm.instructions.Instruction;

/**
 * Das Programm
 * @author Kacper Bohaczyk
 * @version 12-03-2023
 */
public class Program  {

	ArrayList<Instruction> instructionArrayList = new ArrayList<Instruction>();

	/**
	 * Konstruktor der Klasse Program
	 */
	public Program() {

	}

	/**
	 * Gibt eine Instruction aus der ArrayList zurück
	 * @param line Stelle aus dem Array in welcher die Instruction drinnen steht
	 * @return gibt die Instruction zurück
	 */
	public Instruction getInstruction(int line) {
		return instructionArrayList.get(line);
	}

	/**
	 * Löscht eine Instruction aus der ArrayList
	 * @param line Stelle aus dem Array in welcher die Instruction drinnen steht
	 * @return gibt die gelöschte Instruction zurück
	 */
	public Instruction deleteInstruction(int line) {
		Instruction temp = instructionArrayList.get(line);
		instructionArrayList.remove(line);
		return temp;
	}

	/**
	 * Fügt eine Instruction zur ArrayList hinzu
	 * @param instruction ist die Instruction die hinzugefügt wird
	 */
	public void addInstruction(Instruction instruction) {
		instructionArrayList.add(instruction);
	}
	/**
	 * Gibt die Größe der ArrayList zurück
	 * @return Wert der Größe vom Array
	 */
	public int size() {
		return instructionArrayList.size();
	}

	/**
	 * Gibt die Atribute aus der ArrayList als ein String zurück
	 * @return Text in welchem alle Atribute der ArrayList drinnen stehen
	 */
	@Override
	public String toString() {
		String text = "";
		for(int i = 0; i< instructionArrayList.size(); i++) {
			text = text + " " + instructionArrayList.get(i);
		}
		return text;
	}

}
