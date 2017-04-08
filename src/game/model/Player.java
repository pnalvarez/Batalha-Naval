package game.model;

import game.view.BoardView;
import game.view.ShipView;

import game.controller.Cell;
import game.controller.Grid;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;



public class Player  {
	
	
	public String name;
	String result;	
	Player self = this;
	
	public boolean GameIsStart = false;
    public boolean GameIsOver = false;
	
	
	public Point selectedShip; // Clicked point on ShipView grid
	public Ship AirCarrier = new Ship ( 5, "AircraftCarrier" );
   
	public Ship []BatleShip = { new Ship ( 4, "BattleShip1" ), 
			             new Ship ( 4, "BattleShip2" ) };
    	
	public Ship []Cruiser = { new Ship ( 3, "Cruiser1" ), 
			           new Ship ( 3, "Cruiser2" ), 
			           new Ship ( 3, "Cruiser3" ), 
			           new Ship ( 3, "Cruiser4" ), 
			           new Ship ( 3, "Cruiser5" ) };
       
    public Ship []Destroyer = { new Ship ( 2, "Destroyer1" ), 
    		             new Ship ( 2, "Destroyer2" ), 
    		             new Ship ( 2, "Destroyer3" ) };
       
    public Ship []Submarine = { new Ship ( 1, "Submarine1" ), 
    		             new Ship ( 1, "Submarine2" ), 
    		             new Ship ( 1, "Submarine3" ), 
    		             new Ship ( 1, "Submarine4" ) };
            
    TreeMap <String, Ship> ships = new TreeMap <String, Ship> ( ); // All ships are in the tree. Access like dictionary
   
    
    public ShipView shipSelectorPanel;    		   
    public BoardView board;
    
    public Player enemy = null;
    public ArrayList <Cell> enemyCells = new ArrayList <Cell> ( );
    
    Ship  currentClickedShip = null;
    Cell  currentClickedCell = null; // For the player board
    Point currentClickedPoint;      //  For the player board
    
    public JButton nextPlayer   = new JButton ( "PRONTO!" );
    public JButton start        = new JButton ( "FIGHT!" );
    public JButton save         = new JButton ( "SALVAR"  );
    public JButton reset        = new JButton ( "RESETAR" );
 
    public JTextPane  messageBox = new JTextPane ( );
    public JTextPane  messageBox2 = new JTextPane ( );    
    
    	  
    public Player (  ) {
        
    	putShipsIntoTreeMap ( );   	
    	    	   	
    	board = new BoardView ( );  	
    	
    	shipSelectorPanel = new ShipView ( ); 	    	  		
    	shipSelectorPanel.shipSet = ships;        
      	
    	
    	
    	setPlayerControlOnGridView ( );
    	setPlayerControlOnShipsView ( );    	
    	setPlayerControlOnPanelButtons ( );    	   	   
    }
    
    
    
    private void putShipsIntoTreeMap ( ) {
		
    	
    	ships.put ( AirCarrier.name, AirCarrier );
    	   	
    	for( int i = 0; i < 2; i++ )     		
    		ships.put ( BatleShip[i].name, BatleShip[i] );
  	   	
    	for( int i = 0; i < 3; i++ )    		
    		ships.put ( Destroyer[i].name, Destroyer[i] );
    	
    	for( int i = 0; i < 4; i++ ) 	
    		ships.put ( Submarine[i].name, Submarine[i] );
    	
       	for( int i = 0; i < 5; i++ )
    		ships.put ( Cruiser[i].name, Cruiser[i] );
	
    }
    
    
	private void setPlayerControlOnShipsView  ( ) {
				
		shipSelectorPanel.addMouseListener( listenerForShipButton );			
											
	}
    
    
	private void setPlayerControlOnPanelButtons ( ) {
		
    	//start.addActionListener  ( listenerForStartButton  );   	
    	save.addActionListener  ( listenerForSaveButton  );    	
		reset.addActionListener  ( listenerForResetButton  );
		save.setEnabled(false);
	} 

    
	public void setPlayerControlOnGridView ( ) {
    	       
		board.addMouseListener( listener_gridForPutShips );
			
	}

    
	
