package coffeshop;

public class Coffe implements Beverage {

	int cost;

	public Coffe(int cost) {
		this.cost = cost;

	}

	@Override
	public int getCost() {

		return cost;
	}

	@Override
	public String getDescription() {

		return "coffe";
	}

}
