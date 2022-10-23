package main;

public class NotSoSmartCity {

	private String[] inhabitantNames;
	private int nbInhabitants;
	private double totalAmountOfMoney;
	private String name;

	public NotSoSmartCity(String name, int nbInhabitants, double totalAmountOfMoney, String[] inhabitantNames) {
		this.name = name;
		this.nbInhabitants = nbInhabitants;
		this.totalAmountOfMoney = totalAmountOfMoney;
		this.inhabitantNames = inhabitantNames;
	}

	public void printCityNameForEachInhabitant() {
		for (int i = nbInhabitants; i != 0; i--) {
			System.out.println(this.name);
		}
	}

	public double getAverageAmountOfMoney() {
		return totalAmountOfMoney / nbInhabitants;
	}

	public static String babyNameGenerator(String beginning, int lettersToAdd) {
		if (0 == lettersToAdd) {
			return beginning;
		} else {
			return babyNameGenerator(beginning + getRandomLetter(), lettersToAdd - 1);
		}
	}

	private static char getRandomLetter() {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		return alphabet.charAt((int) (Math.random() * alphabet.length()));
	}

	public void printInhabitantNames() {
		for (int i = 0; i < nbInhabitants; i++) {
			System.out.println(inhabitantNames[i]);
		}
	}

	public static void main(String[] args) {

		// Nullpointerexception trigger
		// System.out.println(NotSoSmartCity.babyNameGenerator("Jos", -1));

		// ArrayIndexOutOfBoundsException trigger
		// String[] inhabitantsArray = {};
		// NotSoSmartCity hallow = new NotSoSmartCity("Hallow", 64209 , 80654384, inhabitantsArray);
		// hallow.printInhabitantNames();

		// StackOverflowError trigger
		// NotSoSmartCity hallow = new NotSoSmartCity("Hallow", 64209 , 80654384, null); 
		// hallow.printInhabitantNames();

		// Infinite loop trigger
		// String[] inhabitantsArray = {};
		// NotSoSmartCity hallow = new NotSoSmartCity("Hallow", -1, 80654838, inhabitantsArray);
		// hallow.printCityNameForEachInhabitant();

	}

}
