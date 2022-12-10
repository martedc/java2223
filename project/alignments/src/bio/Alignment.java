package bio;

import java.util.List;

public class Alignment {

	// variables for an alignment (standard alignment, SNiP alignment and corresponding alignment score)
	private List<Genome> standard;
	private List<Genome> snp;
	private int score;

	// constructor method
	public Alignment(List<Genome> std, List<Genome> snp, int score) {
		this.setStandardAlignment(std);
		this.setSNPAlignment(snp);
		this.setScore(score);
	}

	// getter and setter methods
	public List<Genome> getStandardAlignment() {
		return standard;
	}

	public void setStandardAlignment(List<Genome> std) {
		this.standard = std;
	}

	public List<Genome> getSNPAlignment() {
		return snp;
	}

	/* SNiP setter method: determines the corresponding SNiP alignment 
	 * input is the a list of genomes, to get the corresponding SNiP alignment a reference
	 * sequence is taken (first genome) and turned into an array of Characters and
	 * compared line by line with all the following genomes, if the characters
	 * correspond they stay unchanged, otherwise they get replaced with a '.'
	 */
	public void setSNPAlignment(List<Genome> snp) {
		char[] refSequence = standard.get(0).getSequence().toCharArray();
		char[] newSequence;

		for (int i = 0; i < standard.size(); i++) {
			if (i != 0) {
				newSequence = standard.get(i).getSequence().toCharArray();
			} else {
				continue;
			}
			for (int j = 0; j < refSequence.length; j++) {
				if (refSequence[j] == newSequence[j]) {
					newSequence[j] = '.';
				}
			}
			snp.get(i).setSequence(toString(newSequence));
		}
		this.snp = snp;
	}

	public int getScore() {
		return score;
	}

	// Alignment score setter method: computes score
	// works by comparing a reference sequence (first genome) with all following genomes, if a character is not the same 1 gets added to the score
	public void setScore(int score) {
		char[] refSequence = standard.get(0).getSequence().toCharArray();
		char[] newSequence;

		for (int i = 0; i < standard.size(); i++) {
			if (i != 0) {
				newSequence = standard.get(i).getSequence().toCharArray();
			} else {
				continue;
			}
			for (int j = 0; j < refSequence.length; j++) {
				if (refSequence[j] != newSequence[j]) {
					score++;
				}
			}
		}
		this.score = score;
	}
	
	public void findSequence(String s) {
		
		for (int i = 0; i < standard.size(); i++) {
			if (standard.get(i).getSequence().indexOf(s) != -1) {
				standard.get(i).printGenome();
			}
		}
	}
	
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
	}
	
	public void replaceSequence(String id, String targetSequence, String repSequence) {
		
		if (targetSequence.length() != repSequence.length()) {
			System.out.println("Error - The length of the target and replacement sequences has to match!");
		}
		
		if (id.charAt(0) == '>') { 
			for (int i = 0; i < standard.size(); i++) {
				if (standard.get(i).getIdentifier().equals(id)) {
					standard.get(i).setSequence(standard.get(i).getSequence().replace(targetSequence, repSequence));
					return;
				} 
			}
			System.out.println("Error - No genome was found with the input identifier");
		} else {
			for (int i = 0; i < standard.size(); i++) {
				if (standard.get(i).getSequence().equals(id)) {
					standard.get(i).setSequence(standard.get(i).getSequence().replace(targetSequence, repSequence));
					return;
				}
			}
			System.out.println("Error - No genome was found with the input sequence");
		}
	}

	public static String toString(char[] a) {
		String string = new String(a);

		return string;
	}

}
