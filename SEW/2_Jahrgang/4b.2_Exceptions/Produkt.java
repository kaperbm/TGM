package src;

/**
 * Diese Klasse simuliert ein Produkt
 * Sie beinhaltet eine ID, Bezeichnung, eine Beschreibung und einen Preis
 * Die neue Version wurde mit Exceptions erweitert
 * Mache Exceptions wurden extra gemacht, ohne in der Angabe verlang zu werden
 * @author Kacper Bohaczyk
 * @date 22-04-2022
 */
public class Produkt {
	
	private long ProduktID;
	private  String Bezeichnung;
	private String Beschreibung;
	private double Preis;
	/*
	 * Das sind alle privaten Argumente
	 */
	
	/**
	 * Ist der Konstuktor zum Produkt
	 * @param ProduktID 			ist die ID des Produktes
	 * @param Beizeichnung 			ist die Bezeichnung des Produktes
	 * @param Beschreibung 			ist die Beschreibung des Produktes
	 * @param Preis 			ist der Preis des Produktes
	 * @throws NumericRangeException	Diese Exception catcht ob die rübergegebenen Parameter im gültigem Bereich sind
	 */
	public Produkt(long ProduktID, String Bezeichnung, String Beschreibung, double Preis) throws NumericRangeException {
		String IDString = ProduktID + "";	// Ist für das Kontrollieren der ID da
		int laenge = 0;				// Ist für das Kontrollieren der Bezeichnung da
		
		if(IDString.length() > 6) {
			this.ProduktID = ProduktID;
		}
		else {
			throw new NumericRangeException("Die ID muss minimum 7 Stellen aufweisen!+");	// Die Exception wird geworfen falls die länge kürzer ist als 7
		}
		/*
		 * Der Produkt-Parameter wird kontroliert und bei Fähler trifft eine Exception auf
		 */
		
		if(Bezeichnung != null) {
			if(Bezeichnung.length()>1) {
				for(int x = 0; x< Bezeichnung.length(); x++) {
					if(Bezeichnung.charAt(x) != ' ') {
						laenge++;
						if(laenge >1) {
							this.Bezeichnung = Bezeichnung;
							break;
						}
					}
					else {
						throw new IllegalArgumentException("Es dürfen in der Bezeichnung keine Leerzeichen vorkommen!");	// Die Exception wird geworfen falls die Leerzeichen im Parameter vorkommen
					}
				}
			}
			else {
				throw new IllegalArgumentException("Die Bezeichnung darf nicht leer sein!");	// Die Exception wird geworfen falls der Parameter leer ist
			}
		}
		/*
		 * Der Bezeichnung-Parameter wird kontroliert und bei Fähler trifft eine Exception auf
		 */
		
		if(Beschreibung != null) {
			this.Beschreibung = Beschreibung;
		}
		else {
			throw new IllegalArgumentException("Die Beschreibung darf nicht leer sein!");		// Die Exception wird geworfen falls der Parameter leer ist
		}
		/*
		 * Der Beschreibung-Parameter wird kontroliert und bei Fähler trifft eine Exception auf
		 */
		
		if(Preis >= 0) {
		this.Preis = Preis;
		}
		else {
			throw new NumericRangeException("Der Preis darf nicht negativ sein");			// Die Exception wird geworfen falls der Parameter negativ ist
		}
		/*
		 * Der Preis-Parameter wird kontroliert und bei Fähler trifft eine Exception auf
		 */
	}
	
	/**
	 * Gibt einen Gesamtpreis zurück
	 * @param stueckZahl	Ist die Stückanzahl die rübergegeben wurde
	 * @return 		Gibt den umgerechneten Preis zurück
	 */
	public double gesamtPreis(int stueckZahl) {
		if(stueckZahl >=0) {
			return stueckZahl * Preis;
		}
		else {
			throw new IllegalArgumentException("Es darf keine negative Anzahl an Stücken rübergegeben werden");	// Die Exception wird geworfen falls der Parameter im negativen Bereich ist
		}
	}
	
	/**
	 * Fasst alle Argumente des Produktes in ein String zusammen
	 * @return	Es gibt alle Daten in einem String zurück
	 */
	@Override
	public String toString() {
		String daten = ProduktID + " - " + Bezeichnung + ": " + Beschreibung + " - " + Preis;
		return daten;
	}
	
	/**
	 * Ist der Setter für den Preis
	 * @param Preis	Ist der neue Preis
	 * @throws NumericRangeException 	Diese Exception catcht ob die rübergegebenen Parameter im gültigem Bereich sind
	 */
	public void setPreis( double Preis) throws NumericRangeException {
		if(Preis >= 0) {
			this.Preis = Preis;
			}
			else {
				throw new NumericRangeException("Der Preis darf nicht negativ sein");	// Die Exception wird geworfen falls der Parameter negativ ist
			}
	}
	
