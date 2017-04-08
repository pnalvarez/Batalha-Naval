package game.model;

import java.awt.Color;


public class Ship {
		
	public int size = 0;
	public String name;
	public Color shipColor = new Color ( 0, 0, 0 );
	public boolean orientation_horizontal = true;
	public Color shipColorToPaintShipSelectorPanel = new Color ( 0, 0, 0 );
	
	public boolean isSunk = false;			
	public boolean isShipEnable = true;  /* verify if a ship has already chosen */
	
	// control the ship damage - holds all parts damage
	public int hitIndex = 0;  
	public boolean []getHit; 
	
		
	public Ship ( int size, String name ) {		
		
		this.size = size;	
		this.name = name;
		
		getHit = new boolean [size];		
        
		for ( int i = 0; i < this.size; i++ )    
        	getHit [i] = false;
       		
		setShipshipColors ( );
		
	}
		

	
	private void setShipshipColors ( ) {
		
		if ( size == 5 ) {		
			
			this.shipColor = new Color(176,196,222);
			this.shipColorToPaintShipSelectorPanel = new Color(176,196,222);
		
		}	
			
		 else if ( size == 4 ) {
			
			 this.shipColor = new Color(143,188,143);
			this.shipColorToPaintShipSelectorPanel = new Color(143,188,143);
		 
		 }	
			
		 else if ( size == 3 ) {
		
			this.shipColor = new Color(255,215,0);
			this.shipColorToPaintShipSelectorPanel = new Color(255,215,0);
		 
		 }	
			
		 else if ( size == 2 ) {
		
			this.shipColor = new Color(188,143,143);
			this.shipColorToPaintShipSelectorPanel = new Color(188,143,143);
		 
		 }
			
		 else if ( size == 1 ) 	{
		
			this.shipColor = new Color(160,32,240);
			this.shipColorToPaintShipSelectorPanel = new Color(160,32,240);
		
		 }	
			
	}



	public void rotate ( ) {
		
		orientation_horizontal = !orientation_horizontal;				
	
	}
	
	
   
	public boolean isSunk ( ) {
    	
		int sunkIndex = 0;
    	
		for ( int i = 0; i < this.size; i++ )    		
			if( this.getHit[i] == true )    			
    			sunkIndex = sunkIndex + 1;
    		    	
    	 if ( sunkIndex == this.size ) {
    		
			 this.isSunk = true;
    		 return true;
    	 }
    	 
		 return false;   	
    }


	
	public void setHit ( ) {
		
		try {	
		
			this.getHit [ hitIndex ] = true;
			
			hitIndex++;		
		
		} catch(Exception e) { }		
	
	}
	

	
		
}