	public void putEnemyGridIntoArrayList ( ) {
		
		for( int i = 0; i < 15; i++ ) 	
				for ( int j = 0; j < 15; j++ ) 
					
					enemyCells.add ( enemy.board.boardGrid.cells.get( enemy.board.boardGrid.getListIndexFromGridPosition ( i, j, 15 ) ) );			
	}

	
	
	public void setPlayerControlOnEnemyGridView ( ) {
		
    	enemy.board.addMouseListener ( listenerForEnemyGrid );
						
	}

	
   
	public void DisableShip ( Ship shipButton ) {
		
		
		
		
		shipButton.isShipEnable = false;
		
		
	
		
	}

	
	
	public void EnableShip ( Ship shipButton ) {
		
		shipButton.isShipEnable = true;
		
	}

	
	
	public void DisableButton( JButton button ) {
		
    	button.setEnabled(false);
		
	}
	
	
	public void EnableButton( JButton button ) {
		
    	button.setEnabled(true);
		
	}

	
	
	public void putShipOnGrid ( ) {
		   	 		
	
		if ( currentClickedShip.name.equals ("Cruiser1") ||
			 currentClickedShip.name.equals ("Cruiser2") ||
			 currentClickedShip.name.equals ("Cruiser3") ||
			 currentClickedShip.name.equals ("Cruiser4") ||
			 currentClickedShip.name.equals ("Cruiser5")  ) {
			
			if ( currentClickedShip.orientation_horizontal == true ) {
				
				currentClickedCell.isShipPlacedOn = currentClickedShip;
		    	currentClickedCell.cellColor = currentClickedShip.shipColor;
				
		    	currentClickedCell.nextInRow.previousInColumn.isShipPlacedOn = currentClickedShip;
		    	currentClickedCell.nextInRow.previousInColumn.cellColor = currentClickedShip.shipColor;
				
		    	currentClickedCell.nextInRow.nextInRow.isShipPlacedOn = currentClickedShip;
		    	currentClickedCell.nextInRow.nextInRow.cellColor = currentClickedShip.shipColor;
				
			} else {
			
				currentClickedCell.isShipPlacedOn = currentClickedShip;
		    	currentClickedCell.cellColor = currentClickedShip.shipColor;
				
		    	currentClickedCell.nextInRow.nextInColumn.isShipPlacedOn = currentClickedShip;
		    	currentClickedCell.nextInRow.nextInColumn.cellColor = currentClickedShip.shipColor;
				
		    	currentClickedCell.nextInColumn.nextInColumn.isShipPlacedOn = currentClickedShip;
		    	currentClickedCell.nextInColumn.nextInColumn.cellColor = currentClickedShip.shipColor;
		
			}
				
		} else {
					
			for ( int i = 0; i < currentClickedShip.size; i++ ) {
  	    	
				currentClickedCell.isShipPlacedOn = currentClickedShip;
				currentClickedCell.cellColor = currentClickedShip.shipColor;
	    		    	
				
				if ( currentClickedShip.orientation_horizontal == true )  	
					currentClickedCell = currentClickedCell.nextInRow;
	    					
				else
					currentClickedCell = currentClickedCell.nextInColumn;	    			  
			}	      			
		}										
	}
	
	
	
	public boolean AllShipsAreSetOnBoard ( ) {
				
		for ( Map.Entry<String,Ship> entry : ships.entrySet ( ) ) 	
			if ( entry.getValue ( ).isShipEnable )				
				return false;			
		
		EnableButton ( nextPlayer );
		
		return true;
		
	}
	
 
	
	public boolean AllShipsAreSunk ( ) {
	 
		if ( AirCarrier.isSunk 
			 && BatleShip[0].isSunk   && BatleShip[1].isSunk 
			 && Destroyer[0].isSunk   && Destroyer[1].isSunk   && Destroyer[2].isSunk  
			 && Submarine[0].isSunk   && Submarine[1].isSunk   && Submarine[2].isSunk   && Submarine[3].isSunk 
			 && Cruiser  [0].isSunk   && Cruiser  [1].isSunk   && Cruiser  [2].isSunk     && Cruiser[3].isSunk && Cruiser[4].isSunk )
	
			return true;
	 
		else
			return false;
 
	}
    
	
	
