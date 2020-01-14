package fr.epita.exercises;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataStructureUtils {
	// covers from January to April
	private static final int[] daysInMonths = { 31, 28, 31, 30 }; // final is not modifiable, static means unique,
																	// props. represents only for the class
	private static int[] daysInMonths2 = new int[3];
	
	private static final Map<Integer, Integer> daysInMonthsAsMap = new LinkedHashMap<>();
	
	static {
		daysInMonthsAsMap.put(1, 31);
		daysInMonthsAsMap.put(2, 28);
		daysInMonthsAsMap.put(3, 31);
		daysInMonthsAsMap.put(4, 30);
	}
	
	public static void main(String[] args) {
		int januaryNumberOfDays = daysInMonths[1];
		januaryNumberOfDays = daysInMonthsAsMap.get(1);
		januaryNumberOfDays = DaysInMonthEnum.JANUARY.getNumberOfDays();//You cannot go outside of what have been defined in Enum => no error
		System.out.println(januaryNumberOfDays);
	}
	
}
