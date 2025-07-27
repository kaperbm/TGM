import java.math.BigInteger;
import java.util.Random;

/**
 * Task für intensive Berechnungen auf großen Zahlen mit variabler Schwierigkeit
 * @author Kacper Bohaczyk
 * @version 13.03.2024
 */
class IntensiveCalculationTask extends Task {
    private final int difficulty;
    private final Random random;

    /**
     * Konstruktor für den intensiven Berechnungs-Task
     * @param difficulty Die Schwierigkeit der Berechnung
     */
    IntensiveCalculationTask(int difficulty) {
        this.random = new Random();
        this.difficulty = difficulty;
    }

    /**
     * Die Aufgabe wird ausgeführt
     */
    @Override
    void performTask() {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < difficulty; i++) {
            result = result.multiply(BigInteger.valueOf(random.nextInt(1000)));
        }
    }
}