	protected boolean isCellClickedIsOnGrid ( Grid grid, MouseEvent event ) {
		    
		if ( event.getX() >= grid.xOffset && event.getY() >= grid.yOffset ) { 

			int i = ( event.getX() - grid.xOffset ) / grid.cellWidth;
			int j = ( event.getY() - grid.yOffset ) / grid.cellHeight;
					     				
			if ( i >= 0 && j >= 0 && i < 15 && j < 15)   						     						
				return true;   			  						
		} 	   
	  
		   return false;
	}

	
	
	
	
	protected Ship getShipsFromPointGrid ( Point clickedPoint ) {
		
		Point gridPosition = shipSelectorPanel.shipsGrid.getGridPositionFromClickedPoint ( clickedPoint.x, clickedPoint.y );
				
		
		if ( ( gridPosition.x == 2 && gridPosition.y == 1 ) ||          
			 ( gridPosition.x == 1 && gridPosition.y == 2 )	||
			 ( gridPosition.x == 2 && gridPosition.y == 3 )  ) 				
			return ships.get("Cruiser1");
		
		
		else if ( ( gridPosition.x == 2 && gridPosition.y == 5 ) ||          
			 ( gridPosition.x == 1 && gridPosition.y == 6 )	||
			 ( gridPosition.x == 2 && gridPosition.y == 7 )  ) 					
			return ships.get("Cruiser2");
		
		
		else if ( ( gridPosition.x == 2 && gridPosition.y == 9  ) ||          
			 ( gridPosition.x == 1 && gridPosition.y == 10 ) ||
			 ( gridPosition.x == 2 && gridPosition.y == 11 )  ) 				
			return ships.get("Cruiser3");
		
		
		else if ( ( gridPosition.x == 2 && gridPosition.y == 13 ) ||          
			      ( gridPosition.x == 1 && gridPosition.y == 14 ) ||
			      ( gridPosition.x == 2 && gridPosition.y == 15 )  ) 					
			return ships.get("Cruiser4");
		
		
		else if ( ( gridPosition.x == 2 && gridPosition.y == 17 ) ||          
			      ( gridPosition.x == 1 && gridPosition.y == 18 ) ||
			      ( gridPosition.x == 2 && gridPosition.y == 19 )  ) 				
			return ships.get("Cruiser5");
				
		
		else if ( gridPosition.x == 5 && gridPosition.y == 1 )
			return ships.get("Submarine1");
			 				
		
		else if ( gridPosition.x == 5 && gridPosition.y == 3 )
			return ships.get("Submarine2");
			
		
		else if ( gridPosition.x == 5 && gridPosition.y == 5 )
			return ships.get("Submarine3");
		
		
		else if ( gridPosition.x == 5 && gridPosition.y == 7 )
			return ships.get("Submarine4");
					
		
		else if ( ( gridPosition.x == 8 && gridPosition.y == 1 ) ||          
			      ( gridPosition.x == 8 && gridPosition.y == 2 )  ) 					
			return ships.get("Destroyer1");
		
		
		else if ( ( gridPosition.x == 8 && gridPosition.y == 4 ) ||          
			      ( gridPosition.x == 8 && gridPosition.y == 5 )  ) 					
			return ships.get("Destroyer2");
		
		
		else if ( ( gridPosition.x == 8 && gridPosition.y == 7 ) ||          
			      ( gridPosition.x == 8 && gridPosition.y == 8 )  ) 					
			return ships.get("Destroyer3");
		
		
		else if ( ( gridPosition.x == 11 && gridPosition.y == 1 ) ||          
				  ( gridPosition.x == 11 && gridPosition.y == 2 ) || 
				  ( gridPosition.x == 11 && gridPosition.y == 3 ) ||
			      ( gridPosition.x == 11 && gridPosition.y == 4 )  ) 					
			return ships.get("BattleShip1");
		
		
		else if ( ( gridPosition.x == 11 && gridPosition.y == 6 ) ||          
				  ( gridPosition.x == 11 && gridPosition.y == 7 ) ||
				  ( gridPosition.x == 11 && gridPosition.y == 8 ) ||
			      ( gridPosition.x == 11 && gridPosition.y == 9 )  ) 				
			return ships.get("BattleShip2");
				
		
		else if ( ( gridPosition.x == 14 && gridPosition.y == 1 ) ||          
				  ( gridPosition.x == 14 && gridPosition.y == 2 ) ||
				  ( gridPosition.x == 14 && gridPosition.y == 3 ) ||
				  ( gridPosition.x == 14 && gridPosition.y == 4 ) ||
			      ( gridPosition.x == 14 && gridPosition.y == 5 )  ) 				
			return ships.get("AircraftCarrier");
		
		
		return null;
			
	}
	
	
		
	
    MouseAdapter listener_gridForPutShips = new MouseAdapter ( ) {
    			
		public void mouseClicked ( MouseEvent e ) {
    					
    		if ( !GameIsStart&&GameIsOver == false ) {
    		
    			currentClickedPoint = null; /* selected point */              
    			   			
    		
    			if ( isCellClickedIsOnGrid ( board.boardGrid, e) )  						     						
    				currentClickedPoint = board.boardGrid.getGridPositionFromClickedPoint ( e.getX(), e.getY() );   			  			
     			
    			
    			currentClickedCell = board.boardGrid.cells.get ( board.boardGrid.getListIndexFromGridPosition ( currentClickedPoint.x, currentClickedPoint.y, 15 ) ); /* get selected cell from selected point */
     			 
     			if ( currentClickedCell.currentChosenShip != null   )
     			   			
     				try {
     			     		     					
     					if (  currentClickedCell.currentChosenShip != null  ) /* set ship on grid  */
     				    					
     						if ( currentClickedCell.isCellEnoughAndNotTaken ( ) && currentClickedCell.hasCellNoNeighbors ( ) ) { /* verify if possible */
    					  
     							putShipOnGrid ( );
     							    							
     							messageBox.setText( currentClickedShip.name + " foi posicionado com sucesso! ");
    					    							
     							board.boardGrid.initialTheCurrentShipForEachCell( 15, 15 ); // after put ship on the grid, restart the cells.currentChosenShip

     							currentClickedShip.shipColorToPaintShipSelectorPanel = Color.BLACK;
     							   	    						
     							shipSelectorPanel.repaint();	  					    	
     							
     							DisableShip ( currentClickedShip );
  							    						
     						} else 
     							messageBox.setText("Posição proibida!"); 
     			    			     				     			
     				} catch (Exception exception) {
     						
     					messageBox.setText("Por favor selecione um navio");
     					
     					System.out.println("Please select a ship!");
     			
     				}
     				
     			}
    		
    	
    	board.repaint();	
    		
    	if ( AllShipsAreSetOnBoard() )
    		nextPlayer.setEnabled(true);
    	
    	
		}  /* END mouse clicked method */
    		    	    	
    };
    
    
 
