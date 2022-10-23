package main;

public class BMICalculator {

	static double BMI;

	// method calculating BMI
	public static double calculateBMI(double w, double h) {

		BMI = w / (h * h);
		return BMI;

	}

	// Main method
	public static void main(String[] args) {

		// declare variables
		double weight = 60;
		double height = 1.70;
		// calculate BMI
		BMI = calculateBMI(weight, height);
		// print to screen
		System.out.println("Your BMI is " + BMI + ".");

	}

}
