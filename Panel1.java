package Grafico;

import javax.swing.*;

import java.awt.*;

public class Panel1 extends JPanel{

	private final int inicioTabuleiro_X=500;
	private final int inicioTabuleiro_Y=200;
	private final int finalTabuleiro_X=950;
	private final int finalTabuelrio_Y=650;
	private final int Lado=450;
	
	public void paintComponent(Graphics g1){
		
		Graphics2D g2=(Graphics2D)g1;
		
		g2.setColor(Color.cyan.brighter());
		g2.fillRect(500, 200, 450, 450);
		
		g2.setColor(Color.BLACK);
		for(int i=1;i<15;i++)
			g2.drawLine(inicioTabuleiro_X, inicioTabuleiro_Y+30*i, inicioTabuleiro_X+Lado,inicioTabuleiro_Y+30*i );
		
		for(int i=1;i<15;i++)
			g2.drawLine(inicioTabuleiro_X+30*i, inicioTabuleiro_Y, inicioTabuleiro_X+30*i, inicioTabuleiro_Y+Lado);
		
		for(int i=1;i<=15;i++)
			g2.drawString(String.format("%d", i), inicioTabuleiro_X-10, inicioTabuleiro_Y+30*i-15);
		for(int i=1;i<=15;i++)
			g2.drawString(String.format("%d",i), inicioTabuleiro_X+30*i-15, inicioTabuleiro_Y);
		
	}

}
