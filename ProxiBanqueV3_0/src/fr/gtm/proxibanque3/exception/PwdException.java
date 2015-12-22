package fr.gtm.proxibanque3.exception;

/**
 * Sous-classe de la classe LoginException.
 * Lancee quand le mot de passe ne correspond pas au nom utilisateur.
 * @author Adminl
 *
 */

public class PwdException extends LoginException{

	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		
		return "Username and password don't match";
	}

}
