package main;

import java.util.*;

public class Infinity {

	public static void main(String[] args) {

		List<byte[]> list = new LinkedList<>();
		int i = 0;

		try {
			while (true) {

				byte[] b = new byte[10 * 1024 * 1024]; // 10MB byte object
				list.add(b);
				Runtime rt = Runtime.getRuntime();
				System.out.printf("[%3s] Available heap memory: %s%n", i++, rt.freeMemory());

			}
		} catch (OutOfMemoryError e) {
			System.out.println("Memory full!");
		}

	}

}
