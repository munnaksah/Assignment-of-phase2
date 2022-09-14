package coffeshop;

public class Chocolate extends BeverageDecorator {

	int ChocolateCost;

	Chocolate(Beverage beverage, int ChocolateCost) {
		this.beverage = beverage;
		this.ChocolateCost = ChocolateCost;

	}

	@Override
	public int getCost() {

		return beverage.getCost() + ChocolateCost;
	}

	@Override
	public String getDescription() {

		return beverage.getDescription() + " topped with Chocolate";
	}

}
