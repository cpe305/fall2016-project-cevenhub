package edu.calpoly.cpe305.canvas;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class DrawLine implements DrawInterface {

  private static ArrayList<Line> lineList = new ArrayList<Line>();
  
  @Override
  public void drawShape(Canvas canvas, final Group shapeNodes) {
    canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        Line line = new Line();

        line.setFill(CanvasToolModel.paintColor);
        line.setStroke(CanvasToolModel.paintColor);
        line.setStrokeWidth(CanvasToolModel.magnifySize);
        line.setStartX(event.getX() + (StartCanvas.WIDTH / 8));
        line.setStartY(event.getY());

        lineList.add(line);
      }
    });
    canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {        
        lineList.get(lineList.size() - 1).setEndX(event.getX() + (StartCanvas.WIDTH / 8));
        lineList.get(lineList.size() - 1).setEndY(event.getY());
        
        shapeNodes.getChildren().add(lineList.get(lineList.size() - 1));
        Line line = new Line();
        
        line.setStartX(lineList.get(lineList.size() - 1).getEndX());
        line.setStartY(lineList.get(lineList.size() - 1).getEndY());

        line.setFill(CanvasToolModel.paintColor);
        line.setStroke(CanvasToolModel.paintColor);
        line.setStrokeWidth(CanvasToolModel.magnifySize);

        lineList.add(line);
      }
    });
    canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        lineList.get(lineList.size() - 1).setEndX(event.getX() + (StartCanvas.WIDTH / 8));
        lineList.get(lineList.size() - 1).setEndY(event.getY());
        shapeNodes.getChildren().add(lineList.get(lineList.size() - 1));
      }
    });
    
  }

}
