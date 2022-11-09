package main;

import java.util.Scanner;

public class BMIProject {

	// method calculating BMI
	public static double calculateBMI(double w, double h) {
		double BMI;
		BMI = w / (h * h);
		return BMI;
	}

	public static void main(String[] args) {
		// declare variables
		String name = new String();
		double weight;
		double height;
		double BMI;

		// Ask the user for inputs
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter name");
		name = scan.nextLine();
		System.out.println("Please enter weight [kg]");
		weight = scan.nextDouble();
		System.out.println("Please enter height [m]");
		height = scan.nextDouble();
		scan.close();

		// calculate BMI
		BMI = calculateBMI(weight, height);

		// Here: Commands formatting the output and print to screen
		System.out.println(name + " weighs " + weight + "kg and is " + height + "m tall.");
		System.out.println("The BMI is " + BMI);

	}

}
