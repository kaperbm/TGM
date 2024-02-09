/**
 * Orders für die Küche anzeigen
 * @author Kacper Bohaczyk
 * @version 2024-01-11
 */
public class AnzeigeKüche implements Observer, Comparable<Observer> {
    private OrderListe liste;

    /**
     * Konstruktor für die Liste
     * @param liste
     */
    public AnzeigeKüche(OrderListe liste) {
        this.liste = liste;
    }

    /**
     * Anzeigen bei Veränderung
     */
    @Override
    public void update() {
        anzeige();
    }

    /**
     * Anzeige der Orders
     */
    private void anzeige() {
        System.out.println("Küchen Orders:");
        for (Order order : liste.getOrders()) {
            if (order.getState() == States.NEU) {
                System.out.println("NR: " + order.getNumber() + " | Price: " + order.getPrice() + " | State: " + order.getState());
            }
        }
        System.out.println();
    }
 //
    @Override
    public int compareTo(Observer o) {
        if(this.getClass() == o.getClass()){
            return 0;
        }
        return 1;
    }
}