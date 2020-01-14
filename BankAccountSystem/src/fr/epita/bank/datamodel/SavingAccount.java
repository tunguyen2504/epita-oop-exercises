package fr.epita.bank.datamodel;

public class SavingAccount extends Account {
	private double interestRate;

	public SavingAccount() {

	}

	public double computeInterest() {
		double interest = this.balance * interestRate;

		return interest;
	}

	public void withDraw(double amount) {
		this.balance -= amount;
	}
}
