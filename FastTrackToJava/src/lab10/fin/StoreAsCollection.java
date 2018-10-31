package lab10.fin;

import java.util.ArrayList;
import java.util.List;

public class StoreAsCollection {

	private static String[][] NUMBER_ARRAY = { 
										{"2", "Two"},
										{"7", "Seven"},
										{"1", "One"},
										{"4", "Four"},
										{"8", "Eight"},
										{"6", "Six"},
										{"0", "Zero"},
										{"9", "Nine"},
										{"3", "Three"},
										{"5", "Five"}
									};
			

	public static void main(String[] args) {
		
		// Use Arrays.asList as a convenience method to initialize the array. However, you lose control over the type of list
//		@SuppressWarnings("unchecked")		
//		List<Pair<Integer, String>> listOfPairs = Arrays.asList(new Pair[10]);


		// Initialize
		ArrayList<Pair<Integer, String>> listOfPairs = new ArrayList<Pair<Integer, String>>(10);
        for (int index = 0; index < NUMBER_ARRAY.length; ++index) {
            listOfPairs.add(null);
        }

		// Populate
		for (String[] nextArray : NUMBER_ARRAY) {
			Pair<Integer, String> nextPair = new Pair<>(Integer.parseInt(nextArray[0]), nextArray[1]);
			listOfPairs.set(nextPair.getT(), nextPair);
		}

		// List
		for (Pair<Integer, String> nextPair : listOfPairs) {
			System.out.println(nextPair);
		}
	}
}
