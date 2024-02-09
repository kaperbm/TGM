package kbohaczyk;
import java.io.IOException;

/**
 * Diese Klasse führt und testet das Programm Worttrainer
 * @author Kacper Bohaczyk
 * @version 2022-09-11
 */
public class WortTest {
    /**
     * Main Methode testet folgende Klassen:
     * Worteintrag, Worttrainer und Wortliste
     */
    public static void main(String[] args) throws IOException {

        WortListe liste = new WortListe();
        liste.addWort(new WortEintrag("Banane", "https://www.globus.de/produkte/media/image/6d/a6/fe/46878443.jpg"));
        liste.addWort(new WortEintrag("Apfel", "https://media.istockphoto.com/id/184276818/de/foto/roter-apfel.jpg?s=612x612&w=0&k=20&c=HhxNnyYG6mUOA5bJUlDaoznzdIEtiJzQ5H73mG0ZAeU="));
        liste.addWort(new WortEintrag("Orange", "https://www.boeschbodenspies.com/wp-content/uploads/2017/08/orange.png"));
        liste.addWort(new WortEintrag("Nuss", "https://zwei-wealth.ch/fileadmin/dam/upload/Nuss_knacken.jpg"));


        WortTrainer tr = new WortTrainer(liste);
        // ------------------Test von WortTrainerSpeichern-------------------------------------//
        WortTrainerSpeichern test = new WortTrainerSpeichern(tr);
        test.speichern();
        test.laden();
    }
}