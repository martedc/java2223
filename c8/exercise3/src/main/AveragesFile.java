package main;

import java.util.*;
import java.io.*;

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
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
	
		try {
			// ask user for inputs
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
			
			// add average to file
			fw = new FileWriter(inputFile, true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			pw.println("Average:");
			pw.println(calculateAverage(numList));
			
		} catch (FileNotFoundException e) {
			System.out.println("File was not found.");
		} catch (IOException e1) {
			System.out.println("IO error.");
		} finally {
			try {
				pw.close();
				bw.close();
				fw.close();
			} catch (IOException e2) {
				System.out.println("IO error.");
			}
			
		} 
		
		

		// calculate and print average
		System.out.println(numList);
		System.out.println(calculateAverage(numList));

	}

}