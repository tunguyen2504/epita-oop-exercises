package fr.epita.exercises;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		// Creates a date variable of type Date, the default constructor
		// initializes the date variable with the date of the date
		Date date1 = new Date();
		System.out.println(date1);
		
		Date date2 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd - HH:mm:ss.SSS Z z");
		String stringResult = simpleDateFormat.format(date2);
		System.out.println(stringResult);
	}

}
