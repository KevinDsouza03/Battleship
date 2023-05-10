package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;


public class Main extends Application {
	private gameBoard board1 = new gameBoard();
	private Scene root;
	//private Rectangle [][] rect = new Rectangle[10][10];
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//set title
			primaryStage.setTitle("BATTLESHIP");
			
			//add image
			Image image = new Image("file:Battleship.jpg");
			ImageView battleship = new ImageView(image);
			ImageView battleship2 = new ImageView(image);
			ImageView battleship3 = new ImageView(image);
			
			//add label to select player 2 or computer players
			Label selection = new Label("Please select whether you would like to play against another player or the computer: ");
			selection.setStyle("-fx-text-fill: white");
			
			//add radio buttons
			RadioButton player2 = new RadioButton("Human Player");
			RadioButton computerPlayer = new RadioButton("Computer Player");
			player2.setStyle("-fx-text-fill: white");
			computerPlayer.setStyle("-fx-text-fill: white");
			
			//create toggle group
			ToggleGroup radioGroup = new ToggleGroup();
			player2.setToggleGroup(radioGroup);
			computerPlayer.setToggleGroup(radioGroup);
			
			player2.setSelected(true);
			
			//button to confirm selection
			Button selected = new Button("Confirm");
			selected.setStyle("-fx-background-color: teal; -fx-text-fill: white");
			
			VBox layout1 = new VBox(10, battleship, selection, player2, computerPlayer, selected);
			layout1.setStyle("-fx-background-color: black; -fx-font-weight: bold");
			layout1.setAlignment(Pos.CENTER);
			layout1.setPadding(new Insets(0, 0, 10, 0));
			
			root = new Scene(layout1);
			//root.getStylesheets().add("application.css");
			primaryStage.setScene(root);
			
			
			//add label for player1 name
			Label player1Name = new Label("Please enter Player 1's name: ");
			player1Name.setStyle("-fx-text-fill: white");
			
			//textfield for player1 name
			TextField name1 = new TextField();
			
			//Hbox for label and textfield
			HBox firstName = new HBox(10, player1Name, name1);
			
			firstName.setPadding(new Insets(10));

			//add label for player2 name
			Label player2Name = new Label("Please enter Player 2's name: ");
			player2Name.setStyle("-fx-text-fill: white");
			
			//add textfield for player2's name
			TextField name2 = new TextField();
			
			//hbox for label and textfield for player 2 name
			HBox secondName = new HBox(10, player2Name, name2);
			secondName.setPadding(new Insets(0, 0, 0, 10));
			
			//button to click to start game
			Button mybutton = new Button("Start!");
			mybutton.setStyle("-fx-background-color: teal; -fx-text-fill: white");

			//Creating VBox for if 2 players are selected
			VBox vbox = new VBox(10, battleship2, firstName, secondName, mybutton);
			vbox.setAlignment(Pos.CENTER);
			vbox.setStyle("-fx-background-color: black; -fx-font-weight: bold");
			vbox.setPadding(new Insets(0, 0, 10, 0));
			root = new Scene(vbox);
			
			
			
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
			
			//create toggle group
			ToggleGroup radioGroup2 = new ToggleGroup();
			Carrier.setToggleGroup(radioGroup2);
			BattleShip.setToggleGroup(radioGroup2);
			Cruiser.setToggleGroup(radioGroup2);
			Submarine.setToggleGroup(radioGroup2);
			Destroyer.setToggleGroup(radioGroup2);
			Carrier.setSelected(true);
			
			//creating the ships
			ship Carrier1 = new ship(5);
			ship BattleShip1 = new ship(4);
			ship Cruiser1 = new ship(3);
			ship Submarine1 = new ship(3);
			ship Destroyer1 = new ship(2);
			
			
			//creating grid for first board
			GridPane grid1 = new GridPane();
			
