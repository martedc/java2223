package bio;

import java.util.List;

public class Alignment {

	private List<Genome> standard;
	private List<Genome> snp;
	private int score;

	public Alignment(List<Genome> std, List<Genome> snp, int score) {
		this.setStandardAlignment(std);
		this.setSNPAlignment(snp);
		this.setScore(score);
	}

	public List<Genome> getStandardAlignment() {
		return standard;
	}

	public void setStandardAlignment(List<Genome> std) {
		this.standard = std;
	}

	public List<Genome> getSNPAlignment() {
		return snp;
	}

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

	public static String toString(char[] a) {
		String string = new String(a);

		return string;
	}

}
