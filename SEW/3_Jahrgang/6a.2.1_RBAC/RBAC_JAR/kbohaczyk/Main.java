package kbohaczyk;

import kbohaczyk.AdminRole;

public class Main {

    public static void main(String[] args) {

        //Rollen erstellen
        Role guestRole = new GuestRole();
        Role employeeRole = new EmployeeRole();
        Role adminRole = new AdminRole();

        //kbohaczyk.User erstellen
        User user1 = new User("test3");
        User user2 = new User("test4");

        //Rollen zu kbohaczyk.User hinzufügen
        user1.addRole(guestRole);
        user1.addRole(employeeRole);
        user2.addRole(guestRole);

        //Files erstellen
        Resource file1 = new Resource("Test");
        Resource file2 = new Resource("Test2");

        //Rollen zu Files hinzufügen
        file1.addRole(guestRole);
        file1.addRole(employeeRole);
        file2.addRole(adminRole);

        // Zugriff testen
        System.out.println(file1.check(user1)); //true //guest + employee
        System.out.println(file2.check(user1)); //false //admin
        System.out.println(file1.check(user2)); //true //guest + employee
        System.out.println(file2.check(user2)); //false //admin

        //Rollen von Benutzern und Ressourcen entfernen
        user1.delRole(guestRole); //nur mehr employee
        file1.delRole(employeeRole); //nur mehr guest

        System.out.println("\n");
        // erneut Zugriff testen
        System.out.println(file1.check(user1)); //false //guest
        System.out.println(file2.check(user1)); //false //admin
        System.out.println(file1.check(user2)); //true //guest
        System.out.println(file2.check(user2)); //false //admin


    }

}