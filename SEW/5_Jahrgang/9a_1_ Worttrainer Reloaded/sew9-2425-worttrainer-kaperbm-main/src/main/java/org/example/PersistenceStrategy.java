package org.example;

import java.io.IOException;

public interface PersistenceStrategy {

    /**
     * Speichert den aktuellen Zustand des Rechtschreibtrainers.
     *
     * @param trainer Der Rechtschreibtrainer, dessen Zustand gespeichert werden soll.
     * @param fileName Der Name der Datei, in die der Zustand geschrieben werden soll.
     * @throws IOException Wenn es ein Problem beim Speichern gibt.
     */
    void save(Rechtschreibtrainer trainer, String fileName) throws IOException;

    /**
     * Lädt den gespeicherten Zustand des Rechtschreibtrainers.
     *
     * @param fileName Der Name der Datei, aus der der Zustand gelesen werden soll.
     * @return Der geladene Rechtschreibtrainer.
     * @throws IOException Wenn es ein Problem beim Laden gibt.
     */
    Rechtschreibtrainer load(String fileName) throws IOException;
}
