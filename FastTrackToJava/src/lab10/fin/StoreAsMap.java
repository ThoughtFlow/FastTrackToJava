package lab10.fin;

import java.util.HashMap;
import java.util.Map;

public class StoreAsMap {

	private static final String[][] NUMBER_ARRAY = 
		{ 
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
	

	private static Map<String, Pair<String, String>>  toMap(String[][] numberSet) {
		
		Map<String, Pair<String, String>> pairMap = new HashMap<>();
		
		for (String[] nextRow : numberSet) {
			Pair<String, String> nextPair = new Pair<>(nextRow[0], nextRow[1]);
			pairMap.put(nextPair.getT(), nextPair);
		}
		
		return pairMap;
	}
	
	public static void main(String[] args) {
		
		Map<String, Pair<String, String>> pairMap = toMap(NUMBER_ARRAY);
		for (String next : pairMap.keySet()) {
			System.out.println(next + ": " + pairMap.get(next));
		}
	}
}
