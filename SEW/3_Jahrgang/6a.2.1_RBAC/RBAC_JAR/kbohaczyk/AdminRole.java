package kbohaczyk;
/**
 * Die Klasse AdminRole erstellt eine Rolle für den Admin
 * Hier wird der Name und die Beschreibung definiert.
 * @author Kacper Bohaczyk
 * @version 27-03-2023
 */
public class AdminRole implements Role {
    private static final String name = "Admin";
    private static final String beschreibung = "Hat auf das ganze System Zugriffsrechte";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return beschreibung;
    }
}
