package kbohaczyk;
/**
 * Die Klasse GuestRole erstellt eine Rolle für den Gast
 * Hier wird der Name und die Beschreibung definiert.
 * @author Kacper Boahczyk
 * @version 27-03-2023
 */
public class GuestRole implements Role {
    private static final String name = "Guest";
    private static final String beschreibung = "Hat beschränkten Zugriff auf das System";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return beschreibung;
    }
}
