package game.controller;

import game.model.Ship;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.geom.Rectangle2D;


public class Cell extends Rectangle2D.Double {
		
	public Cell checkingCell,		
	            previousInRow, 
	            nextInRow, 
	            previousInColumn, 
	            nextInColumn;
	
		
	public Color cellColor = Color.CYAN; 
	
	// chosen ship by player
	public Ship currentChosenShip = null;   
	
    // ship placed on the Cell. Stay here!
	public Ship isShipPlacedOn = null;  
	
	// verify if a cell was hit by other player
	public boolean isHit = false;  
	
	public JTextPane label;
    
	

    public Cell ( int x0, int y0, int width, int height ) {
		
			super ( x0, y0, width, height );
					
			checkingCell = this;
    }
	
    
    
    /* Verify if a ship can be placed on Grid from a clicked Cell */
	public boolean isCellEnoughAndNotTaken() {
       
		if ( currentChosenShip.orientation_horizontal == true ) {
		         		
			for( int i = 0; i < currentChosenShip.size; i++ ) {  // Is there enough space ?
			          
				if( checkingCell == null ) 			        	  	
					return false;
			          
				 else 
			     	checkingCell = checkingCell.nextInRow;				         
			}
		         		              
			
			checkingCell = this;
		         		        
					
			if ( currentChosenShip.name.equals ("Cruiser1") ||
				 currentChosenShip.name.equals ("Cruiser2") ||
				 currentChosenShip.name.equals ("Cruiser3") ||
				 currentChosenShip.name.equals ("Cruiser4") ||
				 currentChosenShip.name.equals ("Cruiser5")  ) 
								
				if ( checkingCell.nextInRow.previousInColumn == null )
					return false;
	
			
			for( int i = 0; i < currentChosenShip.size; i++ ) { // Has the clicked Cell already been occupied ?
			          
		    	if( checkingCell.isShipPlacedOn != null )        	 			        	 
			        	  return false;
			         
		        else     	 
		        	checkingCell = checkingCell.nextInRow;
    
			}	         
		       		      		        	
			
			checkingCell = this;
		   
			
			if ( currentChosenShip.name.equals ("Cruiser1") ||
				 currentChosenShip.name.equals ("Cruiser2") ||
				 currentChosenShip.name.equals ("Cruiser3") ||
				 currentChosenShip.name.equals ("Cruiser4") ||
				 currentChosenShip.name.equals ("Cruiser5")  )
				
				if ( checkingCell.nextInRow.previousInColumn.isShipPlacedOn != null )
					return false;
			
			
			
			} else {   // Vertical position
		    	 
		    	for( int i = 0;  i < currentChosenShip.size; i++ ) {
			      
		    		if(checkingCell == null) 			     	  
			        	  return false;
			        
		    		  else 			        	 
			        	  checkingCell = checkingCell.nextInColumn;			               
		    	 }
		         
		    	 
		    	checkingCell = this;
		         
		    	
		    	if ( currentChosenShip.name.equals ("Cruiser1") ||
					 currentChosenShip.name.equals ("Cruiser2") ||
					 currentChosenShip.name.equals ("Cruiser3") ||
					 currentChosenShip.name.equals ("Cruiser4") ||
					 currentChosenShip.name.equals ("Cruiser5")  )
		    	
		    		if ( checkingCell.nextInColumn.nextInRow == null )
		    			return false;
		    	
		    	for( int i = 0; i < currentChosenShip.size; i++ ) {
			          
		    		 if( checkingCell.isShipPlacedOn != null ) 			        	  
			        	  return false;			          
		    		 
		    		 else 			        	
						  checkingCell = checkingCell.nextInColumn;			         		    		 
			          
		    	 }	    
		               
		    	checkingCell = this;
		     
		    	
		    	if ( currentChosenShip.name.equals ("Cruiser1") ||
					 currentChosenShip.name.equals ("Cruiser2") ||
					 currentChosenShip.name.equals ("Cruiser3") ||
					 currentChosenShip.name.equals ("Cruiser4") ||
					 currentChosenShip.name.equals ("Cruiser5")  )
			    	
			    	if ( checkingCell.nextInColumn.nextInRow.isShipPlacedOn != null )
			    		return false;
		    			    	
			}		
			
		return true;
}


	
	/* Verify if a clicked Cell has neighbors  */
	public boolean hasCellNoNeighbors ( ) {
		
		try {
		
			if (  currentChosenShip.orientation_horizontal == true ) {
        
				try {
							
					if ( checkingCell.previousInRow.isShipPlacedOn != null && checkingCell.previousInRow != null )    /*Has left neighbor?*/								
						return false;	
		
				} catch ( Exception e ) {    }
								
				for ( int i = 0;  i < currentChosenShip.size; i++) {
	          												
					try {
																	
						if ( checkingCell.nextInColumn != null && checkingCell.nextInColumn.isShipPlacedOn != null ) 	        	  				
								return false;
					
					} catch ( Exception e1 ) {    }	
				
					
					try {
											
						if  (  checkingCell.previousInColumn != null && checkingCell.previousInColumn.isShipPlacedOn != null ) 
								return false;
					
					} catch ( Exception e1 ) {    }
					
					    	  
					checkingCell = checkingCell.nextInRow;			 
									
			    }
       
				try {
					
					if ( checkingCell != null && checkingCell.isShipPlacedOn != null )   /*Has right neighbor?*/
						return false;
			
				} catch ( Exception e1 ) {    }
		 
		
		
			}  else {
    	 
				try {
			
					if ( checkingCell.previousInColumn != null  && checkingCell.previousInColumn.isShipPlacedOn != null) /*Has down neighbor?*/
						return false;	
		  		  
				} catch ( Exception e1 ) {    }
		  
		  
				for ( int i = 0; i < currentChosenShip.size ; i++ ) {
	         		    		 
					try {
			 
						if ( checkingCell.nextInRow  != null && checkingCell.nextInRow.isShipPlacedOn != null ) 
							return false;
					
					} catch ( Exception e1 ) {    }
    				 
    				
					try {
			  
						if ( checkingCell.previousInRow != null && checkingCell.previousInRow.isShipPlacedOn != null ) 	        	  
							return false;
	        
					} catch ( Exception e1 ) {    }
				  				  
    		         	 
					checkingCell = checkingCell.nextInColumn;	         	          
				}
         
		  
				try {
		  
					if( checkingCell != null && checkingCell.isShipPlacedOn != null) /*Has up neighbor?*/ 
						return false;	 
		  
				} catch ( Exception e1 ) {    }
		  		  
		}	

		} catch ( Exception e ) {    }
		
		
		checkingCell = this;   
	  
		
		if ( currentChosenShip.name.equals ("Cruiser1") ||
			 currentChosenShip.name.equals ("Cruiser2") ||
			 currentChosenShip.name.equals ("Cruiser3") ||
			 currentChosenShip.name.equals ("Cruiser4") ||
			 currentChosenShip.name.equals ("Cruiser5")  ) {
			
			if (  currentChosenShip.orientation_horizontal == true ) {
				
				if ( checkingCell.nextInRow.previousInColumn.previousInRow != null && checkingCell.nextInRow.previousInColumn.previousInRow.isShipPlacedOn != null )
					return false;
				
				if ( checkingCell.nextInRow.previousInColumn.nextInRow != null && checkingCell.nextInRow.previousInColumn.nextInRow.isShipPlacedOn != null )
					return false;
				
				if ( checkingCell.nextInRow.previousInColumn.previousInColumn != null && checkingCell.nextInRow.previousInColumn.previousInColumn.isShipPlacedOn != null )
					return false;

			} else {
				
				
				if ( checkingCell.nextInColumn.nextInRow.previousInColumn != null && checkingCell.nextInColumn.nextInRow.previousInColumn.isShipPlacedOn != null )
					return false;
				
				if ( checkingCell.nextInColumn.nextInRow.nextInColumn != null && checkingCell.nextInColumn.nextInRow.nextInColumn.isShipPlacedOn != null )
					return false;
				
				if ( checkingCell.nextInColumn.nextInRow.nextInRow != null && checkingCell.nextInColumn.nextInRow.nextInRow.isShipPlacedOn != null )
					return false;
				
			}
				
		}
	    		
		return true;
				
	}
				

	
	
    /* This method changes the Cell color when a player attacks other */
	public void getHit() {

		try {	
		if ( checkingCell.isShipPlacedOn != null ) // verifica se tem nave na celula
			checkingCell.cellColor = Color.RED; // troca a cor pra vermelho

		else 
			checkingCell.cellColor = Color.WHITE; // troca a cor pra branco se nao tem nave
	
	
		checkingCell.isHit = true; //celula foi atacada

	
		if ( checkingCell.isShipPlacedOn != null ) {

			checkingCell.isShipPlacedOn.setHit ( );  // indicates that part of ship was hit

			if ( checkingCell.isShipPlacedOn.isSunk ( ) ) 
				checkingCell.label.setText ( label.getText ( ) + "\n" + checkingCell.isShipPlacedOn.name + " Afundou!");	//mostra que a nave presente nesse espaco ja foi afundada
			
		} 
	
	} catch (Exception e){}	
}		

}
