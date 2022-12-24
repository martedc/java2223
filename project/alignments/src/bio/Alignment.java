package bio;

import java.util.List;
import java.util.ArrayList;

/**
 * The Alignment class keeps track of two lists of Genomes. The standard alignment and the SNiP alignment. This class contains methods allowing Bioinformaticians to make changes to their personal alignments.
 * @author Marten De Cock r0800075
 *
 */
public class Alignment {

	private List<Genome> standard;
	private List<Genome> snp;
	private int score;

	
	/**
	 * Constructor method for the Alignment class. 
	 * @param std standard alignment
	 * @param snp SNiP alignment 
	 * @param score alignment score 
	 */
	public Alignment(List<Genome> std, List<Genome> snp, int score) {
		this.setStandardAlignment(std);
		this.setSNPAlignment(snp);
		this.setScore();
	}
	
	/**
	 * Copy constructor of the Alignment class. Used to ensure different id's in the memory during execution.
	 * @param toClone alignment to clone
	 */
	public Alignment(Alignment toClone) {
		List<Genome> copyStandardList = new ArrayList<>();
		List<Genome> copySnpList = new ArrayList<>();
		Genome myGenome1;
		Genome myGenome2;
		
		for (Genome g : toClone.getStandardAlignment()) {
			myGenome1 = new Genome(g);
			myGenome2 = new Genome(g);
			copyStandardList.add(myGenome1);
			copySnpList.add(myGenome2);
		}
		this.standard = copyStandardList;
		this.setSNPAlignment(copySnpList);
		this.score = toClone.getScore();
		
	}

	/**
	 * @return standard alignment
	 */
	public List<Genome> getStandardAlignment() {
		return standard;
	}

	/**
	 * @param std standard alignment
	 */
	public void setStandardAlignment(List<Genome> std) {
		this.standard = std;
	}

	/**
	 * @return SNiP alignment
	 */
	public List<Genome> getSNPAlignment() {
		return snp;
	}

	/**
	 * Sets the SNiP alignment, uses a reference sequence (first genome) and replaces all non-corresponding genomes with a '.' resulting in a new list of Genomes.
	 * @param alignment alignment to construct SNiP alignment from (has to be in the standard form)
	 */
	public void setSNPAlignment(List<Genome> alignment) {
		char[] refSequence = alignment.get(0).getSequence().toCharArray();
		char[] newSequence;
		List<Genome> myAlignment = new ArrayList<>();
		Genome myGenome;
		
		for (Genome g : alignment) {
			myGenome = new Genome(g);
			myAlignment.add(myGenome);
		}

		for (int i = 0; i < standard.size(); i++) {
			if (i != 0) {
				newSequence = myAlignment.get(i).getSequence().toCharArray().clone();
			} else {
				continue;
			}
			for (int j = 0; j < refSequence.length; j++) {
				if (refSequence[j] == newSequence[j]) {
					newSequence[j] = '.';
				}
			}	
			myAlignment.get(i).setSequence(toString(newSequence));
		}
		this.snp = myAlignment;
		
	}

	/**
	 * @return alignment score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Calculates alignment score. Compares the reference sequence (first genome) and adds 1 when a nucleotide doesn't correspond. 
	 */
	public void setScore() {
		char[] refSequence = this.standard.get(0).getSequence().toCharArray();
		char[] newSequence;
		int s = 0;

		for (int i = 0; i < standard.size(); i++) {
			if (i != 0) {
				newSequence = this.standard.get(i).getSequence().toCharArray();
			} else {
				continue;
			}
			for (int j = 0; j < refSequence.length; j++) {
				if (refSequence[j] != newSequence[j]) {
					s++;
				}
			}
		}
		this.score = s;
		
	}
	
	/**
	 * Finds genomes with a given sequence of nucleotides. 
	 * Prints the results.
	 * @param snip true to search SNiP alignment, false to search SNP alignment
	 * @param s sequence of nucleotides
	 */
	public void findSequence(boolean snip, String s) {
		
		if (snip == true) {
			for (int i = 0; i < snp.size(); i++) {
				if (snp.get(i).getSequence().indexOf(s) != -1) {
					snp.get(i).printGenome();
				} 
			}
		} else if (snip == false) {
			for (int i = 0; i < standard.size(); i++) {
				if (standard.get(i).getSequence().indexOf(s) != -1) {
					standard.get(i).printGenome();
				}
			}
		} else {
			System.out.println("Error - Please enter true/false correctly");
		}
		System.out.println('\n');
		
	}
	
