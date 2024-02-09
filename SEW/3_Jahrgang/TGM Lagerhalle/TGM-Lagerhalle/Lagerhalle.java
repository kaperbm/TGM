import java.util.HashMap;

/**
 * @author Kacper Bohaczyk
 * @version 13-04-2023
 */
public class Lagerhalle {
	private String strasse;

	private int hausnummer;

	private String staat;

	private int plz;

	private HashMap<Gegenstand, Integer> bestand = new HashMap<>();

	private UUID UUID;


	/**
	 * Konstruktor
	 */
	public Lagerhalle() {

	}

	/**
	 * Konstrktor
	 * @param strasse
	 * @param hausnummer
	 * @param staat
	 * @param plz
	 */
	public Lagerhalle(String strasse, int hausnummer, String staat, int plz) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.staat = staat;
		this.plz = plz;
	}

	/**
	 * Settet eine UniqueID mit einer Random Zahl
	 */
	private void setUniqueID() {
		this.UUID = new UUID((int)Math.random());
	}

	/**
	 * Gibt die UUID zurück
	 * @return
	 */
	private UUID getUniqueID() {
		return this.UUID;
	}

	/**
	 * Gibt die Strasse zurück
	 * @return
	 */
	public String getStrasse() {
		return this.strasse;
	}

	/**
	 * Setter für die Strasse
	 * @param strasse
	 */
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	/**
	 * Getter für die Hausnummer
	 * @return
	 */
	public int getHausnummer() {
		return this.hausnummer;
	}

	public HashMap getBestand(){
		return this.bestand;
	}

	/**
	 * Setter für die Hausnummer
	 * @param hausnummer
	 */
	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	/**
	 * Getter für den Staat
	 * @return
	 */
	public String getStaat() {
		return this.staat;
	}

	/**
	 * Setter für den Staat
	 * @param staat
	 */
	public void setStaat(String staat) {
		this.staat = staat;
	}

	/**
	 * Getter für die PLZ
	 * @return
	 */
	public int getPlz() {
		return this.plz;
	}

	/**
	 * Setter für die PLZ
	 * @param plz
	 */
	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String bestandDesLagers() {
		String output = "";
		for(Gegenstandtyp typ : Gegenstandtyp.values()) {
			int anzahl = 0;
			for(HashMap.Entry<Gegenstand, Integer> e : bestand.entrySet()) {
				if(e.getKey().getType() == typ) {
					anzahl += e.getValue();
				}
			}
			output += typ.name() + " (" + typ.getDescription() + "): " + anzahl + "; ";
		}
		return output;
	}

	public int bestandAnzahlDesGegenstands(Gegenstand g) {
		return bestand.get(g);
	}

	public void bestandHinzu(Gegenstand g, int anzahl) {
		bestand.put(g, anzahl);
	}

	public int bestandWeg(Gegenstand g) {
		return 	bestand.remove(g);
	}

	/**
	 * Overrides
	 * @param obj
	 * @return
	 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Lagerhalle other = (Lagerhalle) obj;
			if (this.bestand != other.bestand)
				return false;
			if(this.plz  != other.plz) {
				return false;
			}
			if(this.staat != other.staat){
				return false;
			}
			if(this.hausnummer != other.hausnummer) {
				return false;
			}
			if (this.UUID != other.UUID) {
				return false;
			}
			return true;
	}

	/**
	 * Gibt die Atribute als ein Text zurück
	 * @return
	 */
	public String toString() {
		String text;
		text = this.getStrasse() + " " + this.getStaat() +  " " + this.getPlz()+ " " + this.getHausnummer() + " " + this.getBestand() + " " + this.getUniqueID();
		return  text;
	}

	/**
	 * Hash map für das Lagerhalle Object
	 * @return
	 */
	public int hashCode() {
		int result = 17;
		result = 31 * result + strasse.hashCode();
		result = 31 * result + staat.hashCode();
		result = 31 * result + UUID.hashCode();
		result = 31 * result + plz;
		result = 31 * result + hausnummer;
		return result;
	}
}
