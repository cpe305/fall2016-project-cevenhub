package edu.calpoly.cpe305.canvas;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class DrawCircle implements DrawInterface {
  
  private static final float defaultRadius = 4;
  private static ArrayList<Circle> circleList = new ArrayList<Circle>();

  @Override
  public void drawShape(Canvas canvas, final Group shapeNodes) {
    canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        Circle circle = new Circle();

        circle.setFill(CanvasToolModel.paintColor);
        circle.setStroke(CanvasToolModel.paintColor);
        circle.setRadius(defaultRadius * CanvasToolModel.magnifySize);
        circle.setCenterX(event.getX() + (StartCanvas.WIDTH / 8));
        circle.setCenterY(event.getY());
        
        circleList.add(circle);
        shapeNodes.getChildren().add(circleList.get(circleList.size() - 1));
      }
    });
    canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        Circle circle = new Circle();

        circle.setFill(CanvasToolModel.paintColor);
        circle.setStroke(CanvasToolModel.paintColor);
        circle.setRadius(defaultRadius * CanvasToolModel.magnifySize);
        circle.setCenterX(event.getX() + (StartCanvas.WIDTH / 8));
        circle.setCenterY(event.getY());
        
        circleList.add(circle);
        shapeNodes.getChildren().add(circleList.get(circleList.size() - 1));
      }
    });
    canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        
      }
    });
    
  }

}
