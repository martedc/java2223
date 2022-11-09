package main;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.BufferedWriter;

public class AveragesFile {

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
		Scanner scanFile = new Scanner(System.in);
		double num = 1;
		String inputFile;
		String outputFile;

		// ask user for inputs
		try {
			System.out.println("Please enter the filename: (with extension)");
			inputFile = "src/" + scanFile.nextLine();
			File input = new File(inputFile);
			scanFile.close();
			Scanner scan = new Scanner(input);
			
			do {
				num= scan.nextDouble();
				numList.add(num);
			} while (scan.hasNextDouble());
			scan.close();
		} catch (Exception e) {
			System.out.println("An error has occured.");
		}
		
		// add average to file

		// calculate and print average
		System.out.println(numList);
		System.out.println(calculateAverage(numList));

	}

}