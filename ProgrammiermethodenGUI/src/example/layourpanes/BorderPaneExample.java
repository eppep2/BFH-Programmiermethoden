package example.layourpanes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneExample extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		//Create Pane Border Pane (root node)
        BorderPane root = new BorderPane();
        
        
        //Add some buttons
        root.setTop(new Button("I'm on top"));
        root.setLeft(new Button("I'm left"));
        root.setRight(new Button("I'm right"));
        root.setBottom(new Button("I'm at the bottom"));
        root.setCenter(new Button("I'm in the center"));
        // Set up the stage and show it
        stage.setTitle(this.getClass().getSimpleName());
        stage.setScene(new Scene(root, 200, 80));
        stage.show();
		
	}
	public static void main(String[] args) {
        launch(args);
    }
}
