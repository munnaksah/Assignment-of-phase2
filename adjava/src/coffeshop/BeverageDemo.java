package coffeshop;

public class BeverageDemo {

	public static void main(String[] args) {

		Beverage b1 = new Coffe(100);
		b1 = new Caramel(b1, 30);
		b1 = new Cream(b1, 40);
		printCoffee(b1);

	}

	private static void printCoffee(Beverage c) {
		System.out.println("Cost: " + c.getCost() + ", Description: " + c.getDescription());
	}

}
