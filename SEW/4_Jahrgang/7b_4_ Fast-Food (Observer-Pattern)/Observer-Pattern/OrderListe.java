import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Subjekt konkret
 * @author Kacper Bohaczyk
 * @version 2024-01-11
 */
public class OrderListe implements Subject {
    ArrayList<Order> orders;
    Set<Observer> observers;

    /**
     * Konstruktor der Liste
     */
    OrderListe(){
        orders = new ArrayList<>();
        observers = new TreeSet<>();
    }

    /**
     * neue Order
     * @param o Order
     */
    public void addOrder(Order o){
        orders.add(o);
        notifyObservers();
    }

    /**
     * neuer Observer
     * @param observer neue Observer
     */
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        this.notifyObservers();
    }

    /**
     * Observer entfernen
     * @param observer entfernter Observer
     */
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Observer Nachricht
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * neuer Status setzten
     * @param o Order
     * @param state neuer Status
     */
    public void setState(Order o, States state){
        for(Order order : orders)
            if (order.equals(o)){
                o.setState(state);
                notifyObservers();
            }
    }

    /**
     * Alle Orders zurückgeben
     * @return Liste der Orders
     */
    public ArrayList<Order> getOrders(){
        return this.orders;
    }
}
