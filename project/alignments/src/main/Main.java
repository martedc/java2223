package main;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import team.*;
import bio.*;

/**
 * @author Marten De Cock r0800075
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		// Ask user for for files containing team members and alignment.
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the file containing the team members: (with .txt extension)");
		String txtName = scan.nextLine();
		System.out.println("Please enter the file containing the alignment: (with .fasta extension)");
		String fastaName = scan.nextLine();
		System.out.println(System.lineSeparator());
		scan.close();

		// Initialize the list of employees and the starting alignment from the user inputted files. 
		// Uses an instance of the Lists class, which contains methods to read the files and create lists.
		Lists lists = new Lists();
		EmployeeList employeeList = new EmployeeList(lists.createEmployeeList(txtName));
		Alignment startingAlignment = new Alignment(lists.createGenomeList(fastaName), lists.createGenomeList(fastaName), 0);

		// Initialize the repository and bioinformaticians' starting alignments.
		List<Alignment> startingRepository = new ArrayList<>();
		for (Employee e : employeeList.getEmployeeList()) {
			if (e instanceof BioInformatician) {
				Alignment iniAlignment = new Alignment(startingAlignment);
				((BioInformatician) e).setAlignment(iniAlignment);
				Alignment iniRepoAlignment1 = new Alignment(((BioInformatician) e).getAlignment());
				startingRepository.add(iniRepoAlignment1);
				((BioInformatician) e).setRepoID(startingRepository.size() - 1);
			} else {
				startingRepository.add(null);
			}
		}
		
		// Create the repository with the startingAlignment and startingAlignment variables. 
		// Technical support employees also set this initial repository as backup.
		AlignmentRepo repo = new AlignmentRepo(startingAlignment,startingRepository); 
		for (Employee e : employeeList.getEmployeeList()) {
			if (e instanceof TechnicalSupport) {
				AlignmentRepo iniRepo = new AlignmentRepo(repo);
				((TechnicalSupport) e).setBackup(iniRepo);
			} else {
				continue;
			}
		}
		
		/*
		 * All necessary code has now been executed to start making changes to the initial position.
		 * All following code are the employees executing some of their methods to make changes to alignments, write to files, etc.
		 */
		
		employeeList.printEmployees();
		employeeList.getBioinformatician(0).findSequence(false, "ACACAGAGCTAAGGCAGTAGCAGATTTCAAAA");
		employeeList.getBioinformatician(0).replaceSequence(">1997.D.KE.97.ML415", "ACACAGAGCTAAGGCAGTAGCAGATTTCAAAA", "ACACAGAACTAGGGCAGTAACAGATTCCAAAA", repo);
		employeeList.getTeamLead(0).setOptimalAlignment(employeeList.getBioinformatician(0), repo);
		employeeList.getBioinformatician(1).replaceSequence("ACATTT", "ACGTCT", repo);
		employeeList.getTeamLead(0).setOptimalAlignment(employeeList.getBioinformatician(1), repo);
		employeeList.getTeamLead(0).setAlignment(employeeList.getBioinformatician(2), repo);
		employeeList.getTechSupportList(0).setBackup(repo);
		employeeList.getTeamLead(0).writeReportToFile(repo);
		employeeList.getBioinformatician(2).replaceSequence(">2002.F1.AR.02.ARE933", "AGGAGAGCC", "AGGGGGGCC", repo);
		employeeList.getTechSupportList(0).restoreRepository(repo);
		employeeList.getBioinformatician(2).writeReportToFile();
		employeeList.getTeamLead(0).setOptimalAlignment(employeeList.getBioinformatician(2), repo);
		employeeList.getBioinformatician(0).removeGenome(">1997.D.KE.97.ML415", repo);
		
	}

}
