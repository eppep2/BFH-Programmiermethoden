package exercises.stopwatch;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stopwatch extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		//Create Pane HBox Pane (root node)
        BorderPane root = new BorderPane();
        
        //
        Label lbl_watchstate = new Label("Stopped");
        Label lbl_seconds = new Label("0:00");
        Button btn_start = new Button("Start");
        Button btn_stop = new Button("Stop");
        Button btn_reset = new Button("Reset");
        
        HBox controls = new HBox(10);
        controls.setAlignment(Pos.CENTER);
        controls.getChildren().addAll(btn_start, btn_stop, btn_reset);
        HBox display = new HBox(10);
        display.setAlignment(Pos.CENTER);
        VBox bottomBox = new VBox();
        
        bottomBox.getChildren().addAll(controls, lbl_watchstate);
        
        display.getChildren().addAll(new Label("Sekunden:"), lbl_seconds);
        
        
        root.setCenter(display);
        root.setBottom(bottomBox);
        
        
        // Set up the stage and show it
        stage.setTitle(this.getClass().getSimpleName());
        stage.setScene(new Scene(root, 300, 200));
        stage.show();
		
	}
	public static void main(String[] args) {
        launch(args);
    }
}
