package main;

import java.util.*;

public class Averages {

	public static double calculateAverage(ArrayList<Double> numList) {
		int sum = 0;

		for (int i = 0; i < numList.size(); i++) {
			sum += numList.get(i);
		}
		return sum / numList.size();
	}

	public static void main(String[] args) {
		// declare variables
		ArrayList<Double> numList = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		double input = 1;

		// ask user for inputs
		do {
			System.out.println("Please give the next number:        (Enter 0 to end)");
			input = sc.nextDouble();
			numList.add(input);
		} while (input != 0);
		sc.close();

		// calculate and print average
		System.out.println(calculateAverage(numList));

	}

}
