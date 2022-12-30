package entities;

public abstract class Plant implements Growable {

	private int growth;
	private final double maxGrowth = 100;
	
	public Plant(int growth) {
		this.growth = growth;
	}
	
	
	public void grow() {
		growth += 1;
	}
	
	public boolean isFullyGrown() {
		if (growth >= maxGrowth) {
			return true;
		} else {
			return false;
		}
	}
	
}
