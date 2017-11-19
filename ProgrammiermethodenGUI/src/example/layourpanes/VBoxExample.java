/**
 * 
 */
package example.layourpanes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Simple VBox Example
 * @author Samuel Pulfer
 *
 */
public class VBoxExample extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		//Create Pane HBox Pane (root node)
        VBox root = new VBox(5);
        
        //Add some buttons
        root.getChildren().addAll(new Button("Button01"),new Button("Button02"),new Button("Button03"));
        // Set up the stage and show it
        stage.setTitle(this.getClass().getSimpleName());
        stage.setScene(new Scene(root, 200, 80));
        stage.show();
		
	}
	public static void main(String[] args) {
        launch(args);
    }

}
