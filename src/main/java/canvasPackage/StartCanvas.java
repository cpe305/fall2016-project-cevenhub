package canvasPackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StartCanvas extends Application{
	
	public final static int WIDTH = 1500;
	public final static int HEIGHT = 1000;
	public final static Color textColor = Color.BLACK;
	private final static String GRAY = "-fx-background-color: #CCCCCC;";

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage window) throws Exception {
		window.setTitle("Digital Drawing Tools");
		
		Pane rootNode = new Pane();
		StackPane stack = new StackPane();
        Canvas toolBackground = new Canvas(WIDTH/8, HEIGHT);
        HBox sizeSlider = CanvasTools.makeSlider();
        VBox radioButtons = CanvasTools.radioButtons();
        VBox penEraser = CanvasTools.penOrEraser();
        
        stack.setStyle(GRAY);
        stack.getChildren().add(toolBackground);

        rootNode.getChildren().add(stack);
        rootNode.getChildren().add(sizeSlider);
        rootNode.getChildren().add(radioButtons);
        rootNode.getChildren().add(penEraser);
        
        Scene scene = new Scene(rootNode, WIDTH, HEIGHT);
        window.setScene(scene);
        window.show();
	}
	
	public void createToolBar() {
		
	}

}
