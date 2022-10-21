package main;

public class Person {
	String name;
	int age;
	boolean isMarried;
	
		public Person(String personName, int personAge, boolean maritalStatus){
			name = personName;
			age = personAge;
			isMarried = maritalStatus;
		}

		public static void marry(Person p1, Person p2){
			p1.isMarried = true;
			p2.isMarried = true;
	
		}
}
