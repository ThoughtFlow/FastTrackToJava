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
	

	private static Map<String, Integer>  toMap(String[][] languageSet) {
		
		Map<String, Integer> pairMap = new HashMap<String, Integer>();
		
		for (String[] nextRow : languageSet) {
			pairMap.put(nextRow[1], Integer.parseInt(nextRow[0]));
		}
		
		return pairMap;
	}
	
	public static void main(String[] args) {
		
		Map<String, Integer> pairMap = toMap(NUMBER_ARRAY);

		System.out.println("One = " + pairMap.get("One"));
		System.out.println("Two = " + pairMap.get("Two"));
		System.out.println("Three = " + pairMap.get("Three"));
		System.out.println("Four = " + pairMap.get("Four"));
		System.out.println("Five = " + pairMap.get("Five"));
		System.out.println("Six = " + pairMap.get("Six"));
		System.out.println("Seven = " + pairMap.get("Seven"));
		System.out.println("Eight = " + pairMap.get("Eight"));
		System.out.println("Nine = " + pairMap.get("Nine"));
	}
}
