import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Erstelle eine neue Lagerhalle
        Lagerhalle lagerhalle = new Lagerhalle("JojoGasse", 15, "Morioh", 15);

        // Erstelle einige Gegenstände
        Gegenstand kasten = new Gegenstand( "Kasten");
        Gegenstand tisch = new Gegenstand( "Tisch");
        Gegenstand sessel = new Gegenstand( "Sessel");

        // Füge einige Gegenstände zur Lagerhalle hinzu
        lagerhalle.bestandHinzu(kasten, 6);
        lagerhalle.bestandHinzu(tisch, 2);
        lagerhalle.bestandHinzu(sessel, 3);


        // Überprüfe, ob die Duplikatserkennung und Sortierung im SortedSet funktionieren
        SortedSet<Gegenstand> gegenstaende = new TreeSet<Gegenstand>();
        gegenstaende.add(sessel);
        gegenstaende.add(kasten);
        gegenstaende.add(tisch);

        System.out.print(lagerhalle.toString());
    }
}