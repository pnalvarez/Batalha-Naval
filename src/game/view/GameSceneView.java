package game.view;

import game.controller.Cell;
import game.model.Player;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;



public class GameSceneView extends JFrame {


	public JPanel contentPane;		  	
    public JTextPane centralLabel = new JTextPane ( );
     
       
     private static GameSceneView instance = null;
        
     protected GameSceneView ( ) { }
         
     public static GameSceneView getInstance ( ) {
	 	
    	 if ( instance == null ) 	         
    		 instance = new GameSceneView ( );
	       			    		    	 
    	 return instance;
	}
     
     
         

	public void setPanelFrame ( ) {
		
		instance.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );		
		instance.setBounds ( 100, 100, 1200, 700 );		
		contentPane = new JPanel ( );		
		contentPane.setBorder ( new EmptyBorder ( 5, 5, 5, 5 ) );		
		contentPane.setLayout ( null );				
		instance.setContentPane ( contentPane );
	
	}

	
	public void setPlayersBoardsOnPanel ( Player player_01, Player player_02 ) {
		
		
		player_01.board.setBounds (30, 40, 500, 500);
		player_02.board.setBounds (670, 40, 500, 500);
		
		
		contentPane.add( player_01.board );
		contentPane.add( player_02.board );
		
	}
	
	
	public void setPlayerBoardAndShipSelectorOnPanel ( Player player ) {
			
			player.board.setBounds (50, 40, 500, 500);
			player.shipSelectorPanel.setBounds (650, 40, 500, 500);
			
			contentPane.add( player.board );
			contentPane.add( player.shipSelectorPanel );
									
	}

	
	public void setMessegeBoxOnPanel ( Player player ) {
					
		player.messageBox.setBounds ( 800, 550, 180, 50 );
		player.messageBox.setBackground(Color.LIGHT_GRAY);
		player.messageBox.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		contentPane.add ( player.messageBox );
		
		
		player.messageBox2.setBounds ( 1020, 550, 80, 50 );
		player.messageBox2.setBackground(Color.LIGHT_GRAY);
		player.messageBox2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		contentPane.add ( player.messageBox2 );
		
	
	}
	
		
	public void setLabelsOnPanel ( Player player_01, Player player_02 ) {
		
		
		centralLabel.setBounds ( 540, 42, 120, 510 );
		
		for ( Cell cell :  player_01.board.boardGrid.cells  ) 		
			cell.label = centralLabel;
			
	
		for ( Cell cell :  player_02.board.boardGrid.cells  ) 
			cell.label = centralLabel;
			
		
		contentPane.add ( centralLabel );
		
		JLabel lblP1 = new JLabel ( "PLAYER 1" );
		lblP1.setFont ( new Font( "Adobe Caslon Pro", Font.BOLD | Font.ITALIC, 52 ) );
		lblP1.setBounds ( 169, 495, 67, 62) ;
		contentPane.add ( lblP1 );
		
		JLabel lblP2 = new JLabel ( "PLAYER 2" );
		lblP2.setFont (new Font ( "Adobe Caslon Pro", Font.BOLD | Font.ITALIC, 53 ) );
		lblP2.setBounds ( 778, 487, 193, 81 );
		contentPane.add ( lblP2 );
			
	}
	
	

	 public void setButtonsOnPanel ( Player player, boolean nextPlayer, boolean start, boolean reset, boolean save ) {
    	
		 
		 if ( nextPlayer == true ) {
			 
			 player.nextPlayer.setBounds ( 380, 570, 80, 50 );
			 contentPane.add ( player.nextPlayer ); 			 			 
		 }
			 
		 if ( start == true ) {
			 
			player.start.setBounds ( 380, 570, 80, 50 );
			contentPane.add ( player.start );
			 			 
		 }
		 
		 if ( reset == true ) {
			 
			 player.reset.setBounds ( 250, 570, 80, 50 );
			 contentPane.add ( player.reset ); 
			 
		 }
		 
		 if ( save == true ) {
			 
			 player.save.setBounds ( 10, 580, 80, 50 );
			 contentPane.add ( player.save ); 
			 			 
		 }
			
    }
	
	
		
}
