package kbohaczyk;
import javax.swing.*;
import java.net.MalformedURLException;

/**
 * Das ist die Frame Klasse
 * sie bestimmt das Fenster
 * @author Kacper Bohaczyk
 * @version 09-01-2023
 */
public class TrainerFrame extends JFrame {
    public TrainerFrame() throws MalformedURLException {
        super("Wort-Trainer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WortListe liste = new WortListe();
        liste.addWort(new WortEintrag("Apfel", "https://res.cloudinary.com/saas-ag/image/upload/w_1200,h_630,b_white,c_pad,q_auto,f_auto/v1664972437/mpreis/products/ac8c0f84-00fa-4ae1-8f75-d32e6b9d5973.jpg"));
        liste.addWort(new WortEintrag("Banane", "https://www.globus.de/produkte/media/image/6d/a6/fe/46878443.jpg"));
        liste.addWort(new WortEintrag("Orange", "https://www.issgesund.at/img/uploads/large/5f76e6a8e1468_orangen.jpg"));
        liste.addWort(new WortEintrag("Nuss", "https://cdn.duden.de/_media_/full/N/Nuss-201020427386.jpg"));
        WortTrainer trainer = new WortTrainer(liste);
        Controller cont = new Controller(trainer);
        this.add(cont.getView());
        this.pack();
        this.setVisible(true);

    }
    public static void main(String[] args) throws MalformedURLException {
        new TrainerFrame();
    }
}
