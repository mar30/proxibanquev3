package fr.gtm.proxibanque3.exception;

public class UsrTypeException extends Exception{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		
		return "Unexpected user type: implement new use case or contact DBA to correct";
	}
}
