package it.excepts;

public class WrongInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String details;
	public WrongInputException(String a)
	{
		details=a;
	}
	
	public String toString()
	{
		return "WrongInputException[" +details + "]";
	}

}
