package edu.calpoly.cpe305.canvas;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
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
    final ArrayList<Line> lineList = new ArrayList<Line>();

    stack.setStyle(GRAY);
    stack.getChildren().add(toolBackground);

    HBox sizeSlider = CanvasToolModel.makeSlider();
    VBox radioButtons = CanvasToolModel.radioButtons();
    VBox penEraser = CanvasToolModel.penOrEraser();
    VBox rgbSlider = CanvasToolModel.rgbSliders();
    final Group lineNodes = new Group();

    rootNode.getChildren().add(stack);
    rootNode.getChildren().add(sizeSlider);
    rootNode.getChildren().add(radioButtons);
    rootNode.getChildren().add(penEraser);
    rootNode.getChildren().add(rgbSlider);
    rootNode.getChildren().add(lineNodes);

    Scene scene = new Scene(rootNode, WIDTH, HEIGHT);

    scene.setOnMousePressed(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        Line line = new Line();
        line.setStartX(event.getX());
        line.setStartY(event.getY());
        lineList.add(line);
        System.out.println("Start X: " + line.getStartX() + " Start Y: " + line.getStartY());
      }
    });
    scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        lineList.get(lineList.size() - 1).setEndX(event.getX());
        lineList.get(lineList.size() - 1).setEndY(event.getY());
        System.out.println("End X: " + lineList.get(lineList.size() - 1).getEndX() + " End Y: "
            + lineList.get(lineList.size() - 1).getEndY());
        lineNodes.getChildren().add(lineList.get(lineList.size() - 1));
      }
    });

    window.setScene(scene);
    window.show();

  }

  public void createToolBar() {

  }

}
