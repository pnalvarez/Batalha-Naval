package game.controller;

import game.model.Player;
import game.view.GameSceneView;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class GameScene extends JFrame {

	private JPanel contentPane;
	static GameScene frame;
    public static Player player_01  = new Player();
    public static Player player_02  = new Player();
	
    public static String namePlayer01 = "", 
	                     namePlayer02 = "";
    
    
    public static void main ( String[] args ) {
		
		EventQueue.invokeLater ( new Runnable ( ) {
			
			public void run() {
				
				try {
					
					frame = new GameScene ( );
					frame.setVisible(true);
				
				} catch (Exception e) {
				
					e.printStackTrace ( );
				}
			}
		});
	}

	
	

	public GameScene ( ) {
		
		setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
		setBounds ( 100, 100, 450, 344 );
		contentPane = new JPanel ( );
		contentPane.setBorder ( new EmptyBorder ( 5, 5, 5, 5 ) );
		setContentPane ( contentPane );
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("        BATALHA NAVAL");
		lblNewLabel.setBounds ( 147, 0, 154, 90 );
		contentPane.add ( lblNewLabel );
		
	    JLabel lblplayer1 = new JLabel("Jogador 1");
	    JLabel lblplayer2 = new JLabel("Jogador 2");	    
	    lblplayer1.setBounds ( 130, 90,  100, 30);
	    lblplayer2.setBounds ( 130, 150,  100, 30);	    
	    contentPane.add ( lblplayer1 );
	    contentPane.add ( lblplayer2 );
	    
	    JTextField lblname1 = new JTextField(16);
	    JTextField lblname2 = new JTextField(16);
	    lblname1.setText ("jogador 1");
	    lblname2.setText ("jogador 2");
	    lblname1.setSelectedTextColor(Color.GRAY);
	    lblname2.setSelectedTextColor(Color.GRAY);	    
	    lblname1.setBorder ( BorderFactory.createCompoundBorder ( lblname1.getBorder ( ), BorderFactory.createEmptyBorder (5, 5, 5, 5) ) );
	    lblname2.setBorder ( BorderFactory.createCompoundBorder ( lblname1.getBorder ( ), BorderFactory.createEmptyBorder (0, 5, 0, 12) ) );	    
	    lblname1.setBounds ( 200, 90, 130, 30);	    
	    lblname2.setBounds ( 200, 150, 130, 30);	    
	    contentPane.add ( lblname1 );
	    contentPane.add ( lblname2 );
			
	    
		JButton btnNewGame = new JButton ( "NOVO JOGO" );
		
		btnNewGame.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
						
						GameSceneView view = GameSceneView.getInstance();
		                view.setPanelFrame();
		                view.setPlayerBoardAndShipSelectorOnPanel ( player_01 );
		                
		                JLabel lbltitle = new JLabel ( "PLAYER_01:  " + lblname1.getText() );
		                lbltitle.setBounds ( 50, 570, 200, 50 );
		                view.contentPane.add(lbltitle);		              
		                player_01.nextPlayer.setEnabled(false);
		               
		                player_01.name = lblname1.getText();
		                
		                view.setButtonsOnPanel(player_01, true, false, true, false);
		                view.setMessegeBoxOnPanel(player_01);
		                
		                view.setVisible(true);					
						frame.setVisible(false);
						
						namePlayer01 = lblname1.getText();
					    					
				
				} catch(Exception e) {
					
				
				}
			
			}
		
		});
		
		btnNewGame.setBounds ( 100, 230, 100, 50 );
		contentPane.add(btnNewGame);
		
	
		player_01.nextPlayer.addActionListener ( new ActionListener ( ) {
			
			public void actionPerformed ( ActionEvent arg0 ) {
				
				
				try {
													 
						
						GameSceneView view = GameSceneView.getInstance();
		                view.setPanelFrame();
		                view.setPlayerBoardAndShipSelectorOnPanel ( player_02 );
		                
		                JLabel lbltitle = new JLabel ( "PLAYER_02:  " + lblname2.getText() );
		                lbltitle.setBounds ( 50, 570, 200, 50 );
		                view.contentPane.add(lbltitle);		              
		               
		                player_02.name = lblname2.getText();
		                
		                view.setButtonsOnPanel(player_02, false, true, true, false);
		                view.setMessegeBoxOnPanel(player_02);
		                
		                view.setVisible(true);					
						frame.setVisible(false);
						
						namePlayer02 = lblname2.getText();
				
				} catch(Exception e) {
					
				
				}
			
			}
		
		}); 
		
		
		
		player_02.start.addActionListener (new ActionListener() {
			
			public void actionPerformed ( ActionEvent e ) {
				
				
				try {
				
					
					
					
				System.out.println("aquiii");
				
				if( player_02.AllShipsAreSetOnBoard() ) {
				
					player_02.messageBox.setText ("FIGHT!!!!!");
				  
					player_02.GameIsStart = true;
					player_02.save.setEnabled ( true );
				
					player_01.GameIsStart = true;
					player_01.save.setEnabled ( true );
					
					

					for ( Cell cell : player_01.board.boardGrid.cells  ) {
						
						cell.cellColor = Color.CYAN;
						
					}
					
					for ( Cell cell : player_02.board.boardGrid.cells  ) {
						
						cell.cellColor = Color.CYAN;
						
					}
					
				
					GameSceneView view = GameSceneView.getInstance();
	                view.setPanelFrame();
	                view.setPlayersBoardsOnPanel(player_01, player_02);
	                view.setButtonsOnPanel(player_01, false, false, false, true);
					
	                
	                player_02.messageBox.setBounds ( 800, 550, 180, 50 );
	        		player_02.messageBox.setBackground(Color.LIGHT_GRAY);
	        		player_02.messageBox.setBorder(BorderFactory.createLineBorder(Color.CYAN));
	        		view.contentPane.add ( player_02.messageBox );
	                
	                
	        		player_01.messageBox.setBounds ( 800, 550, 180, 50 );
	        		player_01.messageBox.setBackground(Color.LIGHT_GRAY);
	        		player_01.messageBox.setBorder(BorderFactory.createLineBorder(Color.CYAN));
	        		view.contentPane.add ( player_01.messageBox );
	                
	               
	                player_01.enemy = player_02;
	    			player_02.enemy = player_01;
	    			
	    			player_01.putEnemyGridIntoArrayList();
	    			player_02.putEnemyGridIntoArrayList();
	    				    		
	    			player_01.setPlayerControlOnEnemyGridView();
	    			player_02.setPlayerControlOnEnemyGridView();
	                	             	                
	    			view.setLabelsOnPanel(player_01, player_02);
	                	                	               
	                view.setVisible(true);					
					frame.setVisible(false);
						
				} else {
				  
					player_02.messageBox.setText("Por favor posicione todos os navios antes de começar!");
				}
							
			
				} catch(Exception e6) {	}
				
			}
			
		});
		
		

		
		JButton btnLoadGame = new JButton ( "LOAD GAME" );
		
		btnLoadGame.addActionListener ( new ActionListener ( ) {
			
			public void actionPerformed ( ActionEvent e ) {
				        
				        String text = "";
				        				        
				        player_01 = new Player();				        	
			        	player_02 = new Player ();
			        	
			        	player_01.name = namePlayer01;
			        	player_02.name = namePlayer02;
			        	
				        
				        try {
						
				        	FileReader readfile = new FileReader ( "saveFile.txt" );						
				        	BufferedReader textReader = new BufferedReader (  readfile );
						 
				        	text = textReader.readLine();
						
				        	if ( text.equals ( "false" ) ) {
							
				        		player_01.GameIsStart = false;
				        		player_02.GameIsStart = false;
			        	
				        	} else {
							
				        		player_01.GameIsStart = true;
				        		player_02.GameIsStart = true;
						
				        	}
						
				        	text = textReader.readLine ( );
						
				        	if ( text.equals ( "false" ) ) {
							
				        		player_01.GameIsOver = false;
				        		player_02.GameIsOver = false;
						
				        	} else {
							
				        		player_01.GameIsOver = true;
				        		player_02.GameIsOver = true;
						
				        	}
						
				        	
				        	// To the player_01...update cells....
				        	
				        	for ( Cell cell : player_01.board.boardGrid.cells ) {
				        		
				        		text = textReader.readLine ( );
				        		
				        		if ( text.equals ( "AircraftCarrier" ) ) { 
				        			
				        			cell.isShipPlacedOn = player_01.AirCarrier;
				        			cell.cellColor = Color.CYAN;
				        							        		
				        		} else if ( text.equals ( "BattleShip1" ) ) {  
				        			
				        			cell.isShipPlacedOn = player_01.BatleShip[0];
				        			cell.cellColor = Color.CYAN;				        			
				        							        		
				        		} else if ( text.equals ( "BattleShip2" ) ) {   
				        			
				        			cell.isShipPlacedOn = player_01.BatleShip[1];
				        			cell.cellColor = Color.CYAN;
				        							        			
				        		} else if ( text.equals ( "Cruiser1" ) ) {   
				        			
				        			cell.isShipPlacedOn = player_01.Cruiser[0];
				        			cell.cellColor = Color.CYAN;
				        							        			
				        		} else if ( text.equals ( "Cruiser2" ) ) {  
				        			
				        			cell.isShipPlacedOn = player_01.Cruiser[1];
				        			cell.cellColor = Color.CYAN;
				        			
				        		} else if ( text.equals ( "Cruiser3" ) ) {   
				        			
				        			cell.isShipPlacedOn = player_01.Cruiser[2];
				        			cell.cellColor = Color.CYAN;
				        							        			
				        		} else if ( text.equals ( "Cruiser4" ) ) {   
				        			
				        			cell.isShipPlacedOn = player_01.Cruiser[3];
				        			cell.cellColor = Color.CYAN;
				        							        			
				        		} else if ( text.equals ( "Cruiser5" ) ) {  
				        			
				        			cell.isShipPlacedOn = player_01.Cruiser[4];
				        			cell.cellColor = Color.CYAN;
				        							        							        		
				        		} else if ( text.equals ( "Destroyer1" ) ) {   
				        			
				        			cell.isShipPlacedOn = player_01.Destroyer[0];
				        			cell.cellColor = Color.CYAN;
				        			
				        			
				        		} else if ( text.equals ( "Destroyer2" ) ) {  
				        			
				        			cell.isShipPlacedOn = player_01.Destroyer[1];
				        			cell.cellColor = Color.CYAN;
				        			
				        			
				        		} else if ( text.equals ( "Destroyer3" ) ) {  
				        			
				        			cell.isShipPlacedOn = player_01.Destroyer[2];
				        			cell.cellColor = Color.CYAN;
				        			
				        			
				        		} else if ( text.equals ( "Submarine1" ) ) {   
				        			
				        			cell.isShipPlacedOn = player_01.Submarine[0];
				        			cell.cellColor = Color.CYAN;
				        			
				        			
				        		} else if ( text.equals ( "Submarine2" ) ) { 
				        			
				        			cell.isShipPlacedOn = player_01.Submarine[1];
				        			cell.cellColor = Color.CYAN;
				        			
				        			
				        		} else if ( text.equals ( "Submarine3" ) ) { 
				        			
				        			cell.isShipPlacedOn = player_01.Submarine[2];
				        			cell.cellColor = Color.CYAN;
				        			
				        			
				        		} else if ( text.equals ( "Submarine4" ) ) {  
				        			
				        			cell.isShipPlacedOn = player_01.Submarine[3];
				        			cell.cellColor = Color.CYAN;
				        			
				        		} else {  
				        			
				        			
				        			cell.isShipPlacedOn = null;
				        							        			
				        		}
				        		
				        	}
				        	
				        	// To the player_01...update hit
				        	for ( Cell cell : player_01.board.boardGrid.cells ) {
				        		
				        		text = textReader.readLine ( );
				        	
				        		if ( text.equals ( "true" ) ) {
				        			
				        			cell.isHit = true;
				        			
				        			if ( cell.isShipPlacedOn == null )
				        				cell.cellColor = Color.WHITE;
				        			
				        			else {
				        				
				        				cell.cellColor = Color.RED;
				        				cell.isShipPlacedOn.getHit[ cell.isShipPlacedOn.hitIndex ] = true;
				        				cell.isShipPlacedOn.hitIndex += 1;
				        				
				        				if ( cell.isShipPlacedOn.hitIndex == cell.isShipPlacedOn.size )
				        					cell.isShipPlacedOn.isSunk = true;
					        				
				        			}			        							        		
				        		} 				        			        	
				        	}
				        	
				        	
				        	text = textReader.readLine();
				        	
				        	
				        	// To the player_02...
				        	if ( text.equals ( "enemy.mode" ) ) {
				        		
					        	
				        		// To the player_02...update cells....
				        		for ( Cell cell : player_02.board.boardGrid.cells ) {
					        		
					        		text = textReader.readLine ( );
					        		
					        		if ( text.equals ( "AircraftCarrier" ) ) { 
					        			
					        			cell.isShipPlacedOn = player_02.AirCarrier;
					        			cell.cellColor = Color.CYAN;
					        							        		
					        		} else if ( text.equals ( "BattleShip1" ) ) {  
					        			
					        			cell.isShipPlacedOn = player_02.BatleShip[0];
					        			cell.cellColor = Color.CYAN;				        			
					        							        		
					        		} else if ( text.equals ( "BattleShip2" ) ) {   
					        			
					        			cell.isShipPlacedOn = player_02.BatleShip[1];
					        			cell.cellColor = Color.CYAN;
					        							        			
					        		} else if ( text.equals ( "Cruiser1" ) ) {   
					        			
					        			cell.isShipPlacedOn = player_02.Cruiser[0];
					        			cell.cellColor = Color.CYAN;
					        							        			
					        		} else if ( text.equals ( "Cruiser2" ) ) {  
					        			
					        			cell.isShipPlacedOn = player_02.Cruiser[1];
					        			cell.cellColor = Color.CYAN;
					        			
					        		} else if ( text.equals ( "Cruiser3" ) ) {   
					        			
					        			cell.isShipPlacedOn = player_02.Cruiser[2];
					        			cell.cellColor = Color.CYAN;
					        							        			
					        		} else if ( text.equals ( "Cruiser4" ) ) {   
					        			
					        			cell.isShipPlacedOn = player_02.Cruiser[3];
					        			cell.cellColor = Color.CYAN;
					        							        			
					        		} else if ( text.equals ( "Cruiser5" ) ) {  
					        			
					        			cell.isShipPlacedOn = player_02.Cruiser[4];
					        			cell.cellColor = Color.CYAN;
					        							        							        		
					        		} else if ( text.equals ( "Destroyer1" ) ) {   
					        			
					        			cell.isShipPlacedOn = player_02.Destroyer[0];
					        			cell.cellColor = Color.CYAN;
					        			
					        			
					        		} else if ( text.equals ( "Destroyer2" ) ) {  
					        			
					        			cell.isShipPlacedOn = player_02.Destroyer[1];
					        			cell.cellColor = Color.CYAN;
					        			
					        			
					        		} else if ( text.equals ( "Destroyer3" ) ) {  
					        			
					        			cell.isShipPlacedOn = player_02.Destroyer[2];
					        			cell.cellColor = Color.CYAN;
					        			
					        			
					        		} else if ( text.equals ( "Submarine1" ) ) {   
					        			
					        			cell.isShipPlacedOn = player_02.Submarine[0];
					        			cell.cellColor = Color.CYAN;
					        			
					        			
					        		} else if ( text.equals ( "Submarine2" ) ) { 
					        			
					        			cell.isShipPlacedOn = player_02.Submarine[1];
					        			cell.cellColor = Color.CYAN;
					        			
					        			
					        		} else if ( text.equals ( "Submarine3" ) ) { 
					        			
					        			cell.isShipPlacedOn = player_02.Submarine[2];
					        			cell.cellColor = Color.CYAN;
					        			
					        			
					        		} else if ( text.equals ( "Submarine4" ) ) {  
					        			
					        			cell.isShipPlacedOn = player_02.Submarine[3];
					        			cell.cellColor = Color.CYAN;
					        			
					        		} else {  
					        			
					        			
					        			cell.isShipPlacedOn = null;
					        							        			
					        		}
					        	
					        		
				        		}						        		
					        		// To the player_02...update hit
					        	for ( Cell cell : player_02.board.boardGrid.cells ) {
						        		
						        	text = textReader.readLine ( );
						        	
						        	if ( text.equals ( "true" ) ) {
						        			
						        		cell.isHit = true;
						        			
						        		if ( cell.isShipPlacedOn == null )
						        			cell.cellColor = Color.WHITE;
						        			
						        		else {
						        				
						        			cell.cellColor = Color.RED;
						        			cell.isShipPlacedOn.getHit[ cell.isShipPlacedOn.hitIndex ] = true;
						        			cell.isShipPlacedOn.hitIndex += 1;
						        				
						        			if ( cell.isShipPlacedOn.hitIndex == cell.isShipPlacedOn.size )
						        				cell.isShipPlacedOn.isSunk = true;
							        				
						        		}			        							        		
						        	} 				        			        	
						        }
					        							        		
				        	}
				        	
				        	
				        textReader.close();
				        
				          
						player_02.GameIsStart = true;
						player_02.save.setEnabled ( true );
					
						player_01.GameIsStart = true;
						player_01.save.setEnabled ( true );
						
				
						GameSceneView view = GameSceneView.getInstance();
		                view.setPanelFrame();
		                view.setPlayersBoardsOnPanel(player_01, player_02);
		                view.setButtonsOnPanel(player_01, false, false, false, true);
							                
		                player_02.messageBox.setBounds ( 800, 550, 180, 50 );
		        		player_02.messageBox.setBackground(Color.LIGHT_GRAY);
		        		player_02.messageBox.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		        		view.contentPane.add ( player_02.messageBox );
		                	                
		        		player_01.messageBox.setBounds ( 800, 550, 180, 50 );
		        		player_01.messageBox.setBackground(Color.LIGHT_GRAY);
		        		player_01.messageBox.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		        		view.contentPane.add ( player_01.messageBox );
		                
			            player_01.enemy = player_02;
		    			player_02.enemy = player_01;		    			
		    			player_01.putEnemyGridIntoArrayList();
		    			player_02.putEnemyGridIntoArrayList();    				    		
		    			player_01.setPlayerControlOnEnemyGridView();
		    			player_02.setPlayerControlOnEnemyGridView();

		    			view.setLabelsOnPanel(player_01, player_02);
		                	   
		                view.setVisible(true);					
						frame.setVisible(false);
				        
				        
				        } catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					
				        } catch (IOException e1) {
						
						e1.printStackTrace();
					
				        }
				
			}
		
			
		});
		
		btnLoadGame.setBounds ( 250, 230, 100, 50 );
		contentPane.add (btnLoadGame);

	}
	
}
