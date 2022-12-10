package main;

import java.util.Scanner;
import team.*;
import bio.*;

public class Main {

	public static void main(String[] args) {
		Lists lists = new Lists();
		Scanner scan = new Scanner(System.in);

		// ask user for .txt file and .fasta file
		System.out.println("Please enter the file containing the team members: (with extension)");
		String txtName = scan.nextLine();
		System.out.println("Please enter the file containing the alignment: (with extension)");
		String fastaName = scan.nextLine();

		// create a list of the employees in the team
		EmployeeList employeeList = new EmployeeList(lists.createEmployeeList(txtName));
		employeeList.printEmployees();

		// fetch starting alignment from file
		Alignment startingAlignment = new Alignment(lists.createGenomeList(fastaName), lists.createGenomeList(fastaName), 0);

		// set starting alignment for Bioinformaticians
		for (Employee e : employeeList.getEmployeeList()) {
			if (e instanceof BioInformatician) {
				((BioInformatician) e).setAlignment(startingAlignment);
			}
		}

		// setting starting shared alignment
		AlignmentRepo repo = new AlignmentRepo(startingAlignment); 

		// test: setting new shared alignment
		((TeamLead) employeeList.getEmployeeN(0)).setRepoAlignment(repo, startingAlignment, (BioInformatician) employeeList.getEmployeeN(2));

		// test: finding AACAAATG in the genomes
		// startingAlignment.findSequence("AACAAATG");
		
		// test: finding >1990.U.CD.90.90CD121E12's sequence and replacing with testId and testSeq
		/*
		 * String searchSequence =
		 * startingAlignment.getStandardAlignment().get(0).getSequence();
		 * startingAlignment.replaceGenome(searchSequence, "testID", "testSEQ");
		 * startingAlignment.getStandardAlignment().get(0).printGenome();
		 */
		
		// test: replace sequence in >1990.U.CD.90.90CD121E12 
		/*
		 * String searchSequence =
		 * startingAlignment.getStandardAlignment().get(0).getSequence();
		 * startingAlignment.replaceSequence(searchSequence, "T", "CC");
		 * startingAlignment.getStandardAlignment().get(0).printGenome();
		 */
		 
		
		scan.close();
	}

}
