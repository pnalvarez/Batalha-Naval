package game.controller;

import game.model.Ship;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Point;



public class Grid {
	   
	public List<Cell> cells;  // all cells of the Grid here! 
	
	public int cellWidth,
			   cellHeight,
			   xOffset,
			   yOffset;
		
	
	
	public Grid ( int screenWidth, int screenHeight, int rowCount, int columnCount ) {

		initializecells ( screenWidth, screenHeight, rowCount, columnCount );
	
	}

	
	private void initializecells ( int screenWidth, int screenHeight, int rowCount, int columnCount ) {

		cells = new ArrayList<Cell> (  rowCount * columnCount );

		cellWidth = screenWidth / columnCount;
		cellHeight = screenHeight / rowCount;
		xOffset = ( screenWidth -  ( columnCount * cellWidth  ) ) / 2;
		yOffset = ( screenHeight - ( rowCount    * cellHeight ) ) / 2;
	
				
		if ( cells.isEmpty( ) ) {  // Fill the grid with its Cells

			for ( int i = 0; i < rowCount; i++ )					
				for ( int j = 0; j < columnCount; j++ ) {
					
					Cell cell = new Cell ( xOffset + ( j * cellWidth ), yOffset + ( i * cellHeight ), cellWidth, cellHeight );		
					cells.add ( cell );		    														
				}		
		}    		
					
								
		for ( int i = 0; i < rowCount; i++ )  // Link each cells grid with its neighbors - left, right, up, down neighbors		     
			for ( int j = 0; j < columnCount; j++ ) {
		    	 		    	 		    	 
		    	
				if ( i == 0 )  
		    		cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).previousInColumn = null;
		    		
		    	
		    	else
		    		cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).previousInColumn = cells.get( getListIndexFromGridPosition( i - 1, j, rowCount ) );		    		 		    	 				    	 				    	 
		    	 	
		    	
		    	if ( j == 0 )
		    		cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).previousInRow = null;
		    		 
		    	
		    	else
		    		cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).previousInRow = cells.get( getListIndexFromGridPosition( i, j - 1, rowCount ) );
		    	 			    	 			    	 				    	 
		    	 			    	 	
		    	if ( j == (columnCount - 1) && i != (rowCount - 1) ) {
		    	
		    	 	cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).nextInRow = null;
		    		cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).nextInColumn = cells.get( getListIndexFromGridPosition( i + 1, j, rowCount ) );
		    	
		    	
		    	} else if ( j != (columnCount - 1) && i == (rowCount - 1) ) {
		    		
		    		cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).nextInRow = cells.get( getListIndexFromGridPosition( i, j + 1, rowCount ) );
		    		cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).nextInColumn = null;
		    	
		    	
		    	} else if( j == (columnCount - 1) && i == (rowCount - 1) ) {
		    	
		    		cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).nextInRow = null;
		    		cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).nextInColumn = null;
		    	
		    	
		    	} else {
		    		
		    		cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).nextInRow = cells.get( getListIndexFromGridPosition ( i, j + 1, rowCount ) );
		    		cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).nextInColumn = cells.get( getListIndexFromGridPosition ( i + 1, j, rowCount ) );
		    	}	    	 	 
		    	 
		    }											
	}

	
	
	
	// Given i and j matrix position, return element index in the cells List
	public int getListIndexFromGridPosition ( int i, int j, int rowCount ) {
		
		return ( i * rowCount + j );			
	}
	
	
	
	// Given x and y distances from windows reference, return i and j matrix position.
	public Point getGridPositionFromClickedPoint ( double x0, double y0 ) {
				
		int i = (int) ( ( y0 - this.yOffset )  / this.cellHeight );
		int j = (int) ( ( x0 - this.xOffset ) / this.cellWidth   );
		
		return new Point (i, j); 			
	
	}
	
	
	
	// Set all cells.currentChosenShip with the clicked ship by player
	public void setCurrentShipForEachCell ( Ship ship, int rowCount, int columnCount ) {

		for( int i = 0; i <  rowCount; i++ )     
			for ( int j = 0; j < columnCount; j++ )
			
				cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).currentChosenShip = ship;
				
	
	}
		
	
	
	// Set all cells.currentChosenShip with null. Restart all them.
	public void initialTheCurrentShipForEachCell ( int rowCount, int columnCount ) {
		
		for( int i = 0; i < rowCount; i++ ) 	    
			for ( int j = 0; j < columnCount; j++ ) 
				
				cells.get( getListIndexFromGridPosition( i, j, rowCount  ) ).currentChosenShip = null;
	
	}

  
  
    // Reset the Grid to ships. 
	public void resetShipPlacementOnEachCell ( int rowCount, int columnCount ) {
	   
	for( int i = 0; i < rowCount; i++ ) 
	    
		for ( int j = 0; j < columnCount; j++ ) {
		
			cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).currentChosenShip = null;
			cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).isShipPlacedOn = null;
			cells.get( getListIndexFromGridPosition( i, j, rowCount ) ).cellColor = Color.CYAN;			
		}	   	
   
	}

	
}
