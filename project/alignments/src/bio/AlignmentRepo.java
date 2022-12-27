package bio;

import java.util.List;
import java.util.ArrayList;
import team.*;

/**
 * Repository class containing an optimalAlignment and bioinformaticians' personal alignments.
 * @author Marten De Cock r0800075
 *
 */
public class AlignmentRepo {
	
	private Alignment optimalAlignment;
	private List<Alignment> alignmentList;
	private boolean called;

	/**
	 * Constructor method for the AlignmentRepo class. 
	 * @param optimalAlignment optimal alignment
	 * @param alignmentList list of alignments 
	 */
	public AlignmentRepo(Alignment optimalAlignment, List<Alignment> alignmentList) {
		this.setOptimalAlignment(optimalAlignment);
		this.setRepository(alignmentList);
	}
	
	/**
	 * Copy constructor for the AlignmentRepo class. Used to ensure different id's in the memory during execution.
	 * @param toClone
	 */
	public AlignmentRepo(AlignmentRepo toClone) {
		Alignment copyOptimal = new Alignment(toClone.getOptimalAlignment());
		List<Alignment> copyRepo = new ArrayList<>();
		Alignment myAlignment;
		
		for (Alignment a : toClone.getRepository()) {
			if (a == null) {
				copyRepo.add(null);
			} else {
				myAlignment = new Alignment(a);
				copyRepo.add(myAlignment);
			}
		
		}
		this.optimalAlignment = copyOptimal;
		this.alignmentList = copyRepo;
		
	}

	/**
	 * @return list of personal alignments.
	 */
	public List<Alignment> getRepository() {
		return alignmentList;
	}

	/**
	 * @param alignmentList list of personal alignments.
	 */
	public void setRepository(List<Alignment> alignmentList) {
		this.alignmentList = alignmentList;
	}

	/**
	 * Replaces an alignment in the repository on the index corresponding with the bioinformaticians' repository id (int repoID). Checks wether the employee has the permissions to call this method by checking the repository id.
	 * @param id employees repoID
	 * @param newAlignment replacement alignment
	 */
	public void changeAlignment(int id, Alignment newAlignment) {
		
		if (id >= 0) {
			alignmentList.add(id, newAlignment);
			alignmentList.remove(id + 1);
			System.out.println("New alignment score: " + newAlignment.getScore() + '\n');
		} else {
			System.out.println("Error - This employee has insufficient permissions to access this method");
		}
		
	}

	/**
	 * @return current optimal alignment
	 */
	public Alignment getOptimalAlignment() {
		return optimalAlignment;
	}

	/**
	 * Only used once when initializing the repository. 
	 * @param optimalAlignment alignment to set as optimal alignment
	 */
	public void setOptimalAlignment(Alignment optimalAlignment) {
		if (called) return;
		called = true;
		this.optimalAlignment = optimalAlignment;
	}
	
	/**
	 * Called by the TeamLead class to set a new optimal alignment from a bioinformaticians' personal alignment. Checks wether the employee has the permissions to call this method by checking the repository id (int repoID).
	 * @param a bioinformaticians' personal alignment
	 * @param id employees repoID
	 */
	public void setOptimalAlignment(Alignment a, int id) {
		
		if (id < 0) {
			this.optimalAlignment = a;
		} else {
			System.out.println("Error - This employee has insufficient permissions to access this method");
		}
		
	}
	
	/**
	 * Called by the TechnicalSupport class to clear the repository (set all values in the list to null). Checks wether the employee has the permissions to call this method by checking the repository id (int repoID).
	 * @param id employees repoID
	 */
	public void clearRepository(int id) {
		
		if (id == -2) {
			this.optimalAlignment = null;
			for (Alignment a: alignmentList) {
				alignmentList.set(alignmentList.indexOf(a), null);
			}
		} else {
			System.out.println("Error - This employee has insufficient permissions to access this method");
		}
		
	}
	
	public void restoreRepository(int id, AlignmentRepo backup, EmployeeList el) {
		this.optimalAlignment = backup.getOptimalAlignment();
		
		if (id == -2) {
			for (int i = 0; i < alignmentList.size() ; i++) {
				if (alignmentList.get(i) == null) {
					continue;
				} else {
					alignmentList.set(i, backup.getRepository().get(i));
					Employee myEmployee = el.getEmployeeList().get(i);
					if (myEmployee instanceof BioInformatician) {
						BioInformatician bi = (BioInformatician)myEmployee;
						bi.setAlignment(backup.getRepository().get(i));
					}
				}
			}
		} else {
			System.out.println("Error - This employee has insufficient permissions to access this method");
		}
		
	}
	
}