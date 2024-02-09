package sew6.calcvm;
import java.util.ArrayList;

/**
 * Klasse die als ein Stack agiert
 * @author Kacper Bohaczyk
 * @version 12-03-2023
 */
public class Stack {

	private final ArrayList <Integer> stack;

	/**
	 * Konstruktor der Klasse Stack
	 */
	public Stack() {
		this.stack = new ArrayList<>();
	}

	/**
	 * fügt ein neues Object zum Array hinzu
	 * @param inst ist das Object welches hinzugefügt wird
	 */
	public void push(Integer inst) {
		stack.add(inst);
	}

	/**
	 * Gibt das Oberste objekt vom array aus und löscht dieses dabei
	 * @return gibt das oberste Object zurück
	 */
	public Integer pop() throws ExceptionEmpty{
		Integer val = 0;
		if(stack.isEmpty()) {
			throw new ExceptionEmpty();
		}

		val = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return val;		// wird bei einer richtigen ArrayList nie ausgeführt
	}

	/**
	 * Gibt das oberste object des Arrays zurück ohne dabei es zu löschen
	 * @return gibt das oberste object vom array
	 */
	public Integer peek() throws ExceptionEmpty {
		if (stack.isEmpty()) {
			throw new ExceptionEmpty();
		}
		return stack.get(stack.size() - 1);        // wird bei einer richtigen ArrayList nie ausgeführt}

	}

	/**
	 * die Methode schaut nach ob die ArrayList leer ist oder nicht
	 * @return gibt true: bei einer leeren und false: bei einem befüllten Array zurück
	 */
	public boolean isEmpty() {
		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}
}