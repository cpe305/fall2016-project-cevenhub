package something;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CanvasTools {

	private final static Color textColor = Color.BLACK;
	
	public static Slider toolSizeSlider() {
		Slider sizeSlider = new Slider(1, 3, 1);
		
		sizeSlider.setOrientation(Orientation.HORIZONTAL);
		sizeSlider.setLayoutX(StartCanvas.WIDTH/30);
        sizeSlider.setLayoutY(StartCanvas.HEIGHT/4);
		
		return sizeSlider;
	}
	
	public static Label toolSizeLabel() {
		Label sizeLabel = new Label("Size");
		
		sizeLabel.setFont(new Font("Arial", 18));
		sizeLabel.setTextFill(textColor);
		sizeLabel.setLayoutY(StartCanvas.HEIGHT/4);
		
		return sizeLabel;
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
		RadioButton rb4 = new RadioButton("Polygon");
	
		rb1.setToggleGroup(group);		
		rb2.setToggleGroup(group);
		rb3.setToggleGroup(group);
		rb4.setToggleGroup(group);
		
		// adds label and radio button options to Vbox 
		VBox vbradio = new VBox(20, lbltitle, rb1, rb2, rb3, rb4);		
		vbradio.setPadding(new Insets(10));

        return vbradio;
	}
}
