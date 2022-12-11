package main;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
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
		// employeeList.printEmployees();

		// fetch starting alignment from file
		Alignment startingAlignment = new Alignment(lists.createGenomeList(fastaName), lists.createGenomeList(fastaName), 0);

		// initialising starting alignments and repository
		List<Alignment> startingRepository = new ArrayList<>();
		startingRepository.add(startingAlignment);
		for (Employee e : employeeList.getEmployeeList()) {
			if (e instanceof BioInformatician) {
				Alignment myAlignment = new Alignment(startingAlignment);
				((BioInformatician) e).setAlignment(myAlignment);
				startingRepository.add(((BioInformatician) e).getAlignment());
				((BioInformatician) e).setRepoID(startingRepository.size() - 1);
			}
		}
		AlignmentRepo repo = new AlignmentRepo(startingRepository);
		
		// testing bioinformatician changes
		String testIdentifier = startingAlignment.getStandardAlignment().get(0).getIdentifier();
		
		// ((BioInformatician) employeeList.getEmployeeN(1)).findSequence(false, "AACAAATG");
	
		// ((BioInformatician) employeeList.getEmployeeN(1)).replaceGenome(testIdentifier, ">testid", "AABTGTGCCAAG", repo);
		
		((BioInformatician) employeeList.getEmployeeN(1)).replaceSequence(testIdentifier, "TTT", "CCC", repo);
		((BioInformatician) employeeList.getEmployeeN(2)).replaceSequence(testIdentifier, "C", "T", repo);
		
		
		startingAlignment.getStandardAlignment().get(0).printGenome();
		repo.getRepository().get(1).getStandardAlignment().get(0).printGenome();
		repo.getRepository().get(2).getStandardAlignment().get(0).printGenome();
		
		scan.close();
	}

}
