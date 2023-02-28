import java.util.Arrays;

public class DateHelper {
	static String getMonth(int month) {
		String month_name = "";
		if(month == 1)
			month_name = "january";
		else if(month == 2)
			month_name = "febuary";
		else if(month == 3)
			month_name = "march";
		else if(month == 4)
			month_name = "april";
		else if(month == 5)
			month_name = "may";
		else if(month == 6)
			month_name = "june";
		else if(month == 7)
			month_name = "july";
		else if(month == 8)
			month_name = "august";
		else if(month == 9)
			month_name = "september";
		else if(month == 10)
			month_name = "october";
		else if(month == 11)
			month_name = "november";
		else if(month == 12)
			month_name = "december";
		else
			month_name = "there are only 12 months";
		return month_name;
	}

	static int getMonth(String month) {
		int month_num = 0;
		if(month.toLowerCase().contains("jan"))
			month_num = 1;
		else if(month.toLowerCase().contains("feb"))
			month_num = 2;
		else if(month.toLowerCase().contains("mar"))
			month_num = 3;
		else if(month.toLowerCase().contains("apr"))
			month_num = 4;
		else if(month.toLowerCase().contains("may"))
			month_num = 5;
		else if(month.toLowerCase().contains("jun"))
			month_num = 6;
		else if(month.toLowerCase().contains("jul"))
			month_num = 7;
		else if(month.toLowerCase().contains("aug"))
			month_num = 8;
		else if(month.toLowerCase().contains("sep"))
			month_num = 9;
		else if(month.toLowerCase().contains("oct"))
			month_num = 10;
		else if(month.toLowerCase().contains("nov"))
			month_num = 11;
		else if(month.toLowerCase().contains("dec"))
			month_num = 12;
		return month_num;

	}
	public static String getDay(int day) {
		String day_name = "";
		if(day == 1)
			day_name = "monday";
		else if(day == 2)
			day_name = "tuesday";
		else if(day == 3)
			day_name = "wednesday";
		else if(day == 4)
			day_name = "thursday";
		else if(day == 5)
			day_name = "friday";
		else if(day == 6)
			day_name = "saturday";
		else if(day == 7 || day == 0)
			day_name = "sunday";
		return day_name;

	}
	public static int getDay(String day) {
		int day_num = 0;
		if(day.toLowerCase().contains("mon"))
			day_num = 1;
		else if(day.toLowerCase().contains("tue"))
			day_num = 2;
		else if(day.toLowerCase().contains("wed"))
			day_num = 3;
		else if(day.toLowerCase().contains("thu"))
			day_num = 4;
		else if(day.toLowerCase().contains("fri"))
			day_num = 5;
		else if(day.toLowerCase().contains("sat"))
			day_num = 6;
		else if(day.toLowerCase().contains("sun"))
			day_num = 7;

		return day_num;
	}

	public static String getDate(int year, int month, int day) {
		String date = "";
		String s_year = Integer.toString(year);
		String s_month = Integer.toString(month);
		String s_day = Integer.toString(day);

		date = s_year + "-" + s_month + "-" + s_day;
		return date;

	}
	public static int[] getDate(String date) {
		int[] full_date = new int[3];
		String[] parts = date.split("-");

		full_date = Arrays.stream(parts)
				.mapToInt(Integer::parseInt)
				.toArray();
		return full_date;
	}

