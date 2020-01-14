package fr.epita.agefinder.datamodel;

/**
 * @author Anh Tu NGUYEN - Group 2
 *
 */

public class Person {
	private String name;
	private DateOfBirth dob;
	private int daysToBirthDay;
	
	public Person(String name, DateOfBirth dob) {
		this.name = name;
		this.dob = dob;
	}

	public String getName() {
		return this.name;
	}

	public DateOfBirth getDob() {
		return this.dob;
	}

	public int getDaysToBirthDay() {
		return daysToBirthDay;
	}

	public void setDaysToBirthDay(int daysToBirthDay) {
		this.daysToBirthDay = daysToBirthDay;
	}

	public String getBirthDay() {
		return dob.getDay() + "/" + dob.getMonth() + "/" + dob.getYear();
	}
}
