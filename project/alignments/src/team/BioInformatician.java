package team;

import bio.*;

public class BioInformatician extends Employee {
	
	private Alignment alignment;

	// constructor method, Bioinformatician is a subclass of Employee
	public BioInformatician(String firstName, String lastName, int experience, Alignment alignment, int repoID) {
		super("Bioinformatician",firstName,lastName,experience, repoID);
		this.setAlignment(alignment);
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}
	
	
	public void findSequence(boolean snip, String s) {
		System.out.println("Bioinformatician " + this.getFirstName() + " searching for genomes with " + s + ". Genomes found:" );
		alignment.findSequence(snip, s);
	}
	
	public void replaceGenome(String id, String repIdentifier, String repSequence, AlignmentRepo repo) {
		System.out.println("Bioinformatician " + this.getFirstName() + " replacing genome.");
		alignment.replaceGenome(id, repIdentifier, repSequence);
		repo.changeAlignment(this.getRepoID(), alignment);
	}
	
	public void replaceSequence(String id, String targetSequence, String repSequence, AlignmentRepo repo) {
		this.alignment.replaceSequence(id, targetSequence, repSequence);
		repo.changeAlignment(this.getRepoID(), this.getAlignment());
	}
	
	public void replaceSequence(String targetSequence, String repSequence, AlignmentRepo repo) {
		alignment.replaceSequence(targetSequence, repSequence);
		repo.changeAlignment(this.getRepoID(), alignment);
	}
	
	public void addGenome(String identifier, String sequence, AlignmentRepo repo) {
		alignment.addGenome(identifier, sequence);
		repo.changeAlignment(this.getRepoID(), alignment);
	}
	
	public void removeGenome(String id, AlignmentRepo repo) {
		alignment.removeGenome(id);
		repo.changeAlignment(this.getRepoID(), alignment);
	}
}