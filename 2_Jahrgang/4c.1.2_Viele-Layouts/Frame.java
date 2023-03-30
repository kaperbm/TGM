package kbohaczyk;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 * Ist die Klasse zum erstellen des Frames
 * @author Kacper Bohaczyk
 * @date 12-05-2022
 */
public class Frame extends JFrame{
	Panel panel;
	/**
	 * 
	 */
	Frame(){
		super("Grid-Layout");
		
		panel = new Panel();
		JFrame fenster = new JFrame();
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setBounds(300, 100, 1200, 600);
		fenster.setTitle("Viele Layouts in einem Grid Layout");
		fenster.setResizable(true);
		fenster.setLayout(new GridLayout(3,2,10,10));
		fenster.add(panel);
		fenster.pack();
		fenster.setVisible(true);
		
	}
	
	

}
