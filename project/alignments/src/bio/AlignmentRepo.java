package bio;

import java.util.List;

public class AlignmentRepo {
	
	private Alignment optimalAlignment;
	private List<Alignment> alignmentList;
	private boolean called;

	// constructor method
	public AlignmentRepo(Alignment optimalAlignment, List<Alignment> alignmentList) {
		this.setOptimalAlignment(optimalAlignment);
		this.setRepository(alignmentList);
	}

	// getter and setter for repository
	public List<Alignment> getRepository() {
		return alignmentList;
	}

	public void setRepository(List<Alignment> alignmentList) {
		this.alignmentList = alignmentList;
	}

	public void changeAlignment(int id, Alignment newAlignment) {
		if (id > 0) {
			alignmentList.add(id, newAlignment);
			alignmentList.remove(id + 1);
			System.out.println("New alignment score: " + newAlignment.getScore());
		} else {
			System.out.println("Error - This employee has insufficient permissions to access this method");
		}
	}

	public Alignment getOptimalAlignment() {
		return optimalAlignment;
	}

	public void setOptimalAlignment(Alignment optimalAlignment) {
		if (called) return;
		called = true;
		this.optimalAlignment = optimalAlignment;
	}
	
	public void setOptimalAlignment(int id) {
		if (id == 0) {
			
		} else {
			System.out.println("Error - This employee has insufficient permissions to access this method");
		}
	}
}