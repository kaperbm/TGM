package kbohaczyk.figuren;
import java.awt.*;

public class Dreieck extends Figur implements Konstanten{
    private int h;
    private int w;

    public Dreieck(int x, int y, int h, int w, Color color) {
        this.setyStelle(y);
        this.setxStelle(x);
        this.setFarb(color);
        this.setH(h);
        this.setW(w);
    }
    @Override
    public String toString(){
        return "("+this.getxStelle() + "/" + this.getyStelle()+") " + this.getH() + " * " + this.getH() + " Farbe: " + Integer.toHexString(this.getFarb().getRGB());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getFarb());
        int[] xa = new int[3];
        int[] ya = new int[3];
        xa[0] = this.getxStelle();
        ya[0] = this.getyStelle();
        xa[1] = xa[0]+this.w;
        ya[1] = ya[0];
        xa[2] = xa[0]+this.w/2;
        ya[2] = ya[0]+this.h;
        g.fillPolygon(xa, ya, Konstanten.ECKEN);
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}