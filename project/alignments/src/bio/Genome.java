package bio;

public class Genome {
	
	// variables for a genome
	private String identifier;
	private String sequence;
	
	// constructor class: identifier and genome sequence as strings
	public Genome(String identifier, String sequence) {
		this.setIdentifier(identifier);
		this.setSequence(sequence);
	}

	// getters and setters for variables
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	@Override
	public String toString() {
		return sequence;
	}
	
}
