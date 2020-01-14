package fr.epita.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	public void log(String message) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd - HH:mm:ss.SSS Z z");
		String timeStamp = simpleDateFormat.format(date);
		print(format(message, timeStamp));
	}
	
	protected void print(String message) {
		System.out.println(message);
	}
	
	private String format(String message, String timeStamp) {
		return timeStamp + " -- " + message;
	}
}
