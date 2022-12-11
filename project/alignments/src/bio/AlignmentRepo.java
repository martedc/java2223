package bio;

import java.util.List;

public class AlignmentRepo {

	private List<Alignment> alignmentList;

	// constructor method
	public AlignmentRepo(List<Alignment> alignmentList) {
		this.setRepository(alignmentList);
	}

	// getter and setter for repository
	public List<Alignment> getRepository() {
		return alignmentList;
	}

	public void setRepository(List<Alignment> alignmentList) {
		this.alignmentList = alignmentList;
	}

	public void changeAlignment(int place, Alignment newAlignment) {
		alignmentList.add(place, newAlignment);
		alignmentList.remove(place + 1);
	}

}