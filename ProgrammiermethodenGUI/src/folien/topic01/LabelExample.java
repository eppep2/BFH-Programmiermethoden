package folien.topic01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LabelExample extends Application{
	@Override
    public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		final Label label1 = new Label("I'm a Label");
		root.getChildren().add(label1);

		final Label label2 = new Label("I'm a\nLabel too!");
		label2.setFont(Font.font("Dialog", FontWeight.BOLD, 16));
		root.getChildren().add(label2);

		final ImageView image = new ImageView(new Image("file:res/lock.png"));
		final Label label3 = new Label("Don't change me", image);
		label3.setContentDisplay(ContentDisplay.RIGHT);
		root.getChildren().add(label3); 
		
		 // Set up the stage
        stage.setTitle("JavaFX Example");
        stage.setScene(new Scene(root, 200, 80));
        stage.show();
    }
	public static void main(String[] args) {
	        launch(args);
	    }
}
