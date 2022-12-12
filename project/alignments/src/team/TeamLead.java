package team;

import bio.*;

public class TeamLead extends Employee {

	// constructor method, TeamLead is a subclass of Employee
	public TeamLead(String firstName, String lastName, int experience, int repoID) {
		super("TeamLead",firstName,lastName,experience, repoID);
	}
	
	public void setOptimalAlignment(AlignmentRepo repo) {
		repo.setOptimalAlignment(this.getRepoID());
	}
}