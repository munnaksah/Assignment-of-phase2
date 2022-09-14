package coffeshop;

public class Honey extends BeverageDecorator {
	int honeyCost;

	Honey(Beverage beverage, int honeyCost) {
		this.beverage = beverage;
		this.honeyCost = honeyCost;

	}

	@Override
	public int getCost() {

		return beverage.getCost() + honeyCost;
	}

	@Override
	public String getDescription() {

		return beverage.getDescription() + " topped with honey";
	}

}
