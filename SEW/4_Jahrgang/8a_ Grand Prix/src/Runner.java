import java.util.List;

/**
 * Ein Läufer, der an einem Rennen teilnimmt.
 * @author Kacper Bohaczyk
 * @version 13.03.2024
 */
class Runner implements Runnable {
    private final Kommunikation communicationLogic;
    private final List<Task> calculations;
    private final int id;

    /**
     * Konstruktor für den Läufer.
     * @param id Die eindeutige ID des Läufers.
     *
     * @param communicationLogic Die Kommunikationslogik zwischen Läufer und Schiedsrichter.
     * @param calculations Die Berechnungen für die Geschwindigkeit.
     */
    Runner(int id, Kommunikation communicationLogic, List<Task> calculations) {
        this.id = id;
        this.communicationLogic = communicationLogic;
        this.calculations = calculations;
    }

    /**
     * Der Läufer beginnt zu laufen, sobald das Rennen gestartet wird.
     */
    @Override
    public void run() {
        try {
            communicationLogic.awaitStart();
            int totalTime = 0;

            for (int i = 0; i < calculations.size(); i++) {
                long startTime = System.currentTimeMillis();
                calculations.get(i).performTask();
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;

                if (i == calculations.size() - 1) {
                    communicationLogic.setRaceFinished(true);
                }
                totalTime += (int) elapsedTime;

                String update = "Thread " + id + " hat Runde " + (i + 1) + " nach " + totalTime + "ms abgeschlossen!";
                communicationLogic.sendUpdate(update);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
