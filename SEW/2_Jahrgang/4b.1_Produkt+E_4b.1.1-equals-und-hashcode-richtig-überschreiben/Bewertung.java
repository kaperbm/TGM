package src;
/**
 * Ist die Bewertungs Klasse
 * Sie beinhaltet schon alle Erweiterungen der Aufgabe "E 4b.1.1 equals und hashcode richtig �berschreiben"
 * @author Kacper Bohaczyk
 * @date 10.3.2022
 */
public class Bewertung {

	private double bewertung;
	private String anmerkung;

	/**
	 * Ist der Konstruktor zum Bewertungs Objekt
	 * @param bewertung	ist eine double variable die eine Bewertung darstellen soll
	 * @param anmerkung	ist ist ein String in dem eine Anmerkung stehen soll
	 */
	public Bewertung(double bewertung, String anmerkung) {
		this.bewertung = bewertung;
		this.anmerkung = anmerkung;
	}
	
	/**
	 * Ist der Setter f�r die Bewertung
	 * @param wert 	ist eine double Variable die den Wert representiert
	 */
	public void setBewertung(double wert) {
		this.bewertung = wert;
	}
	
	/**
	 * Ist der Setter f�r die Variable Anmerkung
	 * @param anmerkung 	ist ein String der eine Anmerkung representieren soll
	 */
	public void setAnmerkung(String anmerkung) {
		this.anmerkung = anmerkung;
	}
	
	/**
	 * Ist die Getter-Methode f�r die Variable Bewertung
	 * @return gibt die Bewertung zur�ck
	 */
	public double getBewertung() {
		return bewertung;
	}
	
	/**
	 * Ist die Getter-Methode f�r die Variable Anmerkung
	 * @return gibt die Anmerkung zur�ck
	 */
	public String getAnmerkung() {
		return anmerkung;
	}
	
	/**
	 * Fasst alle Argumente des Produktes in ein String zusammen
	 * @return	Es gibt alle Daten in einem String zur�ck
	 */
	@Override
	public String toString() {
		String werte = bewertung + " - " + anmerkung;
		return werte;
	}
	
	/**
	 * 	Diese Methode vergleicht die Atribute der r�bergegebenen Bewertung mit der der jetzigem
	 * @param b	ist das Bewertung Objekt
	 * @return	gibt zur�ck ob die beiden Bewertungen �bereinstimmen
	 */
	public boolean equals(Bewertung b) {
		/*
		 * 1.Schritt wir schauen ob die Referenz gleich ist
		 * Falls ja ist es exact dasselbe Produkt
		 */
		if(this == b) {
			return true;
		}
		
		/*
		 * 2.Schritt	wir schauen ob das Objekt existiert
		 * Falls nein k�nnen wie direkt false zur�ckgeben
		 */
		if(b == null) {
			return false;
		}
		
		/*
		 * 3.Schritt	 wir vergleichen ob die Klassen gleich sind
		 * Falls die Klassen nicht gleich sind kann man direkt false zur�ckgeben
		 * dies hat den Grund, weil die Atribute dann anders sind und nicht verglichen werden k�nnen
		 */
		if(getClass() != b.getClass()) {
			return false;
		}
		Bewertung bewertung = (Bewertung) b;
		
		return (this.bewertung == b.getBewertung() && this.anmerkung == b.getAnmerkung());
	}
	
	/**
	 * Diese Methode gibt den HashCode ausgerechnet durch die Formel zur�ck
	 */
	@Override
	public int hashCode() {
		double hash = bewertung + this.anmerkung.hashCode();
		return (int) hash;
	}
}
