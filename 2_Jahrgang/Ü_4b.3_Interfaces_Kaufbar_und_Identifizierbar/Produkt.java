package src;

/**
 * Diese Klasse simuliert ein Produkt
 * Sie beinhaltet eine ID, Bezeichnung, eine Beschreibung und einen Preis
 * Die neue Version wurde mit Exceptions erweitert
 * Mache Exceptions wurden extra gemacht, ohne in der Angabe verlang zu werden
 * In dieser Erweiterung wurde um Kaufbar und Identifizierbar erweitert 
 * @author Kacper Bohaczyk
 * @date 22-04-2022
 */
public class Produkt implements Kaufbar,  Identifizierbar {
	
	private long ProduktID;
	private  String Bezeichnung;
	private String Beschreibung;
	private double Preis;
	/*
	 * Das sind alle privaten Argumente
	 */
	
	/**
	 * Ist der Konstuktor zum Produkt
	 * @param ProduktID 	ist die ID des Produktes
	 * @param Beizeichnung 	ist die Bezeichnung des Produktes
	 * @param Beschreibung 	ist die Beschreibung des Produktes
	 * @param Preis 		ist der Preis des Produktes
	 * @throws NumericRangeException	Diese Exception catcht ob die r�bergegebenen Parameter im g�ltigem Bereich sind
	 */
	public Produkt(long ProduktID, String Bezeichnung, String Beschreibung, double Preis) throws NumericRangeException {
		String IDString = ProduktID + "";	// Ist f�r das Kontrollieren der ID da
		int laenge = 0;						// Ist f�r das Kontrollieren der Bezeichnung da
		
		if(IDString.length() > 6) {
			this.ProduktID = ProduktID;
		}
		else {
			throw new NumericRangeException("Die ID muss minimum 7 Stellen aufweisen!+");	// Die Exception wird geworfen falls die l�nge k�rzer ist als 7
		}
		/*
		 * Der Produkt-Parameter wird kontroliert und bei Fehler trifft eine Exception auf
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
						throw new IllegalArgumentException("Es d�rfen in der Bezeichnung keine Leerzeichen vorkommen!");	// Die Exception wird geworfen falls die Leerzeichen im Parameter vorkommen
					}
				}
			}
			else {
				throw new IllegalArgumentException("Die Bezeichnung darf nicht leer sein!");	// Die Exception wird geworfen falls der Parameter leer ist
			}
		}
		/*
		 * Der Bezeichnung-Parameter wird kontroliert und bei F�hler trifft eine Exception auf
		 */
		
		if(Beschreibung != null) {
			this.Beschreibung = Beschreibung;
		}
		else {
			throw new IllegalArgumentException("Die Beschreibung darf nicht leer sein!");		// Die Exception wird geworfen falls der Parameter leer ist
		}
		/*
		 * Der Beschreibung-Parameter wird kontroliert und bei F�hler trifft eine Exception auf
		 */
		
		if(Preis >= 0) {
		this.Preis = Preis;
		}
		else {
			throw new NumericRangeException("Der Preis darf nicht negativ sein");				// Die Exception wird geworfen falls der Parameter negativ ist
		}
		/*
		 * Der Preis-Parameter wird kontroliert und bei F�hler trifft eine Exception auf
		 */
	}
	
	/**
	 * Gibt einen Gesamtpreis zur�ck
	 * @param stueckZahl	Ist die St�ckanzahl die r�bergegeben wurde
	 * @return 				Gibt den umgerechneten Preis zur�ck
	 */
	@Override
	public double gesamtPreis(int stueckZahl)throws NumericRangeException {
		if(stueckZahl >=0) {
			return stueckZahl * Preis;
		}
		else {
			throw new NumericRangeException("Es darf keine negative Anzahl an St�cken r�bergegeben werden");	// Die Exception wird geworfen falls der Parameter im negativen Bereich ist
		}
	}
	
	/**
	 * Fasst alle Argumente des Produktes in ein String zusammen
	 * @return	Es gibt alle Daten in einem String zur�ck
	 */
	@Override
	public String toString() {
		String daten = ProduktID + " - " + Bezeichnung + ": " + Beschreibung + " - " + Preis;
		return daten;
	}
	
	/**
	 * Ist der Setter f�r den Preis
	 * @param Preis	Ist der neue Preis
	 * @throws NumericRangeException 	Diese Exception catcht ob die r�bergegebenen Parameter im g�ltigem Bereich sind
	 */
	public void setPreis( double Preis) throws NumericRangeException {
		if(Preis >= 0) {
			this.Preis = Preis;
			}
			else {
				throw new NumericRangeException("Der Preis darf nicht negativ sein");				// Die Exception wird geworfen falls der Parameter negativ ist
			}
	}
	
