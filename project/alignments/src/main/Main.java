package main;

import java.util.List;
import java.util.Scanner;
import team.*;
import bio.*;

public class Main {

	public static void main(String[] args) {
		Lists lists = new Lists();
		Scanner scan = new Scanner(System.in);
		String newLine = System.lineSeparator();

		// ask user for .txt file and .fasta file
		System.out.println("Please enter the file containing the team members: (with extension)");
		String txtName = scan.nextLine();
		System.out.println("Please enter the file containing the alignment: (with extension)");
		String fastaName = scan.nextLine();

		// create a list of the employees in the team
		List<Employee> employeeList = lists.createEmployeeList(txtName);
		System.out.println(newLine + "### Team members:" + newLine);
		for (Employee e : employeeList) {
			System.out.println("Name: " + e.getFirstName() + " " + e.getLastName());
			System.out.println("Function: " + e.getFunction());
			System.out.println("Experience: " + e.getExperience() + " years" + newLine);
		}
		System.out.println("###" + newLine);

		// fetch starting alignment from file
		Alignment startingAlignment = new Alignment(lists.createGenomeList(fastaName), lists.createGenomeList(fastaName), 0);
		
		// print starting alignment score
		System.out.println(startingAlignment.getScore());

		// set starting alignment for Bioinformaticians
		for (Employee e : employeeList) {
			if (e instanceof BioInformatician) {
				((BioInformatician) e).setAlignment(startingAlignment);
			}
		}

		// setting starting shared alignment
		AlignmentRepo repo = new AlignmentRepo(startingAlignment);

		// test: setting new shared alignment
		((TeamLead) employeeList.get(0)).setRepoAlignment(repo, startingAlignment,
				(BioInformatician) employeeList.get(2));

		scan.close();
	}

}
