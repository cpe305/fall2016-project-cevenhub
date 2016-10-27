package edu.calpoly.cpe305.canvas;

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

public class StartCanvas extends Application {

  public static final int WIDTH = 1500;
  public static final int HEIGHT = 1000;
  public static final Color textColor = Color.BLACK;
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
    VBox radioButtons = CanvasToolModel.radioButtons();
    VBox penEraser = CanvasToolModel.penOrEraser();
    VBox rgbSlider = CanvasToolModel.rgbSliders();
    
    rootNode.getChildren().add(stack);
    rootNode.getChildren().add(sizeSlider);
    rootNode.getChildren().add(radioButtons);
    rootNode.getChildren().add(penEraser);
    rootNode.getChildren().add(rgbSlider);

    Scene scene = new Scene(rootNode, WIDTH, HEIGHT);
    window.setScene(scene);
    window.show();
  }

  public void createToolBar() {

  }

}
