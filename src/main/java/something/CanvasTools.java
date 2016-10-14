package something;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
}
