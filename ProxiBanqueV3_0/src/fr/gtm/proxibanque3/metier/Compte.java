package fr.gtm.proxibanque3.metier;

import fr.gtm.proxibanque3.exception.DebitException;

/**
 * Classe des instances de compte bancaire
 * @author Adminl
 *Caracterisee par un numero de compte, un solde, une date d'ouverture, un decouvert et un taux d'interet.
 *Lie a une instance de la classe Client.
 */

public class Compte {
	
	protected int idcompte;
	protected float solde;
	protected String dateOuverture;
	
		
	protected Client client;
	
	
	

/**
 * Constructeur de la classe
 */
	public Compte() {
		super();
	}

	public Compte(int idcompte) {
		super();
		this.idcompte = idcompte;
	}

	public Compte(int idcompte, Client client) {
		super();
		this.idcompte = idcompte;
		this.client = client;
	}

	

	public Compte(int idcompte, float solde, String dateOuverture, Client client) {
		super();
		this.idcompte = idcompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.client = client;
	}

	/**
	 * Prendre le numero de compte
	 * @return entier idcompte
	 */
	public int getIdcompte() {
		return idcompte;
	}

	/**
	 * Assigner un numero de compte
	 * @param idcompte entier
	 */
	public void setIdcompte(int idcompte) {
		this.idcompte = idcompte;
	}

	/**
	 * Prendre la valeur du solde
	 * @return float solde
	 */
	public float getSolde() {
		return solde;
	}

	/**
	 * Assigner un solde
	 * @param solde float
	 */
	public void setSolde(float solde) {
		this.solde = solde;
	}

	/**
	 * Prendre la date d'ouverture
	 * @return String de la date d'ouverture
	 */
	public String getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * Assigner une date d'ouverture
	 * @param dateOuverture
	 */
	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
/**
 * Prendre le client associe au compte
 * @return objet de la classe Client
 */
	public Client getClient() {
		return client;
	}

	/**
	 * Assigner un objet Client
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
	/**
	 * Crediter le compte d'un montant
	 * @param mt montant
	 * @return nouveau solde
	 */
	public float crediterCompte(float mt) {
		solde = getSolde();	 
		 solde = solde + mt;
		 setSolde(solde);
		 return solde;
	}
	
	/**
	 * Retirer du compte un montant
	 * @param mt montant
	 * @return nouveau solde
	 * @throws DebitException
	 */
	public float debiterCompte(float mt) throws DebitException{
		solde = getSolde();
		 if(solde>=mt){
			 solde = solde - mt;
			 setSolde(solde);
		 }else{
		 throw new DebitException();
		 }
		 
		 return solde;
	}


}
