package team;

import bio.*;
import java.time.LocalDateTime;

/**
 * TechnicalSupport is a subclass of Employee. It has an additional variable backup, which is a backup for the alignment repository.
 * @author Marten De Cock r0800075
 *
 */
public class TechnicalSupport extends Employee {
	
	private AlignmentRepo backup;
	private LocalDateTime backupDateTime;
	
	/**
	 * Constructor method for the TechnicalSupport class.
	 * @param firstName first name of the employee
	 * @param lastName last name of the employee
	 * @param experience experience in years of the employee
	 * @param repoID identifier in the repository [-2]
	 */
	public TechnicalSupport(String firstName, String lastName, int experience, int repoID) {
		super("TechnicalSupport",firstName,lastName,experience, repoID);
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
		LocalDateTime myObj = LocalDateTime.now();
		this.setBackupDateTime(myObj);
		
		if (this.getBackup() != null) {
			AlignmentRepo newBackup = new AlignmentRepo(backup);
			System.out.println("Technical support " + this.getFirstName() + " making a backup" + '\n');
			this.backup = newBackup;
		} else {
			this.backup = backup;
		}
		
	}
	
	public LocalDateTime getBackupDateTime() {
		return backupDateTime;
	}

	public void setBackupDateTime(LocalDateTime backupDateTime) {
		this.backupDateTime = backupDateTime;
	}
	
	/**
	 * Restores the repository to the backup of the TechnicalSupport.
	 * @param repo which alignment repository to restore the backup to
	 */
	public void restoreRepository(AlignmentRepo repo, EmployeeList el) {
		System.out.println("Technical support " + this.getFirstName() + " restoring repository from backup" + '\n');
		
		// repo.setRepository(this.getBackup().getRepository());
		// repo.setOptimalAlignment(this.getBackup().getOptimalAlignment(), getRepoID());
		repo.restoreRepository(this.getRepoID(),this.getBackup(),el);
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