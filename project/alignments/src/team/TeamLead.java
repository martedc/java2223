package team;

import bio.*;

public class TeamLead extends Employee {

	// constructor method, TeamLead is a subclass of Employee
	public TeamLead(String firstName, String lastName, int experience) {
		super("TeamLead",firstName,lastName,experience);
	}
	
	// copy alignment from Bioinformatician to the shared alignment
	public void setRepoAlignment(AlignmentRepo repo, Alignment a, BioInformatician bi) {
		repo.setAlignment(a);
		System.out.println(this.getFunction() + " " + this.getFirstName() + " " + this.getLastName() + " promoted alignment from " + bi.getFirstName() + " " + bi.getLastName() + " to the shared alignment");
	}
	
	// copy shared alignment to Bioinformatician's personal alignment
	public void setUserAlignment(AlignmentRepo repo, BioInformatician bi) {
		bi.setAlignment(repo.getAlignment());
		System.out.println("Copying shared alignment to " + bi.getFirstName() + " " + bi.getLastName());
	}
	
}