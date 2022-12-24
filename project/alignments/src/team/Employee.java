package team;

/**
 * Employee is an abstract class which has BioInformatician, TeamLead and TechnicalSupport as subclasses. 
 * @author Marten De Cock r0800075
 *
 */
public abstract class Employee {

	private String function;
	private String firstName;
	private String lastName;
	private int experience;
	private int repoID;

	/**
	 * Constructor method for the Employee class. 
	 * @param function function of the employee
	 * @param firstName first name of the employee
	 * @param lastName last name of the employee
	 * @param experience experience in years of the employee
	 * @param repoID identifier in the repository [-2, infinity]
	 */
	public Employee(String function, String firstName, String lastName, int experience, int repoID) {
		this.setFunction(function);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setExperience(experience);
		this.setRepoID(repoID);
	}

	/**
	 * @return function of the employee
	 */
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

	/**
	 * @param function function of the employee
	 */
	public void setFunction(String function) {
		this.function = function;
	}

	/**
	 * @return first name of the employee
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName first name of the employee
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return last name of the employee
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName last name of the employee
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return experience of the employee
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * @param experience experience of the employee
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * @return repository id of the employee
	 */
	public int getRepoID() {
		return repoID;
	}

	/**
	 * @param repoID repository of the employee
	 */
	public void setRepoID(int repoID) {
		this.repoID = repoID;
	}

}
