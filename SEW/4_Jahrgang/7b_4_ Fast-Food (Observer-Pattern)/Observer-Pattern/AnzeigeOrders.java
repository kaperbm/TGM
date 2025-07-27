/**
 * Anzeige der Kassa Bestellungen
 * @author Kacper Bohaczyk
 * @version 2024-01-11
 */
class AnzeigeOrders implements Observer, Comparable<Observer> {
    private OrderListe liste;

    /**
     * Konstruktor für die Liste
     * @param liste
     */
    public AnzeigeOrders(OrderListe liste) {
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
     * Bestellungen werden angezeigt
     */
    private void anzeige() {
        System.out.println("Kassen Orders:");
        for(Order order : liste.getOrders())
            if (order.getState() != States.ABGEHOLT) {
                System.out.println("NR: " + order.getNumber() + " | State: " + order.getState());
            }
        System.out.println();
    }

    @Override
    public int compareTo(Observer o) {
        if(this.getClass() == o.getClass()){
            return 0;
        }
        return 1;
    }
}