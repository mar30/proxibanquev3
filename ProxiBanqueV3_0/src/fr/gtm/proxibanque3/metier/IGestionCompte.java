package fr.gtm.proxibanque3.metier;

import java.util.ArrayList;

import fr.gtm.proxibanque3.exception.DebitException;

public interface IGestionCompte {
	
	/**
	 * Creer un compte courant
	 * @param compte
	 * @return
	 */
	public int createCompteCourant(CompteCourant compte);
	/**
	 * Creer un compte epargne
	 * @param compte
	 * @return
	 */
	public int createCompteEpargne(CompteEpargne compte);
	
	/**
	 * Lire les informations du compte a partir du numero de compte
	 * @param idcompte
	 * @return objet Compte associe a idcompte
	 */
	public Compte readCompteIdcompte(int idcompte); 
/**
 * Mettre a jour les informations du compte
 * @param compte
 * @return
 */
	public int updateCompte(Compte compte);
	
	/**
	 * Crediter le compte d'un montant mt
	 * @param idcompte
	 * @param mt
	 * @return numero des objets compte modifies
	 */
	public int crediterCompte(int idcompte, float mt);
	
	/**
	 * Retirer du compte un montant mt
	 * @param idcompte
	 * @param mt
	 * @return numero des objets compte modifies
	 * @throws DebitException
	 */
	
	public int debiterCompte(int idcompte, float mt) throws DebitException;
	/**
	 * supprimer un compte
	 * @param idcompte
	 * @return
	 */
	public int deleteCompte(int idcompte);
	
	/**
	 * Trouver tous les comptes lies a un client, a partir de son identifiant
	 * @param idcli entier
	 * @return arraylist des objets Compte associes au client
	 */
	public ArrayList<Compte> findAllCompteCli(int idcli);
	
	/**
	 * Trouver tous les comptes de la base
	 * @return liste des objets Compte
	 */
	public ArrayList<Compte> findAllCompte();
	
	/**
	 * Effectuer un virement
	 * @param idcomptecredit compte a crediter
	 * @param idcomptedebit compte a debiter
	 * @param mt montant a transferer
	 * @return boolean true si l'operation a ete effectue
	 * @throws DebitException
	 */
	public boolean effectuerVirement(int idcomptecredit, int idcomptedebit, float mt) throws DebitException;
	
	

}
