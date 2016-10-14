package something;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartCanvas extends Application{
	
	public final static int WIDTH = 1500;
	public final static int HEIGHT = 1000;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage window) throws Exception {
		window.setTitle("Digital Drawing Tools");
		
		// create canvas
        Canvas canvas = new Canvas(WIDTH/2, HEIGHT/2);
        
		// creates label 
		Label lbltitle = new Label("Choose a shape: ");
		lbltitle.setMinWidth(50);
		lbltitle.setAlignment(Pos.CENTER);
		lbltitle.setStyle("-fx-font-size: 16px; -fx-background-color: tan; -fx-text-fill:white;");
		lbltitle.setPadding(new Insets(10));
		
        // creating buttons 
		final ToggleGroup group = new ToggleGroup();

		RadioButton rb1 = new RadioButton("Circle");
		RadioButton rb2 = new RadioButton("Rectangle");
		RadioButton rb3 = new RadioButton("Triangle");
		RadioButton rb4 = new RadioButton("Polygon");
	
		rb1.setToggleGroup(group);		
		rb2.setToggleGroup(group);
		rb3.setToggleGroup(group);
		rb4.setToggleGroup(group);
		
		// adds label and radio button options to Vbox 
		VBox vbradio = new VBox(20, lbltitle, rb1, rb2, rb3, rb4);		
		vbradio.setPadding(new Insets(10));

		GridPane root = new GridPane();
        root.addColumn(0, vbradio);
		root.addColumn(1, canvas);
        
        window.setScene(new Scene(root));
        window.show();
	}

}
