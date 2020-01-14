package fr.epita.logging.tests;

import java.io.FileNotFoundException;

import fr.epita.logging.FileLogger;

public class FileLoggerTest {
	
	public static void main(String[] args) throws FileNotFoundException {
		FileLogger logger = new FileLogger();
		logger.log("Test 1");
		logger.log("Test 2");
	}
	
}
