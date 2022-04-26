package src;

/**
 * Dieses Interface kann fuer alle Klassen verwendet werden, die Objekte darstellen, welche
 * gekauft werden koennen.
 * Diese Klasse ist geblieben wie bei der Angabe. Der Einzige Unterschied ist, dass ich die Deutschen Buchstaben mit Englischen erstetzt habe( wegen uebergabefehlern)
 * @author Lisa Vittori
 * @version 20.03.2018
 */
public interface Kaufbar {
	/**
	 * Liefert den Preis des kaufbaren Objekts als Dezimalzahl (in Euro)
	 * @return den Preis des kaufbaren Objekts
	 */
	public double getPreis();
	
	/**
	 * Berechnet den Gesamtpreis des kaufbaren Objekts anhand der Uebergebenen Stueck-Anzahl
	 * und gibt diesen als Dezimalzahl zurueck.
	 * @param anzahl die Anzahl der gekauften Stuecke
	 * @return den Gesamtpreis anhand der Uebergebenen Anzahl an Stuecken
	 * @throws NumericRangeException falls die Uebergebene Anzahl 0 oder negativ ist
	 */
	public double gesamtPreis(int anzahl) throws NumericRangeException;
}
