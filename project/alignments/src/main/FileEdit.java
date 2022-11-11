package main;

import team.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileEdit {

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
					myEmployee = new TeamLeader(scan.next(), scan.next(), Integer.parseInt(scan.next()));
					break;
				case "Bioinformatician":
					myEmployee = new BioInformatician(scan.next(), scan.next(), Integer.parseInt(scan.next()));
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

	public void readFasta(String fileName) {

		try {
			fileName = "src/" + fileName;
			File myText = new File(fileName);
			Scanner scan = new Scanner(myText);
			while (scan.hasNextLine()) {
				String text = scan.nextLine();
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - File was not found.");
		}

	}

}
