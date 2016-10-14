package something;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
		
		Pane root = new Pane();
		StackPane stack = new StackPane();
        Canvas toolsBG = new Canvas(WIDTH/10, HEIGHT);
        Slider sizeSlider = CanvasTools.toolSizeSlider();
        
        stack.setStyle("-fx-background-color: #CCCCCC;");
        stack.getChildren().add(toolsBG);
        root.getChildren().add(stack);
        root.getChildren().add(sizeSlider);
        
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        window.setScene(scene);
        window.show();
		
	}

}
