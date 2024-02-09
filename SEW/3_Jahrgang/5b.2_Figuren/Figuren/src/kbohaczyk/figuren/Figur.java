package kbohaczyk.figuren;

import java.awt.*;

/**
 *
 * @author Kacper Bohaczyk
 * @version 19-01-2023
 */
public abstract class Figur {
    private int xStelle;
    private int yStelle;
    private Color farb;
    public  abstract void  draw(Graphics g);

    /**
     * Overites to string methode
     * @return Ein Text
     */
    @Override
    public String toString(){
        return (this.xStelle + "/" + this.yStelle + " Farbe: "+ this.farb.toString());
    }

    /**
     * Getter für x stelle
     * @return xstelle
     */
    public int getxStelle() {
        return xStelle;
    }

    /**
     * Setter für die x stelle
     * @param xStelle x stelle
     */
    public void setxStelle(int xStelle) {
        this.xStelle = xStelle;
    }

    /**
     * Getter für die y methode
     * @return y stelle
     */
    public int getyStelle() {
        return yStelle;
    }

    /**
     * Setter für die y mehtode
     * @param yStelle ystelle
     */
    public void setyStelle(int yStelle) {
        this.yStelle = yStelle;
    }

    /**
     * getter für die Farbe
     * @return farbe
     */
    public Color getFarb() {
        return farb;
    }

    /**
     * Setter für dei Farbe
     * @param farb farbe
     */
    public void setFarb(Color farb) {
        this.farb = farb;
    }
}