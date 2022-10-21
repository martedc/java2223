package main;

import java.util.Arrays;

public class PlayerAnalyser {
	
	public static int minGoalsScored(int[] nbGoalsScored){

		Arrays.sort(nbGoalsScored);
		return nbGoalsScored[0];

	}

	public static int maxGoalsScored(int[] nbGoalsScored){

		Arrays.sort(nbGoalsScored);
		return nbGoalsScored[nbGoalsScored.length-1];

	}

	public static double meanGoalsScored(int[] nbGoalsScored){
		
		int count = 0; 
		
			for (int i = 0; i < nbGoalsScored.length; i++) {
			count += nbGoalsScored[i];
			}
			
		return count/nbGoalsScored.length;
		
	}

	public static double medianGoalsScored(int[] nbGoalsScored){

		//Arrays.sort sorts a given list in ascending order
		Arrays.sort(nbGoalsScored);

		if (nbGoalsScored.length % 2 == 0) {
			return (nbGoalsScored[nbGoalsScored.length/2] + nbGoalsScored[(nbGoalsScored.length/2)+1])/2;
		} else {
			return nbGoalsScored[nbGoalsScored.length%2];
		}
		
	}

	public static void main(String[] args){

		int intScoredGoals[] = {2,0,2,1,1};
		
		minGoalsScored(intScoredGoals);
		maxGoalsScored(intScoredGoals);
		meanGoalsScored(intScoredGoals);
		medianGoalsScored(intScoredGoals);

	}
}
