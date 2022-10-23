package main;

import java.util.Scanner;
import java.util.InputMismatchException;

public class BMICalculator {

	static double BMI;

	// method calculating BMI
	public static double calculateBMI(double w, double h) {

		BMI = w / (h * h);
		return BMI;

	}

	static void checkWeight(double w) {

		if (w < 0) {
			throw new ArithmeticException("Error - Weight cannot be negative!");
		}

	}

	static void checkHeight(double h) {
		if (h < 0) {
			throw new ArithmeticException("Error - Height cannot be negative!");
		}

	}

	// Main method
	public static void main(String[] args) {

		// ask user for weight and height
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter your weight (kg): ");
			double weight = sc.nextDouble();
			System.out.println("Please enter your height (m): ");
			double height = sc.nextDouble();

			// check weight and height
			checkWeight(weight);
			checkHeight(height);

			// calculate
			BMI = calculateBMI(weight, height);

			// print result to screen
			System.out.println("Your BMI is " + BMI + ".");

			sc.close();
		} catch (IllegalArgumentException e){
			System.out.println("Error - Illigal argument given!");
		} catch (InputMismatchException e) {
			System.out.println("Error - Input must of type double!");
		}

	}
	
}
