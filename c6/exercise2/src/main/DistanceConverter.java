package main;

public class DistanceConverter {

	// constructor method
	public DistanceConverter() {
	}

	// method to convert distance from miles to km
	public double convert(double dist_miles) {

		// define conversion factor
		double oneMileInKM = 1.609;
		double dist_km;
		dist_km = dist_miles * oneMileInKM;

		return dist_km;

	}

}
