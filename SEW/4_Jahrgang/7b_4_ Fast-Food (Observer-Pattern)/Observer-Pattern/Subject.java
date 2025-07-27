/**
 * Subject für die Observers
 */
interface Subject {
    /**
     * Observer anhängen
     * @param observer neuer Observer
     */
    void attach(Observer observer);

    /**
     * Observer verwerfen
     * @param observer Observer
     */
    void detach(Observer observer);

    /**
     * Observer benachrichtigen
     */
    void notifyObservers();
}