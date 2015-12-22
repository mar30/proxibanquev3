package fr.gtm.proxibanque3.metier;

import java.util.List;

/**
 * Classe metier du Client.
 * Caracterise par numero d'identification client, nom, prenom, adresse, code postal, ville, telephone, email.
 * Lie a un conseiller et a une liste de comptes
 * @author Adminl
 *
 */

public class Client {

	private int idcli;
	private String nom;
	private String prenom;
	private String adresse;
	private int codePostal;
	private String ville;
	private String tel;
	private String email;
	
	private Conseiller conseiller;
	private List<Compte> listecomptecli;
	
		
	
	/**
	 * Constructeur de la classe
	 * @param idcli
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param tel
	 * @param email
	 * @param conseiller
	 * @param listecomptecli
	 */
	public Client(int idcli, String nom, String prenom, String adresse, int codePostal, String ville, String tel,
			String email, Conseiller conseiller, List<Compte> listecomptecli) {
		super();
		this.idcli = idcli;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.tel = tel;
		this.email = email;
		this.conseiller = conseiller;
		this.setListecomptecli(listecomptecli);
	}





/**
 * Constructeur de la classe
 * @param idcli
 * @param nom
 * @param prenom
 * @param adresse
 * @param codePostal
 * @param ville
 * @param tel
 * @param email
 */

	public Client(int idcli, String nom, String prenom, String adresse, int codePostal, String ville, String tel, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.tel = tel;
		this.email = email;
	}








/**
 * Constructeur de la classe
 * @param idcli
 */
	public Client(int idcli) {
		super();
		this.idcli = idcli;
	}




/**
 * Constructeur de la classe
 * @param idcli
 * @param conseiller
 */
	public Client(int idcli, Conseiller conseiller) {
		super();
		this.idcli = idcli;
		this.conseiller = conseiller;
	}




/**
 * Constructeur de la classe
 */
	public Client() {
		super();
	}




/**
 * Prendre numero identification client
 * @return entier
 */
	public int getIdcli() {
		return idcli;
	}
	
	/**
	 * Assigner numero identification client
	 * @param idcli
	 */
	public void setIdcli(int idcli) {
		this.idcli = idcli;
	}
	
	/**
	 * Prendre nom du client
	 * @return String nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Assigner nom au client
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Prendre prenom du client
	 * @return String prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Assigner prenom au client
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Prendre adresse du client
	 * @return String adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * Assigner adresse
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * Prendre code postal
	 * @return entier
	 */
	public int getCodePostal() {
		return codePostal;
	}
	
	/**
	 * Assigner code postal
	 * @param codePostal entier
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	/**
	 * Prendre ville du client
	 * @return String ville
	 */
	public String getVille() {
		return ville;
	}
	
	/**
	 * Assigner ville
	 * @param ville String
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/**
	 * Prendre numero de telephone du client
	 * @return String telephone
	 */
	public String getTel() {
		return tel;
	}
	
	/**
	 * Assigner telephone
	 * @param tel String
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * Prendre l'objet conseiller associe au client
	 * @return objet Conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}
	
	/**
	 * Assigner un objet de type Conseiller
	 * @param conseiller instance de la classe Conseiller
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}


/**
 * Prendre l'adresse email du client
 * @return String email
 */
	public String getEmail() {
		return email;
	}




/**
 * Assigner un adresse email
 * @param email String
 */
	public void setEmail(String email) {
		this.email = email;
	}



/**
 * Prendre la liste des comptes associes au client
 * @return liste des objets de la classe Compte
 */

public List<Compte> getListecomptecli() {
	return listecomptecli;
}



/**
 * Assigner une liste des compte
 * @param listecomptecli liste des objets de la classe Compte
 */

public void setListecomptecli(List<Compte> listecomptecli) {
	this.listecomptecli = listecomptecli;
}
	
	
	
	
}
