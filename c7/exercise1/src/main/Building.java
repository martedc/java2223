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

	public void setSpace(int space) throws IlligalArgumentException {
		tempSpace = space;
		if (space <= 0) {
			throw new IlligalArgumentException(space)
		}
		this.availableSpace = tempSpace;
	}
	
	public int getSpace() {
		return this.availableSpace;
	}
	
	public void setAddress(String address) {
		this.address = address
	}
	
	public String getAddress() {
		return this.availableSpace;
	}
	
	public String toString() {
		if (address != "Unknown") {
			System.out.println("This is a building with " + this.getSpace() + " square meters of floor space, located at " + this.getAddress() + ".");
		}
		System.out.println("This is a building with " + this.getSpace() + " square meters of floor space, the address is unknown.");
	}
	
	public void main(String[] args) {
		Building myBuilding = new Building(82,"Vaartstraat 9, 3000 Leuven");
		Building myUnknownBuilding new Buildling(54);
		myBuildling.toString();
		myUnkownBuildling.toString();
	}
	
}
