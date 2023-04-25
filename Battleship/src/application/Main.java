package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
			Image image = new Image("file:Battleship.jpg");
			ImageView battleship = new ImageView(image);
			
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

			VBox vbox = new VBox(10, battleship, firstName, secondName, mybutton);
			vbox.setAlignment(Pos.CENTER);
			vbox.setStyle("-fx-background-color: black; -fx-font-weight: bold");
			vbox.setPadding(new Insets(0, 0, 10, 0));
			Scene scene = new Scene(vbox);
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
