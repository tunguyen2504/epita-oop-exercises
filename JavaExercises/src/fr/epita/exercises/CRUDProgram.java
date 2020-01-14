package fr.epita.exercises;

import java.util.Scanner;

public class CRUDProgram {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean isAuthenticated = authenticate(scanner);

		if (!isAuthenticated) {
			System.exit(401);
		} else {
			String option = "";
			while (!option.equals("4")) {
				createMenu();
				option = scanner.nextLine();
				switch (option) {
				case "1":
					System.out.println("Create.");
					break;
				case "2":
					System.out.println("Update.");
					break;
				case "3":
					System.out.println("Delete.");
					break;
				case "4":
					System.out.println("Program finished.");
					break;
				default:
					System.out.println("Invalid input.");
					break;
				}
			}
		}
	}

	public static boolean authenticate(Scanner scanner) {
		System.out.println("Username: ");
		String userName = scanner.nextLine();
		System.out.println("Password: ");
		String password = scanner.nextLine();

		if (userName.equalsIgnoreCase("ADMIN") && password.equals("123")) {
			return true;
		} else {
			return false;
		}
	}

	public static void createMenu() {
		System.out.println("MENU");
		System.out.println("\n1. Create");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Exit");
		System.out.println("Please choose an option: ");
	}
}
