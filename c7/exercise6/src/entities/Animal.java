package entities;

public abstract class Animal implements Feedable, Growable {
	
	private int age;
	
	public Animal(int age) {
		this.setAge(age);
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void feed() {
		
	}
	
	public boolean isHungry() {
		
		return false;
	}
	
	public void grow() {
		this.age += 1;
	}

}
