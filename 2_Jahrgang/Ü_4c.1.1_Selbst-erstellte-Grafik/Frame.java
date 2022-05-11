package kbohaczyk;
import javax.swing.JFrame;

/**
 * Ist die Klasse zum erstellen des Frames
 * @author Kacper Bohaczyk
 * @date 09-05-2022
 */
public class Frame extends JFrame{
	Grafik panel;
	/**
	 * 
	 */
	Frame(){
		panel = new Grafik();
		JFrame fenster = new JFrame();
		fenster.setTitle("Selbst erstellte Grafik");
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setResizable(true);
		fenster.add(panel);
		fenster.pack();
		fenster.setVisible(true);
	}
	
	

}
