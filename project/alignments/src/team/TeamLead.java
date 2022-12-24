package team;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import bio.*;

/**
 * TeamLead is a subclass of Employee.
 * @author Marten De Cock r0800075
 *
 */
public class TeamLead extends Employee {

	/**
	 * Constructor method for the TeamLead class.
	 * @param firstName first name of the employee
	 * @param lastName last name of the employee
	 * @param experience experience in years of the employee
	 * @param repoID identifier in the repository [-1]
	 */
	public TeamLead(String firstName, String lastName, int experience, int repoID) {
		super("TeamLead",firstName,lastName,experience, repoID);
	}
	
	/**
	 * Sets new optimal alignment in the repository. 
	 * @param bi bioinformatician with personal alignment
	 * @param repo alignment repository
	 */
	public void setOptimalAlignment(BioInformatician bi, AlignmentRepo repo) {
		System.out.println("Promoting " + bi.getFirstName() + "'s alignment to optimal alignment" + '\n');
		
		Alignment myAlignment = new Alignment(bi.getAlignment());
		repo.setOptimalAlignment(myAlignment, this.getRepoID());
	}
	
	/**
	 * Sets new personal alignment for bioinformatician from optimal alignment in the repository.
	 * @param bi bioinformatician with personal alignment
	 * @param repo alignment repository
	 */
	public void setAlignment(BioInformatician bi, AlignmentRepo repo) {
		System.out.println("Copying optimal alignment to " + bi.getFirstName() + '\n');
		
		Alignment myAlignment = new Alignment(repo.getOptimalAlignment());
		bi.setAlignment(myAlignment);
		repo.getRepository().set(bi.getRepoID(), myAlignment);
	}
	
	/**
	 * Writes all bioinformaticians alignments to a text file (firstNamelastName.alignment.txt).
	 * @param repo alignment repository
	 */
	public void writeAlignmentToFile(AlignmentRepo repo) {
		System.out.println("Team lead " + this.getFirstName() + " writing alignments to file" + '\n');
		
		try {
			String fileName = this.getFirstName() + this.getLastName() + ".alignment.txt";
			BufferedWriter myWriter = new BufferedWriter(new FileWriter(fileName));
			for (Alignment a : repo.getRepository()) {
				if (a == null) {
					continue;
				} else {
					myWriter.write('\n');
					for (Genome g : a.getStandardAlignment()) {
						myWriter.write(g.getIdentifier() + '\n');
						myWriter.write(g.getSequence() + '\n');
					}
				}
			}
			myWriter.close();
			
		} catch (IOException e) {
			System.out.println("Error - Unable to write to file");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Writes report of all bioinformaticians alignments, contains alignment scores (firstNamelastName.alignment.txt).
	 * @param repo alignment repository
	 */
	public void writeReportToFile(AlignmentRepo repo) {
		System.out.println("Team lead " + this.getFirstName() + " writing report to file" + '\n');
		
		try {
			String fileName = this.getFirstName() + this.getLastName() + ".score.txt";
			BufferedWriter myWriter = new BufferedWriter(new FileWriter(fileName));
			for (Alignment a : repo.getRepository()) {
				if (a == null) {
					continue;
				} else {
					myWriter.write("Alignment score: " + a.getScore() + '\n');
				}
			}
			myWriter.close();
			
		} catch (IOException e) {
			System.out.println("Error - Unable to write to file");
			e.printStackTrace();
		}
		
	}
	
}


