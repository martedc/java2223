package main;

import java.util.List;
import java.util.Scanner;

import team.Employee;

public class Main {

	public static void main(String[] args) {

		FileEdit fileEdit = new FileEdit();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the file containing the team members: (with extension)");
		String txtName = scan.nextLine();
		//System.out.println("Please enter the file containing the alignment: (with extension)");
		//String fastaName = scan.nextLine();
		List<Employee> employeeList = fileEdit.createEmployeeList(txtName);
		for (Employee e: employeeList) {
			System.out.println();
		}
		
		scan.close();

	}

}
