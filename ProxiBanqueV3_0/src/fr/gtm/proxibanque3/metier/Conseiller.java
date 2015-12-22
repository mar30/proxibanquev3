package fr.gtm.proxibanque3.metier;

/**
 * Classe specifiant le conseiller.
 * Caracterise par numero d'identification, nom, prenom et lie a un numero d'identification d'utilisateur usrid
 * @author Adminl
 *
 */

public class Conseiller {

	private int idCn;
    private String nom;
    private String prenom;
    private int usrid;
   
    
    /**
     * Constructeur de la classe
     * @param idCn numero d'identification conseiller
     * @param nom nom du conseiller
     * @param prenom prenom du conseiller
     * @param usrid numero d'identification d'utilisateur
     */
    public Conseiller(int idCn, String nom, String prenom, int usrid) {
		super();
		this.idCn = idCn;
		this.nom = nom;
		this.prenom = prenom;
		this.usrid = usrid;
	}
    
    

/**
 * Constructeur de la classe
 * @param idCn numero d'identification conseiller
 * @param nom nom du conseiller
 * @param prenom prenom du conseiller
 */
	public Conseiller(int idCn, String nom, String prenom) {
		super();
		this.idCn = idCn;
		this.nom = nom;
		this.prenom = prenom;
	}


	/**
	 * Constructeur de la classe
	 * @param nom nom du conseiller
	 * @param prenom prenom du conseiller
	 */
	public Conseiller(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}



/**
 * Constructeur de la classe
 */
	public Conseiller() {
    }


	/**
	 * Prendre le numero d'identification
	 * @return entier du numero d'identification
	 */
	public int getIdCn() {
		return idCn;
	}

/**
 * Assigner le numero d'identification
 * @param idCn  entier du numero d'identification
 */
	public void setIdCn(int idCn) {
		this.idCn = idCn;
	}

/**
 * Prendre le nom du conseiller
 * @return String du nom
 */
	public String getNom() {
		return nom;
	}

/**
 * Assigner le nom au conseiller
 * @param nom String nom
 */
	public void setNom(String nom) {
		this.nom = nom;
	}

/**
 * Prendre le prenom du conseiller
 * @return
 */
	public String getPrenom() {
		return prenom;
	}

/**
 * Assigner le prenom 
 * @param prenom String prenom 
 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

/**
 * Prendre le numero d'utilisateur
 * @return entier usrid
 */
	public int getUsrid() {
		return usrid;
	}

/**
 * Assigner le numero d'utilisateur
 * @param usrid entier usrid
 */
	public void setUsrid(int usrid) {
		this.usrid = usrid;
	}


	

   
     
 



   
	
}
