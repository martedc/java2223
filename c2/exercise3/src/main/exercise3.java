package main;

public class exercise3 {
	public static void main(String[] args) {

		double[] firstArray, secondArray;
		firstArray = new double[3];
		secondArray = new double[3];
		boolean[] comparisonArray = new boolean[3];
		
		firstArray[0] = 0;
		firstArray[1] = 10;
		firstArray[2] = 8.8;
		secondArray[0] = -4;
		secondArray[1] = 10;
		secondArray[2] = 8.78;
		comparisonArray[0] = firstArray[0]==secondArray[0];
		comparisonArray[1] = firstArray[1]==secondArray[1];
		comparisonArray[2] = firstArray[2]==secondArray[2];

		System.out.println("The first elements of the two arrays are equal: " + comparisonArray[0]);
		System.out.println("The second elements of the two arrays are equal: " + comparisonArray[1]);
		System.out.println("The third elements of the two arrays are equal: " + comparisonArray[2]);

		}
}
