package lab08.init;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum RgbColor {
	WHITE  (1.00f, 1.00f, 1.00f),
	SILVER (0.75f, 0.75f, 0.75f),
	GRAY   (0.50f, 0.50f, 0.50f),
	BLACK  (0.00f, 0.00f, 0.00f),
	RED    (1.00f, 0.00f, 0.00f),
	MAROON (0.50f, 0.00f, 0.00f),
	YELLOW (1.00f, 1.00f, 0.00f),
	OLIVE  (0.50f, 0.50f, 0.00f),
	LIME   (0.00f, 1.00f, 0.00f),
	GREEN  (0.00f, 0.50f, 0.00f),
	AQUA   (0.00f, 1.00f, 1.00f),
	TEAL   (0.00f, 0.50f, 0.50f),
	BLUE   (0.00f, 0.00f, 1.00f),
	NAVY   (0.00f, 0.00f, 0.50f),
	FUSHIA (1.00f, 0.00f, 1.00f),
	PURPLE (0.50f, 0.00f, 0.50f);
	
	private final float red;
	private final float green;
	private final float blue;
	
	RgbColor(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public float getRed() {
		return red;
	}

	public float getGreen() {
		return green;
	}

	public float getBlue() {
		return blue;
	}
	
	public float getBrightness() {
		return red + green + blue;
	}
	
	public Set<RgbColor> getEqualBightness(RgbColor combineWith) {

		// Implement this
		return Collections.EMPTY_SET;
	}

	public Float getTotalBrightnessInRange(RgbColor until) {

	    // Implement this
	    return 0f;
	}
}
