package main;

import entities.*;

public class Main {

	public static void main(String[] args) {
		Farmer myFarmer1 = new Farmer("Jos");
		MiniFarm myFarm = new MiniFarm(myFarmer1);

		Dog myDog = new Dog("Kakske", 1, "Border Collie");
		Cow myCow1 = new Cow(1, "Limousin");
		Cow myCow2 = new Cow(0, "Limousin");
		Cow myCow3 = new Cow(5, "Limousin");
		Cow myCow4 = new Cow(2, "Limousin");
		
		myFarm.addAnimal(myDog);
		myFarm.addAnimal(myCow1);
		myFarm.addAnimal(myCow2);
		myFarm.addAnimal(myCow3);
		myFarm.addAnimal(myCow4);
		
		myFarm.listAnimals();
	}

}
