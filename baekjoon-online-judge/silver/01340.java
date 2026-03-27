import java.io.*;
import java.util.*;

public class Main {

	static boolean isLeapYear(int year) {
		if (year % 400 == 0) return true;
		if (year % 100 == 0) return false;
		return year % 4 == 0;
	}

	static int monthToIndex(String month) {
		switch (month) {
			case "January": return 0;
			case "February": return 1;
			case "March": return 2;
			case "April": return 3;
			case "May": return 4;
			case "June": return 5;
			case "July": return 6;
			case "August": return 7;
			case "September": return 8;
			case "October": return 9;
			case "November": return 10;
			case "December": return 11;
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String in = br.readLine();
		StringTokenizer st = new StringTokenizer(in, " ,:");
		String monthStr = st.nextToken();
		int day = Integer.parseInt(st.nextToken());
		int year = Integer.parseInt(st.nextToken());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());

		// Solve
		boolean leap = isLeapYear(year);

		int[] daysInMonth = {
			31,
			leap ? 29 : 28,
			31, 30, 31, 30,
			31, 31, 30, 31, 30, 31
		};

		int month = monthToIndex(monthStr);

		long passedDays = 0;
		for (int i = 0; i < month; ++i) {
			passedDays += daysInMonth[i];
		}
		passedDays += (day - 1);

		long passedMinutes = passedDays * 24L * 60L + hour * 60L + minute;
		long totalMinutes = (leap ? 366L : 365L) * 24L * 60L;

		// Output
		System.out.print((double) passedMinutes * 100.0 / totalMinutes);
	}
}