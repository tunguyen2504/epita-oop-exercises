package fr.epita.agefinder.launcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fr.epita.agefinder.datamodel.DateOfBirth;
import fr.epita.agefinder.datamodel.Person;

/**
 * @author Anh Tu NGUYEN - Group 2
 *
 */

public class Launcher {
	private static int currDay, currMonth, currYear;

	public static final void main(String[] args) {
		String option = "";
		Scanner scanner = new Scanner(System.in);
		
		todayInput(scanner);
		while (!option.equals("3")) {
			createMenu(scanner);
			option = scanner.nextLine();
			switch (option) {
			case "1":
				ageFinder(scanner);
				break;
			case "2":
				nearestBirthday(scanner);
				break;
			case "3":
				System.out.println("Exit program...");
				break;
			default:
				System.out.println("Invalid option! Please choose again.");
				break;
			}
		}
		System.out.println("Goodbye!");
		scanner.close();
	}

	//To create main menu
	private static void createMenu(Scanner scanner) {
		System.out.println("\n----------MENU----------");
		System.out.println("1. Age Finder?");
		System.out.println("2. Nearest birthday?");
		System.out.println("3. Exit.");
		System.out.println("Please choose an option: ");
	}

	//To calculate age
	private static void ageFinder(Scanner scanner) {
		int birthDay, birthMonth, birthYear, ageDay, ageMonth, ageYear, numOfDays;

		System.out.println("AGE FINDER");
		System.out.println("____________________________");
		DateOfBirth dob = bDateInput(scanner);
		birthDay = dob.getDay();
		birthMonth = dob.getMonth();
		birthYear = dob.getYear();

		dob.ageCalculate(currDay, currMonth, currYear);
		ageDay = dob.getAgeDay();
		ageMonth = dob.getAgeMonth();
		ageYear = dob.getAgeYear();
		numOfDays = dob.getNumOfDays();

		System.out.println("\nToday is: " + currDay + "/" + currMonth + "/" + currYear);
		System.out.println("Your birthday is: " + birthDay + "/" + birthMonth + "/" + birthYear);
		if (ageDay == 0 && ageMonth == 0 && ageYear == 0) {
			System.out.println("You are born today!");
		} else {
			System.out.println("Your age is: " + ((ageYear > 0) ? (ageYear + " years ") : "")
					+ ((ageMonth > 0) ? (ageMonth + " months ") : "") + ((ageDay > 0) ? (ageDay + " days") : ""));
			System.out.println("Your age in days is: " + numOfDays + " days");
		}
	}

	//To enter list of people with birthday and find the nearest incoming birthday
	private static void nearestBirthday(Scanner scanner) {
		int count = 0;

		List<Person> personList = new ArrayList<Person>();

		System.out.println("NEAREST BIRTHDAY");
		System.out.println("____________________________");
		do {
			System.out.println("Enter name of person " + (count + 1) + ": ");
			String name = scanner.nextLine();
			if (name.equals("0"))
				break;
			DateOfBirth dob = bDateInput(scanner);
			Person person = new Person(name, dob);
			int daysToBirthDay = dob.calculateDaysToBirthday(currDay, currMonth, currYear);
			person.setDaysToBirthDay(daysToBirthDay);
			personList.add(person);
			count++;
		} while (true);
		
		Collections.sort(personList, (p1, p2) -> p1.getDaysToBirthDay() - p2.getDaysToBirthDay());

		System.out.println("Today is: " + currDay + "/" + currMonth + "/" + currYear);
		for (int i = 0; i < personList.size(); i++) {
			Person person = personList.get(i);
			System.out.println((i + 1) + ". " + person.getName() + " " + person.getBirthDay() + " - "
					+ person.getDaysToBirthDay() + " days to birthday.");
		}
	}
	
	//To input current date
	private static void todayInput(Scanner scanner) {
		do {
			System.out.println("Enter current year: ");
			currYear = scanner.nextInt();
			if (currYear < 1)
				System.out.println("Invalid year!");
		} while (currYear < 1);
		do {
			System.out.println("Enter current month: ");
			currMonth = scanner.nextInt();
			if (currMonth < 1 || currMonth > 12)
				System.out.println("Invalid month!");
		} while (currMonth < 1 || currMonth > 12);
		do {
			System.out.println("Enter current date: ");
			currDay = scanner.nextInt();
			if (currDay < 1 || currDay > 31)
				System.out.println("Invalid date!");
			if (((currYear % 4 != 0 || (currYear % 100 == 0 && currYear % 400 != 0)) && currMonth == 2 && currDay > 28)
					|| (currMonth == 2 && currDay > 29)) {
				System.out.println("Invalid date for February!");
			}
		} while (!isValidDate(currYear, currMonth, currDay));
		scanner.nextLine();
	}

	//To input birth date
	private static DateOfBirth bDateInput(Scanner scanner) {
		int birthDay, birthMonth, birthYear;

		do {
			System.out.print("\nPlease enter your birth year: ");
			birthYear = scanner.nextInt();
			if (birthYear < 1)
				System.out.println("Invalid year!");
			if (birthYear > currYear) {
				System.out.println("Birth year cannot be greater than current year!");
			}
		} while (birthYear < 1 || birthYear > currYear);
		do {
			System.out.print("\nPlease enter your birth month: ");
			birthMonth = scanner.nextInt();
			if (birthMonth < 1 || birthMonth > 12)
				System.out.println("Invalid month!");
			if (birthYear == currYear && birthMonth > currMonth) {
				System.out.println(
						"Birth month cannot be greater than current month when birth year is equal current year!");
			}
		} while (birthMonth < 1 || birthMonth > 12 || (birthYear == currYear && birthMonth > currMonth));
		do {
			System.out.print("Please enter your birth date: ");
			birthDay = scanner.nextInt();
			if (birthDay < 1 || birthDay > 31)
				System.out.println("Invalid date!");
			if (((birthYear % 4 != 0 || (birthYear % 100 == 0 && birthYear % 400 != 0)) && birthMonth == 2
					&& birthDay > 28) || (birthMonth == 2 && birthDay > 29)) {
				System.out.println("Invalid date for February!");
			}
			if (birthYear == currYear && birthMonth == currMonth && birthDay > currDay) {
				System.out.println("Birth date cannot be greater than current date!");
			}
		} while (!isValidDate(birthYear, birthMonth, birthDay)
				|| (birthYear == currYear && birthMonth == currMonth && birthDay > currDay));
		scanner.nextLine();
		DateOfBirth dob = new DateOfBirth(birthDay, birthMonth, birthYear);
		return dob;
	}

	//To check if input date is valid
	private static boolean isValidDate(int year, int month, int date) {
		if (date < 1)
			return false;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (date > 31)
				return false;
			else
				return true;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (date > 30)
				return false;
			else
				return true;
		} else if (((year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) && month == 2 && date > 28)
				|| (month == 2 && date > 29)) {
			return false;
		} else
			return true;
	}
}
