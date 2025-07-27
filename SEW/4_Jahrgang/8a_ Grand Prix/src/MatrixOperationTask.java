/**
 * Task für das Durchführen von Matrixoperationen
 * @author Kacper Bohaczyk
 * @version 13.03.2024
 */
class MatrixOperationTask extends Task {
    private final int size;

    /**
     * Konstruktor für den Matrix-Operationen-Task
     * @param size Die Größe der Matrix (quadratisch)
     */
    MatrixOperationTask(int size) {
        this.size = size;
    }

    /**
     * Die Aufgabe wird ausgeführt
     */
    @Override
    void performTask() {
        // Erstellen einer quadratischen Matrix mit zufälligen Werten
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }

        // Durchführen einer Matrixoperation (z.B. Matrixmultiplikation)
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += matrix[i][k] * matrix[k][j];
                }
            }
        }
    }
}
