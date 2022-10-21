package main;

public class Person {
	String name;
	int age;
	Person spouse;
	
		public Person(String personName, int personAge){
			name = personName;
			age = personAge;
		}

		public static void marry(Person p1, Person p2){
			p1.spouse = p2;
			p2.spouse = p1;
		}

		public Person createClone(){
			Person clone = new Person(name, age);
			Person clonedSpouse = new Person(spouse.name, spouse.age);

			//technically not required
			marry(clone, clonedSpouse);
			return clone;
		}
}
