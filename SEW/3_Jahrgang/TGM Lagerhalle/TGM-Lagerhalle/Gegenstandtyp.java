/**
 *
 * @author Kacper Boahczyk
 * @version 13-04-2023
 */
public enum Gegenstandtyp {

    Kasten("Kasten"),
    Tisch("Tisch"),
    Bett("Bett");


    private String description;

     private Gegenstandtyp(String description) {
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }

}
