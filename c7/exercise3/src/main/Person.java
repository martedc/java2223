package main;

public class Person implements PersonalisedPrint, CanSing {

	String name;
	String gender;
	
	public void prettyPrint() {
		System.out.println("=-=-= " + this.name + "=-=-=");
	}
	
	public void sing() {
		System.out.println("21st night of September");
	}
}
