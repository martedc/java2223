package entities;

public class Dog extends Animal {

	private final int matureAge = 1;
	private String name;
	private final String breed;
	
	public Dog(String name, int age, String breed) {
		super(age);
		this.setName(name);
		this.breed = breed;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	@Override
	public boolean isFullyGrown() {
		if (this.getAge() >= matureAge) {
			return true;
		}
		return false;
	}

}
