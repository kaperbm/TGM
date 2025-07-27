import java.util.Random;

/**
 * Task für das Durchführen einer intensiven Berechnung auf einer großen Datenmenge mit primitiven Datentypen
 * @author Kacper Bohaczyk
 * @version 13.03.2024
 */
class IntensiveDataProcessingTask extends Task {
    private final int[] data;
    private final int iterations;

    /**
     * Konstruktor für den Task der intensiven Datenverarbeitung
     * @param dataSize Die Größe der zu verarbeitenden Daten
     * @param iterations Die Anzahl der Iterationen für die Berechnung
     */
    IntensiveDataProcessingTask(int dataSize, int iterations) {
        this.data = new int[dataSize];
        this.iterations = iterations;
        // Initialisierung des Datenarrays mit zufälligen Werten
        Random random = new Random();
        for (int i = 0; i < dataSize; i++) {
            data[i] = random.nextInt(100);
        }
    }

    /**
     * Die Aufgabe wird ausgeführt
     */
    @Override
    void performTask() {
        for (int i = 0; i < iterations; i++) {
            // Kopieren des Datenarrays für jede Iteration, um unabhängige Berechnungen durchzuführen
            int[] processedData = new int[data.length];
            System.arraycopy(data, 0, processedData, 0, data.length);

            // Intensive Berechnung auf den Daten durchführen
            for (int j = 0; j < processedData.length; j++) {
                processedData[j] = intensiveOperation(processedData[j]);
            }

            // Optional: Ergebnisse der Berechnung ausgeben
            // System.out.println("Ergebnisse der intensiven Berechnung Iteration " + (i + 1) + ": " + Arrays.toString(processedData));
        }
    }

    /**
     * Eine intensive Operation auf einem Datenpunkt durchführen
     * (Hier eine einfache Beispieloperation: Quadrieren)
     * @param value Der zu verarbeitende Datenpunkt
     * @return Das Ergebnis der Operation
     */
    private int intensiveOperation(int value) {
        return value * value;
    }
}
