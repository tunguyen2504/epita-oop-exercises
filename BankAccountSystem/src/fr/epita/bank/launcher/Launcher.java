package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.SavingAccount;

public class Launcher {

	public static void main(String[] args) {
		SavingAccount savingAccount = new SavingAccount();
		double interest = savingAccount.computeInterest();
		System.out.println(interest);
		savingAccount.withDraw(300);
		System.out.println(savingAccount.getBalance());
	}

}
