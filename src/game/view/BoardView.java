package game.view;

import game.controller.Cell;
import game.controller.Grid;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class BoardView extends JPanel {
    	             	
	public Grid boardGrid; // grid that represents the board
	
	
	public BoardView ( ) {
        		
		this.setBackground (Color.WHITE);
		boardGrid = new Grid ( 500, 500, 15, 15 ); // Grid 15x15
		
	}
            	
	public Dimension getPreferredSize ( ) {           
	
		return new Dimension (500, 500);        		
	}

             
	public void invalidate ( ) {      
		
		super.invalidate ( );    
	} 
        
        
	protected void paintComponent(Graphics g) {
            
		super.paintComponent ( g );		
		
		Graphics2D g2d = (Graphics2D) g.create ( );  
			
		for (Cell cell : boardGrid.cells) {
			
			g2d.setColor ( cell.cellColor );
			g2d.fill ( cell );
		}
					
		g2d.setColor(Color.BLACK);
			
        for (Cell cell : boardGrid.cells)
        	g2d.draw(cell);
        
        
        g2d.dispose();
	
	}
	
	
}
