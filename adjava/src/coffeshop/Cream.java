package coffeshop;

public class Cream extends BeverageDecorator {

	int creamCost;

	Cream(Beverage beverage, int creamCost) {
		this.beverage = beverage;
		this.creamCost = creamCost;

	}

	@Override
	public int getCost() {

		return beverage.getCost() + creamCost;
	}

	@Override
	public String getDescription() {

		return beverage.getDescription() + " topped with cream";
	}

}
