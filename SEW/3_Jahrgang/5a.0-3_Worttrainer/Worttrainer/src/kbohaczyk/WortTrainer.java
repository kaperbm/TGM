package kbohaczyk;

/**
 * Diese Klasse kann ein zufälliges WortListe-Objekt ausgeben
 * oder checken, ob es mit einem anderen Wort übereinstimmt.
 * @author Kacper Bohaczyk
 * @version 04-01-2023
 */
public class WortTrainer {
    private WortListe objekt;
    private WortEintrag wort;
    //statistik
    private int abfrage;
    private int richtig;
    /**
     * Konstruktor vom WortTrainer
     * @param objekt ist das rübergebene Wortliste Objekt
     */
    public WortTrainer(WortListe objekt) {
        try {
            this.objekt = objekt;
        }catch(NullPointerException e){
            System.err.println(e.getMessage());
        }

    }

    /**
     * Getter Methode der WortListe
     * @return Gibt die WortListe zurück
     */
    public WortListe getWortListe(){
        return this.objekt;
    }

    /**
     * Die Methode WortZufall gibt einen zufälligen
     * Eintrag von dem aktuellen Wortliste-Objekt aus
     * @return das zufällige Wort zurück
     */
    public WortEintrag WortZufall(){
        WortEintrag wort;
        int laenge = 4;
        double d = Math.random() * laenge;
        int zufall = (int)d;
        wort = objekt.getWorteinträge(zufall);
        this.wort = wort;
        this.abfrage++;
        return wort;
    }

    /**
     * Die Methode WortAktuell gibt das Wort
     * des aktuellen Worteintrages zurück
     * @return gibt das aktuelle Wort zurück
     */
    public WortEintrag WortAktuell(){
        this.abfrage++;
        return this.wort;
    }

    /**
     * Die Methode check vergleicht ein eingegebenes
     * Wort mit dem aktuellen Worteintrag.
     * @param wort1 ist das eingegebene Wort
     * @return gibt zurück, ob die Wörter übereinstimmen
     */
    public boolean check (String wort1){
        if(wort1.equals(this.wort)){
            this.richtig++;
            return true;
        }
        return false;
    }

    /**
     * Diese Methode check vergleicht ein eingegebenes
     * Wort mit dem aktuellen Worteintrag.
     * Groß- und Kleinschreibung wird nicht beachtet
     * @param wort1 ist das eingegebene Wort
     * @return gibt zurück, ob die Wörter übereinstimmen
     */
    public boolean checkIgnoreCase (String wort1){
        if(wort1.toUpperCase().equals(this.wort.getWort().toUpperCase())){
            this.richtig++;
            return true;
        }
        return false;
    }

    /**
     * Getter der Abfrage
     * @return gibt die Anzahl an anfragen zurück
     */
    public int getAbfrage(){
        return this.abfrage;
    }
    /**
     * Getter von Richtig
     * @return gibt die Anzahl von richtigen Abfragen zurück
     */
    public int getRichtig() {
        return this.richtig;
    }

    /**
     * Gibt zurück einen Text in welchem steht von wie vielen Abfragen wie viele richtig sind
     * @return gibt den text zurück
     */
    public String AbfrageRichtigToString(){
        String text = "Von " + this.abfrage + " Abfragen waren " + this.richtig + " richtig.";
        return text;
    }

}
