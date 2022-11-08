package main;

public class Building {

	private int availableSpace;
	private String address;

	public Building(int availableSpace, String address) {
		this.setSpace(availableSpace);
		this.setAddress(address);
	}
	
	public Building(int availableSpace) {
		this.setSpace(availableSpace);
		this.setAddress("Unknown");
	}

	public void setSpace(int space) {
		int tempSpace = space;
		if (space <= 0) {
			throw new ArithmeticException("The space cannot be negative!");
		}
		this.availableSpace = tempSpace;
	}
	
	public int getSpace() {
		return this.availableSpace;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String toString() {
		if (address != "Unknown") {
			return "This is a building with " + this.getSpace() + " square meters of floor space, located at " + this.getAddress() + ".";
		}
		return "This is a building with " + this.getSpace() + " square meters of floor space, the address is unknown.";
	}
	
	public static void main(String[] args) {
		Building myBuilding = new Building(25,"Vaartstraat 9, 3000 Leuven");
		Building myUnknownBuilding = new Building(54);
		Building myIlligalBuilding = new Building(0, "Legestraat, 1412 Sinterklaasdorp");
		System.out.println(myBuilding.toString());
		System.out.println(myUnknownBuilding.toString());
		System.out.println(myIlligalBuilding.toString());
	}
	
}