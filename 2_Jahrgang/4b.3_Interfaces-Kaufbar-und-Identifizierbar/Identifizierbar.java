package src;

/**
 * Hiermit werden alle Objekte gekennzeichnet, die eine Textuelle ID von mindestens 15
 * Stellen zurueckgeben koennen.
 * Diese Klasse ist geblieben wie bei der Angabe. Der Einzige Unterschied ist, dass ich die Deutschen Buchstaben mit Englischen erstetzt habe( wegen uebergabefehlern)
 * @author Lisa Vittori
 * @version 20.03.2018
 */
public interface Identifizierbar {
	/**
	 * Diese Methode gibt einen ID-Bezeichnung mit mindestens 15 Stellen zurueck
	 * @return eine ID als Text mit mindestens 15 Zeichen.
	 */
	public String identifier();
}
