import org.example.Rechtschreibtrainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Testing {

    private Rechtschreibtrainer trainer;

    @BeforeEach
    public void setUp() {
        trainer = new Rechtschreibtrainer();
    }

    @Test
    public void testAddWortBildPaar() throws MalformedURLException {
        // Arrange
        String wort = "Pikachu";
        String url = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png";

        // Act
        trainer.addWortBildPaar(wort, url);

        // Assert
        assertEquals(1, trainer.getTrainingsDatenListe().size());
        assertEquals("Pikachu", trainer.getTrainingsDatenListe().get(0).getWort());
        assertEquals(new URL(url), trainer.getTrainingsDatenListe().get(0).getUrl());
    }

    @Test
    public void testWortBildPaarMitUngültigerURL() {
        // Arrange
        String wort = "InvalidURLTest";
        String url = "invalid-url";

        // Act
        trainer.addWortBildPaar(wort, url);

        // Assert
        assertEquals(0, trainer.getTrainingsDatenListe().size(), "Das Wort-Bild-Paar sollte nicht hinzugefügt werden.");
    }

    @Test
    public void testWaehleZufall() throws MalformedURLException {
        // Arrange
        trainer.addWortBildPaar("Pikachu", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png");
        trainer.addWortBildPaar("Charmander", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png");

        // Act
        trainer.waehleZufall();

        // Assert
        assertNotNull(trainer.getAktuellesPaar(), "Es sollte ein zufälliges Wort-Bild-Paar gewählt werden.");
    }

    @Test
    public void testPruefeAntwortRichtig() throws MalformedURLException {
        // Arrange
        trainer.addWortBildPaar("Pikachu", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png");
        trainer.waehleZufall();

        // Act
        boolean isCorrect = trainer.pruefeAntwort("Pikachu");

        // Assert
        Assertions.assertTrue(isCorrect, "Die Antwort sollte korrekt sein.");
        assertEquals(1, trainer.getRichtigeVersuche(), "Die Anzahl der richtigen Versuche sollte 1 sein.");
        assertEquals(1, trainer.getGesamteVersuche(), "Die Anzahl der gesamten Versuche sollte 1 sein.");
        assertEquals(0, trainer.getFalscheVersuche(), "Die Anzahl der falschen Versuche sollte 0 sein.");
    }

    @Test
    public void testPruefeAntwortFalsch() throws MalformedURLException {
        // Arrange
        trainer.addWortBildPaar("Pikachu", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png");
        trainer.waehleZufall();

        // Act
        boolean isCorrect = trainer.pruefeAntwort("Charmander");

        // Assert
        Assertions.assertFalse(isCorrect, "Die Antwort sollte falsch sein.");
        assertEquals(0, trainer.getRichtigeVersuche(), "Die Anzahl der richtigen Versuche sollte 0 sein.");
        assertEquals(1, trainer.getGesamteVersuche(), "Die Anzahl der gesamten Versuche sollte 1 sein.");
        assertEquals(1, trainer.getFalscheVersuche(), "Die Anzahl der falschen Versuche sollte 1 sein.");
    }


    @Test
    public void testWaehleZufallMitLeererListe() {
        // Act
        trainer.waehleZufall();

        // Assert
        assertNull(trainer.getAktuellesPaar(), "Es sollte kein Paar ausgewählt werden, wenn die Liste leer ist.");
    }
}
