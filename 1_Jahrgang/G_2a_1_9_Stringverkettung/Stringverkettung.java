package sew_1chit;
/**
 * Diese Klasse soll zeigen wie man mehrere String zusammenfügen kann
 * @author Kacper Bohaczyk
 * @date 22-04-2022
 */
public class Stringverkettung
{
    /**
     * Die main Klasse gibt alles aus
     *@param args Argumente
     */
	public static void main(String[] args){
	String txt1;    				// Deklaration des Textes1
	String txt2;    				// Deklaration des Textes2
	String txt3;    				// Deklaration des Textes3
	String txt4;    				// Deklaration des Textes4
	txt1 = "Das ist ";				// Initialision des Textes1
	txt2 = "meine ";				// Initialision des Textes2
	txt3 = "deine ";				// Initialision des Textes3
	txt4 = "Zeichenkette!";			// Initialision des Textes4
	
	System.out.println(txt1 + txt2 + txt4);			// Gibt den text 1,2 und 4 aus 
	System.out.println(txt1 + txt3 + txt4);			// Gibt den text 1,3 und 4 aus
	}
 }