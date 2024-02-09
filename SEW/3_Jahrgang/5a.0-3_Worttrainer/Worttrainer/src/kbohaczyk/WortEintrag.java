package kbohaczyk;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Diese Klasse nimmt ein Wort und eine URL auf und erstellt ein Objekt
 * Dabei überprüft sie auch nach gültigkeit der URL
 * @author Kacper Bohaczyk
 * @version 2022-09-11
 */

public class WortEintrag {
    private String Wort;
    private String URL;

    /**
     * Konstruktor der Klasse
     * @param Wort ist das übergebene Wort
     * @param URL ist die übergebene URL
     */
    public WortEintrag(String Wort, String URL) {
        if(Wort.length() >= 2) {
            this.Wort = Wort;
        }
        else{
            System.err.println("Das Wort muss mindestens 2 Buchstaben beinhalten");
        }
        this.URL = URL;
    }

    /**
     * Die Methode checkURL überprüft die URL nach gültigkeit
     * @return gibt zurück ob die URL gültig ist
     */
    public static boolean checkURL(String URL){

        if(URL.startsWith("https://")){
            char c1 = URL.charAt(8);
            if (!(c1 >= 'A' && c1 <= 'Z') && !(c1 >= 'a' && c1 <= 'z')) {
                return false;
            }
            if(!(URL.charAt(9) == '.')){
                return false;
            }
            char c2 = URL.charAt(10);
            if (!(c2 >= 'A' && c2 <= 'Z') && !(c2 >= 'a' && c2 <= 'z')) {
                return false;
            }
            return true;
        }
        else if(URL.startsWith("http://")){
            char c1 = URL.charAt(7);
            if (!(c1 >= 'A' && c1 <= 'Z') && !(c1 >= 'a' && c1 <= 'z')) {
                return false;
            }
            if(!(URL.charAt(8) == '.')){
                return false;
            }
            char c2 = URL.charAt(9);
            if (!(c2 >= 'A' && c2 <= 'Z') && !(c2 >= 'a' && c2 <= 'z')) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     *
     */
    public void setURL(String url) {
        if(checkURL(url)) {
            this.URL = url;
        }
    }

    /**
     * Getter Methode vom Atribut Wort
     * @return gibt das Wort zurück
     */
    public String getWort() {
        return Wort;
    }

    /**
     * Getter Methode vom Atribut URL
     * @return gibt die URL zurück
     */
    public String getURL() {
        return URL;
    }

    /**
     * Hier wird die toString Methode überschreiben.
     * Die Daten werden zu einem Text zusammengefasst
     * @return gibt die Daten der Klasse als Text zurück
     */
    @Override
    public String toString(){

        return this.Wort + ";" + this.URL;
    }

}
