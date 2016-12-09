package edu.calpoly.cpe305.canvas;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class DrawSquare implements DrawInterface {
  
  private static final float defaultWidth = 4;
  private static ArrayList<Rectangle> squareList = new ArrayList<Rectangle>();

  @Override
  public void drawShape(Canvas canvas, final Group shapeNodes) {
    canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        Rectangle square = new Rectangle();

        square.setFill(CanvasToolModel.paintColor);
        square.setStroke(CanvasToolModel.paintColor);
        square.setWidth(defaultWidth * CanvasToolModel.magnifySize);
        square.setHeight(defaultWidth * CanvasToolModel.magnifySize);
        square.setX(event.getX() + (StartCanvas.WIDTH / 8));
        square.setY(event.getY());
        
        squareList.add(square);
        shapeNodes.getChildren().add(squareList.get(squareList.size() - 1));
      }
    });
    canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        Rectangle square = new Rectangle();

        square.setFill(CanvasToolModel.paintColor);
        square.setStroke(CanvasToolModel.paintColor);
        square.setWidth(defaultWidth * CanvasToolModel.magnifySize);
        square.setHeight(defaultWidth * CanvasToolModel.magnifySize);
        square.setX(event.getX() + (StartCanvas.WIDTH / 8));
        square.setY(event.getY());
        
        squareList.add(square);
        shapeNodes.getChildren().add(squareList.get(squareList.size() - 1));
      }
    });
    canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        
      }
    });
    
  }

}
