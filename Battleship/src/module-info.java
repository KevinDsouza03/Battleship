/***
 * test
 * @author dsouz
 *
 */
module Test {
	requires javafx.controls;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
}
