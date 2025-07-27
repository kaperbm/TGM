/**
 * POS
 * @author Kacper Bohaczyk
 * @version 2024-01-11
 */

class POS {
    /**
     * Neue Order
     * @param orderNumber Nummer
     * @param price Preis
     * @return neue Order
     */
    public Order newOrder(int orderNumber, double price) {
        return new Order(orderNumber, price);
    }

    /**
     * Order wird bearbeitet
     * @param liste Liste
     * @param order Order
     */
    public void orderINBEARBEITUNG(OrderListe liste, Order order) {
        liste.setState(order, States.IN_BEARBEITUNG);
    }

    /**
     * Order ist bereit
     * @param liste Liste
     * @param order Orders
     */
    public void orderBEREIT(OrderListe liste, Order order) {
        liste.setState(order, States.BEREIT);
    }
}
