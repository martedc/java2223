package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class MuffinBakery {
	
	final double blueberryPrice = 3;
	final double chocolatePrice = 2.5;
	final double redvelvetPrice = 3.5;
	static int nrBlueberry;
	static int nrChocolate;
	static int nrRedvelvet;

	public static void main(String[] args) {
		try {
			File orders = new File("src/orders.txt");
			Scanner scan = new Scanner(orders);
			StringTokenizer st;
			Customer myCustomer;
			List<Customer> customerList = new ArrayList<Customer>();
			
			while (scan.hasNextLine()) {
				String str = scan.nextLine();
				
				if (!str.equals("")) {
					st = new StringTokenizer(str);
					String[] strArray = new String[4];
					
					int i = 0;
					while (st.hasMoreTokens()) {
						String token = st.nextToken(",").toString();
						strArray[i] = token;
						i++;
					}
					
					int b = Integer.valueOf(strArray[1]);
					int c = Integer.valueOf(strArray[2]);
					int r = Integer.valueOf(strArray[3]);
					
					myCustomer = new Customer(strArray[0], b, c, r);
					myCustomer.setTotalCost(b, c, r);
					customerList.add(myCustomer);
				} else {
					continue;
				}
			}
			scan.close();
			
			for (Customer c : customerList) {
				nrBlueberry += c.getNrBlueberry();
				nrChocolate += c.getNrChocolate();
				nrRedvelvet += c.getNrRedvelvet();
				c.printInvoice();
			}
			
			System.out.println("### Total orders per type ###");
			System.out.println("Blueberry: " + nrBlueberry);
			System.out.println("Chocolate: " + nrChocolate);
			System.out.println("Red Velvet: " + nrRedvelvet);
			
		} catch (FileNotFoundException fe) {
			System.out.println("Eror - Specified file not found.");
		} 
	}

}
