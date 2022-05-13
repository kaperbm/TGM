package kbohaczyk;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
/**
 * Ist die Klasse mit der Grafik
 * @author Kacper Bohaczyk
 * @date 09-05-2022
 */
public class Grafik extends JPanel{
	
	/*
	 * Ist der Konstuktor zur Grafik
	 */
	Grafik(){
		this.setPreferredSize(new Dimension(500, 500));
	}
	
	/**
	 * Ist  die Methode mit welcher gezeichnet wird 
	 */
	public void paint(Graphics grafik) {
		
		Graphics2D g2D = (Graphics2D) grafik;
		g2D.setPaint(Color.GRAY);		// Die Farbe wird auf Grau gesetzt
		g2D.fillRect(150,150,200,200);		// Es wird der Unterteil vom Haus dargestellt
		
		g2D.setPaint(Color.RED);		// Die Farbe wird auf Rot gesetzt
		int[] kordX = {150, 250 ,350};		// Array für die X Kordinaten (gebraucht beim Dreieck)
		int[] kordY = {150, 50 ,150};		// Array für die Y Kordinaten (gebraucht beim Dreieck)
		g2D.fillPolygon(kordX, kordY, 3);	// Ein rotes Dreieck wird erstellt
		
		g2D.setPaint(new Color(102,51,0));	// Die Farbe wird auf Braun eingestellt (Man muss mit RGB werden arbeiten, weil es keine eingebaute funktion wie BROWN/brown gibt)
		g2D.fillRect(300,300,30,50);		// Die Tür wird erstellt
		
		g2D.fillRect(050,270,20,80);		// Ist der Baumstamm
		g2D.fillRect(400,270,20,80);		// Ist der zweite Baumstamm
		
		g2D.setPaint(Color.BLUE);		// Die Farbe wird auf Blau gesetzt
		g2D.fillRect(200,200,30,30);		// Ein Fenster wird ertellt
		g2D.fillRect(270,200,30,30);		// Ein zweites Fenster wird ertellt
		
		g2D.setPaint(Color.YELLOW);		// Die Farbe wird auf Gelb gesetzt
		g2D.fillOval(235,90,30,30);		// Ein beleuchtetes Fenster wird erstellt
		
		g2D.fillOval(350,30,50,50);		// Eine Sonne wird erstellt
		
		g2D.setPaint(new Color(102,51,0));	// Die Farbe wird erneut auf Braun gestellt
		g2D.setStroke(new BasicStroke(3));	// Es wird ein stärkerer Stroke eingestellt (Dies ist wichtig um bei draw Methoden eine Festere Umrandung zu bekommen)
		g2D.drawRect(200, 200, 30, 30);		// Es wird eine Umrandung zum ersten Fenster erstellt
		g2D.drawRect(270,200,30,30);		// Es wird eine Umrandung zum zweiten Fenster erstellt
		g2D.drawOval(235,90,30,30);		// Es wird eine Umrandung zum beleuchtetem Fenster erstellt
		
		g2D.setPaint(Color.GREEN);		// Die Farbe wird auf ein helles Grün gestellt
		g2D.fillOval(300,400,30,30);		
		g2D.fillOval(310,410,30,30);
		g2D.fillOval(320,400,30,30);
		/**
		 * Es werden Mehrere Kreise gesetzt um ein Busch zu erstellen

		g2D.fillOval(100,400,30,30);
		g2D.fillOval(110,410,30,30);
		g2D.fillOval(120,400,30,30);
		/**
		 * Es werden Mehrere Kreise gesetzt um ein Busch zu erstellen
		 */
		
		g2D.fillOval(200,450,30,30);
		g2D.fillOval(210,460,30,30);
		g2D.fillOval(220,450,30,30);
		/**
		 * Es werden Mehrere Kreise gesetzt um ein Busch zu erstellen
		 */
			
		g2D.fillOval(25,250,50,50);	
		g2D.fillOval(385,250,50,50);
		/**
		 * Es werden die Bläter der Bäume mit Kreisen dargestellt.
		 */
		
	}
}
