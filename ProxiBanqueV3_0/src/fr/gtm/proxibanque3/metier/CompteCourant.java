package fr.gtm.proxibanque3.metier;

import fr.gtm.proxibanque3.exception.DebitException;

/**
 * Sous-classe de la classe Compte
 * @author Adminl
 *
 */

public class CompteCourant extends Compte{
	
	
	private float decouvert;
	
	
	/**
	 * Prendre la valeur du decouvert
	 * @return float decouvert
	 */
	public float getDecouvert() {
		return decouvert;
	}



	/**
	 * Etablir la valuer du decouvert
	 * @param decouvert
	 */
	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
	}

	
	@Override
	public float debiterCompte(float mt) throws DebitException{
		solde = getSolde(); 
		
		 if(solde+decouvert>=mt){
			 solde = solde - mt;
			 setSolde(solde);
		 }else{
		 throw new DebitException();
		}
		 
		 return solde;
	}
	
	
	

}
