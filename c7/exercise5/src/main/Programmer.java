package main;

public class Programmer extends Employee {
	
	String favoriteProgrammingLanguage;
	int linesOfCodeWritten;
	
	public Programmer(String name, String gender, int employeeID, String fav, int codeWritten) {
		super(name, gender, employeeID);
		this.favoriteProgrammingLanguage = fav;
		this.linesOfCodeWritten = codeWritten;
	}
	
	public void calculateSalary() {
		if (this.favoriteProgrammingLanguage == "Java") {
			double salary = (10000 + this.linesOfCodeWritten)*2;
		}
		double salary = (10000 + this.linesOfCodeWritten);
	}
	
}

