package sew_1chit;	// Das package einfach löschen falls in BlueJ programmiert werden muss
import javax.swing.JOptionPane;
/**
 * Das Programm rechnet jeden Rechenforgang mit von der User eingebenen Zahlen
 * @author Kacper Bohaczyk
 * @version 22-04-2022
 */
public class Dezimalzahlen{
    public static void main(String[] args){
        String eingabe = JOptionPane.showInputDialog(null, "Mit welcher Zahl soll gerechnet werden?");	
        double zahl = Double.parseDouble(eingabe);
        String eingabe2 = JOptionPane.showInputDialog(null, "Mit welcher Zahl soll gerechnet werden?");
        double zahl2 = Double.parseDouble(eingabe2);
        /*
         * In dem Oberem Breich werden die Zahlen eingegeben
         */
        double addition = zahl+zahl2;
        System.out.println("Summe: " + zahl + " + " + zahl2 + " = " + addition); 
        double subtraktion = zahl-zahl2;
        System.out.println("Differenz: " +zahl + " - " + zahl2 + " = " + subtraktion); 
        double multiplikation = zahl*zahl2;
        System.out.println("Produkt: " +zahl + " * " + zahl2 + " = " + multiplikation); 
        double division = zahl/zahl2;
        System.out.println("Quotient: " +zahl + " / " + zahl2 + " = " + division);
        /*
         * Hier werden die Zahlen Addiert Subtrahiert Multiplitzirt und Dividiert 
         */
    }
}
