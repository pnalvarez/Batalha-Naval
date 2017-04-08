package Grafico;
import javax.swing.*;

import java.awt.*;

import javax.swing.JFrame;

public class InicioFrame extends JFrame {

	private final int X=600;
	private final int Y=300;
	
	public InicioFrame(String title){
		
		super(title);
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension size=tk.getScreenSize();
		
		int width=size.width;
		int height=size.height;
		
		setBounds((width-X)/2,(height-Y)/2,X,Y);
		
		Container c=getContentPane();
		
		setLayout(null);
		
		JLabel j1=new JLabel("Jogador1");
		JLabel j2=new JLabel("Jogador2");
		j1.setBounds(100,35,100,100);
		j2.setBounds(100,115,100,100);
	    
		
		JTextField t1=new JTextField();
		JTextField t2=new JTextField();
		
		t1.setBounds(160, 70, 300, 30);
		t2.setBounds(160,150,300,30);
		
		JButton comecar=new JButton("comecar");
		comecar.setBounds(250,200,150,50);
		
		c.add(j1);
		c.add(j2);
		c.add(t1);
		c.add(t2);
		c.add(comecar);
		
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
}
