package fr.gtm.proxibanque3.metier;

/**
 * Sous-classe de la classe compte
 * @author Adminl
 *
 */

public class CompteEpargne extends Compte{
	
	
	private float taux;
	
	
	/**
	 * Prendre la valeur du taux d'interets
	 * @return float taux
	 */
	public float getTaux() {
		return taux;
	}

	/**
	 * Etablir la valuer du taux d'interets
	 * @param taux
	 */
	public void setTaux(float taux) {
		this.taux = taux;
	}


	public float calculinterets(){
		return getSolde()*taux;
	}

	
	


}
