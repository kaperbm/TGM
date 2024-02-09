package kbohaczyk.cipher;

/**
 * Ein Interface für die encrypt und decrypt Methoden
 * @author Kacper Bohaczyk
 * @version 16-01-2023
 */
public interface Cipher {
    String encrypt(String text);
    String decrypt(String text);
}