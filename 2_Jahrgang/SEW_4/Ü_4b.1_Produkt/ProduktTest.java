package src;

/**
 * Diese Klasser ist die Main Klasse der Produkte
 * @author 	Kacper Bohaczyk
 * @date 	22-04-2022
 */
public class ProduktTest {
	
	/**
	 * Ist die main Klasse
	 * @param args Argumente
	 */
	public static void main(String[]args) {
		Produkt p1 = new Produkt(987654321, "Mappe rot", "eine d�nne rote Mappe", 2.49);
		Produkt p2 = new Produkt(987654321, "Mappe rot", "eine d�nne rote Mappe", 2.49);
		Produkt p3 = new Produkt(15082005, "Radiergummi", "Ein Radiergummi zum l�schen", 1.50);
		
		ErweitertesProdukt pe1 = new ErweitertesProdukt(15082005, "Radiergummi", "Ein Radiergummi zum l�schen", 3.0 , 20);
		ErweitertesProdukt pe2 = new ErweitertesProdukt(15082005, "Radiergummi", "Ein Radiergummi zum l�schen", 3.0 , 20);
		ErweitertesProdukt pe3 = new ErweitertesProdukt(23221315, "Bleistift", "Ein Bleistift zum schreiben", 2.0 , 10);
		pe1.setBewertungen(4);	

		Bewertung bewertung = new Bewertung(3.0,"Ziemlich gut");
		Bewertung bewertung2 = new Bewertung(5.0,"Excellent");
		Bewertung bewertung3 = new Bewertung(5.0,"Excellent");

		/*
		 * Hier wird alles Vorbereitet um die Methoden zu testen
		 */
		
		System.out.println(p3.gesamtPreis(3));					// Testet aus ob die Methode gesamtPreis richtig funktioniert
		System.out.println(p3.toString());						// Testet aus ob alle Daten r�bergegeben werden
		System.out.println("Vergleich: " + p1.equals(p2));		// vergleicht ob die Methode equals aus der Klasse "Produkt" funktioniert (solte true zur�ckgeben)
		System.out.println("Vergleich: " + p1.equals(p3));		// vergleicht ob die Methode equals aus der Klasse "Produkt" funktioniert (solte false zur�ckgeben)
		System.out.print(p1.hashCode());						// f�hrt die Methode hashCode aus der Klasse "Produkt" aus
		/**
		 * Hier werden alle Methoden f�r die Klasse: "Produkt" getestet
		 */
		
		pe1.setBewertungen(4);								// settet die l�nge f�r den Bewertungsarray
		pe1.neueBewertung(bewertung);							// F�gt eine neue Bewertung hinzu um die Methode durchschnittsbewertung austesten zu k�nnen
		pe1.neueBewertung(bewertung2);							// F�gt eine neue Bewertung hinzu um die Methode durchschnittsbewertung austesten zu k�nnen
		System.out.println(pe1.ermaessigterPreis());		// probiert die Methode ermaessigterPreis aus
		System.out.println(pe1.gesamtPreis(2));				// checkt nach ob die Methode gesamtPreis funktioniert
		System.out.println(pe1.durchschnittsbewertung());	// gibt die Durchschnittsbewertung zur�ck
		System.out.print(pe1.toString());					// gibt alle Daten in einem String zur�ck
		System.out.println(pe1.equals(pe2));				// vergleicht ob die Methode equals aus der Klasse ErweitertesProdukt funktioniert (solte true zur�ckgeben)
		System.out.println(pe1.equals(pe3));				// vergleicht ob die Methode equals aus der Klasse ErweitertesProdukt funktioniert (solte false zur�ckgeben)
		System.out.println(pe1.hashCode());					// f�hrt die Methode hashCode aus der Klasse "ErweitertesProdukt" aus
		/**
		 * Hier werden alle Methoden f�r die Klasse: "ErweitertesProdukt2 getestet
		 */
		System.out.println("Vergleich: " + bewertung2.equals(bewertung3));	// vergleicht ob die Methode equals in der Klasse Bewertung funktioniert (solte true zur�ckgeben)
		System.out.println("Vergleich: " + bewertung.equals(bewertung2));		// vergleicht ob die Methode equals in der Klasse Bewertung funktioniert (solte true zur�ckgeben)
		System.out.print(bewertung.hashCode());							// f�hrt die Methode hashCode aus der Klasse "Bewertung" aus
		/**
		 * Hier werden alle Methoden f�r die Klasse: "Bewertung" getestet
		 */
	}
}
