package main;

public class ArrayEvenOrOdd {

	public static void checkEvenOrOdd(int[] array) {

		try {
			for (int i = 0; i < array.length; i++) {
				try {
					if (10 % array[i] == 0) {
						System.out.println("This number is even. Result: " + 10 / array[i]);
					} else {
						System.out.println("This number is odd");
					}
				} catch (ArithmeticException e) {
					System.out.println("Error - Cannot divide by 0.");
					continue;
				}

			}
		} catch (ArithmeticException e) {
			System.out.println("Error - Index out of bounds.");
		}

	}

	public static void main(String[] args) {

		// declare array
		int[] intArray = { 2, 6, 8, 1, 9, 0, 10, 23, 7, 5, 3 };

		// run check
		checkEvenOrOdd(intArray);

	}

}
