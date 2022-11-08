package main;

public abstract class Employee extends Person implements SalaryCalculation {

	int employeeID;

	public Employee(String name, String gender, int id) {
		super(name, gender);
		this.employeeID = id;
	}
	
}