	/**
	 * Ist der Setter für die Bezeichnung
	 * @param Bezeichnung	Ist die neue Bezeichnung
	 * @throws NumericRangeException   Diese Exception catcht ob die rübergegebenen Parameter im gültigem Bereich sind
	 */
	public void setBezeichnung(String Bezeichnung) throws NumericRangeException {
		int laenge = 0;
		if(Bezeichnung != null) {
			if(Bezeichnung.length()>1) {
				for(int x = 0; x> Bezeichnung.length(); x++) {
					if(Bezeichnung.charAt(x) != ' ') {
						laenge++;
						if(laenge >1) {
							this.Bezeichnung = Bezeichnung;
							break;
						}
					}
					else {
						throw new IllegalArgumentException("Es dürfen in der Bezeichnung keine Leerzeichen vorkommen!");	// Die Exception wird geworfen falls die Leerzeichen im Parameter vorkommen
					}
				}
			}
			else {
				throw new IllegalArgumentException("Die Bezeichnung darf nicht leer sein!");	// Die Exception wird geworfen falls der Parameter leer ist
			}
		}
	}
	
	/**
	 * Ist der Setter für die Beschreibung
	 * @param Beschreibung	Ist die neue Beschreibung
	 * @throws NumericRangeException 	Diese Exception catcht ob die rübergegebenen Parameter im gültigem Bereich sind
	 */
	public void setBeschreibung( String Beschreibung) throws NumericRangeException {
		if(Beschreibung != null) {
			this.Beschreibung = Beschreibung;
		}
		else {
			throw new IllegalArgumentException("Die Beschreibung darf nicht leer sein!");		// Die Exception wird geworfen falls der Parameter leer ist
		}
	}
	
	/**
	 * Ist der Setter für die ProduktID
	 * @param ProduktID			Ist die neue ProduktID
	 * @throws NumericRangeException 	Diese Exception catcht ob die rübergegebenen Parameter im gültigem Bereich sind
	 */
	public void setProduktID( int ProduktID) throws NumericRangeException {
		String IDString = ProduktID + "";	// Ist für das Kontrollieren der ID da
		int laenge = 0;				// Ist für das Kontrollieren der Bezeichnung da
		
		if(IDString.length() > 6) {
			this.ProduktID = ProduktID;
		}
		else {
			throw new NumericRangeException("Die ID muss minimum 7 Stellen aufweisen!+");	// Die Exception wird geworfen falls die länge kürzer ist als 7
		}
	}
	
	 /**
	  * Ist die Getter-Methode für den Preis
	  * @return	Gibt den Preis des Produktes zurück
	  */
	public double getPreis() {
		return Preis;
	}
	
	/**
	 * Ist die Getter-Methode für die Beschreibung
	 * @return	Gibt die Beschreibung des Produktes zurück
	 */
	public String getBeschreibung() {
		return Beschreibung;
	}
	
	/**
	 * Ist die Getter-Methode für die Bezeichnung
	 * @return	Gibt die Beschreibung des Produktes zurück
	 */
	public String getBezeichnung() {
		return Bezeichnung;
	}
	
	/**
	 * Ist die Getter-Methode für die ID
	 * @return Gibt die ProduktID zurück
	 */
	public long getProduktID() {
		return ProduktID;
	}
	
	/**
	 * Vergleicht die Atribute des rübergegebenen Produktes mit den des jetzigem
	 * @param p 	Ist das Produkt welches mit diesem verglichen wird
	 * @return 	Gibt zurück ob beide Produkte identisch sind oder nicht
	 */
	public boolean equals(Produkt p) {
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
		
		/*
		 *  4.Schritt	wir konventieren den Typ um
		 *  dies ist dazu da, damit wir auf die Atribute und Methoden zugreifen können
		 */
		Produkt produkt = (Produkt) p;
		
		/**
		 * 5.Schritt	wie vergeleichen die Atribute miteinander
		 */
		return (this.Beschreibung == p.getBeschreibung()) && (this.Bezeichnung == p.getBezeichnung()) && (this.Preis == p.getPreis()) && (this.ProduktID == p.ProduktID);
	}
	
	/**
	 * Gibt den HashCode ausgerechnet durch die Formel zurück
	 */
	@Override
	public int hashCode() {
		double hash = Preis + Bezeichnung.hashCode() + Beschreibung.hashCode() + ProduktID ;
		return (int) hash;
	}

}
