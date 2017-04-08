package Grafico;

import java.awt.GraphicsConfiguration;

import javax.swing.*;

import java.awt.*;

public class Frame1 extends JFrame {

	private final int X=1000;
	private final int Y=1000;
	
	public Frame1(String title){
		
		super(title);
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension size=tk.getScreenSize();
		
		int width=size.width;
		int height=size.height;
		
		setBounds((width-X)/2,(height-Y)/2,X,Y);
		
		//Container c=getContentPane();
		setLayout(null);
		
		//Panel1 panel=new Panel1();
		//getContentPane().add(panel);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//setVisible(true);
	}
	

}
