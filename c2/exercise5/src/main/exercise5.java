package main;

public class exercise5 {
	//Define variables

	static double a = 1.8;

	static int b = 32;

	//Method for changing to Celsius

	public static double changeToCelsius(double fahrenheit){

	double celsius;

	celsius = (Fahrenheit-b)/a;

	return celsius;

	}

	//Method for changing to Fahrenheit

	public static double changeToFahrenheit(double celsius){

	double fahrenheit;

	fahrenheit = celsius*a+b;

	return fahrenheit;

	}

	// Main method

	public static void main(String[] args) {

	double degreesCelsius = 20;

	double degreesFahrenheit = 100;

	//Call methods

	double celsius = changeToCelsius(degreesFahrenheit);

	double fahrenheit = changeToFahrenheit(degreesCelsius);

	//Print results

	System.out.println("celsius: " + celsius + "\nfahrenheit: " + fahrenheit);

	}
}
