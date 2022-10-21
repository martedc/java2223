package main;

public class exercise7 {
	// Main method

	public static void main(String[] args) {

	float[] numbers = {1.2f, 2.4f, 6.5f, 4.7f, 6.1f}; // Array of numbers

	float mean = meanOfArray(numbers);

	System.out.println(mean);

	}

	// Method for calculating mean

	public static float meanOfArray(float[] numbers)

	{

	float mean;

	mean = (numbers[0]+numbers[1]+numbers[2]+numbers[3]+numbers[4])/5;

	return mean;

	}
}
