package kbohaczyk.figuren;
import java.awt.*;

/**
 * @author Kacper Bohaczyk
 * @version 19-01-2023
 */

public class Linie extends Figur {
    private int x2;
    private int y2;

    /**
     * Konstruktor
     * @param x xstelle
     * @param y ystelle
     * @param x2 x2stelle
     * @param y2 y2stelle
     * @param color farbe
     */
    public Linie(int x,int y,int x2, int y2, Color color) {
        this.setxStelle(x);
        this.setyStelle(y);
        this.setFarb(color);
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Methdoe draw wird überschrieben
     * @param g Graphics
     */
    @Override
    public void draw(Graphics g){
        g.setColor(this.getFarb());
        g.drawLine(this.getxStelle(),this.getyStelle(), this.getX2(), this.getY2());
    }

    /**
     * To string
     * @return Gibt text zurück
     */
    @Override
    public String toString(){
        return "("+this.getxStelle() + "/" + this.getyStelle()+")"+" ("+this.getX2() + "/" + this.getY2()+")"+ " Farbe: "+ Integer.toHexString(this.getFarb().getRGB());
    }

    /**
     * Getter x2
     * @return x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * Settet die x2 stelle
     * @param x2
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * Getter für y2
     * @return
     */
    public int getY2() {
        return y2;
    }

    /**
     * Setter für y2
     * @param y2
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }
}