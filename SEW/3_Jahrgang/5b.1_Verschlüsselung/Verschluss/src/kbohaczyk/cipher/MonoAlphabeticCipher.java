package kbohaczyk.cipher;

import java.util.Arrays;

/**
 * Die Klasse für die Haubtverschlüsselung und entschlüsselung
 * @author Kacper Boahczyk
 * @version 16-01-2023
 */
public class MonoAlphabeticCipher implements Cipher {

    private static final char[] def = "abcdefghijklmnopqrstuvwxyzäöüß".toCharArray();
    private char[] secret;

    /**
     * Der Konstruktor wird erstellt
     */
    public MonoAlphabeticCipher() {
        this.secret = def;
    }

    /**
     * Ein neuer Schlüssel wird gesetzt
     * @param secret Der neue Schlüssel
     */
    protected void setSecret(char[] secret) {
        this.secret = Arrays.copyOf(secret, secret.length);
    }

    /**
     * Der Schlüssel wird zurückgegeben
     * @return Den Schlüssel
     */
    public char[] getSecret() {
        return Arrays.copyOf(secret, secret.length);
    }

    /**
     * Eine Nachricht wird mit dem Schlüssel verschlüsselt
     * @param text  Die Nachricht
     * @return Die verschlüsselte Nachricht
     */
    @Override
    public String encrypt(String text) {
        text = text.toLowerCase();
        char[] encryptedText = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = String.copyValueOf(def).indexOf(c);
            if (index >= 0){
                encryptedText[i] = secret[index];
            }


        }
        text = String.copyValueOf(encryptedText);
        return text;
    }

    /**
     * Eine verschlüsselte Nachricht wird entschlüsselt
     * @param text  Die verschlüsselte Nachricht
     * @return Die entschlüsselte Nachricht
     */
    @Override
    public String decrypt(String text) {
        text = text.toLowerCase();
        char[] decryptedText = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = String.copyValueOf(secret).indexOf(c);
            if (index >= 0) {
                decryptedText[i] = def[index];
            }
        }
        text = String.copyValueOf(decryptedText);
        return text;
    }

}
