package bio;

/**
 * Class that defines a genome with an identifier and corresponding nucleotide sequence.
 * @author Marten De Cock r0800075
 *
 */
public class Genome {
	
	private String identifier;
	private String sequence;
	
	/**
	 * Constructor method for the Genome class.
	 * @param identifier identifier of the genome
	 * @param sequence nucleotide sequence of the genome
	 */
	public Genome(String identifier, String sequence) {
		this.setIdentifier(identifier);
		this.setSequence(sequence);
	}
	
	/**
	 * Copy constructor of the Genome class. Used to ensure different id's in the memory during execution.
	 * @param toCopy genome to copy
	 */
	public Genome(Genome toCopy) {
		this.identifier = toCopy.identifier;
		this.sequence = toCopy.sequence;
	}

	/**
	 * @return the identifier of the genome
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier identifier of a genome
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the nucleotide sequence of the genome
	 */
	public String getSequence() {
		return sequence;
	}

	/**
	 * @param sequence nucleotide sequence of a genome
	 */
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	/**
	 * Prints the identifier and sequence to string.
	 */
	public void printGenome() {
		System.out.println(identifier);
		System.out.println(sequence);
	}
	
	/**
	 * Overrides the toString() method to return the sequence of a genome.
	 */
	@Override
	public String toString() {
		return sequence;
	}
	
}
