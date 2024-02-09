package kbohaczyk;

import java.util.HashSet;
import java.util.Set;

/**
 * kbohaczyk.User Klasse
 * @author Kacper Bohaczyk
 * @version 27-03-2023
 */
public class User {
    private String name;
    private Set<Role> roles = new HashSet<>();

    /**
     * Konstruktor des Users
     * @param name name
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Getter Methode für den Namen
     * @return gibt den Namen zurück
     */
    public String getName() {
        return name;
    }

    /**
     * Added die Rolle zum Set
     * @param role
     */
    public void addRole(Role role) {
        roles.add(role);
    }

    /**
     * Löscht die Rolle aus dem Set
     * @param role
     */
    public void delRole(Role role) {
        roles.remove(role);
    }

    /**
     * Gibt die Rollen zurück
     * @return Rolle
     */
    public Set<Role> getRoles() {
        return roles;
    }
}