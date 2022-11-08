package main;

public class SalesPerson extends Employee {

	int itemsSold;

	public SalesPerson(String name, String gender, int employeeID, int itemsSold) {
		super(name, gender, employeeID);
		this.itemsSold = itemsSold;
	}
	
	public void calculateSalary() {
		double salary = this.itemsSold*10;
	}

}
