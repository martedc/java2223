package main;

public class Truck extends Vehicle {

	private double maxPayload;

	public Truck(double topSpeed, double mass, double maxPayload) {
		super(topSpeed, mass);
		this.setMaxPayload(maxPayload);
	}

	public double getMaxPayload() {
		return this.maxPayload;
	}

	public void setMaxPayload(double newMaxPayload) {
		this.maxPayload = newMaxPayload;
	}
	
	@Override
	public double calculateValue() {
		return super.calculateValue()*(this.getMaxPayload()/1000);
	}

}
