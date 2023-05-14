package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.Random;
/**
 * 
 * @author vanessali
 *
 */

public class Main extends Application {
	//human player board
	private gameBoard boardH = new gameBoard();
	
	//computer player board
	private gameBoard boardC = new gameBoard();

	private Scene root;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			computerPlayer generator = new computerPlayer();
			computerPlayer computer = generator.generatePlayer();
			
			boardC = new gameBoard(computer);
			//set title
			primaryStage.setTitle("BATTLESHIP");
			
			//add image
			Image image = new Image("file:Battleship.jpg");
			ImageView battleship = new ImageView(image);
			
			
			//add label for human player name
			Label playerName = new Label("Please enter your name: ");
			playerName.setStyle("-fx-text-fill: white");
			
			//textfield for human player name
			TextField name = new TextField();
			
			//Hbox for label and textfield
			HBox Name = new HBox(10, playerName, name);
			
			Name.setPadding(new Insets(10));

			
			//button to click to start game
			Button start = new Button("Start!");
			start.setStyle("-fx-background-color: teal; -fx-text-fill: white");


			//if playing computer
			VBox vbox1 = new VBox(10, battleship, Name, start);
			
			//styling vbox
			vbox1.setStyle("-fx-background-color: black; -fx-font-weight: bold");
			vbox1.setAlignment(Pos.CENTER);
			vbox1.setPadding(new Insets(0, 0, 10, 0));
			
			//creating new scene object
			root = new Scene(vbox1);
			
