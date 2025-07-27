/**
 * Klasse, die den Ablauf des Rennens überwacht.
 * @author Kacper Bohaczyk
 * @version 13.03.2024
 */
class Referee {
    private final Kommunikation kommunikation;

    /**
     * Konstruktor für den Referee.
     * @param kommunikation Die Kommunikationslogik für die Interaktion mit den Läufern.
     */
    Referee(Kommunikation kommunikation) {
        this.kommunikation = kommunikation;
    }

    /**
     * Startet das Rennen.
     * @throws InterruptedException Ausfall eines Threads
     */
    void startRace() throws InterruptedException {
        System.out.println("Die Läufer sind bereit...");
        kommunikation.signalStart();
        System.out.println("Start!");

        int numRounds = kommunikation.getNumberOfRunners();
        int numRunners = kommunikation.getNumberOfRunners();
        int nextPlace = 1;

        for (int i = 0; i < numRounds; i++) {
            for (int j = 0; j < numRunners; j++) {
                String update = kommunikation.receiveUpdate();
                if (kommunikation.isRaceFinished()){
                    update += " Platz " + nextPlace + "!";
                    kommunikation.setRaceFinished(false);
                    nextPlace++;
                }
                System.out.println(update);
            }
        }
    }
}
