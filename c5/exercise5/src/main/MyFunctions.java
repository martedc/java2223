package main;

public class MyFunctions {

	public static int f(int x) {

		int total = 1;

		if (x < 0) {
			return -1;
		}

		int i = 1;
		while (i < x) {
			i++;
			total = total * i;
		}
		return total;

	}

	public static int[] fList(int y) {

		
		int[] returnList;
		returnList = new int[y];
		
		int i = 0;
		while (i < y) {
			returnList[i] = f(i);
			i++;
		}

		return returnList;

	}

	public static void main(String[] args) {
		
		System.out.println(fList(8));
		
	}

}
