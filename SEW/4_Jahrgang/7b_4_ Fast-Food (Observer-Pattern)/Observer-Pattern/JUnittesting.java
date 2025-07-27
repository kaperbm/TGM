import org.junit.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUNIT Tests
 * @author Kacper Bohaczyk
 * @version 2024-01-11
 */
public class JUnittesting {

    private OrderListe liste;
    private AnzeigeOrders anzeigeOrders;
    private POS pos;
    private checkoutterminal checkout;
    private AnzeigeKüche anzeigeKüche;

    @Before
    public void setUp() {
        liste = new OrderListe();
        anzeigeOrders = new AnzeigeOrders(liste);
        pos = new POS();
        checkout = new checkoutterminal();
        anzeigeKüche = new AnzeigeKüche(liste);

        liste.attach(anzeigeKüche);
        liste.attach(anzeigeOrders);
    }

    @Test
    public void testFall1() {
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

        assertTrue(order1.getState() == States.ABGEHOLT);
        assertTrue(order2.getState() == States.ABGEHOLT);
    }

    @Test
    public void testFall2() {
        Order order1 = pos.newOrder(3, 16.90);
        Order order2 = pos.newOrder(4, 3.20);

        liste.addOrder(order1);
        liste.addOrder(order2);

        pos.orderINBEARBEITUNG(liste, order1);
        pos.orderINBEARBEITUNG(liste, order2);

        pos.orderBEREIT(liste, order2);
        pos.orderBEREIT(liste, order1);

        checkout.OrderAbgeholt(liste, order1);
        checkout.OrderAbgeholt(liste, order2);

        assertTrue(order1.getState() == States.ABGEHOLT);
        assertTrue(order2.getState() == States.ABGEHOLT);
    }

    @Test
    public void testFall3() {
        Order order1 = pos.newOrder(5, 11.11);
        Order order2 = pos.newOrder(6, 1);

        liste.addOrder(order1);
        liste.addOrder(order2);

        pos.orderINBEARBEITUNG(liste, order1);
        pos.orderINBEARBEITUNG(liste, order2);

        pos.orderBEREIT(liste, order1);
        pos.orderBEREIT(liste, order2);

        checkout.OrderAbgeholt(liste, order2);

        assertTrue(order1.getState() == States.BEREIT);
        assertTrue(order2.getState() == States.ABGEHOLT);
    }
}
