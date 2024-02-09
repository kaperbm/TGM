package kbohaczyk.figuren;
import java.awt.*;
/**
 * @author Kacper Bohaczyk
 * @version 19-01-2023
 */
public class Kreis extends Figur{
    private int radius;

    /**
     * Konstruktor
     * @param x x stelle
     * @param y y stelle
     * @param radius radius des Objektes
     * @param farbe farbe
     */
    public Kreis(int x, int y, int radius, Color farbe){
        this.setxStelle(x);
        this.setyStelle(x);
        this.setFarb(farbe);
        this.setRadius(radius);
    }

    /**
     * Methode Draw
     * @param g
     */
    @Override
    public void draw(Graphics g){
        g.setColor(this.getFarb());
        g.fillOval(this.getxStelle(),this.getyStelle(),radius,radius);
    }

    /**
     * Getter für den Radius
     * @return
     */
    public int getRadius() {
        return radius;
    }

    /**
     * To String methode wird überschreiben
     * @return Gibt die Stellen und Radius sowie Farbe zurück
     */
    @Override
    public String toString(){
        return "("+this.getxStelle() + "/" + this.getyStelle()+") R:" + this.getRadius() + " Farbe: " + Integer.toHexString(this.getFarb().getRGB());
    }

    /**
     * Setter für den Radius
     * @param radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
}