    MouseAdapter listenerForEnemyGrid = new MouseAdapter() {
    	
    	public void mouseClicked ( MouseEvent e ) {
    		
    		Cell currentEnemyCell;
    		
    		if ( GameIsStart && GameIsOver == false ) {			   
    			  
    			Point selectedCell = null;               
    			
     			if ( isCellClickedIsOnGrid ( enemy.board.boardGrid, e) )  						     						
     			
     				selectedCell = enemy.board.boardGrid.getGridPositionFromClickedPoint ( e.getX(), e.getY() );   			  			
     			
     			
     			currentEnemyCell = enemy.board.boardGrid.cells.get ( enemy.board.boardGrid.getListIndexFromGridPosition ( selectedCell.x, selectedCell.y, 15 ) ); /* get selected cell from selected point */
     			   									
    			
     			if ( currentEnemyCell.isHit == false ) {
    					  
    				currentEnemyCell.getHit();
    					 					  
    				if ( currentEnemyCell.isShipPlacedOn == null ) 		 
    					messageBox.setText("Tiro na água!");
    				    					 
    				 else 		  
    					messageBox.setText("Você acertou um navio inimigo!");
 
                    if ( enemy.AllShipsAreSunk ( ) ) {
                        	 
                    	GameIsOver = true;                   	 
                    	save.setEnabled(false);
                    	messageBox.setText(self.name + " É O VENCEDOR!!!");
                    	result = "win";						 
    					 
                     } else if ( self.AllShipsAreSunk ( ) ) {
    						  
                        	GameIsOver = true;  						  
                        	save.setEnabled(false);
                        	result="lose";						  
                     }						  					  
                        					  
     			}
    		  		
    		} else if ( !GameIsOver ) 
    			messageBox.setText("Não é permitido atacar o inimigo até a partida começar!");
    		     		
    	}
    		    	
   };
    
    
  
  
   MouseAdapter listenerForShipButton = new MouseAdapter ( ) {
    	
    	public void mouseClicked ( MouseEvent event ) {
   		
    		Point point = event.getPoint();
    	   		
    		currentClickedShip = getShipsFromPointGrid ( point ); 
    		
 		
    		try {
    		   		
    			if ( currentClickedShip.isShipEnable &&  !currentClickedShip.shipColorToPaintShipSelectorPanel.equals(Color.BLACK) ) {
    				
    			
    				if ( SwingUtilities.isRightMouseButton ( event ) ) {
    				
    					try {
    					
    					currentClickedShip.rotate();
    					
    					if(currentClickedShip.orientation_horizontal==true){
        					
    						messageBox2.setText( "Posição do navio: Horizontal");
    					
    					} else {
    						
    						messageBox2.setText("Posição do navio: Vertical");
    					}
    					  					
    					} catch (Exception e) {  }
    					
    				}
    				
    				try {
    			 			
    					for ( Map.Entry<String,Ship> entry : ships.entrySet ( ) ) {	
	    						
	    						if ( !entry.getValue ( ).shipColorToPaintShipSelectorPanel.equals(Color.BLACK)     )
	    						
	    							entry.getValue ( ).shipColorToPaintShipSelectorPanel = entry.getValue ( ).shipColor;
	    					
	    					}	
    					
    					
    					currentClickedShip.shipColorToPaintShipSelectorPanel = new Color ( 19, 251, 19 );
    					    					   					
    					messageBox.setText ( currentClickedShip.name + " foi escolhido" );
    		   			
    					board.boardGrid.setCurrentShipForEachCell ( currentClickedShip, 15, 15 );
   				
    				} catch (Exception e) {  }
    			   			
    			}
    				
    		} catch (Exception e) {  }
    		   		
    		shipSelectorPanel.repaint();
   	   	 
    	}	
    		
   };
    

