package entities;

public class Bee extends Animal {
	
	private final int matureAge = 0;

	public Bee(int age) {
		super(age);
	}
	
	@Override
	public boolean isFullyGrown() {
		if (this.getAge() >= matureAge) {
			return true;
		}
		return false;
	}
	
}
