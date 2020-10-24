package it.core;
import java.io.*;

import java.io.Serializable;

public class Birthday implements Serializable {
	// By implementing the Serializable interface we can convert the objects into byte streams

	private static final long serialVersionUID = 1L;
	private int dd;
	private int mm;
	private int yyyy;
	private String day;
	private String month;
	public Birthday()   // a default constructor
	{
		dd=0;
		mm=0;
		yyyy=0;
		day=null;
	}
	public Birthday(int day,int month,int year) // a parameterized constructor
	{
		day=dd;
		month=mm;
		year=yyyy;
	}
	public void setDay(int day)
	{
		day=dd;
	}
	public void setMonth(int month)
	{
		month=mm;
	}
	public void setYear(int year)
	{
		year=yyyy;
	}
	public int getDay(int dd)
	{
		return dd;
	}
	public int getMonth()
	{
		return mm;
	}
	public int getYear(int yyyy)
	{
		return yyyy;
	}
	public int isLeap(int year)
	{
		if(year%100 == 0 && year%400==0)
			return 1;
		else if( year%100 != 0 && year%4==0)
			return 1;
		else return 0;
	}
	public String calcDay(int mm,int dd,int yyyy)
	{
		int days=0,n=0,w=0;
		//finding day of week of december 31st of previous year
		n=(((yyyy-1)*365+((yyyy-1)/4)-((yyyy-1)/100)+((yyyy-1))/400))%7; //Sunday is zero
		//I'm  not using a break statement in between the months, so that switch will add the days in each month before the current month
		switch(mm)
		{
			case 12: days=days+30; //add number of days in November
			case 11: days=days+31; //add number of days in October
			case 10: days=days+30; //add number of days in September
			case 9: days=days+31; //add number of days in August
			case 8: days=days+31; //add number of days in July
			case 7: days=days+30; //add number of days in June
			case 6: days=days+31; //add number of days in May
			case 5: days=days+30; //add number of days in April
			case 4: days=days+31; //add number of days in March
			case 3: days=days+28+ isLeap(yyyy); //add number of days in Feb
			case 2: days=days+31; //add number of days in Jan
			break;
		}
		//add d of birthday-month + number of days in all previous months+ 1 for leap year (if leap, otherwise 0)
		days= days + dd;
		w = (days%7 + n)%7;
		switch(w)
		{
			case 0: day="Sunday";
					break;
			case 1: day="Monday";
					break;
			case 2: day="Tuesday";
					break;
			case 3: day="Wednesday";
					break;
			case 4: day="Thursday";
					break;
			case 5: day="Friday";
					break;
			case 6: day="Saturday";
					break;
		}
		return day;
	}
