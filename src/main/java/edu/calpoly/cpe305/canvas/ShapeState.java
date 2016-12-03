package edu.calpoly.cpe305.canvas;

import javafx.scene.Group;
import javafx.scene.Scene;

public class ShapeState {
  private DrawInterface shapeState;

  public ShapeState() {
    setState(new DrawLine());
  }

  public void setState(final DrawInterface newShape) {
    shapeState = newShape;
  }

  public void drawShape(Scene scene, final Group shapeNodes) {
    shapeState.drawShape(scene, shapeNodes);
  }
}
