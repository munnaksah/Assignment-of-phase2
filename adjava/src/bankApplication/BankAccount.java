package bankApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BankAccount {
	private String accountNumber;
	private double minimumBalance;
	private double currentBalance;
	private double interestRate;
	private List<Transaction> transactions;
	private static AtomicInteger TRANSACTION_ID_GENERATOR = new AtomicInteger(0);

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + "]";
	}

	public void setcurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public void withdraw(double amount) throws MinBalanceException {
		// System.out.println("minimumBalance :" + minimumBalance);
		// System.out.println("currentBalance :" + currentBalance);
		if (this.getType().equals("Savings")) {

			if ((currentBalance - amount) < SavingAccount.minimumBalance) {
				throw new MinBalanceException(
						"Unable to withdraw, Please maintain minimum balance always: CurrentBalance:" + currentBalance
								+ "\n Minimum balance: " + SavingAccount.minimumBalance);
			}
		} else {
			if ((currentBalance - amount) < CurrentAccount.minimumBalance) {
				throw new MinBalanceException(
						"Unable to withdraw, Please maintain minimum balance always: currentBalance: " + currentBalance
								+ "\n Min Balance: " + CurrentAccount.minimumBalance);
			}
		}

		synchronized (this) {
			currentBalance -= amount;
			Transaction transaction = new Transaction();
			String transactionId = Integer.toString(TRANSACTION_ID_GENERATOR.incrementAndGet());
			transaction.setTransactionId(transactionId);
			transaction.setAmount(amount);
			transaction.setType("Withdraw");
			if (transactions == null) {
				transactions = new ArrayList<>();
			}
			transactions.add(transaction);
		}
	}

	public void deposit(double amount) throws DepositException {
		if (amount < 0) {
			throw new DepositException("Deposit amount should be greater than 0, deposit amount: " + amount);
		}
		synchronized (this) {
			currentBalance += amount;
			Transaction transaction = new Transaction();
			String transactionId = Integer.toString(TRANSACTION_ID_GENERATOR.incrementAndGet());
			transaction.setTransactionId(transactionId);
			transaction.setType("Deposit");
			transaction.setAmount(amount);
			if (transactions == null) {
				transactions = new ArrayList<>();
			}
			transactions.add(transaction);
		}
	}

	public List<Transaction> getTransactionHistory() {
		return transactions;
	}

	public List<Transaction> getMiniStatement() {
		List<Transaction> miniStatement = new ArrayList<>();
		int count = 0;
		ListIterator<Transaction> listIterator = transactions.listIterator(transactions.size());
		while (listIterator.hasPrevious()) {
			miniStatement.add(listIterator.previous());
			count++;
			if (count > 10) {
				break;
			}
		}
		return miniStatement;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public String getaccountNumber() {
		return accountNumber;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public abstract double getMinimumBalance();

	public abstract double getInterestRate();

	public abstract String getType();

}