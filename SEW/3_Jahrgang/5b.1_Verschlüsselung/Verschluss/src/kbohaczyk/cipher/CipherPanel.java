package kbohaczyk.cipher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Das Panel zur GUI
 * @author Kacper Bohaczyk
 * @version 16-01-2023
 */
public class CipherPanel extends JPanel {
    private JTextField feld;
    private JTextField ausgabe;
    private JButton encryptB;
    private JButton decryptB;
    private JComboBox cipherAuswahl;

    private JPanel obererPanel;
    private JPanel mittlererPanel;
    private JPanel untererPanel;

    /**
     * Ein Panel wird für das GUI erstellt
     */
    public CipherPanel(){
        feld = new JTextField(40);
        ausgabe = new JTextField(40);
        ausgabe.setEditable(false);
        encryptB = new JButton("Encrypt");
        decryptB = new JButton("Decrypt");
        cipherAuswahl = new JComboBox(new String[] { "Monoalphabetic Cipher", "Substitution Cipher", "Shift Cipher" });

        obererPanel = new JPanel();
        obererPanel.add(encryptB);
        obererPanel.add(decryptB);

        mittlererPanel = new JPanel();
        mittlererPanel.add(feld);
        mittlererPanel.add(ausgabe);

        untererPanel = new JPanel();
        untererPanel.add(new JLabel("Cipher:"));
        untererPanel.add(cipherAuswahl);

        this.setLayout(new BorderLayout());
        this.add(obererPanel, BorderLayout.NORTH);
        this.add(mittlererPanel, BorderLayout.CENTER);
        this.add(untererPanel, BorderLayout.SOUTH);

        Controller actionListener = new Controller();
        encryptB.addActionListener(actionListener);
        decryptB.addActionListener(actionListener);
        cipherAuswahl.addActionListener(actionListener);
    }

    /**
     * Der Controller zur GUI
     */
    public class Controller implements ActionListener {
        MonoAlphabeticCipher mac;
        JTextField secret;
        JSpinner verschiebung;

        /**
         * Einzelne Aktionen werden abgeprüft
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == encryptB) {

                String selectedCipher = (String) cipherAuswahl.getSelectedItem();
                if (selectedCipher.equals("Monoalphabetic Cipher")) {
                    mac = new MonoAlphabeticCipher();
                } else if (selectedCipher.equals("Substitution Cipher")) {
                    mac = new SubstitutionCipher(secret.getText().toCharArray());
                } else if (selectedCipher.equals("Shift Cipher")) {
                    mac = new ShiftCipher((Integer) verschiebung.getValue());
                }

                ausgabe.setText(mac.encrypt(feld.getText()));
            } else if (e.getSource() == decryptB) {

                String selectedCipher = (String) cipherAuswahl.getSelectedItem();
                if (selectedCipher.equals("Monoalphabetic Cipher")) {
                    mac = new MonoAlphabeticCipher();
                } else if (selectedCipher.equals("Substitution Cipher")) {
                    mac = new SubstitutionCipher(secret.getText().toCharArray());
                } else if (selectedCipher.equals("Shift Cipher")) {
                    mac = new ShiftCipher((Integer) verschiebung.getValue());
                }

                ausgabe.setText(mac.decrypt(feld.getText()));
            }

            else if (e.getSource() == cipherAuswahl) {
                untererPanel.removeAll();
                untererPanel.add(cipherAuswahl);
                if (cipherAuswahl.getSelectedIndex() == 1) {
                    untererPanel.add(new JLabel("Secret alphabet:"));
                    secret = new JTextField(30);
                    untererPanel.add(secret);
                } else if (cipherAuswahl.getSelectedIndex() == 2) {
                    untererPanel.add(new JLabel("Shift value:"));
                    verschiebung = new JSpinner(new SpinnerNumberModel(0, 0, 29, 1));
                    untererPanel.add(verschiebung);
                }
                untererPanel.revalidate();
                untererPanel.repaint();
            }

        }
    }
}
