package lab.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility functions for labs.
 */
public interface Util {
	
	static long startTime = System.currentTimeMillis();
	
	/**
	 * Given a range, counts the number of primes with it.
	 *  
	 * @param startRange The start of the range to count.
	 * @param endRange   The end of the range to count.
	 * @return The number of primes found.
	 */
	static Integer countPrimes(int startRange, int endRange) {
		int primesFound = 0;

		for (int primeCandidate = startRange; primeCandidate <= endRange; ++primeCandidate) {
			primesFound += isPrime(primeCandidate) ? 1 : 0;
		}

		return primesFound;
	}

	/**
	 * Given an integer, determines whether or not number is prime.
	 * 
	 * @param primeCandidate The number to test for primeness.
	 * @return True if prime - false otherwise.
	 * @throws IllegalArgumentException Thrown if primeCandidate is a negative number.
	 */
	static boolean isPrime(int primeCandidate) throws IllegalArgumentException {
		
		if (primeCandidate < 0) {
			throw new IllegalArgumentException("PrimeCandidate must be a positive number - received: " + primeCandidate);
		}
		
		boolean isPrime = primeCandidate == 2;

		if (primeCandidate > 2) {
			isPrime = true;
			for (int testValue = 2; testValue <= Math.sqrt(primeCandidate); ++testValue) {
				if (primeCandidate % testValue == 0) {
					isPrime = false;
					break;
				}
			}
		} 

		return isPrime;
	}
	
	/**
	 * Returns a BufferedReader for a string representing a URL.
	 *  
	 * @param stringedUrl The url for which to obtain a BufferedReader in the form of a string.
	 * @return The BufferedReader object.
	 * @throws IOException Thrown  if the BufferedReader could not be obtained.
	 */
	static BufferedReader getReader(String stringedUrl) throws IOException {
		
	       URL url = new URL(stringedUrl);
		   return new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
	}

	/**
	 * Returns a map containing the url (key) and the occurrences of that url (value) from the given list of strings.
	 * 
	 * @param stringsToCatalogue The strings to convert into a map.
	 * @return The map representing the catalog.
	 */
	static Map<String, Integer> catalog(List<String> stringsToCatalogue) {

		Map<String, Integer> map = new HashMap<>();
		
		stringsToCatalogue.stream().forEach(s -> map.merge(s, 1, (v1, v2) -> ++v1));
		return map;
	}
	
	/**
	 * Merges two maps into a new one.
	 * 
	 * @param mergeToMap First map to merge (creates a brand new map if null).
	 * @param mergedMap Second map to merge.
	 * @return A merged map.
	 */
	static Map<String, Integer> merge(Map<String, Integer> mergeToMap, Map<String, Integer> mergedMap) {
		mergedMap.keySet().stream().forEach(key -> mergeToMap.merge(key, mergedMap.get(key), (map1Value, map2Value) -> map1Value + map2Value));
		
		return mergeToMap;
	}
	
	/**
	 * Simulates work being done for a given amount of duration.
	 * 
	 * @param durationInSeconds The time for the simulates work to be done.
	 */
	static void doWork(long durationInSeconds) {
		
		try {
			Thread.sleep(durationInSeconds * 1000);
		} catch (InterruptedException e) {
			// Ignore error.
		}
	}

	/**
	 * Tests the given condition and throws a RuntimeException if false.
	 * 
	 * @param condition The condition to test.
	 * @param stringedCondition The description of the condition.
	 * @throws RuntimeException Thrown if the condition false.
	 */
	static void ensure(boolean condition, String stringedCondition) throws RuntimeException {
		
		if (!condition) {
			throw new RuntimeException("Condition failed: " + stringedCondition);
		}
	}
}