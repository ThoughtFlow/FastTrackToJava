package lab08.init;

import java.util.EnumSet;
import java.util.Set;

public class TestRgbColor {

	public static void main(String[] args) {
		
		for (RgbColor firstColor : EnumSet.allOf(RgbColor.class)) {
			for (RgbColor secondColor : EnumSet.allOf(RgbColor.class)) {
				Set<RgbColor> equalBightness = firstColor.getEqualBightness(secondColor);
				String otherColors = equalBightness.size() > 0 ? equalBightness.toString() : "no other color";
				System.out.println("The brightness of " + firstColor + " and " + secondColor + " combined is the same brightness as " + otherColors);
				System.out.println("Total brightness in from " + firstColor + " to " + secondColor + " is " + firstColor.getTotalBrightnessInRange(secondColor));
			}
		}
	}
}