   ActionListener listenerForResetButton = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			nextPlayer.setEnabled(false);
			
			for ( Map.Entry<String, Ship> entry : ships.entrySet ( ) ) {
				
				EnableShip (entry.getValue() );
				
				entry.getValue().shipColorToPaintShipSelectorPanel = entry.getValue().shipColor;
				
			}
			
			shipSelectorPanel.repaint();
			
			board.boardGrid.resetShipPlacementOnEachCell ( 15, 15 );
			
			
			for ( Cell cell : board.boardGrid.cells  ) {
				
				cell.cellColor = Color.CYAN;
				
			}
				
			board.repaint();	
			
			}
			
	};
	    

	
	
	ActionListener listenerForSaveButton = new ActionListener() {

		
		public void actionPerformed ( ActionEvent e ) {
			
			try {
				
				FileWriter saveFile = new FileWriter ( "saveFile.txt", false );
				
				PrintWriter textWriter = new PrintWriter ( saveFile );
				
				textWriter.println ( GameIsStart + "" );
				
				textWriter.println ( GameIsOver + "" );
				
				for ( Cell cell : self.board.boardGrid.cells ) {
					
					if ( cell.isShipPlacedOn != null )
						textWriter.println(cell.isShipPlacedOn.name);
					
					else
						textWriter.println("null");											
																	
				}
				
				for ( Cell cell : self.board.boardGrid.cells ) 
					textWriter.println ( cell.isHit + "" );
				
				
				textWriter.println ( "enemy.mode" );
				
				
				for ( Cell cell : self.enemyCells ) {
					
					if ( cell.isShipPlacedOn != null )
						textWriter.println(cell.isShipPlacedOn.name);
					
					else
						textWriter.println("null");											
																	
				}
				
				
				for ( Cell cell : self.enemyCells )
					textWriter.println ( cell.isHit + "" );
				
				
				 JOptionPane.showMessageDialog(null,"Jogo salvo com sucesso");
				 
				 textWriter.close();
			
			} catch (Exception e1) {  }
			
		}
		
	}; 

   
   
   
}
