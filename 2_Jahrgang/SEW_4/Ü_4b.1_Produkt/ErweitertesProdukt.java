package src;
/**
 * Ist eine Erweiterung zu der Klasse Produkt
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
	 * @param ProduktID		Ist die ProduktID die r�bergegeben wird
	 * @param Bezeichnung	Ist die Bezeichnung die r�bergegeben wird
	 * @param Beschreibung	Ist die Beschreibung die r�bergegeben wird
	 * @param Preis			Ist die Preis die r�bergegeben wird
	 * @param rabatt		Ist die Rabatt die r�bergegeben wird
	 */
	public ErweitertesProdukt(int ProduktID, String Bezeichnung, String Beschreibung, double Preis , double rabatt) {
		super(ProduktID, Bezeichnung, Beschreibung, Preis);
		if((rabatt>0) && (rabatt <100)) {
			double prozent = (100-rabatt) /100;
			rabatt = prozent;
			this.rabatt = rabatt;
			}
	}

	/**
	 * Ist der Setter f�r die Bewertung
	 * @param anzahl  ist die l�nge der Arrays
	 */
	public void setBewertungen(int anzahl) {
		this.bewertungen =  new Bewertung [anzahl];
	}
	/**
	 * Ist der Setter f�r den Rabatt
	 * @param rabatt ist der neue Rabatt
	 */
	public void setRabatt(double rabatt) {
		if((rabatt>0) && (rabatt <100)) {
			double prozent = (100-rabatt) /100;
			rabatt = prozent;
		this.rabatt = rabatt;
		}
	}
	
	
	/**
	 * Ist der Getter f�r die Bewertung
	 * @return	gibt das Bewertungs-array zur�ck
	 */
	public Bewertung[] getBewertung() {
		return bewertungen;
	}
	
	/**
	 * Ist der Getter f�r den Rabatt
	 * @return	gibt die rabatt-variable zur�ck
	 */
	public double getRabatt() {
		return rabatt;
	}
	/**
	 * Diese Methode rechnet den ermeassigten Preis aus
	 * @return	gibt den ermaessigten Preis zur�ck
	 */
	public double ermaessigterPreis() {
		
		return super.getPreis() * rabatt;
	}
	
	/**
	 * Diese Methode rechnet den gesamten Preis aus, nachdem er abgerechnet wurde
	 * @return gibt den neuen Preis zur�ck
	 */
	public double gesamtPreis(int anzahl) {
		return (super.getPreis() * anzahl)  * rabatt;
	}
	
	/**
	 * Diese Methode f�gt eine neue Bewertung hinzu
	 * @param bewertung		Ist die neue Bewertung
	 */
	public void neueBewertung(Bewertung bewertung) {
		for(int i = 0; i< bewertungen.length; i++) {
			if(bewertungen[i] == null) {					// Das if-Statement schaut nach ob der Platz im Array leer ist
				bewertungen[i] = bewertung;					// Er f�gt die neue Bewertung in die Bewertungsliste hinzu
				break;										// Unterbricht die for-Schleife
			}
		}
	}
	
	/**
	 * Diese Methode gibt die Durchschnittsbewertung zur�ck
	 * @return die 	Durchschnittsbewertung wird zur�ckgegeben
	 */
	public double durchschnittsbewertung() {
		double durchschnitt = 0.0;
		int div = 0;
		for(int i = 0; i< bewertungen.length; i++) {
			if(bewertungen[i]!= null) {								// Mittels der for-Schleife und dem If-Statement wird ermittelt wie gro� der bef�llte Bereich vom Array ist
				durchschnitt = durchschnitt + bewertungen[i].getBewertung();		
				div++;
			}
		}
		durchschnitt = durchschnitt/div;
		return durchschnitt;
	}
	
	/**
	 * Diese Methode fasst alle Daten in einen String zusammen und gibt ihn dann zur�ck
	 * @return 	Der String wird zur�ckgegeben
	 */
	@Override
	public String toString() {
		String daten = super.toString();
		daten = daten + " (" + ermaessigterPreis() + " Euro mit " + getRabatt() + " Erm��igung) - Wertung: " +  durchschnittsbewertung() +   " (1.5 Schlechte Qualit�t; 4.6 Super Produkt; 3.8 Unfreundlicher Lieferant)\n";
		return daten;
	}
	
	/**
	 * Vergleicht die Atribute des r�bergegebene Produktess mit den des jetzigem
	 * @param p
	 * @return
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
		 * Falls nein k�nnen wie direkt false zur�ckgeben
		 */
		if(p == null) {
			return false;
		}
		
		/*
		 * 3.Schritt	 wir vergleichen ob die Klassen gleich sind
		 * Falls die Klassen nicht gleich sind kann man direkt false zur�ckgeben
		 * dies hat den Grund, weil die Atribute dann anders sind und nicht verglichen werden k�nnen
		 */
		if(getClass() != p.getClass()) {
			return false;
		}
		ErweitertesProdukt erweitertesprodukt = (ErweitertesProdukt) p;
		
		return (super.getBeschreibung() == p.getBeschreibung()) && (super.getBezeichnung() == p.getBezeichnung()) && (super.getPreis() == p.getPreis()) && (super.getProduktID() == p.getProduktID()) && (this.rabatt == p.rabatt);
	}
}