package something;

import javafx.geometry.Orientation;
import javafx.scene.control.Slider;

public class CanvasTools {

	public static Slider toolSizeSlider() {
		Slider sizeSlider = new Slider(1, 3, 1);
		sizeSlider.setOrientation(Orientation.HORIZONTAL);
		
		return sizeSlider;
	}
}
