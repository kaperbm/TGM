import java.lang.Comparable;
/**
 * @author Kacper Bohaczyk
 * @version 13-04-2023
 */
public class Gegenstand implements Comparable{

	private String name;

	private int weight;

	Gegenstandtyp type;

	/**
	 * Konstruktor
	 * @param name
	 */
	public Gegenstand(String name) {
		this.name = name;
	}

	/**
	 * Konstrukor mit Paramether
	 * @param name
	 * @param type
	 * @param weight
	 */
	public void Gegenstand(String name, Gegenstandtyp type, int weight) {
	this.name = name;
	this.type = type;
	this.weight = weight;
	}

	/**
	 * Getter für den Typ
	 * @return
	 */
	public Gegenstandtyp getType() {
		return type;
	}

	/**
	 * Setter für den tüp
	 * @param type
	 */
	public void setType(Gegenstandtyp type) {
		this.type = type;
	}

	/**
	 * Getter für das Gewicht
	 * @return
	 */
	public int getWeight() {
		return this.weight;
	}

	/**
	 * Setter für das Gewicht
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Getter für den Namen
	 * @return
	 */
	public String getName() {
		return this.name;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gegenstand other = (Gegenstand) obj;
		if (this.name != other.name)
			return false;
		if (this.weight !=other.weight) {
			return false;
		}
		if(this.type != other.type){
			return false;
		}
		return true;
	}

	public int compareTo(Gegenstand other){
		if(this.weight < other.weight) {
			return -1;
		}
		else if (this.weight > other.weight) {
			return 1;
		}
		if(this.type != other.type) {
			return -1;
		}
		if(this.name != other.name) {
			return -1;
		}
		return 0;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
