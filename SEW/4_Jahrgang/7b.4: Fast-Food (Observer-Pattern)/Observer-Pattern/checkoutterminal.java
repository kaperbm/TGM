/**
 * Order-Status zu Abgeholt setzen
 * @author Kacper Bohaczyk
 * @version 2024-01-11
 */
public class checkoutterminal {
    /**
     * Order wird abgeholt
     * @param liste Die Liste der Orders
     * @param order die gesuchte Order
     */
    public void OrderAbgeholt(OrderListe liste, Order order) {
        liste.setState(order, States.ABGEHOLT);
    }
}
