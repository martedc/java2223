package entities;

public class Cow extends Animal {

	private final int matureAge = 1;
	private final String breed;
	
	public Cow(int age, String breed) {
		super(age);
		this.breed = breed;
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
