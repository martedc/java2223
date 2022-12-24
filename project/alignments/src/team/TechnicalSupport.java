package team;

import bio.*;

/**
 * TechnicalSupport is a subclass of Employee. It has an additional variable backup, which is a backup for the alignment repository.
 * @author Marten De Cock r0800075
 *
 */
public class TechnicalSupport extends Employee {
	
	private AlignmentRepo backup;
	
	/**
	 * Constructor method for the TechnicalSupport class.
	 * @param firstName first name of the employee
	 * @param lastName last name of the employee
	 * @param experience experience in years of the employee
	 * @param backup backup of the repository
	 * @param repoID identifier in the repository [-2]
	 */
	public TechnicalSupport(String firstName, String lastName, int experience, AlignmentRepo backup, int repoID) {
		super("TechnicalSupport",firstName,lastName,experience, repoID);
		this.setBackup(backup);
	}
	
	/**
	 * @return backup of the repository
	 */
	public AlignmentRepo getBackup() {
		return backup;
	}

	/**
	 * @param backup backup of the repository
	 */
	public void setBackup(AlignmentRepo backup) {
		
		if (this.getBackup() != null) {
			AlignmentRepo newBackup = new AlignmentRepo(backup);
			System.out.println("Technical support " + this.getFirstName() + " making a backup" + '\n');
			this.backup = newBackup;
		} else {
			this.backup = backup;
		}
		
	}
	
	/**
	 * Restores the repository to the backup of the TechnicalSupport.
	 * @param repo which alignment repository to restore the backup to
	 */
	public void restoreRepository(AlignmentRepo repo) {
		System.out.println("Technical support " + this.getFirstName() + " restoring repository from backup" + '\n');
		
		repo.setRepository(this.getBackup().getRepository());
		repo.setOptimalAlignment(this.getBackup().getOptimalAlignment(), getRepoID());
	}

	/**
	 * Clears the alignment repository (sets all values to null).
	 * @param repo which alignment repository to clear
	 */
	public void clearRepository(AlignmentRepo repo) {
		System.out.println("Technical support " + this.getFirstName() + " clearing repository" + '\n');
		
		repo.clearRepository(this.getRepoID());
	}
	
}