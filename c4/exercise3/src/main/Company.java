package main;

public class Company {
	String companyName;
	String location;

		public Company(String name, String companyLocation){
			companyName = name;
			location = companyLocation;
		}

	public boolean isBelgian(){
	return location.equals("Belgium");

	}
}
