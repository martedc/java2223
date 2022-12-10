package team;

import java.util.List;

public class EmployeeList {

	private List<Employee> employeeList;

	// constructor method
	public EmployeeList(List<Employee> list) {
		this.setEmployeeList(list);
	}

	// getter and setter methods
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> list) {
		this.employeeList = list;
	}
	
	// get a specific Employee in the list by giving the place in the list
	public Employee getEmployeeN(int n) {
		return employeeList.get(n);
	}

	// prints an overview of all the Employees
	public void printEmployees() {
		String newLine = System.lineSeparator();
		
		System.out.println(newLine + "### Team members:" + newLine);
		for (Employee e : employeeList) {
			System.out.println("Name: " + e.getFirstName() + " " + e.getLastName());
			System.out.println("Function: " + e.getFunction());
			System.out.println("Experience: " + e.getExperience() + " years" + newLine);
		}
		System.out.println("###" + newLine);
	}
	
}
