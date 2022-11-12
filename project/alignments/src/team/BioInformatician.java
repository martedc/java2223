package team;

import bio.*;

public class BioInformatician extends Employee {
	
	private Alignment alignment;

	// constructor class, Bioinformatician is a subclass of Employee
	public BioInformatician(String firstName, String lastName, int experience, Alignment alignment) {
		super("Bioinformatician",firstName,lastName,experience);
		this.setAlignment(alignment);
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
		if (alignment != null) {
			System.out.println("Setting alignment for " + this.getFirstName() + " " + this.getLastName());
		}
	}

}
