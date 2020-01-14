package fr.epita.agefinder.datamodel;

/**
 * @author Anh Tu NGUYEN - Group 2
 *
 */

public class DateOfBirth {
	private int day, month, year, ageDay, ageMonth, ageYear, numOfDays;

	public DateOfBirth(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public int getAgeDay() {
		return ageDay;
	}

	public int getAgeMonth() {
		return ageMonth;
	}

	public int getAgeYear() {
		return ageYear;
	}

	public int getNumOfDays() {
		return numOfDays;
	}

	public void ageCalculate(int currDay, int currMonth, int currYear) {
		this.ageDay = 0;
		this.ageMonth = 0;
		this.ageYear = 0;
		this.numOfDays = 0;
		if (this.month > currMonth) {
			this.ageYear = currYear - this.year - 1;
			if (this.day <= currDay) {
				this.ageMonth = 12 - this.month + currMonth;
			} else {
				this.ageMonth = 12 - this.month + currMonth - 1;
			}
		} else if (this.month < currMonth) {
			this.ageYear = currYear - this.year;
			if (this.day <= currDay) {
				this.ageMonth = currMonth - this.month;
			} else {
				this.ageMonth = currMonth - this.month - 1;
			}
		} else {
			if (this.day <= currDay) {
				this.ageYear = currYear - this.year;
				this.ageMonth = currMonth - this.month;
			} else {
				this.ageYear = currYear - this.year - 1;
				this.ageMonth = 12 - this.month + currMonth - 1;
			}
		}
		if (this.day > currDay) {
			if (currMonth == 1 || currMonth == 2 || currMonth == 4 || currMonth == 6 | currMonth == 8 || currMonth == 9
					|| currMonth == 11) {
				this.ageDay = 31 - this.day + currDay;
			} else if (currMonth == 3) {
				// condition for a leap year
				if ((currYear % 4 == 0 && currYear % 100 != 0) || currYear % 400 == 0) {
					this.ageDay = 29 - this.day + currDay;
				} else {
					this.ageDay = 28 - this.day + currDay;
				}
			} else {
				this.ageDay = 30 - this.day + currDay;
			}
		} else {
			this.ageDay = currDay - this.day;
		}

		int leapYear = 0;
		// to count the number of leap years
		for (int i = this.year; i < currYear + 1; i++) {
			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
				if (i == this.year) {
					if (this.month == 2 && this.day < 29) {
						leapYear++;
						continue;
					} else
						continue;
				} else if (i == currYear) {
					if ((currMonth > 2) || (currMonth == 2 && currDay == 29)) {
						leapYear++;
						continue;
					} else
						continue;
				}
				leapYear++;
			}
		}

		// to count the days for extra days
		for (int i = this.month; i < this.month + this.ageMonth; i++) {
			int iToMonth = (i <= 12) ? i : i - 12;
			if (iToMonth == 1 || iToMonth == 3 || iToMonth == 5 || iToMonth == 7 || iToMonth == 8 || iToMonth == 10
					|| iToMonth == 12) {
				numOfDays += 31;
			} else if (iToMonth == 4 || iToMonth == 6 || iToMonth == 9 || iToMonth == 11) {
				numOfDays += 30;
			} else {
				numOfDays += 28;
			}
		}
		numOfDays += 365 * this.ageYear + leapYear + this.ageDay;
	}

//	public int ageCalculateByDays(int currDay, int currMonth, int currYear) {
//		int leapYear = 0;
//		// to count the number of leap years
//		for (int i = this.year; i < currYear + 1; i++) {
//			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
//				if (i == this.year) {
//					if (this.month == 2 && this.day < 29) {
//						leapYear++;
//						continue;
//					} else
//						continue;
//				} else if (i == currYear) {
//					if ((currMonth > 2) || (currMonth == 2 && currDay == 29)) {
//						leapYear++;
//						continue;
//					} else
//						continue;
//				}
//				leapYear++;
//			}
//		}
//
//		// to count the days for extra days
//		for (int i = this.month; i < this.month + this.ageMonth; i++) {
//			int iToMonth = (i <= 12) ? i : i - 12;
//			if (iToMonth == 1 || iToMonth == 3 || iToMonth == 5 || iToMonth == 7 || iToMonth == 8 || iToMonth == 10
//					|| iToMonth == 12) {
//				numOfDays += 31;
//			} else if (iToMonth == 4 || iToMonth == 6 || iToMonth == 9 || iToMonth == 11) {
//				numOfDays += 30;
//			} else {
//				numOfDays += 28;
//			}
//		}
//		numOfDays += 365 * this.ageYear + leapYear + this.ageDay;
//		
//		return numOfDays;
//	}

	public int calculateDaysToBirthday(int currDay, int currMonth, int currYear) {
		int currAgeByDays = 0;
		int nextYearAgeByDays = 0;
		int daysToBirthDay = 0;
		ageCalculate(currDay, currMonth, currYear);
		currAgeByDays = this.numOfDays;
		if (currMonth > this.month || (currMonth == this.month && currDay > this.day)) {
			ageCalculate(this.day, this.month, currYear + 1);
		} else if (currMonth == this.month && currDay == this.day) {
			return daysToBirthDay;
		} else {
			ageCalculate(this.day, this.month, currYear);
		}
		nextYearAgeByDays = this.numOfDays;
		daysToBirthDay = nextYearAgeByDays - currAgeByDays;
		return daysToBirthDay;
	}
}
