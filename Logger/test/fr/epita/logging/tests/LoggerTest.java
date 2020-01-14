package fr.epita.logging.tests;

import fr.epita.logging.Logger;

public class LoggerTest {

	public static void main(String[] args) {
		Logger logger = new Logger();
		logger.log("Test 1");
		logger.log("Test 2");
	}
}
