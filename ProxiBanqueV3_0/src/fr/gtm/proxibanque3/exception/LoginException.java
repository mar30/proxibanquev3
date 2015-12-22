package fr.gtm.proxibanque3.exception;
/**
 * Sous-classe de la classe Exception.
 * Lancee si l'autentification de l'utilisateur est negative.
 * @author Adminl
 *
 */
public class LoginException extends Exception{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		
		return "Autentification failed";
	}

}
