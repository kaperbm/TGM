import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Eine Klasse für die Kommunikation zwischen Läufern und Schiedsrichtern.
 * @author Kacper Bohaczyk
 * @version 13.03.2024
 */
class Kommunikation {
    private final BlockingQueue<String> updatesQueue = new LinkedBlockingQueue<>();
    private final CountDownLatch startSignal;
    private final int numberOfRunners;

    private boolean isRaceFinished;

    /**
     * Konstruktor für die Kommunikation.
     * @param numberOfRunners Die Anzahl der Läufer im Rennen.
     */
    Kommunikation(int numberOfRunners) {
        this.numberOfRunners = numberOfRunners;
        startSignal = new CountDownLatch(1);
        isRaceFinished = false;
    }

    /**
     * Sendet ein Update an die Warteschlange.
     * @param update Das zu sendende Update.
     * @throws InterruptedException Ausfall des Threads
     */
    void sendUpdate(String update) throws InterruptedException {
        updatesQueue.put(update);
    }

    /**
     * Empfängt das oberste Update aus der Warteschlange.
     * @return Das empfangene Update.
     * @throws InterruptedException Ausfall des Threads
     */
    String receiveUpdate() throws InterruptedException {
        return updatesQueue.take();
    }

    /**
     * Lässt Threads warten, bis das Startsignal erteilt wird.
     * @throws InterruptedException Ausfall des Threads
     */
    void awaitStart() throws InterruptedException {
        startSignal.await();
    }

    /**
     * Gibt das Startsignal für Threads frei.
     */
    void signalStart() {
        startSignal.countDown();
    }

    /**
     * Gibt die Anzahl der Läufer zurück.
     * @return Die Anzahl der Läufer im Rennen.
     */
    int getNumberOfRunners() {
        return numberOfRunners;
    }

    /**
     * Überprüft, ob das Rennen beendet ist.
     * @return true, wenn das Rennen beendet ist, ansonsten false.
     */
    public boolean isRaceFinished() {
        return isRaceFinished;
    }

    /**
     * Setzt den Zustand des Rennens.
     * @param raceFinished Der Zustand des Rennens (beendet oder nicht).
     */
    public void setRaceFinished(boolean raceFinished) {
        isRaceFinished = raceFinished;
    }
}
