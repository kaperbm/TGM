package src;
/**
 * Diese Klasse simuliert ein Produkt
 * Sie beinhaltet eine ID, Bezeichnung, eine Beschreibung und einen Preis
 * Sie wurde schon mit dem Inhalt der Aufgabe "E 4b.1.1 equals und hashcode richtig überschreiben" modifiziert
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
	 * @param ProduktID 	ist die ID des Produktes
	 * @param Beizeichnung 	ist die Bezeichnung des Produktes
	 * @param Beschreibung 	ist die Beschreibung des Produktes
	 * @param Preis 	ist der Preis des Produktes
	 */
	public Produkt(long ProduktID, String Bezeichnung, String Beschreibung, double Preis) {
		this.ProduktID = ProduktID;
		this.Bezeichnung = Bezeichnung;
		this.Beschreibung = Beschreibung;
		this.Preis = Preis;
	}
	
	/**
	 * Gibt einen Gesamtpreis zurück
	 * @param stueckZahl	Ist die Stückanzahl die rübergegeben wurde
	 * @return 		Gibt den umgerechneten Preis zurück
	 */
	public double gesamtPreis(int stueckZahl) {
		return stueckZahl * Preis;
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
	 */
	public void setPreis( double Preis) {
		this.Preis = Preis;
	}
	
	/**
	 * Ist der Setter für die Bezeichnung
	 * @param Bezeichnung	Ist die neue Bezeichnung
	 */
	public void setBezeichnung( String Bezeichnung) {
		this.Bezeichnung = Bezeichnung;
	}
	
	/**
	 * Ist der Setter für die Beschreibung
	 * @param Beschreibung	Ist die neue Beschreibung
	 */
	public void setBeschreibung( String Beschreibung) {
		this.Beschreibung = Beschreibung;
	}
	
	/**
	 * Ist der Setter für die ProduktID
	 * @param ProduktID	Ist die neue ProduktID
	 */
	public void setProduktID( int ProduktID) {
		this.ProduktID = ProduktID;
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