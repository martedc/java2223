package team;

import bio.*;

public class BioInformatician extends Employee {
	
	private Alignment alignment;
	private int repoID;

	// constructor method, Bioinformatician is a subclass of Employee
	public BioInformatician(String firstName, String lastName, int experience, Alignment alignment, int repoID) {
		super("Bioinformatician",firstName,lastName,experience);
		this.setAlignment(alignment);
		this.setRepoID(repoID);
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}
	
	public int getRepoID() {
		return repoID;
	}
	
	public void setRepoID(int id) {
		this.repoID = id;
	}
	
	public void findSequence(boolean snip, String s) {
		alignment.findSequence(snip, s);
	}
	
	public void replaceGenome(String id, String repIdentifier, String repSequence, AlignmentRepo repo) {
		alignment.replaceGenome(id, repIdentifier, repSequence);
		repo.changeAlignment(repoID, alignment);
	}
	
	public void replaceSequence(String id, String targetSequence, String repSequence, AlignmentRepo repo) {
		alignment.replaceSequence(id, targetSequence, repSequence);
		repo.changeAlignment(repoID, alignment);
	}
	
	public void replaceSequence(String targetSequence, String repSequence, AlignmentRepo repo) {
		alignment.replaceSequence(targetSequence, repSequence);
		repo.changeAlignment(repoID, alignment);
	}
	
	public void addGenome(String identifier, String sequence, AlignmentRepo repo) {
		alignment.addGenome(identifier, sequence);
		repo.changeAlignment(repoID, alignment);
	}
	
	public void removeGenome(String id, AlignmentRepo repo) {
		alignment.removeGenome(id);
		repo.changeAlignment(repoID, alignment);
	}
}