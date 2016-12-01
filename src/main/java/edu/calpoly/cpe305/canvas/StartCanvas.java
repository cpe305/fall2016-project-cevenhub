package edu.calpoly.cpe305.canvas;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StartCanvas extends Application {

  public static final int WIDTH = 1500;
  public static final int HEIGHT = 1000;
  private static final String GRAY = "-fx-background-color: #CCCCCC;";

  public static void main(String[] args) {
    launch(args);

  }

  @Override
  public void start(Stage window) throws Exception {
    window.setTitle("Digital Drawing Tools");

    Pane rootNode = new Pane();
    StackPane stack = new StackPane();
    Canvas toolBackground = new Canvas(WIDTH / 8, HEIGHT);

    stack.setStyle(GRAY);
    stack.getChildren().add(toolBackground);

    HBox sizeSlider = CanvasToolModel.makeSlider();
    VBox shapeChoices = CanvasToolModel.shapeChoice();
    VBox penEraser = CanvasToolModel.penOrEraser();
    VBox rgbSlider = CanvasToolModel.rgbSliders();
    final Group shapeNodes = new Group();
    
    rootNode.getChildren().add(stack);
    rootNode.getChildren().add(sizeSlider);
    rootNode.getChildren().add(shapeChoices);
    rootNode.getChildren().add(penEraser);
    rootNode.getChildren().add(rgbSlider);
    rootNode.getChildren().add(shapeNodes);

    Scene scene = new Scene(rootNode, WIDTH, HEIGHT);
    
    ShapeState shape = new ShapeState();
    shape.drawShape(scene, shapeNodes);

    window.setScene(scene);
    window.show();

  }

}
