package bankApplication;

public class SavingAccount extends BankAccount {
	public static final double minimumBalance = 10000.0;
	public static final double interestRate = 4.5;

	public String getType() {

		return "Saving";
	}

	public double getMinimumBalance() {

		return minimumBalance;

	}

	public double getInterestRate() {

		return interestRate;

	}

}
