package main;

public class Patterns {

	public static void upperTriangle(int num) {

		for (int i = 0; i < num; i++) {
			System.out.print("*".repeat(num - i) + "\n");
		}

	}

	public static void lowerTriangle(int num) {

		for (int i = num - 1; i != -1; i--) {
			System.out.print(" ".repeat(i) + "*".repeat(num - i) + "\n");
		}

	}

	public static void diamond(int num) {

		int i = 1;

		do {

			if (i < num) {
				System.out.print(" ".repeat(num - i) + "*".repeat((i * 2) - 1) + " ".repeat(num - i) + "\n");
			}

			if (i == num) {
				System.out.print("*".repeat((num * 2) - 1) + "\n");
			}

			if (i > num) {
				System.out.print(
						" ".repeat(-num + i) + "*".repeat((num - (-num + i)) * 2 - 1) + " ".repeat(-num + i) + "\n");
			}
			i++;
		} while (i < num * 2);
	}

	public static void main(String[] args) {
		lowerTriangle(10);
		System.out.print("\n");
		upperTriangle(3);
		System.out.print("\n");
		diamond(8);
	}

}