	/**
	 * Ist der Setter f�r die Bezeichnung
	 * @param Bezeichnung	Ist die neue Bezeichnung
	 * @throws NumericRangeException 	Diese Exception catcht ob die r�bergegebenen Parameter im g�ltigem Bereich sind
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
						throw new IllegalArgumentException("Es d�rfen in der Bezeichnung keine Leerzeichen vorkommen!");	// Die Exception wird geworfen falls die Leerzeichen im Parameter vorkommen
					}
				}
			}
			else {
				throw new IllegalArgumentException("Die Bezeichnung darf nicht leer sein!");	// Die Exception wird geworfen falls der Parameter leer ist
			}
		}
	}
	
	/**
	 * Ist der Setter f�r die Beschreibung
	 * @param Beschreibung	Ist die neue Beschreibung
	 * @throws NumericRangeException 	Diese Exception catcht ob die r�bergegebenen Parameter im g�ltigem Bereich sind
	 */
	public void setBeschreibung( String Beschreibung) throws NumericRangeException {
		if(Beschreibung != null) {
			this.Beschreibung = Beschreibung;
		}
		else {
			throw new IllegalArgumentException("Die Beschreibung darf nicht leer sein!");				// Die Exception wird geworfen falls der Parameter leer ist
		}
	}
	
	/**
	 * Ist der Setter f�r die ProduktID
	 * @param ProduktID	Ist die neue ProduktID
	 * @throws NumericRangeException 	Diese Exception catcht ob die r�bergegebenen Parameter im g�ltigem Bereich sind
	 */
	public void setProduktID( int ProduktID) throws NumericRangeException {
		String IDString = ProduktID + "";	// Ist f�r das Kontrollieren der ID da
		int laenge = 0;						// Ist f�r das Kontrollieren der Bezeichnung da
		
		if(IDString.length() > 6) {
			this.ProduktID = ProduktID;
		}
		else {
			throw new NumericRangeException("Die ID muss minimum 7 Stellen aufweisen!+");	// Die Exception wird geworfen falls die l�nge k�rzer ist als 7
		}
	}
	
	 /**
	  * Ist die Getter-Methode f�r den Preis
	  * @return	Gibt den Preis des Produktes zur�ck
	  */
	@Override
	public double getPreis() {
		return Preis;
	}
	
	/**
	 * Ist die Getter-Methode f�r die Beschreibung
	 * @return	Gibt die Beschreibung des Produktes zur�ck
	 */
	public String getBeschreibung() {
		return Beschreibung;
	}
	
	/**
	 * Ist die Getter-Methode f�r die Bezeichnung
	 * @return	Gibt die Beschreibung des Produktes zur�ck
	 */
	public String getBezeichnung() {
		return Bezeichnung;
	}
	
	/**
	 * Ist die Getter-Methode f�r die ID
	 * @return Gibt die ProduktID zur�ck
	 */
	public long getProduktID() {
		return ProduktID;
	}
	
	/**
	 * Vergleicht die Atribute des r�bergegebenen Produktes mit den des jetzigem
	 * @param p 	Ist das Produkt welches mit diesem verglichen wird
	 * @return 	Gibt zur�ck ob beide Produkte identisch sind oder nicht
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
		
		/*
		 *  4.Schritt	wir konventieren den Typ um
		 *  dies ist dazu da, damit wir auf die Atribute und Methoden zugreifen k�nnen
		 */
		Produkt produkt = (Produkt) p;
		
		/**
		 * 5.Schritt	wie vergeleichen die Atribute miteinander
		 */
		return (this.Beschreibung == p.getBeschreibung()) && (this.Bezeichnung == p.getBezeichnung()) && (this.Preis == p.getPreis()) && (this.ProduktID == p.ProduktID);
	}
	
	/**
	 * Gibt den HashCode ausgerechnet durch die Formel zur�ck
	 */
	@Override
	public int hashCode() {
		double hash = Preis + Bezeichnung.hashCode() + Beschreibung.hashCode() + ProduktID ;
		return (int) hash;
	}

	@Override
	public String identifier() {
		String id = this.ProduktID + "";
		for(int x = id.length(); x < 15; x++) {
			id = "0" + id;
		}
		return id;
	}

}