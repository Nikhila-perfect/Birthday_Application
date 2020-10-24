package it.tests;
import java.util.ArrayList;
import it.core.Birthday;
import it.excepts.WrongInputException;

public class TestBirthday {
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ArrayList<Birthday> al=new ArrayList<Birthday>();
		Birthday b1=new Birthday();
		new BirthdayGUI(b1,al);

	}

}
