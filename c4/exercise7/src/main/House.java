package main;

public class House {
	int maximum;
	Person[] inhabitants;

		public House(int maximum, Person[] inhabitants){
			this.maximum = maximum;
			this.inhabitants = inhabitants;

		}

	//This method has a void return type, since we do not need it to return any value.

	//Not static as this method operates on the instance variable 'inhabitants' and hence requires an object of the House class.

		public void assessLivingConditions(){
			if(inhabitants.length < maximum){
				System.out.println("There is still room in the house.");
				
			} else if(inhabitants.length == maximum){
				System.out.println("The house is full.");
				
			} else {
				System.out.println("There are too many people living in this house!");

			}

		}

		public static void main(String[] args){

			Person jenny = new Person("Jenny", 22);
			Person forest = new Person("Forest", 24);
			Person dan = new Person("Dan", 23);
			Person bubba = new Person("Bubba", 24);

			int houseOneLimit = 4;
			
			House houseOne = new House(houseOneLimit, new Person[]{jenny, forest, dan, bubba});
			houseOne.assessLivingConditions(); // The house is full
			
			int houseTwoLimit = 25;
			
			House houseTwo = new House(houseTwoLimit, new Person[]{jenny, forest, dan, bubba});
			houseTwo.assessLivingConditions(); //There is still room in the house.
			
			int houseThreeLimit = 1;
			House houseThree = new House(houseThreeLimit, new Person[]{jenny, forest, dan, bubba});
			houseThree.assessLivingConditions(); //There are too many people living in this house!

	}
}
