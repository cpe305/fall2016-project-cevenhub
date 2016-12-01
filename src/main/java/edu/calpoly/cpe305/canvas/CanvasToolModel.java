package edu.calpoly.cpe305.canvas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class CanvasToolModel {

  private static final Color textColor = Color.BLACK;
  private static int rVal;
  private static int gVal;
  private static int bVal;
  public static Color paintColor;
  public static float magnifySize = 1;

  /**
   * makeSlider - A method which creates the visual aspect of size slider.
   * 
   * @return a horizontal node of the slider tool
   */
  public static HBox makeSlider() {
    Slider sizeSlider = new Slider(1, 10, 1);
    Label sizeLabel = new Label("Size");
    
    sizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
      public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal) {
        magnifySize = newVal.floatValue();
      }
    });

    sizeSlider.setOrientation(Orientation.HORIZONTAL);

    sizeLabel.setFont(new Font("Arial", 18));
    sizeLabel.setTextFill(textColor);

    HBox hbTool = new HBox(5, sizeLabel, sizeSlider);
    hbTool.setLayoutY(StartCanvas.HEIGHT / 3);

    return hbTool;
  }

  /**
   * rgbSliders - A method which creates the visual aspect of rgb slider.
   * 
   * @return a vertical node of the RGB slider tool
   */
  public static VBox rgbSliders() {
    // creates RGB Sliders
    Label lbltitle = new Label("Choose a color:");
    lbltitle.setMinWidth(50);
    lbltitle.setAlignment(Pos.CENTER);
    lbltitle.setStyle("-fx-font-size: 16px; -fx-background-color: grey; -fx-text-fill:white;");
    lbltitle.setPadding(new Insets(10));

    rVal = 255;
    gVal = 255;
    bVal = 255;

    paintColor = Color.rgb(rVal, gVal, bVal);

    // default color black
    Slider redSlide = new Slider(0, 255, rVal);
    Slider greenSlide = new Slider(0, 255, gVal);
    Slider blueSlide = new Slider(0, 255, bVal);
    final Rectangle colorView = new Rectangle(100, 20, paintColor);

    redSlide.valueProperty().addListener(new ChangeListener<Number>() {
      public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal) {
        rVal = newVal.intValue();
        paintColor = Color.rgb(rVal, gVal, bVal);
        colorView.setFill(paintColor);
      }
    });
    blueSlide.valueProperty().addListener(new ChangeListener<Number>() {
      public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal) {
        bVal = newVal.intValue();
        paintColor = Color.rgb(rVal, gVal, bVal);
        colorView.setFill(paintColor);
      }
    });
    greenSlide.valueProperty().addListener(new ChangeListener<Number>() {
      public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal) {
        gVal = newVal.intValue();
        paintColor = Color.rgb(rVal, gVal, bVal);
        colorView.setFill(paintColor);
      }
    });

    VBox vbSlider = new VBox(20, lbltitle, redSlide, greenSlide, blueSlide, colorView);
    vbSlider.setPadding(new Insets(10));
    vbSlider.setLayoutY(StartCanvas.HEIGHT / 2.25);

    return vbSlider;
  }

  /**
   * radioButtons - A method which creates the visual aspect of the cursor shapes tool.
   * 
   * @return a vertical node of the cursor shapes tool
   */
  public static VBox shapeChoice() {

    // creates label
    Label lbltitle = new Label("Choose a shape: ");
    lbltitle.setMinWidth(50);
    lbltitle.setAlignment(Pos.CENTER);
    lbltitle.setStyle("-fx-font-size: 16px; -fx-background-color: tan; -fx-text-fill:white;");
    lbltitle.setPadding(new Insets(10));

    // creating buttons
    final ToggleGroup group = new ToggleGroup();

    final RadioButton rb1 = new RadioButton("Line");
    final RadioButton rb2 = new RadioButton("Circle");
    final RadioButton rb3 = new RadioButton("Rectangle");
    final RadioButton rb4 = new RadioButton("Triangle");

    rb1.setToggleGroup(group);
    rb2.setToggleGroup(group);
    rb3.setToggleGroup(group);
    rb4.setToggleGroup(group);
    rb1.setSelected(true);
    
    group.notify();
    
    // adds label and radio button options to Vbox
    VBox vbradio = new VBox(20, lbltitle, rb1, rb2, rb3, rb4);
    vbradio.setPadding(new Insets(10));

    return vbradio;
  }

  /**
   * penOrEraser - A method which creates the visual aspect of selecting the pen or eraser tool.
   * 
   * @return a vertical node of the pen or eraser tool
   */
  public static VBox penOrEraser() {
    final ToggleGroup group = new ToggleGroup();

    RadioButton pen = new RadioButton("Pen");
    RadioButton eraser = new RadioButton("Eraser");

    pen.setToggleGroup(group);
    eraser.setToggleGroup(group);
    pen.setSelected(true);

    VBox vbRadio = new VBox(20, pen, eraser);
    vbRadio.setLayoutY(StartCanvas.HEIGHT / 4.5);
    vbRadio.setPadding(new Insets(10));

    return vbRadio;
  }
}