	/**
	 * Replaces a genome in the alignment in place of the genome with the given identifier.
	 * @param id identifier of the genome 
	 * @param repIdentifier replacement identifier
	 * @param repSequence replacement sequence
	 */
	public void replaceGenome(String id, String repIdentifier, String repSequence) {
	
		if (id.charAt(0) == '>') { 
			for (int i = 0; i < standard.size(); i++) {
				if (standard.get(i).getIdentifier().equals(id)) {
					standard.get(i).setIdentifier(repIdentifier);
					standard.get(i).setSequence(repSequence);
					return;
				} 
			}
			System.out.println("Error - No genome was found with the input identifier");
		} else {
			for (int i = 0; i < standard.size(); i++) {
				if (standard.get(i).getSequence().equals(id)) {
					standard.get(i).setIdentifier(repIdentifier);
					standard.get(i).setSequence(repSequence);
					return;
				}
			}
			System.out.println("Error - No genome was found with the input sequence");
		}
		this.setSNPAlignment(standard);
		this.setScore();
		
	}
	
	/**
	 * Replaces a given sequence of nucleotides with a new sequence in a genome.
	 * @param id identifier of the genome 
	 * @param targetSequence target sequence of nucleotides
	 * @param repSequence replacement sequence of nucleotides
	 */
	public void replaceSequence(String id, String targetSequence, String repSequence) {
		
		if (targetSequence.length() != repSequence.length()) {
			System.out.println("Error - The length of the target and replacement sequences has to match!");
		} else {
			if (id.charAt(0) == '>') { 
				for (int i = 0; i < this.standard.size(); i++) {
					if (this.standard.get(i).getIdentifier().equals(id)) {
						this.standard.get(i).setSequence(this.standard.get(i).getSequence().replace(targetSequence, repSequence));
						this.setSNPAlignment(this.standard);
						this.setScore();
						return;
					} 
				}
				System.out.println("Error - No genome was found with the input identifier");
			} else {
				for (int i = 0; i < this.standard.size(); i++) {
					if (this.standard.get(i).getSequence().equals(id)) {
						this.standard.get(i).setSequence(this.standard.get(i).getSequence().replace(targetSequence, repSequence));
						this.setSNPAlignment(this.standard);
						this.setScore();
						return;
					}
				}
				System.out.println("Error - No genome was found with the input sequence");
			}
		}
		
	}
	
	/**
	 * Replaces a given sequence of nucleotides with a new sequence in an alignment.
	 * @param targetSequence target sequence of nucleotides
	 * @param repSequence replacement sequence of nucleotides
	 */
	public void replaceSequence(String targetSequence, String repSequence) {
		
		if (targetSequence.length() != repSequence.length()) {
			System.out.println("Error - The length of the target and replacement sequences has to match!");
		} else {
			for (int i = 0; i < standard.size(); i++) {
				this.standard.get(i).setSequence(standard.get(i).getSequence().replace(targetSequence, repSequence));
				this.setSNPAlignment(standard);
			}
		}
		this.setScore();
	}
	
	/**
	 * Adds a genome at the end of the alignment repository.
	 * @param identifier identifier of the new genome
	 * @param sequence sequence of the new genome
	 */
	public void addGenome(String identifier, String sequence) {
		
		if (identifier.charAt(0) != '>') {
			System.out.println("Error - An incorrect identifier was given");
		} else {
			Genome myGenome = new Genome(identifier, sequence);
			standard.add(myGenome);
			this.setSNPAlignment(standard);
			this.setScore();
		}
	}
	
	
	/**
	 * Removes a genome based on the given identifier.
	 * @param id
	 */
	public void removeGenome(String id) {
		
		if (id.charAt(0) == '>') { 
			for (int i = 0; i < standard.size(); i++) {
				if (standard.get(i).getIdentifier().equals(id)) {
					standard.remove(i);
					return;
				} 
			}
			System.out.println("Error - No genome was found with the input identifier");
		} else {
			for (int i = 0; i < standard.size(); i++) {
				if (standard.get(i).getSequence().equals(id)) {
					standard.remove(i);
					return;
				}
			}
			System.out.println("Error - No genome was found with the input sequence");
		}
		this.setSNPAlignment(standard);
		this.setScore();
		
	}
	
	/**
	 * Converts an array of characters into a string.
	 * @param a array of characters
	 * @return joined string
	 */
	public static String toString(char[] a) {
		String string = new String(a);
		return string;
	}
	
}
