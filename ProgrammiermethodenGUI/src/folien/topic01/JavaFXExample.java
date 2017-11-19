package folien.topic01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        HBox hbox = new HBox(5);root.setCenter(hbox);

        // Create a label and a text field and add them to the scene graph
        Label l = new Label("Name");
        TextField t = new TextField();
        hbox.getChildren().addAll(l, t);

        // Create a button and add it to the scene graph
        Button b = new Button("Quit"); root.setBottom(b);

        // Set up the stage
        stage.setTitle("JavaFX Example");
        stage.setScene(new Scene(root, 200, 80));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
