package main;

public class Frozen {

	public static void main(String[] args) {

		String[] clientname = { "Anna", "Elsa", "Olaf", "Hans", "Kristoff" };
		double[] accountbalance = { 1000, 5000, 9, 55, 23 };

		for (int i = 1; i < 5; i++) {
			System.out.println(clientname[i] + " has " + accountbalance[i] + " dollars. \n");
		}
		
	}

}
