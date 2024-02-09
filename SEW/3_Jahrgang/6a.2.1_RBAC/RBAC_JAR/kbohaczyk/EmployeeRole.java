package kbohaczyk;


/**
 * Die Klasse EmployeeRole erstellt eine Rolle für den Mitarbeiter
 * Hier wird der Name und die Beschreibung definiert.
 * @author Manuel Durst
 * @version 27-03-2023
 */
public class EmployeeRole implements Role {
    private static final String name = "Employee";
    private static final String beschreibung = "Hat auf den Großteil des Systems zugriff";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return beschreibung;
    }
}
