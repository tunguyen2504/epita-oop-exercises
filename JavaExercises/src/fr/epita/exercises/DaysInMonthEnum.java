package fr.epita.exercises;

public enum DaysInMonthEnum {
	JANUARY(1,31,"January"),
	FEBRUARY(2,28,"February"),
	MARCH(3,31,"March"),
	APRIL(4,30,"April"),
	;

	private int index, numberOfDays;
	private String displayName;
	
	private DaysInMonthEnum(int index, int numberOfDays, String displayName) {
		this.index = index;
		this.numberOfDays = numberOfDays;
		this.displayName = displayName;
	}

	public int getIndex() {
		return index;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	
}
