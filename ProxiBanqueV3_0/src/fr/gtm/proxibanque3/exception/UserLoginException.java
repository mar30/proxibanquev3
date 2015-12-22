package fr.gtm.proxibanque3.exception;

/**
 * Sous-classe de la classe LoginException.
 * Lancee si le nom d'utilisateur n'a pas de correspondance dans la liste des 
 * utilisateurs enregistres.
 * @author Adminl
 *
 */

public class UserLoginException extends LoginException{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		
		return "Username not found";
	}
	
	

}
