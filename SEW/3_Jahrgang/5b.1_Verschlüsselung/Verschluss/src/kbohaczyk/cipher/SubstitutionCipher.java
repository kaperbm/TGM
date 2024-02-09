package kbohaczyk.cipher;

import java.util.Arrays;

/**
 * Eine Erweiterung der MonoAlphabeticCipher Klasse
 * @author Kacper Bohaczyk
 * @version 16-01-2023
 */
public class SubstitutionCipher extends MonoAlphabeticCipher {
    /**
     * Ein neuer Schlüssel wird gesetzt
     * @param secret    Das neue Alphabet (der Schlüssel)
     */
    public SubstitutionCipher(char[] secret){
        if (secret.length != 30) {
            throw new IllegalArgumentException("Das Alphabet muss 30 Zeichen haben");
        }
        char[] sortedAlphabet = Arrays.copyOf(secret, secret.length);
        Arrays.sort(sortedAlphabet);
        for (int i = 1; i < sortedAlphabet.length; i++) {
            if (sortedAlphabet[i] == sortedAlphabet[i-1]) {
                throw new IllegalArgumentException("Buchstaben dürfen nicht doppelt vorkommen");
            }
        }
        super.setSecret(secret);
    }
}
