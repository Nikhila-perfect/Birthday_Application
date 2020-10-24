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
	