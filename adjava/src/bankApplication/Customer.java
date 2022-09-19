package bankApplication;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String panNumber;
	private List<BankAccount> accounts;
	private BankAccount bankAccount;

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setBankAccounts(BankAccount bankAccount) {
		if (accounts == null) {
			accounts = new ArrayList<>();
		}
		accounts.add(bankAccount);
	}

	@Override
	public String toString() {
		return "Customer [accounts=" + accounts + ", panNumber=" + panNumber + "]";
	}

}
