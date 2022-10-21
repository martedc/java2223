package main;

public class Customer {
	
	String name;
	int age;
	private boolean isMarried;
	final static int adultAge = 18;

		public Customer(String customerName, int customerAge, boolean customerMaritalStatus){
			name = customerName;
			age = customerAge;
			isMarried = customerMaritalStatus;
		}

		public boolean isAdult(){
			return (age >= adultAge);
		}

		public static void main(String[] args){
			Customer myFirstCustomer = new Customer("Maria", 19, false);
		}
}
