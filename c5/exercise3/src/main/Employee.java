package main;

public class Employee {
	
	static String employeeType;
	static int tenureCompany;
	
	public Employee(String type, int tenure) {
		employeeType = type;
		tenureCompany = tenure;
	}
	
	public double calculateWage(Employee e) {
		double a = 0.1;
		double wageCEO = 5000;
		double wageMID = 2000;
		double wageCIO = 3000;
		double wageCFO = 3000;
		double wageCLERK = 1000;
		
		
		if (Employee.employeeType == "CEO") {
			return wageCEO*(Employee.tenureCompany*a);
		} else if (Employee.employeeType == "MIDLEVELMANAGER") {
			return wageMID*(Employee.tenureCompany*a);
		} else if (Employee.employeeType == "CIO") {
			return wageCIO*(Employee.tenureCompany*a);
		} else if (Employee.employeeType == "CFO") {
			return wageCFO*(Employee.tenureCompany*a);
		} else {
			return wageCLERK*(Employee.tenureCompany*a);
		}
		
	}
	
}
