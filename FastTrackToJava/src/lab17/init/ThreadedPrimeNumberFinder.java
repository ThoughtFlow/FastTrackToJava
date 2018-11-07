package lab17.init;

import java.util.concurrent.ExecutionException;

import lab.util.Util;

public class ThreadedPrimeNumberFinder {

	/**
	 * Returns the number of primes found in the range.
	 * 
	 * @param startRange The starting range for which to count primes.
	 * @param endRange The ending range for which to count primes.
	 * @return The number of primes found.
	 * @throws IllegalArgumentException Thrown if endRange is < startRange.
	 * @throws InterruptedException Thrown upon a thread error.
	 * @throws ExecutionException Thrown upon an error in the callable.
	 */
	private static int countPrimes(int startRange, int endRange)
			throws IllegalArgumentException, InterruptedException, ExecutionException {

		if (endRange < startRange) {
			throw new IllegalArgumentException("Start range must be greater than end range");
		}

		// Make this multi-threaded using the executor service.
		// Change this to executor service with callback and futures.
		// 1) Choose the appropriate executor service and mind the pool size
		// 2) Use submit/invoke, call and future, then shutdown the pool.
		
		// Objective:
		// T1 -- countPrimeInRange --
		// T2 -- countPrimeInRange --\
		// T3 -- countPrimeInRange ---> sum
		// T4 -- countPrimeInRange --/
		// T5 -- countPrimeInRange --
		int totalPrimesFound = 0;
		
		for (int index = startRange; index < endRange; ++index) {
			totalPrimesFound = Util.isPrime(index) ? totalPrimesFound + 1 : totalPrimesFound;
		}
		
		return totalPrimesFound;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("Total primes found: " + countPrimes(0, 1000000));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
