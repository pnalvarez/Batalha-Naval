package game.view;

import game.controller.Grid;
import game.controller.Cell;
import game.model.Ship;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.TreeMap;
import javax.swing.JPanel;



public class ShipView extends JPanel {
    
    
    public TreeMap <String, Ship> shipSet;
    public Grid shipsGrid;
  
    public ShipView ( ) {
        
    	//this.setBackground (Color.BLACK);      	
    	shipsGrid = new Grid ( 500, 500, 21, 21 ); // Grid 21x21   		
 
    }

    
    protected void paintShipCell ( int i, int j, Color shipColor, Graphics2D graph ) {
    	
    	Cell shipCell = shipsGrid.cells.get ( shipsGrid.getListIndexFromGridPosition ( i,  j, 21 ) );    	
    	graph.setColor ( shipColor );		
    	graph.fill ( shipCell );  	
    		
    }
    
    
    
    protected void putShipsOnView ( Graphics2D graph ) {
    	
        /* Set Cruisers on Grid */
    	Ship cruiser1 = shipSet.get ( "Cruiser1" );   		
    	paintShipCell ( 2, 1, cruiser1.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 1, 2, cruiser1.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 2, 3, cruiser1.shipColorToPaintShipSelectorPanel, graph );

    	Ship cruiser2 = shipSet.get ( "Cruiser2" );   		
    	paintShipCell ( 2, 5, cruiser2.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 1, 6, cruiser2.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 2, 7, cruiser2.shipColorToPaintShipSelectorPanel, graph );
    	
    	Ship cruiser3 = shipSet.get ( "Cruiser3" );   		
    	paintShipCell ( 2,  9, cruiser3.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 1, 10, cruiser3.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 2, 11, cruiser3.shipColorToPaintShipSelectorPanel, graph );
    	
    	Ship cruiser4 = shipSet.get ( "Cruiser4" );   		
    	paintShipCell ( 2, 13, cruiser4.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 1, 14, cruiser4.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 2, 15, cruiser4.shipColorToPaintShipSelectorPanel, graph );
    	
    	Ship cruiser5 = shipSet.get ( "Cruiser5" );   		
    	paintShipCell ( 2, 17, cruiser5.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 1, 18, cruiser5.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 2, 19, cruiser5.shipColorToPaintShipSelectorPanel, graph );
    	
    	Ship submarine1 = shipSet.get ( "Submarine1" );   		
    	paintShipCell ( 5, 1, submarine1.shipColorToPaintShipSelectorPanel, graph );
    	
    	Ship submarine2 = shipSet.get ( "Submarine2" );   		
    	paintShipCell ( 5, 3, submarine2.shipColorToPaintShipSelectorPanel, graph );
    	
    	Ship submarine3 = shipSet.get ( "Submarine3" );   		
    	paintShipCell ( 5, 5, submarine3.shipColorToPaintShipSelectorPanel, graph );
    	
    	Ship submarine4 = shipSet.get ( "Submarine4" );   		
    	paintShipCell ( 5, 7, submarine4.shipColorToPaintShipSelectorPanel, graph );
    	
    	
    	Ship destroyer1 = shipSet.get ( "Destroyer1" );   		
    	paintShipCell ( 8, 1, destroyer1.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 8, 2, destroyer1.shipColorToPaintShipSelectorPanel, graph );
    	
    	Ship destroyer2 = shipSet.get ( "Destroyer2" );   		
    	paintShipCell ( 8, 4, destroyer2.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 8, 5, destroyer2.shipColorToPaintShipSelectorPanel, graph );
    	
    	
    	Ship destroyer3 = shipSet.get ( "Destroyer3" );   		
    	paintShipCell ( 8, 7, destroyer3.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 8, 8, destroyer3.shipColorToPaintShipSelectorPanel, graph );
    	
    	
    	Ship battleShip1 = shipSet.get ( "BattleShip1" );   		
    	paintShipCell ( 11, 1, battleShip1.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 11, 2, battleShip1.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 11, 3, battleShip1.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 11, 4, battleShip1.shipColorToPaintShipSelectorPanel, graph );
    	
    	Ship battleShip2 = shipSet.get ( "BattleShip2" );   		
    	paintShipCell ( 11, 6, battleShip2.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 11, 7, battleShip2.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 11, 8, battleShip2.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 11, 9, battleShip2.shipColorToPaintShipSelectorPanel, graph );
    	
    	
    	Ship aircraftCarrier = shipSet.get ( "AircraftCarrier" );   		
    	paintShipCell ( 14, 1, aircraftCarrier.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 14, 2, aircraftCarrier.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 14, 3, aircraftCarrier.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 14, 4, aircraftCarrier.shipColorToPaintShipSelectorPanel, graph );
    	paintShipCell ( 14, 5, aircraftCarrier.shipColorToPaintShipSelectorPanel, graph );
    	
    	
    	
    
    }
    
   
    public void wait(int n){
        long t0, t1;
        t0 = System.currentTimeMillis();

        do {
            t1 = System.currentTimeMillis();            
        } while ((t1 - t0) < n);
    }   
    
     
    
    public Dimension getPreferredSize ( ) {
    	
    	return new Dimension (500, 500);
    
    }

    
  
    protected void paintComponent ( Graphics g ) {
        
    	super.paintComponent ( g );     
    	
    	Graphics2D g2d = (Graphics2D) g.create();
    			  		
    	putShipsOnView ( g2d );
    	    	
    	 g2d.setColor(Color.WHITE); //this.getBackground()
         
         for (Cell cell : shipsGrid.cells)   
         	g2d.draw(cell);
    	 
    	g.dispose();
    
    }



}

