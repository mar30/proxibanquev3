package fr.gtm.proxibanque3.metier;

/**
 * Interface de gestion des informations du conseiller
 * @author Adminl
 *
 */

public interface IGestionAccount {
	
	/**
	 * Charghe l'objet conseiller associe au numero d'utilisateur usrid
	 * @param usrid
	 * @return objet de la classe Conseiller
	 */
	
	public Conseiller chargherConsByUsrId(int usrid);
	
	/**
	 * Mettre a jour les infos du conseiller
	 * @param conseiller
	 * @return numero des objets modifies (zero si l'operation n'a ete effectuee)
	 */
	public int updateConseiller(Conseiller conseiller);

}
