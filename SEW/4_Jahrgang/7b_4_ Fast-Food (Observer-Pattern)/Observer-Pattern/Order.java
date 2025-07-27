/**
 * Bestellung
 * @author Kacper Bohaczyk
 * @version 2024-01-11
 */
class Order{
    private int number;
    private double price;
    private States state;

    /**
     * Konstruktor für Order
     * @param number Ordernummer
     * @param price Preis
     */
    public Order(int number, double price) {
        this.number = number;
        this.price = price;
        this.state = States.NEU;
    }

    /**
     * neuer Status
     * @param state Status
     */
    public void setState(States state) {
        this.state = state;
    }

    /**
     * Status zurückgeben
     * @return Status
     */
    public States getState() {
        return this.state;
    }

    /**
     * Nummer zurückgeben
     * @return Nummer
     */
    public int getNumber() {
        return number;
    }

    /**
     * Preis zurückgeben
     * @return Preis
     */
    public double getPrice() {
        return price;
    }

}