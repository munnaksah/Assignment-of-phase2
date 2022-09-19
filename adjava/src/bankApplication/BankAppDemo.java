package bankApplication;

import java.util.List;
import java.util.Scanner;

public class BankAppDemo {

	static void showmenu(BankAccount bankAccount) throws DepositException, MinBalanceException {
		System.out.println("Welcome Account Number: " + bankAccount.getaccountNumber() + " \nAccount Type "
				+ bankAccount.getType());
		boolean flag = true;
		while (flag) {
			System.out.println("Please Select an option below: ");
			System.out.println("Press 1 to Deposit Amount.");
			System.out.println("Press 2 to Withdraw Amount.");
			System.out.println("Press 3 to TransactionHistory");
			System.out.println("Press 4 to Get Mini Statement");
			System.out.println("Press 5 to Get Minimum Balance");
			System.out.println("Press 6 to Get Current Balance");
			System.out.println("Press 7 to Get Interest Rate");
			System.out.println("Press 8 key Cancel & Exit");
			System.out.println(" ");

			try {
				Scanner scanner = new Scanner(System.in);
				int option = scanner.nextInt();

				switch (option) {
				case 1:
					System.out.println("Please Enter the amount to be deposited: ");
					double depamt = scanner.nextDouble();
					bankAccount.deposit(depamt);

					break;
				case 2:
					System.out.println("Please Enter the amount to withdraw:");
					double withamt = scanner.nextDouble();
					bankAccount.withdraw(withamt);
					break;
				case 3:
					System.out.println("Transaction History:");
					List<Transaction> list = bankAccount.getTransactionHistory();
					list.stream().forEach(
							i -> System.out.println(i.getTransactionId() + " " + i.getType() + " " + i.getAmount()));
					break;
				case 4:
					System.out.println("Mini Statement");
					List<Transaction> miniStmt = bankAccount.getMiniStatement();
					miniStmt.stream().forEach(
							i -> System.out.println(i.getTransactionId() + " " + i.getType() + " " + i.getAmount()));
					break;
				case 5:
					System.out.println("Minimum Balance");
					System.out.println(bankAccount.getMinimumBalance());
					break;
				case 6:
					System.out.println("Your Account Balance is " + bankAccount.getCurrentBalance() + " Rupees");
					System.out.println(" ");
					break;
				case 7:
					System.out.println("Interest Rate: is" + bankAccount.getInterestRate());
					break;

				default:
					System.out.println("Transaction Ended");
					flag = false;
					break;
				}
			} catch (Exception e) {
				System.out.println(e);

				System.out.println("------------------------Try Again-----------------------------");
			}
		}
	}

	public static void main(String args[]) throws AccountNotFoundException, DepositException, MinBalanceException {

		HeadOffice headOffice = new HeadOffice();
		headOffice.createBranch("B0");

		headOffice.createBranch("B1");
//        branch1.

		Customer c = new Customer();
		c.setPanNumber("TKG643Z");

		Branch b = headOffice.getBranchById("1");
		// BankAccount bankAccount = new SavingAccount();

		b.createBankAccount("LKJH651V", "Saving", 10000.0);
		// Getting BankAccount from bank accno
		BankAccount savingsAcno = b.getAccountByAccountNumber("1");
		// showmenu(savingsAcno); //to test for savings account
		b.createBankAccount("ABCDEFG", "Current", 10000.0);

		BankAccount currAcno = b.getAccountByAccountNumber("2");
		showmenu(currAcno); // to test for cur account
	}

}