			//setting scene
			primaryStage.setScene(root);
			

			
			
			
			start.setOnAction(event -> 
			{
				//only works when name isn't empty
				if(!name.getText().isBlank()){
				//storing textfield inputs
				String nameFirst;
				nameFirst = name.getText();
				
				
				Label humanPlayerGrid = new Label(nameFirst + "'s Grid");
				humanPlayerGrid.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20pt");
				
				//button to confirm selection
				Button confirm = new Button("Confirm");
				confirm.setStyle("-fx-background-color: teal; -fx-text-fill: white");
				confirm.setDisable(true);
				
				//creating grid for human player board
				GridPane HPgrid = new GridPane();
				
				//creating radiobuttons for different ship
				
				//add label to select ship
				Label selectShip = new Label("Please select which ship you would like to add: ");
				selectShip.setStyle("-fx-text-fill: white");
				
				//add radio buttons
				RadioButton Carrier = new RadioButton("Carrior (length: 5)");
				RadioButton BattleShip = new RadioButton("Battleship (length: 4)");
				RadioButton Cruiser = new RadioButton("Cruiser (length: 3)");
				RadioButton Submarine = new RadioButton("Submarine (length: 3)");
				RadioButton Destroyer = new RadioButton("Destroyer (length: 2)");
				Carrier.setStyle("-fx-text-fill: white");
				BattleShip.setStyle("-fx-text-fill: white");
				Cruiser.setStyle("-fx-text-fill: white");
				Submarine.setStyle("-fx-text-fill: white");
				Destroyer.setStyle("-fx-text-fill: white");
				
				//create toggle group
				ToggleGroup radioGroup = new ToggleGroup();
				Carrier.setToggleGroup(radioGroup);
				BattleShip.setToggleGroup(radioGroup);
				Cruiser.setToggleGroup(radioGroup);
				Submarine.setToggleGroup(radioGroup);
				Destroyer.setToggleGroup(radioGroup);
				Carrier.setSelected(true);
				
				//creating the ships for human player
				ship Carrier1 = new ship(5);
				ship BattleShip1 = new ship(4);
				ship Cruiser1 = new ship(3);
				ship Submarine1 = new ship(3);
				ship Destroyer1 = new ship(2);
				
				
				//creating the human player grid
				for(int row = 0; row < boardH.getWidth(); row++) {
					for(int col = 0; col < boardH.getHeight(); col++) {
		
						
						//create alternating color grid
						if((row+col)%2 == 0) boardH.getTile(row, col).setFill(Color.ROYALBLUE);
						else {boardH.getTile(row, col).setFill(Color.BLUE);}
						
						int Fcol = col; 
						int Frow = row;
						
						//event to add ships
						boardH.getTile(row, col).setOnMouseClicked(event2 -> {RectangleClickShoot(event2);
								//when carrier is chosen
								if(Carrier.isSelected()) {
									//check if tile is valid for ship
									if(ValidShip(Carrier1, Frow, Fcol)) {
										
										//if valid change color, set occupied and add location
										boardH.getTile(Frow, Fcol).setFill(Color.DARKSLATEGRAY);
										boardH.getTile(Frow, Fcol).updateOccupied(true);
										Carrier1.addLocation(boardH.getTile(Frow, Fcol));
										//if ship is at max length disable ship button
										if(Carrier1.getLocation().size() == Carrier1.getLength()) Carrier.setDisable(true);
									}
								}
								//when battleship is chosen
								else if(BattleShip.isSelected()) {
									//check if tile is valid for ship
									if(ValidShip(BattleShip1, Frow, Fcol)) {
										
										//if valid change color, set occupied and add location
										boardH.getTile(Frow, Fcol).setFill(Color.LIGHTGRAY);
										boardH.getTile(Frow, Fcol).updateOccupied(true);
										BattleShip1.addLocation(boardH.getTile(Frow, Fcol));
										//if ship is at max length disable ship button
										if(BattleShip1.getLocation().size() == BattleShip1.getLength()) BattleShip.setDisable(true);
									}
							
								}
								//when cruiser is chosen
								else if(Cruiser.isSelected()) {
									//check if tile is valid for ship
									if(ValidShip(Cruiser1, Frow, Fcol)) {
										
										//if valid change color, set occupied and add location
										boardH.getTile(Frow, Fcol).setFill(Color.GRAY);
										boardH.getTile(Frow, Fcol).updateOccupied(true);
										Cruiser1.addLocation(boardH.getTile(Frow, Fcol));
										//if ship is at max length disable ship button
										if(Cruiser1.getLocation().size() == Cruiser1.getLength()) Cruiser.setDisable(true);
									}
									
								}
								//when submarine is chosen
								else if(Submarine.isSelected()) {
									//check if tile is valid for ship
									if(ValidShip(Submarine1, Frow, Fcol)) {
										
										//if valid change color, set occupied and add location
										boardH.getTile(Frow, Fcol).setFill(Color.DIMGRAY);
										boardH.getTile(Frow, Fcol).updateOccupied(true);
										Submarine1.addLocation(boardH.getTile(Frow, Fcol));
										//if ship is at max length disable ship button
										if(Submarine1.getLocation().size() == Submarine1.getLength()) Submarine.setDisable(true);
									}
									else Submarine.setDisable(true);
								}
								//when destroyer is chosen
								else if(Destroyer.isSelected()) {
									//check if tile is valid for ship
									if(ValidShip(Destroyer1, Frow, Fcol)) {
										
										//if valid change color, set occupied and add location
										boardH.getTile(Frow, Fcol).setFill(Color.DARKGREY);
										boardH.getTile(Frow, Fcol).updateOccupied(true);
										Destroyer1.addLocation(boardH.getTile(Frow, Fcol));
										//if ship is at max length disable ship button
										if(Destroyer1.getLocation().size() == Destroyer1.getLength()) Destroyer.setDisable(true);
									}
									
								}
								//confirm button is enabled when all ships are on the grid
								if(Carrier.isDisabled() && BattleShip.isDisabled() && Cruiser.isDisabled() && Submarine.isDisabled() && Destroyer.isDisabled()) confirm.setDisable(false);
								
						});
						//add to grid
						HPgrid.add(boardH.getTile(row, col), col, row);
					}
				}
				
				//Create fleet for human player
				ship fleetH[] = {Carrier1, BattleShip1, Cruiser1, Submarine1, Destroyer1};
				
				//Create human player
				player human = new humanPlayer(nameFirst, fleetH);
				
				//grid1 layout vbox
				VBox grid1Layout = new VBox(10, humanPlayerGrid, HPgrid, Carrier, BattleShip, Cruiser, Submarine, Destroyer, confirm);
				grid1Layout.setAlignment(Pos.CENTER);
				grid1Layout.setStyle("-fx-background-color: black; -fx-font-weight: bold");
				grid1Layout.setPadding(new Insets(10));
				
				root = new Scene(grid1Layout);
				
				//System.out.println(nameFirst + "'s Grid");
				primaryStage.setScene(root);
				
				
				
				
				//action when confirm is clicked
				confirm.setOnAction(ev -> {
				
					//confirm is disabled until grid is hit
					confirm.setDisable(true);
					
					//creating grid for computer player board
					GridPane ComputerGrid = new GridPane();
					
					

					System.out.println("Comp Player");
					boardC.printBoard();
					System.out.println("Human Player");
					boardH.printBoard();
					

					//creating radiobuttons for different special moves
					//add label to choose if want to use special move
					Label selectMove = new Label("Please select which special move you would like to use (1 time use only: )");
					selectShip.setStyle("-fx-text-fill: white");
					
					//add radio buttons
					RadioButton rowAttack = new RadioButton("Row Attack");
					RadioButton bomb = new RadioButton("Bomb");
					
					rowAttack.setStyle("-fx-text-fill: white");
					bomb.setStyle("-fx-text-fill: white");
					
					
					//create toggle group
					ToggleGroup specialMoves = new ToggleGroup();
					Carrier.setToggleGroup(specialMoves);
					BattleShip.setToggleGroup(specialMoves);
					
					//create special moves
					specialMove special1 = new rowAttack();
					specialMove special2 = new bomb();
					
					

					for(int row = 0; row < boardC.getWidth(); row++) {
						for(int col = 0; col < boardC.getHeight(); col++) {
			
							
							//create alternating color grid
							if((row+col)%2 == 0) boardC.getTile(row, col).setFill(Color.ALICEBLUE);
							else {boardC.getTile(row, col).setFill(Color.TURQUOISE);}
							
							int Fcol = col; 
							int Frow = row;
							
							
							
							//mouse event to hit computer grid
							boardC.getTile(row, col).setOnMouseClicked(event3 -> {RectangleClickShoot(event3);
							
							if(rowAttack.isSelected() && confirm.isDisable()) {
								boardC.getTile(Frow, Fcol).setFill(Color.AQUA);
								special1.specialAttack(Frow, Fcol, boardC);
								rowAttack.setDisable(true);
								confirm.setDisable(false);
								
							}
							else if(bomb.isSelected() && confirm.isDisable()) {
								boardC.getTile(Frow, Fcol).setFill(Color.AQUA);
								special2.specialAttack(Frow, Fcol, boardC);
								bomb.setDisable(true);
								confirm.setDisable(false);
								
							}
							
											//check that tile wasn't already hit and allow only one tile to be hit
							else if(boardC.validHit(Frow, Fcol) && confirm.isDisable()) {
												//when tile hit, set different color
												human.fire(Frow, Fcol, boardC);
												
													boardC.getTile(Frow, Fcol).setFill(Color.AQUA);
												
												
												//computer randomly shooting at human player board
													
												Random rand = new Random();
												
												int x = rand.nextInt(10);
												int y = rand.nextInt(10);
												
												//check that it isn't already hit
												while(boardH.getTile(x, y).isHit()) {
													x = rand.nextInt(10);
													y = rand.nextInt(10);
												}
												
												
												//firing at human player board
												computer.updateMove(x, y);
												computer.fire(x, y, boardH);
												if(boardH.hitAShip(x, y)) {
													boardH.getTile(x, y).setFill(Color.ORANGE);
												}
												else if(boardH.getTile(x, y).isHit()) {
													boardH.getTile(x, y).setFill(Color.KHAKI);
												}
												
												
												confirm.setDisable(false);
															
									
											}
											
							});
							
							//check if it hit a ship
							if(boardC.hitAShip(row, col)) {	boardC.getTile(Frow, Fcol).setFill(Color.ORANGE);}
							else if(boardC.getTile(row, col).isHit()) boardC.getTile(Frow, Fcol).setFill(Color.KHAKI);
							
							
							
							
							
							//add to grid
							ComputerGrid.add(boardC.getTile(row, col), col, row);
							
							
						}
					}
					//check if any human player ship has sunk
					for(ship s : human.getFleet()){
						for(tile t : s.getLocation()) {
							System.out.println(t.x + "," + t.y + " human" + t.isHit());
						}
						if(s.isSunk(boardH)) {
							for(tile t: s.getLocation()) {
								boardH.getTile(t.x, t.y).setFill(Color.FIREBRICK);
							}
						}
						
					}
					
					//check if computer ship has sunk
					for(ship s1 : computer.getFleet()){
						for(tile t : s1.getLocation()) {
							System.out.println(t.x +","+ t.y + " comp" + t.isHit());
						}
						
						if(s1.isSunk(boardC)) {
							for(tile t: s1.getLocation()) {
								boardC.getTile(t.x, t.y).setFill(Color.FIREBRICK);
							}
							System.out.println(s1.getLength() + "Sunk");
							
						}
						
					}
					
					
					
					
						
					
						Label comp = new Label("Computer Grid");
						comp.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20pt");
						
						//human player grid display
						VBox Hplayer = new VBox(10, humanPlayerGrid, HPgrid);
						Hplayer.setAlignment(Pos.CENTER);
						
						//computer player grid display
						VBox Cplayer = new VBox(10, comp, ComputerGrid);
						Cplayer.setAlignment(Pos.CENTER);
						
						//both displays together
						HBox grids = new HBox(20, Hplayer, Cplayer);
						
						//layout and styling for the scene
						VBox grid2Layout = new VBox(10, grids, selectMove, rowAttack, bomb, confirm);
						grid2Layout.setAlignment(Pos.CENTER);
						grid2Layout.setStyle("-fx-background-color: black; -fx-font-weight: bold");
						grid2Layout.setPadding(new Insets(10));
						
						
						//new scene displaying both grids
						root = new Scene(grid2Layout);
						primaryStage.setScene(root);
						
						if (boardC.checkWin(computer)) {
							//if computer lost, display human win
							Label humanWinner = new Label(nameFirst + " has won! Computer has lost!");
							humanWinner.setStyle("-fx-background-color: black; -fx-text-fill: red; -fx-font-weight: bold; -fx-font-size: 50pt");
							root = new Scene(humanWinner);
							primaryStage.setScene(root);
						}
						else if (boardH.checkWin(human)) {
							//if human lost, display computer win
							Label computerWinner = new Label("Computer has won! " + nameFirst + " has lost!");
							computerWinner.setStyle("-fx-background-color: black; -fx-text-fill: red; -fx-font-weight: bold; -fx-font-size: 50pt");
							root = new Scene(computerWinner);
							primaryStage.setScene(root);
						}
						
						
					
					
				});
				
			
				}
				
			}
			);
		
			
			
			
			
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
	/**
	 * Event for clicking tile
	 * @param event - clicking tile
	 * @param col
	 * @param row
	 */
	private void RectangleClickShoot(MouseEvent event) {
	    
	    
	}
	/**
	 * checks that the selected tile is ok to add to ship
	 * @param ship1
	 * @param row
	 * @param col
	 * @return whether the tile makes a valid ship
	 */
	public boolean ValidShip(ship ship1, int row, int col) {
			//checks ship length is not complete
			if(ship1.getLocation().size() == ship1.getLength()) return false;
		
			//check if tile is occupied
			if(boardH.getTile(row, col).isOccupied()) return false;
			
			//if only 1 tile 
			if(ship1.getLocation().size()==1) {
				int temprow = ship1.getLocation().get(0).x;
				int tempcol = ship1.getLocation().get(0).y;
				//make sure if adding second tile that it is connected to first tile
				if((row==temprow-1||row == temprow+1) && col == tempcol ) {
					return true;
					
				}
				else if ((col==tempcol+1||col==tempcol-1) && row == temprow){
					return true;
					
					
				}
				return false;
			}
			//if >1 tile make sure to stay horizontal or vertical
			if(ship1.getLocation().size()>1) {
				boolean horizontal = false;
				int temprow = ship1.getLocation().get(0).x;
				int tempcol = ship1.getLocation().get(0).y;
				int lastrow = ship1.getLocation().get(ship1.getLocation().size()-1).x;
				int lastcol = ship1.getLocation().get(ship1.getLocation().size()-1).y;
				
				//checking if ship is horizontal or not
				if ((ship1.getLocation().get(1).getY()==tempcol+1||ship1.getLocation().get(1).getY()==tempcol-1) && ship1.getLocation().get(1).getX() == temprow){
					horizontal = true;
					
				}
				//if ship is horizontal, check that clicked tile keeps the ship horizontal
				if(horizontal) {
					if((tempcol==col+1||tempcol==col-1) && temprow == row) return true;
					else if((lastcol==col+1||lastcol==col-1) && lastrow == row) return true;
					
				}
				//if ship is vertical, check that clicked tile keeps the ship vertical
				else if(!horizontal) {
					if((temprow==row-1||temprow == row+1) && tempcol == col) return true;
					else if((lastrow==row-1||lastrow == row+1) && lastcol == col) return true;
				}
					
				
				return false;
	}
		return true;
	}

	

}