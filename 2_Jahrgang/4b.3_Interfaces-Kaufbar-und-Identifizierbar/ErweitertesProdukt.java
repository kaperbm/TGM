package src;
/**
 * Ist eine Erweiterung zu der Klasse Produkt
 * Sie wurde mit Exceptions erweitert
 * Mache Exceptions wurden extra gemacht, ohne in der Angabe verlang zu werden
 * @author 	Kacper Bohaczyk
 * @date	10.3.2022
 */
public class ErweitertesProdukt extends Produkt {

	private double rabatt;
	private Bewertung [] bewertungen; 
	/*
	 * Das sind alle privaten Argumente der Klasse: "ErweitertesProdukt"
	 */
	
	/**
	 * Ist der Konstruktor zum erweiterten Produkt
	 * @param ProduktID			Ist die ProduktID die rübergegeben wird
	 * @param Bezeichnung		Ist die Bezeichnung die rübergegeben wird
	 * @param Beschreibung		Ist die Beschreibung die rübergegeben wird
	 * @param Preis				Ist die Preis die rübergegeben wird
	 * @param rabatt			Ist die Rabatt die rübergegeben wird
	 * @throws NumericRangeException	Diese Exception catcht ob die rübergegebenen Parameter im gültigem Bereich sind
	 */
	public ErweitertesProdukt(int ProduktID, String Bezeichnung, String Beschreibung, double Preis , double rabatt) throws NumericRangeException {
		super(ProduktID, Bezeichnung, Beschreibung, Preis);
		
		if((rabatt>=0) && (rabatt <=100)) {
			double prozent = (100-rabatt) /100;
			rabatt = prozent;
			this.rabatt = rabatt;
			}
		else {
			throw new NumericRangeException("Der Rabatt muss größer als 0 sein, aber kleiner als 100!");				// Die Exception wird geworfen falls der Parameter größer als 100 oder kleiner als 0 ist
		}
	}

	/**
	 * Ist der Setter für die Bewertung
	 * @param anzahl  ist die länge der Arrays
	 */
	public void setBewertungen(int anzahl) {
		if(anzahl >=0) {
		this.bewertungen =  new Bewertung [anzahl];
		}
		else {
			throw new IllegalArgumentException("Die Anzahl darf nicht negativ sein!");									// Die Exception wird geworfen, falls der Parameter im negativen Bereich ist
		}
	}
	/**
	 * Ist der Setter für den Rabatt
	 * @param rabatt ist der neue Rabatt
	 * @throws NumericRangeException	Diese Exception catcht ob die rübergegebenen Parameter im gültigem Bereich sind
	 */
	public void setRabatt(double rabatt) throws NumericRangeException {
		if((rabatt>=0) && (rabatt <=100)) {
			double prozent = (100-rabatt) /100;
			rabatt = prozent;
		this.rabatt = rabatt;
		}
		else {
			throw new NumericRangeException("Der Rabatt muss größer als 0 sein, aber kleiner als 100!");				// Die Exception wird geworfen falls der Parameter größer als 100 oder kleiner als 0 ist
		}
	}
	
	
	/**
	 * Ist der Getter für die Bewertung
	 * @return	gibt das Bewertungs-array zurück
	 */
	public Bewertung[] getBewertung() {
		return bewertungen;
	}
	
	/**
	 * Ist der Getter für den Rabatt
	 * @return	gibt die rabatt-variable zurück
	 */
	public double getRabatt() {
		return rabatt;
	}
	/**
	 * Diese Methode rechnet den ermeassigten Preis aus
	 * @return	gibt den ermaessigten Preis zurück
	 */
	public double ermaessigterPreis() {
		
		return super.getPreis() * rabatt;
	}
	
	/**
	 * Diese Methode rechnet den gesamten Preis aus, nachdem er abgerechnet wurde
	 * @return gibt den neuen Preis zurück
	 */
	public double gesamtPreis(int anzahl) {
		return (super.getPreis() * anzahl)  * rabatt;
	}
	
	/**
	 * Diese Methode fügt eine neue Bewertung hinzu
	 * @param bewertung	Ist die neue Bewertung
	 */
	public void neueBewertung(Bewertung bewertung) {
		for(int i = 0; i< bewertungen.length; i++) {
			if(bewertungen[i] == null) {					// Das if-Statement schaut nach ob der Platz im Array leer ist
				bewertungen[i] = bewertung;					// Er fügt die neue Bewertung in die Bewertungsliste hinzu
				break;										// Unterbricht die for-Schleife
			}
		}
	}
	
	/**
	 * Diese Methode gibt die Durchschnittsbewertung zurück
	 * @return die 	Durchschnittsbewertung wird zurückgegeben
	 */
	public double durchschnittsbewertung() {
		double durchschnitt = 0.0;
		int div = 0;
		for(int i = 0; i< bewertungen.length; i++) {
			if(bewertungen[i]!= null) {					// Mittels der for-Schleife und dem If-Statement wird ermittelt wie groß der befüllte Bereich vom Array ist
				durchschnitt = durchschnitt + bewertungen[i].getBewertung();		
				div++;
			}
		}
		durchschnitt = durchschnitt/div;
		return durchschnitt;
	}
	
	/**
	 * Diese Methode fasst alle Daten in einen String zusammen und gibt ihn dann zurück
	 * @return 	Der String wird zurückgegeben
	 */
	@Override
	public String toString() {
		String daten = super.toString();
		daten = daten + " (" + ermaessigterPreis() + " Euro mit " + getRabatt() + " Ermäßigung) - Wertung: " +  durchschnittsbewertung() +   " (1.5 Schlechte Qualität; 4.6 Super Produkt; 3.8 Unfreundlicher Lieferant)\n";
		return daten;
	}
	
	/**
	 * Vergleicht die Atribute des rübergegebene Produktess mit den des jetzigem
	 * @param p 	Ist ErweiterteProdukt, welches verglichen wird
	 * @return	Gibt zurück ob die Atribute übereinstimmen
	 */
	public boolean equals(ErweitertesProdukt p) {
		/*
		 * 1.Schritt wir schauen ob die Referenz gleich ist
		 * Falls ja ist es exact dasselbe Produkt
		 */
		if(this == p) {
			return true;
		}
		
		/*
		 * 2.Schritt	wir schauen ob das Objekt existiert
		 * Falls nein können wie direkt false zurückgeben
		 */
		if(p == null) {
			return false;
		}
		
		/*
		 * 3.Schritt	 wir vergleichen ob die Klassen gleich sind
		 * Falls die Klassen nicht gleich sind kann man direkt false zurückgeben
		 * dies hat den Grund, weil die Atribute dann anders sind und nicht verglichen werden können
		 */
		if(getClass() != p.getClass()) {
			return false;
		}
		ErweitertesProdukt erweitertesprodukt = (ErweitertesProdukt) p;
		
		return (super.getBeschreibung() == p.getBeschreibung()) && (super.getBezeichnung() == p.getBezeichnung()) && (super.getPreis() == p.getPreis()) && (super.getProduktID() == p.getProduktID()) && (this.rabatt == p.rabatt);
	}
}