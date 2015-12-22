package fr.gtm.proxibanque3.metier;

import fr.gtm.proxibanque3.exception.LoginException;

/**
 * Interface de verification des parametres d'autentification
 * @author Adminl
 *
 */

public interface ILogin {
/**
 * Verifier si le username est dans la base des donnees et si le mot de passe corresponde
 * @param user
 * @return true si l'autentification est positive
 * @throws LoginException
 */
	public boolean verifierUser(User user) throws LoginException;
	
}
