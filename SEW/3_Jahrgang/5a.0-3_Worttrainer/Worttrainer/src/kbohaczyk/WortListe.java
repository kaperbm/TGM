package kbohaczyk;

/**
 * Diese Klasse erstellt ein Objekt der Wortliste, in welchem man
 * Wörter eintragen und löschen kann.
 * @author Kacper Bohaczyk
 * @version 2022-09-11
 */
public class WortListe {
    private WortEintrag[] Worteinträge = new WortEintrag[0];

    public WortEintrag[] getWorteinträge() {
        return Worteinträge;
    }

    /**
     * Diese Methode fügt Wörter zu der Wortliste
     * hinzu und vergrößert diese dabei.
     * @param wort ist das Atribut, welches hinzugefügt wird
     */

    public void addWort(WortEintrag wort){
        try {
                WortEintrag[] temp = new WortEintrag[this.Worteinträge.length + 1];
                for (int i = 0; i < Worteinträge.length; i++) {
                    temp[i] = Worteinträge[i];
                }
                temp[temp.length - 1] = wort;
                Worteinträge = temp;
        }catch (NullPointerException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Doese Methode gibt den Worteintrag des rübergegebenen Indexes zurück.
     * @param index die Stelle vonb der das Wort genommen wird
     * @return der Worteintrag der Stelle [index]
     */
    public WortEintrag getWorteinträge(int index) {
        try {
            return Worteinträge[index];
        }catch (IndexOutOfBoundsException | NullPointerException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Diese Methode sucht das eingegebene Wort und
     * löscht dieses von den Worteinträgen.
     * @param Bezeichnung ist die eingegebene Bezeichnung
     * @return gibt zurück, ob das Wort gelöscht wurde
     */
    public boolean loeschWort(String Bezeichnung){
        try {
            boolean wahr = false;
            for (int i = 0; i < this.Worteinträge.length; i++) {
                if (Bezeichnung.equals(this.Worteinträge[i].getWort())) {
                    this.Worteinträge[i] = null;
                    wahr = true;
                }
            }
            //boolean geloescht = false;
            WortEintrag[] temp = new WortEintrag[Worteinträge.length-1];
            for(int i = 0, y = 0; y < temp.length; i++) {
                if(Worteinträge[i] != null){
                    temp[y] = Worteinträge[i];
                    y++;
                }
            }
            this.Worteinträge = temp;
            return wahr;
        }catch(NullPointerException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    /**
     * Hier wird die toString Methode überschreiben.
     * Die Daten werden zu einem Text zusammengefasst
     * @return gibt den erstellten Text zurück
     */
    @Override
    public String toString(){
        String text = "";
        for(int i = 0; i < Worteinträge.length; i++){
            text = text + Worteinträge[i].getWort() + " " + Worteinträge[i].getURL() + "\n";
        }
        return text;
    }
}