	public static boolean isLeapYear(int year) {
		if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean isValidDate(int year, int month, int day) {
		boolean valid = false;
		if( month > 0 && month < 13) {
			if(day <= daysOfMonth(year,month))
				valid = true;
		}
		return valid;
	}

	public static int daysOfMonth(int year, int month) {
		int days = 1;
		String month_name = getMonth(month);
		if(month_name.toLowerCase().contains("feb")) {
			if(isLeapYear(year) == true)
				days = 29;
			else
				days = 28;
		}
		else if(month_name.toLowerCase().contains("sept") || month_name.toLowerCase().contains("apr") || month_name.toLowerCase().contains("jun") || month_name.toLowerCase().contains("nov"))
			days = 30;
		else
			days = 31;
		return days;
	}
	public static int dayOfYear(int year, int month, int day) {
		int day_number = 0;

		while(month > 0) {
			if(month == 2) {
				if(isLeapYear(year)== true)
					day_number += 28;
				else
					day_number += 29;
				month -=1;
			}
			else if (month == 9 || month == 4 || month == 6 || month == 11) {
				day_number += 30;
				month -= 1;
			}
			else {
				day_number += 31;
				month -=1;
			}
		}
		while(day > 0) {
			day_number += 1;
			day -= 1;
		}

		return day_number;
	}

	public static String dayOfWeek(int year, int month, int day) { // ? don't know
		String dayOfWeek = "";
		if (month < 3 ){
			year -= 1;
		}
		int dayCode  = (year + (year / 4) - (year / 100) + (year / 400) + day) % 7;
		switch (dayCode) {
		case 0:
			dayOfWeek = "Sunday";
			break;
		case 1:
			dayOfWeek = "Monday";
			break;
		case 2:
			dayOfWeek = "Tuesday";
			break;
		case 3:
			dayOfWeek = "Wednesday";
			break;
		case 4:
			dayOfWeek = "Thursday";
			break;
		case 5:
			dayOfWeek = "Friday";
			break;
		case 6:
			dayOfWeek = "Saturday";
			break;
		default:
			dayOfWeek = "default";
			break;
		}
		return dayOfWeek;
	}
	public static int daysBetween(int yearFirst, int monthFirst, int dayFirst, int yearSecond, int monthSecond, int daySecond) { //AAAAAAAAA
		int days_between = 0;
		while(yearSecond - yearFirst != 0) {
			if(isLeapYear(yearSecond) == true ) {
				days_between += 366;
			}
			else
				days_between += 365;
			yearSecond -= 1;
		}
		while(monthFirst != monthSecond) {
			if(monthSecond > monthFirst) {
				while(monthSecond - monthFirst != 0) {
					days_between += daysOfMonth(yearSecond, monthSecond);
					monthSecond -= 1;
				}
			}
			if(monthSecond < monthFirst) {
				while(monthFirst - monthSecond != 0) {
					days_between += daysOfMonth(yearSecond, monthSecond);
					monthFirst -= 1;
				}
			}
		}
		while(dayFirst != daySecond) {
			if(daySecond > dayFirst) {
				while(daySecond - dayFirst != 0) {
					days_between -= 1;
					daySecond -= 1;
				}
			}
			if(daySecond < dayFirst) {
				while(dayFirst - daySecond != 0) {
					days_between -= 1;
					dayFirst -= 1;
				}
			}
		}

		return days_between + 1;
	}

	public static int randomYear(int start, int end) {
		int random_year = (int )((Math.random() * (end-start)) + start);
		return random_year;
	}
	public static int randomYear(int end) {
		int random_year = (int)((Math.random() * (end-1)) + 1);
		return random_year;	
	}
	public static int randomYear() {
		int random_year = (int)(Math.random() * 9999 + 1);
		return random_year;
	}
	public static int randomMonth() {
		int random_month = (int)(Math.random() * 11 + 1);
		return random_month;			
	}
	public static int randomDay(int year, int month) {
		int random_day = 0;
		if(month == 2) {
			if(isLeapYear(year) == true)
				random_day = (int)(Math.random() * 28 + 1);
			if(isLeapYear(year) == false)
				random_day = (int)(Math.random() * 27 + 1);
		}
		if(month == 9 || month == 4 || month == 6 || month == 11)
			random_day = (int)(Math.random() * 29 + 1);
		else
			random_day = (int)(Math.random() * 30 + 1);
		return random_day;
	}

	public static int randomDay(int month) {
		int random_day = 0;
		if(month == 2)
			random_day = (int)(Math.random() * 28 + 1);
		if(month == 9 || month == 4 || month == 6 || month == 11)
			random_day = (int)(Math.random() * 30 + 1);
		else
			random_day = (int)(Math.random() * 31 + 1);
		return random_day;
	}
	public static int randomDay() {
		int random_day = (int)((Math.random() * (31-1)) + 1);
		return random_day;	
	}
	public static int[] randomDate() {
		int[] full_date = new int[3];
		int day = randomDay();
		int month = randomMonth();
		int year = randomYear();

		full_date[0] = day;
		full_date[1]= month;
		full_date[2]= year;

		return full_date;
	}
}
