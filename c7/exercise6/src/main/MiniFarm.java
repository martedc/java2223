package main;

import entities.*;
import java.util.List;
import java.util.ArrayList;

public class MiniFarm {
	
	private Farmer farmer;
	private List<Animal> animalList = new ArrayList<Animal>();
	
	public MiniFarm(Farmer farmer) {
		this.setFarmer(farmer);
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	
	public void addAnimal(Animal a) {
		this.animalList.add(a);
	}
	
	public void removeAnimal(Animal a) {
		this.animalList.remove(a);
	}

	public void listAnimals() {
		System.out.println(this.animalList);
	}
	
}
