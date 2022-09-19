package bankApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Branch {
	public static AtomicInteger ACCOUNT_NUM_GENERATOR = new AtomicInteger(0);
	private List<BankAccount> bankAccounts;
	private List<Customer> customers;
	private String branchId;

	public void createBankAccount(String panNumber, String type, double amount) {
		BankAccount bankAccount = null;
		if (type == "Saving") {
			bankAccount = new SavingAccount();

		} else if (type == "Current") {
			bankAccount = new CurrentAccount();
		}
		int accountNum = ACCOUNT_NUM_GENERATOR.incrementAndGet();
		bankAccount.setAccountNumber(Integer.toString(accountNum));
		bankAccount.setcurrentBalance(amount);
		Customer existingCust = getCustomerByPan(panNumber);
		if (existingCust != null) {
			existingCust.setBankAccounts(bankAccount);
		} else {
			Customer customer = new Customer();
			customer.setBankAccounts(bankAccount);
			customer.setPanNumber(panNumber);
			// Adding Customer to Customers List
			if (customers == null) {
				customers = new ArrayList<>();
			}
			customers.add(customer);

			// Adding Bankacc to bankAccounts List
			if (bankAccounts == null) {
				bankAccounts = new ArrayList<>();
			}
			bankAccounts.add(bankAccount);
		}

	}

	@Override
	public String toString() {
		return "Branch [bankAccounts=" + bankAccounts + ", customers=" + customers + ", branchId=" + branchId + "]";
	}

	public Customer getCustomerByPan(String panNumber) {
		if (customers != null) {
			for (Customer customer : customers) {
				if (customer.getPanNumber().equals(panNumber)) {
					return customer;
				}
			}
		}
		return null;

	}

	public BankAccount getAccountByAccountNumber(String accountNumber) throws AccountNotFoundException {
		for (BankAccount bankAccount : bankAccounts) {
			if (bankAccount.getaccountNumber().equals(accountNumber)) {
				return bankAccount;
			}
		}
		throw new AccountNotFoundException("No Account found with this account number: " + accountNumber);
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		// TODO Auto-generated method stub
		this.branchId = branchId;

	}

}
