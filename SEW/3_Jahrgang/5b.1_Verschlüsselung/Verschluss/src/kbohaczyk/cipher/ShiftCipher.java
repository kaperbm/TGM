package kbohaczyk.cipher;

/**
 * Eine Erweiterung der MonoAlphabeticCipher Klasse
 * @author Kacper Bohaczyk
 * @version 16-01-2023
 */
public class ShiftCipher extends MonoAlphabeticCipher {
    private static final char[] def = "abcdefghijklmnopqrstuvwxyzäöüß".toCharArray();

    /**
     * Die Stellen im Alphabet werden um eien bestimte Anzahl an Stellen verschoben
     * @param shiftValue    Die Anzahl der Stellen
     */
    public ShiftCipher(int shiftValue) {
        if (shiftValue < 0){
            shiftValue = -shiftValue;
        }
        char[] secretAlphabet = new char[30];
        int minus = 0;
        for (int i = 0; i < 30; i++) {
           if (i+shiftValue < 30) {
               secretAlphabet[i] = def[i + shiftValue];
           } else{
               secretAlphabet[i] = def[minus];
               minus++;
           }
        }
        super.setSecret(secretAlphabet);
    }

    /**
     * Eine neue Anazahl der Stellen wird gesetzt
     * @param shiftValue    Die Anzahl der Stellen
     */
    public void setShiftValue(int shiftValue) {
        if (shiftValue < 0){
            shiftValue = -shiftValue;
        }
        char[] secretAlphabet = new char[30];
        int minus = 0;
        for (int i = 0; i < 30; i++) {
            if (i+shiftValue <= 30) {
                secretAlphabet[i] = def[i + shiftValue];
            } else{
                secretAlphabet[i] = def[minus];
                minus++;
            }
        }
        super.setSecret(secretAlphabet);
    }
}
