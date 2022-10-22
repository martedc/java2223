package main;

import java.util.ArrayList;

public class exercise4 {

	public static ArrayList<Integer> getFirstPrimesUsingForLoops(int nbPrimes) {

		ArrayList<Integer> primeNumbers = new ArrayList<>();
		primeNumbers.add(2);
		boolean isPrime;
		int i = 3;

		while (primeNumbers.size() < nbPrimes) {
			
			isPrime = true;
			int j = i - 1;
			
			while (j >= 2) {
				if (i % j == 0) {
					isPrime = false;
				}
				j--;

			}
			if (isPrime) {
				primeNumbers.add(i);
			}
			i++;
		}

		return primeNumbers;
	}

	public static void main(String[] args) {
		
		System.out.println(getFirstPrimesUsingForLoops(10));
	}

}
