package com.example.myclock.controller;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class MyClockUtil {

	private static final String[] SINGLE_DIGITS = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six",
			"Seven", "Eight", "Nine" };
	private static final String[] DOUBLE_DIGITS = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
			"Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	private static final String[] TEN_DIGITS = new String[] { "Zero", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
			"Seventy", "Eighty", "Ninety" };

	public static String convertToWords(LocalTime time) {
		StringBuilder words = new StringBuilder("It's ");
		if (time.getHour() == 00 && time.getMinute() == 0) {
			words = words.append("Midnight");
		} else if (time.getHour() == 12 && time.getMinute() == 0) {
			words = words.append("Midday");
		} else {
			words = words.append(getWords(time.getHour()).toLowerCase()).append(" ")
					.append(getWords(time.getMinute()).toLowerCase());
		}
		return words.toString();
	}
	
	public static String convertToWords(String time) {
		StringBuilder words = new StringBuilder("It's ");
		if (time.equalsIgnoreCase("00:00")) {
			words = words.append("Midnight");
		} else if (time.equalsIgnoreCase("12:00")) {
			words = words.append("Midday");
		} else {
			String[] times = time.split(":");
			int hour = Integer.parseInt(times[0]);
			int min = Integer.parseInt(times[1]);
			words = words.append(getWords(hour).toLowerCase()).append(" ").append(getWords(min).toLowerCase());
		}
		return words.toString();
	}

	private static String getWords(int number) {
		int number1 = number / 10;
		int number2 = number % 10;
		if (number1 == 1) {
			return DOUBLE_DIGITS[number2];
		} else if (number2 == 0) {
			return TEN_DIGITS[number1];
		} else if (number1 == 0) {
			return SINGLE_DIGITS[number2];
		} else {
			return TEN_DIGITS[number1] + " " + SINGLE_DIGITS[number2];
		}
	}

	public static boolean isValid(String time) {
		try {
			LocalTime.parse(time);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}

}
