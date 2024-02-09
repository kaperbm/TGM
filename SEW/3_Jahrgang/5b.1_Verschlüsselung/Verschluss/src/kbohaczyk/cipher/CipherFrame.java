package kbohaczyk.cipher;

import javax.swing.*;

/**
 * Ein Frame für das GUI
 * @author Kacper Bohaczyk
 * @version 16-01-2023
 */
public class CipherFrame extends JFrame {
    /**
     * Ein Frame wird für das GUI erstellt
     */
    public CipherFrame() {
        super("Cipher");
        this.add(new CipherPanel());
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 200, 800, 400);
        this.setVisible(true);
    }

    /**
     * Der Frame wird aufgerufen
     * @param args Argumente
     */
    public static void main(String[] args) {
        new CipherFrame();
    }
}