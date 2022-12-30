package main;

public class Customer {
	
	final private String name;
	private int nrBlueberry;
	private int nrChocolate;
	private int nrRedvelvet;
	private int totalCost;

	public Customer(String n, int b, int c, int r) {
		this.name = n;
		this.setNrBlueberry(b);
		this.setNrChocolate(c);
		this.setNrRedvelvet(r);
	}

	public String getName() {
		return name;
	}

	public int getNrBlueberry() {
		return nrBlueberry;
	}

	public void setNrBlueberry(int nrBlueberry) {
		this.nrBlueberry = nrBlueberry;
	}

	public int getNrChocolate() {
		return nrChocolate;
	}

	public void setNrChocolate(int nrChocolate) {
		this.nrChocolate = nrChocolate;
	}

	public int getNrRedvelvet() {
		return nrRedvelvet;
	}

	public void setNrRedvelvet(int nrRedvelvet) {
		this.nrRedvelvet = nrRedvelvet;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int bp, int cp, int rp) {
		this.totalCost = this.nrBlueberry*bp + this.nrChocolate*cp + this.nrRedvelvet*rp;
	}
	
	public void printInvoice() {
		System.out.println("### Customer " + this.name + "'s invoice ###");
		System.out.println("Blueberry: " + this.nrBlueberry);
		System.out.println("Chocolate: " + this.nrChocolate);
		System.out.println("Red Velvet: " + this.nrRedvelvet);
		System.out.println("Total cost: " + this.totalCost + " Euro" + '\n');
	}
}
