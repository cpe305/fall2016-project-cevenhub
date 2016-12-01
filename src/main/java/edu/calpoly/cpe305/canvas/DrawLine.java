package edu.calpoly.cpe305.canvas;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class DrawLine implements DrawInterface {

  private static ArrayList<Line> lineList = new ArrayList<Line>();
  
  @Override
  public void drawShape(Scene scene, final Group shapeNodes) {
    scene.setOnMousePressed(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        Line line = new Line();

        line.setFill(CanvasToolModel.paintColor);
        line.setStroke(CanvasToolModel.paintColor);
        line.setStrokeWidth(CanvasToolModel.magnifySize);
        line.setStartX(event.getX());
        line.setStartY(event.getY());

        lineList.add(line);
      }
    });
    scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        lineList.get(lineList.size() - 1).setEndX(event.getX());
        lineList.get(lineList.size() - 1).setEndY(event.getY());
        shapeNodes.getChildren().add(lineList.get(lineList.size() - 1));
      }
    });
    
  }

}
