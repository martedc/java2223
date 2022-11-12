package bio;

public class AlignmentRepo {
	
	private Alignment alignment;

	public AlignmentRepo(Alignment alignment) {
		this.setStartingAlignment(alignment);
	}

	// getter and setter for assignment variable
	public Alignment getAlignment() {
		return alignment;
	}

	public void setStartingAlignment(Alignment alignment) {
		this.alignment = alignment;
		System.out.println();
	}
	
	// setting new shared alignment
	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;	
	}
	
}
