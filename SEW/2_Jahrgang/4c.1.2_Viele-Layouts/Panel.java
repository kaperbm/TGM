package kbohaczyk;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Ist die Panel-Klasse. Es werden hier mehrere Layouts ausgetestet
 * @author Kacper Bohaczyk
 * @date 13-05-2022
 * @version 1-Version
 */
public class Panel extends JPanel{
	
	/**
	 * Ist der Konstruktor zur Panel-Klasse
	 */
	Panel() {
		GridLayout grid = new GridLayout(2,3 ,0,0);
		this.setLayout(grid);
		
//-----------------Border-Layout-------------------
		
	JPanel bl1 = new JPanel(new BorderLayout(10,10));	
	JButton b1 = new JButton("PAGE_START");
	JButton b2 = new JButton("LINE_START");
	JButton b3 = new JButton("CENTER");
	JButton b4 = new JButton("PAGE_END");
	bl1.add(b1, BorderLayout.PAGE_START);
	bl1.add(b2, BorderLayout.LINE_START);
	bl1.add(b3, BorderLayout.CENTER);
	bl1.add(b4, BorderLayout.PAGE_END);
	bl1.setBackground(Color.RED);
	this.add(bl1);
	
//--------------------Flow-Layout-------------------
	
	JPanel fl1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JButton bf1 = new JButton("Das");
	JButton bf2 = new JButton("ist");
	JButton bf3 = new JButton("ein");
	JButton bf4 = new JButton("rechtsbündiges");
	JButton bf5 = new JButton("FlowLayout");
    fl1.setBackground(Color.BLUE);
    fl1.add(bf1);
    fl1.add(bf2);
    fl1.add(bf3);
    fl1.add(bf4);
    fl1.add(bf5);
    this.add(fl1);
    
//--------------------Box-Layout--------------------
    
    JButton bb1 = new JButton("Ein");
    JButton bb2 = new JButton("horizontales");
    JButton bb3 = new JButton("Boxlayout");
    JPanel boxl = new JPanel();
    boxl.setLayout(new BoxLayout(boxl, BoxLayout.LINE_AXIS));
    boxl.setBackground(Color.YELLOW);
    bb1.setAlignmentX(Component.CENTER_ALIGNMENT);
    bb2.setAlignmentX(Component.CENTER_ALIGNMENT);
    bb3.setAlignmentX(Component.CENTER_ALIGNMENT);
    boxl.add(bb1);
    boxl.add(bb2);
    boxl.add(bb3);
    this.add(boxl);
    
//------------------Grid-Layout-------------------
    
    JButton bbord1 = new JButton("1");
    JButton bbord2 = new JButton("2");
    JButton bbord3 = new JButton("3");
    JButton bbord4 = new JButton("4");
    JButton bbord5 = new JButton("5");
    JButton bbord6 = new JButton("6");
    JButton bbord7 = new JButton("7");
    JButton bbord8 = new JButton("8");
    JButton bbord9 = new JButton("9");
    JButton bbord10 = new JButton("10");
    JButton bbord11 = new JButton("11");
    JButton bbord12 = new JButton("12");
    JPanel gl1 = new JPanel(new GridLayout(4, 3, 3, 3));
    gl1.setBackground(Color.GREEN);
    gl1.add(bbord1);
    gl1.add(bbord2);
    gl1.add(bbord3);
    gl1.add(bbord4);
    gl1.add(bbord5);
    gl1.add(bbord6);
    gl1.add(bbord7);
    gl1.add(bbord8);
    gl1.add(bbord9);
    gl1.add(bbord10);
    gl1.add(bbord11);
    gl1.add(bbord12);
    this.add(gl1);
    
//------------Box-Layout-im-Flow-Layout------------
    
    JPanel fl2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

    JPanel bl2 = new JPanel();
    bl2.setLayout(new BoxLayout(bl2, BoxLayout.PAGE_AXIS));
    bl2.setBackground(Color.MAGENTA);
    JButton x1 = new JButton("ein");
    x1.setAlignmentX(Component.LEFT_ALIGNMENT);
    JButton x2 = new JButton("BoxLayout");
    x2.setAlignmentX(Component.LEFT_ALIGNMENT);
    JButton x3 = new JButton("innerhalb");
    x3.setAlignmentX(Component.LEFT_ALIGNMENT);
    JButton x4 = new JButton("eines");
    x4.setAlignmentX(Component.LEFT_ALIGNMENT);
    JButton x5 = new JButton("FlowLayouts");
    x5.setAlignmentX(Component.LEFT_ALIGNMENT);
    bl2.add(x1);
    bl2.add(x2);
    bl2.add(x3);
    bl2.add(x4);
    bl2.add(x5);

    fl2.add(bl2);
    this.add(fl2);

//-----------------Einzelner-Button-----------------------
    
    JButton f1 = new JButton("Der letzte Button in der letzten GridLayout-Zelle");
    this.add(f1);
    
	}
}
