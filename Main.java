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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//set title
			primaryStage.setTitle("BATTLESHIP");
			
			//add image
			Image image1 = new Image("file:Battleship.jpg");
			ImageView battleship = new ImageView(image1);
			ImageView battleship2 = new ImageView(image1);
			
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
			
			Button selected = new Button("Confirm");
			selected.setStyle("-fx-background-color: teal; -fx-text-fill: white");
			
			VBox layout1 = new VBox(10, battleship, selection, player2, computerPlayer, selected);
			layout1.setStyle("-fx-background-color: black; -fx-font-weight: bold");
			layout1.setAlignment(Pos.CENTER);
			layout1.setPadding(new Insets(0, 0, 10, 0));
			
			Scene scene1 = new Scene(layout1);
			primaryStage.setScene(scene1);
			
			//add label for player1 name
			Label player1Name = new Label("Please enter Player 1's name: ");
			player1Name.setStyle("-fx-text-fill: white");
			
			TextField name1 = new TextField();
			
			HBox firstName = new HBox(10, player1Name, name1);
			
			firstName.setPadding(new Insets(10));

			//add label for player2 name
			Label player2Name = new Label("Please enter Player 2's name: ");
			player2Name.setStyle("-fx-text-fill: white");
			
			TextField name2 = new TextField();
			
			HBox secondName = new HBox(10, player2Name, name2);
			secondName.setPadding(new Insets(0, 0, 0, 10));
			
			Button mybutton = new Button("Start!");
			mybutton.setStyle("-fx-background-color: teal; -fx-text-fill: white");

			VBox vbox = new VBox(10, battleship2, firstName, secondName, mybutton);
			vbox.setAlignment(Pos.CENTER);
			vbox.setStyle("-fx-background-color: black; -fx-font-weight: bold");
			vbox.setPadding(new Insets(0, 0, 10, 0));
			Scene scene = new Scene(vbox);
			
			selected.setOnAction(e -> 
			{
			if(player2.isSelected()) {
				primaryStage.setScene(scene);
				mybutton.setOnAction(event -> 
				{
					String nameFirstP, nameSecondP;
					nameFirstP = name1.getText();
					nameSecondP = name2.getText();
					System.out.println(nameFirstP + nameSecondP);
					
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
}
