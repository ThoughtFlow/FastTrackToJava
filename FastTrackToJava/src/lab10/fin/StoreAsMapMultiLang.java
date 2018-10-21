package lab10.fin;

import java.util.HashMap;
import java.util.Map;

public class StoreAsMapMultiLang {

	private static final String FRENCH = "FRENCH";
	private static final String ENGLISH = "ENGLISH";
	private static final String[][][] NUMBER_ARRAY = 
		{ 
				{ // English
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
				},

				{ // French
					{"2", "Deux"},
					{"7", "Sept"},
					{"1", "Un"},
					{"4", "Quatre"},
					{"8", "Huit"},
					{"6", "Six"},
					{"0", "Zero"},
					{"9", "Neuf"},
					{"3", "Trois"},
					{"5", "Cinq"}
				}
		};
	

	private static void toMap(String language, String[][] languageSet, Map<Pair<String, Integer>, String> pairMap) {
		
		for (String[] nextRow : languageSet) {
			Pair<String, Integer> nextPair = new Pair<>(language, Integer.parseInt(nextRow[0]));
			pairMap.put(nextPair, nextRow[1]);
		}
	}
	
	private static void print(String language, Map<Pair<String, Integer>, String> pairMap) {
		
		System.out.println("Language: " + language);
		for (int index = 0; index < 10; ++index) {
			   Pair<String, Integer> pairToFind = new Pair<>(language, index);
			   String value;
			   if (pairMap.containsKey(pairToFind)) {
				   value = pairToFind.getU() + ": " + pairMap.get(pairToFind);
			   }
			   else {
				   value = pairToFind.getU() + ": not found";
			   }
			   
			   System.out.println(" " + value);
			}	
	}
	
	public static void main(String[] args) {
		
		Map<Pair<String, Integer>, String> pairMap = new HashMap<Pair<String, Integer>, String>();
		
		toMap(ENGLISH, NUMBER_ARRAY[0], pairMap);
		toMap(FRENCH, NUMBER_ARRAY[1], pairMap);

		print(ENGLISH, pairMap);
		print(FRENCH, pairMap);
	}
}
