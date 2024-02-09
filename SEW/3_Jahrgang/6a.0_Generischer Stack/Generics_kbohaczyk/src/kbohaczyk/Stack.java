package kbohaczyk;

/**
 * @author Kacper Bohaczyk
 * @version 16-02-2023
 * @param <T> generischer Datentyp
 */
public class Stack <T> {

    private T [] array;

    /**
     * Konstruktor
     */
    public Stack() {
        this.array = (T[]) new Object[4];
    }

    /**
     * Konstruktor bei dem man die Anzahl an Stellen rübergeben kann
     * @param anzahl ist die anzahl wie groß der Konstruktor sein soll
     */
    public Stack(int anzahl ) {

        this.array = (T[]) new Object[anzahl];          // casting an Object-array into a generic type t array

    }

    /**
     * fügt ein neues Object zum Array hinzu
     * @param obj ist das Object welches hinzugefügt wird
     * @throws StackFullException Falls der Stack voll ist wird diese Exception zurückgeliefert
     */
    public void push(T obj) throws StackFullException {

        for(int i = 0; i< array.length;i++) {
            if(array[i] == null) {
                array[i] = obj;
                return;
            }
        }
        throw new StackFullException();
    }

    /**
     * Gibt das Oberste objekt vom array aus und löscht dieses dabei
     * @return gibt das oberste object zurück
     * @throws StackEmptyException Falls der Stack leer ist wird diese Exception zurückgeliefert
     */
    public T pop () throws StackEmptyException{
        if(array[0] == null) {
            throw  new StackEmptyException();
        }
        T temp = array[0];
        for(int i = 0; i< array.length;i++) {
            if(array[i] == null) {
                temp = array[i-1];
                array[i-1] = null;
                return temp;
            }
        }
        return temp;
    }

    /**
     * Gibt das oberste object des Arrays zurück
     * @return das oberste object vom array
     * @throws StackEmptyException Falls der Stack leer ist wird diese Exception zurückgeliefert
     */
    public T peek() throws StackEmptyException{
        if(array[0] == null) {
            throw new StackEmptyException();
        }
        for(int i = 0; i< array.length;i++) {
            if(array[i] == null) {
                return array[i-1];
            }
        }
        return array[0];
    }

    /**
     * gibt ein String des Arrays zurück
     * @return Array string
     */
    public String list() {
        String text = "";
        for(int i = 0; i< array.length;i++) {
            if (array[i] == null) {
                break;
            }
            text = text + array[i] + " ";
        }

        return text;
    }
}
