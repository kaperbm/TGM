/**
 * Testklasse
 * @author Kacper Bohaczyk
 * @version 2024-01-11
 */
public class Main {
    /**
     * Testen der Anzeige der Orders
     * @param args Argumente
     */
    public static void main(String[] args) {

        OrderListe liste;
        AnzeigeOrders anzeigeOrders;
        POS pos;
        checkoutterminal checkout;
        AnzeigeKüche anzeigeKüche;

        liste = new OrderListe();
        anzeigeOrders = new AnzeigeOrders(liste);
        pos = new POS();
        checkout = new checkoutterminal();
        anzeigeKüche = new AnzeigeKüche(liste);

        liste.attach(anzeigeKüche);
        liste.attach(anzeigeOrders);
        // Test1
        Order order1 = pos.newOrder(1, 5);
        Order order2 = pos.newOrder(2, 2.30);

        liste.addOrder(order1);
        liste.addOrder(order2);

        pos.orderINBEARBEITUNG(liste, order1);
        pos.orderINBEARBEITUNG(liste, order2);

        pos.orderBEREIT(liste, order1);
        pos.orderBEREIT(liste, order2);

        checkout.OrderAbgeholt(liste, order1);
        checkout.OrderAbgeholt(liste, order2);

        // Test2
        Order order3 = pos.newOrder(3, 16.90);
        Order order4 = pos.newOrder(4, 3.20);

        liste.addOrder(order3);
        liste.addOrder(order4);

        pos.orderINBEARBEITUNG(liste, order3);
        pos.orderINBEARBEITUNG(liste, order4);

        pos.orderBEREIT(liste, order4);
        pos.orderBEREIT(liste, order3);

        checkout.OrderAbgeholt(liste, order3);
        checkout.OrderAbgeholt(liste, order4);

        // Test3
        Order order5 = pos.newOrder(5, 11.11);
        Order order6 = pos.newOrder(6, 1);

        liste.addOrder(order5);
        liste.addOrder(order6);

        pos.orderINBEARBEITUNG(liste, order5);
        pos.orderINBEARBEITUNG(liste, order6);

        pos.orderBEREIT(liste, order5);
        pos.orderBEREIT(liste, order6);

        checkout.OrderAbgeholt(liste, order6);
        checkout.OrderAbgeholt(liste, order5);
    }
}