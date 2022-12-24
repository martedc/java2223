package team;

import bio.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BioInformatician is a subclass of Employee. It has an additional variable alignment, which is the personal alignment.
 * @author Marten De Cock r0800075
 *
 */
public class BioInformatician extends Employee {

	private Alignment alignment;

	
	/**
	 * Constructor method for the BioInformatician class. 
	 * @param firstName first name of the employee
	 * @param lastName last name of the employee
	 * @param experience experience in years of the employee
	 * @param alignment personal alignment of the employee
	 * @param repoID identifier in the repository [0, infinity]
	 */
	public BioInformatician(String firstName, String lastName, int experience, Alignment alignment, int repoID) {
		super("Bioinformatician", firstName, lastName, experience, repoID);
		this.setAlignment(alignment);
	}

	/**
	 * @return personal alignment of the employee
	 */
	public Alignment getAlignment() {
		return alignment;
	}

	/**
	 * @param alignment personal alignment of the employee
	 */
	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	/**
	 * Finds genomes with a given sequence of nucleotides. 
	 * Prints the results.
	 * @param snip true to search SNiP alignment, false to search SNP alignment
	 * @param s sequence of nucleotides
	 */
	public void findSequence(boolean snip, String s) {
		System.out.println("Bioinformatician " + this.getFirstName() + " searching for genomes with " + s + "." + '\n' + "Genomes found:");
		
		alignment.findSequence(snip, s);
	}

	/**
	 * Replaces a genome in the alignment in place of the genome with the given identifier.
	 * @param id identifier of the genome 
	 * @param repIdentifier replacement identifier
	 * @param repSequence replacement sequence
	 * @param repo alignment repository
	 */
	public void replaceGenome(String id, String repIdentifier, String repSequence, AlignmentRepo repo) {
		System.out.println("Bioinformatician " + this.getFirstName() + " replacing genome " + id);
		System.out.println("Old alignment score: " + this.alignment.getScore());
		
		alignment.replaceGenome(id, repIdentifier, repSequence);
		Alignment myAlignment = new Alignment(this.getAlignment());
		repo.changeAlignment(this.getRepoID(), myAlignment);
	}

	/**
	 * Replaces a given sequence of nucleotides with a new sequence in a genome.
	 * @param id identifier of the genome 
	 * @param targetSequence target sequence of nucleotides
	 * @param repSequence replacement sequence of nucleotides
	 * @param repo alignment repository
	 */
	public void replaceSequence(String id, String targetSequence, String repSequence, AlignmentRepo repo) {
		System.out.println("Bioinformatician " + this.getFirstName() + " replacing " + targetSequence + " with " + repSequence + " in genome " + id);
		System.out.println("Old alignment score: " + this.alignment.getScore());
		
		this.alignment.replaceSequence(id, targetSequence, repSequence);
		Alignment myAlignment = new Alignment(this.getAlignment());
		repo.changeAlignment(this.getRepoID(), myAlignment);
	}

	/**
	 * Replaces a given sequence of nucleotides with a new sequence in an alignment.
	 * @param targetSequence target sequence of nucleotides
	 * @param repSequence replacement sequence of nucleotides
	 * @param repo alignment repository
	 */
	public void replaceSequence(String targetSequence, String repSequence, AlignmentRepo repo) {
		System.out.println("Bioinformatician " + this.getFirstName() + " replacing " + targetSequence + " with " + repSequence + " in their alignment");
		System.out.println("Old alignment score: " + this.alignment.getScore());
		
		alignment.replaceSequence(targetSequence, repSequence);
		Alignment myAlignment = new Alignment(this.getAlignment());
		repo.changeAlignment(this.getRepoID(), myAlignment);
	}

	/**
	 * Adds a genome at the end of the alignment repository.
	 * @param identifier identifier of the new genome
	 * @param sequence sequence of the new genome
	 * @param repo alignment repository
	 */
	public void addGenome(String identifier, String sequence, AlignmentRepo repo) {
		System.out.println("Bioinformatician " + this.getFirstName() + " adding new genome " + identifier + " with sequence " + sequence);
		System.out.println("Old alignment score: " + this.alignment.getScore());
		
		alignment.addGenome(identifier, sequence);
		Alignment myAlignment = new Alignment(this.getAlignment());
		repo.changeAlignment(this.getRepoID(), myAlignment);
	}

	/** 
	 * Removes a genome based on the given identifier.
	 * @param id
	 * @param repo
	 */
	public void removeGenome(String id, AlignmentRepo repo) {
		System.out.println("Bioinformatician " + this.getFirstName() + " removing genome " + id);
		System.out.println("Old alignment score: " + this.alignment.getScore());
		
		alignment.removeGenome(id);
		Alignment myAlignment = new Alignment(this.getAlignment());
		repo.changeAlignment(this.getRepoID(), myAlignment);
	}

	/**
	 * Writes the bioinformaticians personal alignment to a text file (firstNamelastName.alignment.txt).
	 */
	public void writeAlignmentToFile() {
		System.out.println("Writing bioinformatician " + this.getFirstName() + "'s alignment to file" + '\n');
		
		try {
			String fileName = this.getFirstName() + this.getLastName() + ".alignment.txt";
			BufferedWriter myWriter = new BufferedWriter(new FileWriter(fileName));
			for (Genome g : this.getAlignment().getStandardAlignment()) {
				myWriter.write(g.getIdentifier() + '\n');
				myWriter.write(g.getSequence() + '\n');
			}
			myWriter.close();
			
		} catch (IOException e) {
			System.out.println("Error - Unable to write to file");
			e.printStackTrace();
		}
		
	}

	/**
	 * Writes a report of the bioinformaticians personal alignment to a text file, contains alignment score (firstNamelastName.score.txt).
	 */
	public void writeReportToFile() {
		System.out.println("Bioinformatician " + this.getFirstName() + " writing report to file" + '\n');
		
		try {
			String fileName = this.getFirstName() + this.getLastName() + ".score.txt";
			BufferedWriter myWriter = new BufferedWriter(new FileWriter(fileName));
			myWriter.write("Alignment score: " + this.getAlignment().getScore());
			myWriter.close();
			
		} catch (IOException e) {
			System.out.println("Error - Unable to write to file");
			e.printStackTrace();
		}
		
	}

}