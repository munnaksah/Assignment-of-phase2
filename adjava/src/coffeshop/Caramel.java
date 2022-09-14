package coffeshop;

public class Caramel extends BeverageDecorator {

	int CaramelCost;

	Caramel(Beverage beverage, int caramelCost) {
		this.beverage = beverage;
		this.CaramelCost = caramelCost;

	}

	@Override
	public int getCost() {

		return beverage.getCost() + CaramelCost;
	}

	@Override
	public String getDescription() {

		return beverage.getDescription() + " tooped with Caramel";
	}

}
