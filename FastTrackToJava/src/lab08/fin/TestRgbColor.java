package lab08.fin;

import java.util.EnumSet;

public class TestRgbColor {

	public static void main(String[] args) {
		
		for (RgbColor firstColor : EnumSet.allOf(RgbColor.class)) {
			for (RgbColor secondColor : EnumSet.allOf(RgbColor.class)) {
				System.out.println("For " + firstColor + " and " + secondColor + ": " + firstColor.getEqualBightness(secondColor));
			}
		}
	}
}
