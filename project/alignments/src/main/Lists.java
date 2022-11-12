package main;

import team.*;
import bio.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lists {

	public List<Employee> createEmployeeList(String fileName) {
		List<Employee> employeeList = new ArrayList<>();

		try {
			fileName = "src/" + fileName;
			File myText = new File(fileName);
			Scanner scan = new Scanner(myText);
			Employee myEmployee;

			while (scan.hasNextLine()) {
				String function = scan.next();

				switch (function) {
				case "TeamLead":
					myEmployee = new TeamLead(scan.next(), scan.next(), Integer.parseInt(scan.next()));
					break;
				case "Bioinformatician":
					myEmployee = new BioInformatician(scan.next(), scan.next(), Integer.parseInt(scan.next()), null);
					break;
				case "TechnicalSupport":
					myEmployee = new TechnicalSupport(scan.next(), scan.next(), Integer.parseInt(scan.next()));
					break;
				default:
					myEmployee = null;
				}

				if (myEmployee != null) {
					employeeList.add(myEmployee);
				}

			}
			scan.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error - File was not found.");
		}
		return employeeList;

	}

	public List<Genome> createGenomeList(String fileName) {
		List<Genome> genomeList = new ArrayList<>();

		try {
			fileName = "src/" + fileName;
			File myFasta = new File(fileName);
			Scanner scan = new Scanner(myFasta);
			Genome myGenome;

			while (scan.hasNext()) {
				String identifier = scan.next();
				char firstChar = identifier.charAt(0);

				if (firstChar == '>') {
					myGenome = new Genome(identifier, scan.next());
				} else {
					myGenome = null;
				}

				if (myGenome != null) {
					genomeList.add(myGenome);
				}
			}
			scan.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error - File was not found.");
		}
		return genomeList;

	}

}