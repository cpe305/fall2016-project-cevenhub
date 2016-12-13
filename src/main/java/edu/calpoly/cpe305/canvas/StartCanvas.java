package edu.calpoly.cpe305.canvas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartCanvas extends Application {

  public static final int WIDTH = 1400;
  public static final int HEIGHT = 1000;
  public static ShapeState shape = new ShapeState(new DrawLine());
  public static Canvas canvas = new Canvas(7 * WIDTH / 8, HEIGHT);
  public static final Group shapeNodes = new Group();
  private static final String GRAY = "-fx-background-color: #CCCCCC;";

  public static void main(String[] args) {
    launch(args);

  }

  @Override
  public void start(Stage window) throws Exception {
    window.setTitle("Digital Drawing Tools");

    Pane rootNode = new Pane();
    StackPane stack = new StackPane();
    
    canvas.setTranslateX(WIDTH / 8);
    stack.getChildren().add(canvas);
    stack.setStyle(GRAY);

    HBox sizeSlider = CanvasToolModel.makeSlider();
    VBox shapeChoices = CanvasToolModel.shapeChoice();
    VBox penEraser = CanvasToolModel.penOrEraser();
    VBox rgbSlider = CanvasToolModel.rgbSliders();
    
    rootNode.getChildren().add(stack);
    rootNode.getChildren().add(sizeSlider);
    rootNode.getChildren().add(shapeChoices);
    rootNode.getChildren().add(penEraser);
    rootNode.getChildren().add(rgbSlider);
    rootNode.getChildren().add(shapeNodes);

    Scene scene = new Scene(rootNode, WIDTH, HEIGHT);
    
    shape.drawShape(canvas, shapeNodes);

    window.setScene(scene);
    window.show();

  }

}
