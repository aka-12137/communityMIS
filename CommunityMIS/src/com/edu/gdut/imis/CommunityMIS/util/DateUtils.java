package com.edu.gdut.imis.CommunityMIS.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long time1 = new Date().getTime();
		long time2 = sdf.parse("2020-01-01").getTime();
		System.out.println(getFieldDifference(time1, time2, Calendar.YEAR));
		System.out.println(getFieldDifference(time1, time2, Calendar.MONTH));
		System.out.println(getFieldDifference(time1, time2, Calendar.DATE));
		System.out.println(sdf.format(addDay(
				new Timestamp(new Date().getTime()), 20)));
	}


	public static int getFieldDifference(long time1, long time2, int field) {
		if (time1 == time2) {
			return 0;
		} else if (time1 > time2) {
			return -getFieldDifference(time2, time1, field);
		}
		Calendar cal1 = Calendar.getInstance();
		cal1.setLenient(false);
		cal1.setTimeInMillis(time1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setLenient(false);
		cal2.setTimeInMillis(time2);
		for (int x = 0; x < Calendar.FIELD_COUNT; x++) {
			if (x > field) {
				cal1.clear(x);
				cal2.clear(x);
			}
		}
		time1 = cal1.getTimeInMillis();
		time2 = cal2.getTimeInMillis();

		long ms = 0;
		int min = 0, max = 1;

		while (true) {
			cal1.setTimeInMillis(time1);
			cal1.add(field, max);
			ms = cal1.getTimeInMillis();
			if (ms == time2) {
				min = max;
				break;
			} else if (ms > time2) {
				break;
			} else {
				max <<= 1;
			}
		}

		while (max > min) {
			cal1.setTimeInMillis(time1);
			int t = (min + max) >>> 1;
			cal1.add(field, t);
			ms = cal1.getTimeInMillis();
			if (ms == time2) {
				min = t;
				break;
			} else if (ms > time2) {
				max = t;
			} else {
				min = t;
			}
		}
		return -min;
	}

	public static Date formDate(String dateStr) {
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM");
		Date date = null;

		try {
			date = dd.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static boolean isSameMonth(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			return false;
		}

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(d1);
		cal2.setTime(d2);

		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (subYear == 0) {
			if (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH))
				return true;
		}

		return false;
	}

	public static Date lastDayOfMonth(Date date) {
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(date);
		int lastDay = cDay.getActualMaximum(Calendar.DAY_OF_MONTH);
		cDay.set(Calendar.DAY_OF_MONTH, lastDay);

		return cDay.getTime();
	}

	public static Date firstDayOfMonth(Date date) {
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(date);
		int firstDay = cDay.getActualMinimum(Calendar.DAY_OF_MONTH);
		cDay.set(Calendar.DAY_OF_MONTH, firstDay);

		return cDay.getTime();
	}

	public static Date addDay(Date date, int count) {
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(date);

		cDay.add(Calendar.DATE, count);

		return cDay.getTime();
	}

	public static Date addMonth(Date date, int count) {
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(date);

		cDay.add(Calendar.MONTH, count);

		return cDay.getTime();
	}

	public static Calendar addMonthc(Date date, int count) {
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(date);

		cDay.add(Calendar.MONTH, count);

		return cDay;
	}

	public static Date addYear(Date date, int count) {
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(date);

		cDay.add(Calendar.YEAR, count);

		return cDay.getTime();
	}

	public static int nianxiancha(Date start, Date now) {
		start = firstDayOfMonth(start);
		now = firstDayOfMonth(now);

		Calendar cStart = Calendar.getInstance();
		cStart.setTime(start);

		Calendar cNow = Calendar.getInstance();
		cNow.setTime(now);

		int year = cNow.get(Calendar.YEAR) - cStart.get(Calendar.YEAR);
		int month = cNow.get(Calendar.MONTH) - cStart.get(Calendar.MONTH);

		if (month >= 0) {
			year = year + 1;
		}

		return year;
	}
	public static Date formDate(String dateStr, String patt){
		SimpleDateFormat dd=new SimpleDateFormat(patt);
		Date date = null;
		
		try {
			date = dd.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
