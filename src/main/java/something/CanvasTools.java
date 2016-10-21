package something;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CanvasTools {

	private final static Color textColor = Color.BLACK;
	private static int rVal, gVal, bVal;
	private static Color paintColor;
	
	public static HBox toolSizeSlider() {
		Slider sizeSlider = new Slider(1, 3, 1);
		Label sizeLabel = new Label("Size");
		
		sizeSlider.setOrientation(Orientation.HORIZONTAL);
        
        sizeLabel.setFont(new Font("Arial", 18));
		sizeLabel.setTextFill(textColor);
		
        HBox hbTool = new HBox(5, sizeLabel, sizeSlider);
        hbTool.setLayoutY(StartCanvas.HEIGHT/3);
		
		return hbTool;
	}
	public static VBox RGBSliders()
	{
		//creates RGB Sliders
		Label lbltitle = new Label("Choose a color:");
		lbltitle.setMinWidth(50);
		lbltitle.setAlignment(Pos.CENTER);
		lbltitle.setStyle("-fx-font-size: 16px; -fx-background-color: grey; -fx-text-fill:white;");
		lbltitle.setPadding(new Insets(10));
		
		rVal = 255;
		gVal = 255;
		bVal = 255;

		paintColor = Color.rgb(rVal, gVal, bVal);
		
		//default color black
		Slider rSlide = new Slider(0 , 255, rVal);
		Slider gSlide = new Slider(0 , 255, gVal);
		Slider bSlide = new Slider(0 , 255, bVal);
		
		Rectangle colorView = new Rectangle(100,20, paintColor);
		
		VBox vbSlider = new VBox(20, lbltitle, rSlide, gSlide, bSlide, colorView );
		vbSlider.setPadding(new Insets(10));
		
		return vbSlider;
	}
	
	public static VBox radioButtons() {
				
		// creates label 
		Label lbltitle = new Label("Choose a shape: ");
		lbltitle.setMinWidth(50);
		lbltitle.setAlignment(Pos.CENTER);
		lbltitle.setStyle("-fx-font-size: 16px; -fx-background-color: tan; -fx-text-fill:white;");
		lbltitle.setPadding(new Insets(10));
		
        // creating buttons 
		final ToggleGroup group = new ToggleGroup();

		RadioButton rb1 = new RadioButton("Circle");
		RadioButton rb2 = new RadioButton("Rectangle");
		RadioButton rb3 = new RadioButton("Triangle");
		RadioButton rb4 = new RadioButton("Point");
	
		rb1.setToggleGroup(group);		
		rb2.setToggleGroup(group);
		rb3.setToggleGroup(group);
		rb4.setToggleGroup(group);
		rb1.setSelected(true);
		
		// adds label and radio button options to Vbox 
		VBox vbradio = new VBox(20, lbltitle, rb1, rb2, rb3, rb4);		
		vbradio.setPadding(new Insets(10));

        return vbradio;
	}
	
	public static VBox penOrEraser() {
		final ToggleGroup group = new ToggleGroup();
		
		RadioButton pen = new RadioButton("Pen");
		RadioButton eraser = new RadioButton("Eraser");
		
		pen.setToggleGroup(group);
		eraser.setToggleGroup(group);
		pen.setSelected(true);
		
		VBox vbRadio = new VBox(20, pen, eraser);
        vbRadio.setLayoutY(StartCanvas.HEIGHT/4.5);
        vbRadio.setPadding(new Insets(10));
		
		return vbRadio;
	}
}
