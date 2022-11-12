package team;

public abstract class Employee {

	// variables for an employee
	private String function;
	private String firstName;
	private String lastName;
	private int experience;

	// constructor class: function, first name, last name and years of experience
	public Employee(String function, String firstName, String lastName, int experience) {
		this.setFunction(function);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setExperience(experience);
	}

	// getters and setters for variables
	public String getFunction() {
		if (this.function == "TeamLead") {
			return "Team Lead";
		} else if (this.function == "Bioinformatician") {
			return function;
		} else if (this.function == "TechnicalSupport") {
			return "Technical Support";
		} else {
			return function;
		}
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}
