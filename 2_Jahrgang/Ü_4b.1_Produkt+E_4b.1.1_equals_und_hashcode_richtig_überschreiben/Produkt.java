package src;
/**
 * Diese Klasse simuliert ein Produkt
 * Sie beinhaltet eine ID, Bezeichnung, eine Beschreibung und einen Preis
 * Sie wurde schon mit dem Inhalt der Aufgabe "E 4b.1.1 equals und hashcode richtig �berschreiben" modifiziert
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
	 * Gibt einen Gesamtpreis zur�ck
	 * @param stueckZahl	Ist die St�ckanzahl die r�bergegeben wurde
	 * @return 		Gibt den umgerechneten Preis zur�ck
	 */
	public double gesamtPreis(int stueckZahl) {
		return stueckZahl * Preis;
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
	 */
	public void setPreis( double Preis) {
		this.Preis = Preis;
	}
	
	/**
	 * Ist der Setter f�r die Bezeichnung
	 * @param Bezeichnung	Ist die neue Bezeichnung
	 */
	public void setBezeichnung( String Bezeichnung) {
		this.Bezeichnung = Bezeichnung;
	}
	
	/**
	 * Ist der Setter f�r die Beschreibung
	 * @param Beschreibung	Ist die neue Beschreibung
	 */
	public void setBeschreibung( String Beschreibung) {
		this.Beschreibung = Beschreibung;
	}
	
	/**
	 * Ist der Setter f�r die ProduktID
	 * @param ProduktID	Ist die neue ProduktID
	 */
	public void setProduktID( int ProduktID) {
		this.ProduktID = ProduktID;
	}
	
	 /**
	  * Ist die Getter-Methode f�r den Preis
	  * @return	Gibt den Preis des Produktes zur�ck
	  */
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

}