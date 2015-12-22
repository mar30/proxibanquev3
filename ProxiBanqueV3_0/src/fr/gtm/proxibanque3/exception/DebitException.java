package fr.gtm.proxibanque3.exception;

/**
 * Sous-classe de la classe Exception.
 * Lancee si l'operation debiter un compte n'est pas effectuee,
 * notamment si le solde est insuffisant.
 * @author Adminl
 *
 */

public class DebitException extends Exception{


	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		
		return "Impossible effectuer l'operation: solde insuffisant";
	}
	
	

}
