package kbohaczyk;

import java.util.HashSet;
import java.util.Set;

/**
 * kbohaczyk.Resource Klasse
 * @author Kacper Bohaczyk
 * @verion 27-03-2023
 */
public class Resource {
    private String name;
    private Set<Role> allowedRoles = new HashSet<>();

    /**
     * Konstruktor der Klasse kbohaczyk.Resource
     * @param name name
     */
    public Resource(String name) {
        this.name = name;
    }

    /**
     * Getter für den Namen
     * @return gibt den Namen
     */
    public String getName() {
        return name;
    }

    /**
     * Added die Rolle zum Set
     * @param role gibt die Rolle
     */
    public void addRole(Role role) {
        allowedRoles.add(role);
    }

    /**
     * Löscht die kbohaczyk.Role aus Set
     * @param role Löscht die Rolle
     */
    public void delRole(Role role) {
        allowedRoles.remove(role);
    }

    /**
     * Added Rollen
     * @return
     */
    public Set<Role> addRoles() {
        return allowedRoles;
    }

    /**
     * Checkt obb die Rolle allowed ist
     * @param user
     * @return
     */
    public boolean check(User user) {
        for (Role role : user.getRoles()) {
            if (allowedRoles.contains(role)) {
                return true;
            }
        }
        return false;
    }
}