			for(int row = 0; row < board1.getWidth(); row++) {
				for(int col = 0; col < board1.getHeight(); col++) {
	
					
					//create alternating color grid
					if((row+col)%2 == 0) board1.getTile(row, col).setFill(Color.ROYALBLUE);
					else {board1.getTile(row, col).setFill(Color.BLUE);}
					
					int Fcol = col; 
					int Frow = row;
					board1.getTile(row, col).setOnMouseClicked(event -> {RectangleClickShoot(event, Frow, Fcol);
					
							if(Carrier.isSelected()) {
								
								if(ValidShip(Carrier1, Frow, Fcol)) {
									System.out.println(board1.getTile(Frow, Fcol).getX()+ board1.getTile(Frow, Fcol).getY());
									board1.getTile(Frow, Fcol).setFill(Color.DARKSLATEGRAY);
									board1.setTileOccupied(Frow, Fcol);
									Carrier1.addLocation(board1.getTile(Frow, Fcol));
									if(Carrier1.getLocation().size() == Carrier1.getLength()) Carrier.setDisable(true);
								}
							}
							else if(BattleShip.isSelected()) {
								if(ValidShip(BattleShip1, Frow, Fcol)) {
									System.out.println(board1.getTile(Frow, Fcol).getX()+ board1.getTile(Frow, Fcol).getY());
									board1.getTile(Frow, Fcol).setFill(Color.DARKSLATEGRAY);
									board1.setTileOccupied(Frow, Fcol);
									BattleShip1.addLocation(board1.getTile(Frow, Fcol));
									if(BattleShip1.getLocation().size() == BattleShip1.getLength()) BattleShip.setDisable(true);
								}
						
							}
							else if(Cruiser.isSelected()) {
								if(ValidShip(Cruiser1, Frow, Fcol)) {
									System.out.println(board1.getTile(Frow, Fcol).getX()+ board1.getTile(Frow, Fcol).getY());
									board1.getTile(Frow, Fcol).setFill(Color.DARKSLATEGRAY);
									board1.setTileOccupied(Frow, Fcol);
									Cruiser1.addLocation(board1.getTile(Frow, Fcol));
									if(Cruiser1.getLocation().size() == Cruiser1.getLength()) Cruiser.setDisable(true);
								}
								
							}
							else if(Submarine.isSelected()) {
								if(ValidShip(Submarine1, Frow, Fcol)) {
									System.out.println(board1.getTile(Frow, Fcol).getX()+ board1.getTile(Frow, Fcol).getY());
									board1.getTile(Frow, Fcol).setFill(Color.DARKSLATEGRAY);
									board1.setTileOccupied(Frow, Fcol);
									Submarine1.addLocation(board1.getTile(Frow, Fcol));
									if(Submarine1.getLocation().size() == Submarine1.getLength()) Submarine.setDisable(true);
								}
							}
							else if(Destroyer.isSelected()) {
								if(ValidShip(Destroyer1, Frow, Fcol)) {
									System.out.println(board1.getTile(Frow, Fcol).getX()+ board1.getTile(Frow, Fcol).getY());
									board1.getTile(Frow, Fcol).setFill(Color.DARKSLATEGRAY);
									board1.setTileOccupied(Frow, Fcol);
									Destroyer1.addLocation(board1.getTile(Frow, Fcol));
									if(Destroyer1.getLocation().size() == Destroyer1.getLength()) Destroyer.setDisable(true);
								}
								
							}
					});
					// this line initializes the rectangle for how to handle a click.
					grid1.add(board1.getTile(row, col), col, row);
				}
			}
			//switch player button
			Button switchPlayer = new Button("Switch Player");
			switchPlayer.setStyle("-fx-background-color: blue; -fx-text-fill: white");
			
			
			//player type selected
			selected.setOnAction(e -> 
			{
			//if choose to play against another player
			if(player2.isSelected()) {
				//change scene to ask for both players' names
				primaryStage.setScene(root);
				
				mybutton.setOnAction(event -> 
				{
					if(!name1.getText().isBlank() && !name2.getText().isEmpty()) 
					{
					//storing textfield inputs
					String nameFirstP, nameSecondP;
					
					nameFirstP = name1.getText();
					nameSecondP = name2.getText();
					
					Label player1Grid = new Label(nameFirstP);
					player1Grid.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20pt");
					
					
					//grid1 layout vbox
					VBox grid1Layout = new VBox(10, player1Grid, grid1, Carrier, BattleShip, Cruiser, Submarine, Destroyer, switchPlayer);
					grid1Layout.setAlignment(Pos.CENTER);
					grid1Layout.setStyle("-fx-background-color: black; -fx-font-weight: bold");
					grid1Layout.setPadding(new Insets(10));
					
					root = new Scene(grid1Layout);
					
					System.out.println(nameFirstP + " " + nameSecondP);
					primaryStage.setScene(root);
					gameBoard player1 = new gameBoard();
					player1.printBoard();
					
					}
					}
				
					
				);
				
			}
			else {
				//if choose to play against computer
				VBox vbox2 = new VBox(10, battleship3, firstName, mybutton);
				
				//styling vbox2
				vbox2.setStyle("-fx-background-color: black; -fx-font-weight: bold");
				vbox2.setAlignment(Pos.CENTER);
				vbox2.setPadding(new Insets(0, 0, 10, 0));
				
				//creating new scene object
				root = new Scene(vbox2);
				
				//setting scene
				primaryStage.setScene(root);
				
				mybutton.setOnAction(event -> 
				{
					if(!name1.getText().isBlank()){
					//storing textfield inputs
					String nameFirst;
					nameFirst = name1.getText();
					
					Label player1Grid = new Label(nameFirst + "'s Grid");
					player1Grid.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 20pt");
					
					//Button confirming ship position
					Button confirm = new Button("Confirm");
					confirm.setStyle("-fx-background-color: teal; -fx-text-fill: white");
					
					
					
					//grid1 layout vbox
					VBox grid1Layout = new VBox(10, player1Grid, grid1, Carrier, BattleShip, Cruiser, Submarine, Destroyer, confirm);
					grid1Layout.setAlignment(Pos.CENTER);
					grid1Layout.setStyle("-fx-background-color: black; -fx-font-weight: bold");
					grid1Layout.setPadding(new Insets(10));
					
					root = new Scene(grid1Layout);
					
					
					
					System.out.println(nameFirst + "'s Grid");
					primaryStage.setScene(root);

					
					consoleRunner temp = new consoleRunner();
					//System.exit(0);
					}
				}
				);
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

	public gameBoard getBoard1() {
		return board1;
	}

	public void setBoard1(gameBoard board1) {
		this.board1 = board1;
	}
	
	private void RectangleClickShoot(MouseEvent event, int col, int row) {
	    int x = col;
	    int y = row;
	    System.out.println("(" + x + ", " + y + ")");
	   
	    // Do something with the coordinates here
	}
	public boolean ValidShip(ship ship1, int row, int col) {
			//checks ship length is not complete
			if(ship1.getLocation().size() == ship1.getLength()) return false;
		
			//check if tile is occupied
			if(board1.getTileisOccupied(row, col)) return false;
			
			//if only 1 tile 
			if(ship1.getLocation().size()==1) {
				double temprow = ship1.getLocation().get(0).getX();
				double tempcol = ship1.getLocation().get(0).getY();
				if((row==temprow-1||row == temprow+1) && col == tempcol ) {
					System.out.println("Vertical");
					return true;
					
				}
				else if ((col==tempcol+1||col==tempcol-1) && row == temprow){
					System.out.println("Horizontal");
					return true;
					
					
				}
				return false;
			}
			//if >1 tile make sure to stay horizontal or vertical
			if(ship1.getLocation().size()>1) {
				boolean horizontal = false;
				double temprow = ship1.getLocation().get(0).getX();
				double tempcol = ship1.getLocation().get(0).getY();
				double lastrow = ship1.getLocation().get(ship1.getLocation().size()-1).getX();
				double lastcol = ship1.getLocation().get(ship1.getLocation().size()-1).getY();
				
				//checking if ship is horizontal or not
				if ((ship1.getLocation().get(1).getY()==tempcol+1||ship1.getLocation().get(1).getY()==tempcol-1) && ship1.getLocation().get(1).getX() == temprow){
					horizontal = true;
					
				}
				
				if(horizontal) {
					if((tempcol==col+1||tempcol==col-1) && temprow == row) return true;
					else if((lastcol==col+1||lastcol==col-1) && lastrow == row) return true;
					
				}
				else if(!horizontal) {
					if((temprow==row-1||temprow == row+1) && tempcol == col) return true;
					else if((lastrow==row-1||lastrow == row+1) && lastcol == col) return true;
				}
					
				
				return false;
	}
		return true;
	}

	

}
