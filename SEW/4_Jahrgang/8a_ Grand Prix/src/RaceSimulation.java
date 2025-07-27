import java.util.List;

/**
 * Testklasse für die Lauf-Simulation.
 * @author Kacper Bohaczyk
 * @version 13.03.2024
 */
public class RaceSimulation {
    /**
     * Testmethode für das Rennen.
     * @param args Argumente
     * @throws InterruptedException Ausfall des Threads
     */
    public static void main(String[] args) throws InterruptedException {
        Kommunikation raceComm = new Kommunikation(3);

        List<Task> Tasks1 = List.of(
                new IntensiveCalculationTask(2200),
                new MatrixOperationTask(958),
                new IntensiveDataProcessingTask(10830, 503)
        );

        List<Task> Tasks2 = List.of(
                new MatrixOperationTask(240),
                new IntensiveDataProcessingTask(4000, 5000),
                new IntensiveCalculationTask(5380553)
        );

        List<Task> Tasks3 = List.of(
                new IntensiveDataProcessingTask(80000, 5801),
                new IntensiveCalculationTask(200000),
                new MatrixOperationTask(358)
        );

        List<List<Task>> allRunnerTasks = List.of(
                Tasks1, Tasks2, Tasks3
        );

        Thread[] runnerThreads = new Thread[raceComm.getNumberOfRunners()];
        for (int i = 0; i < runnerThreads.length; i++) {
            runnerThreads[i] = new Thread(new Runner(i + 1, raceComm, allRunnerTasks.get(i)));
            runnerThreads[i].start();
        }

        Referee raceRef = new Referee(raceComm);
        raceRef.startRace();
    }
}
