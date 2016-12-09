package edu.calpoly.cpe305.canvas;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;

public class ShapeState {
  private DrawInterface shapeState;

  public ShapeState(final DrawInterface newShape) {
    shapeState = newShape;
  }

  public void drawShape(Canvas canvas, final Group shapeNodes) {
    shapeState.drawShape(canvas, shapeNodes);
  }
}
