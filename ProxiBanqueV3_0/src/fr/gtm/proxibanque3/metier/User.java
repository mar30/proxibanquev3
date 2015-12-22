package fr.gtm.proxibanque3.metier;
/**
 * 
 * @author Adminl
 *
 *Class metier de l'utilisateur. Caracterise par un numero d'identification, un nom d'utilisateur username,
 *un mot de passe et un String specifiant le type d'utilisateur
 *
 */

public class User {

	private int usrid;
	private String username;
	private String pwd;
	private String type;
	
	/**
	 * constructeur	de la classe
	 */
	public User() {
		super();
	}
	
/**
 * Constructeur de la classe, specifiant
 * @param usrid numero identification de l'utilisateur, entier
 * @param username nom de l'utilisateur, String
 * @param pwd mot de passe, String
 * @param type type d'utilisateur, String
 */
	
	public User(int usrid, String username, String pwd, String type) {
		super();
		this.usrid = usrid;
		this.username = username;
		this.pwd = pwd;
		this.type = type;
	}

/**
 * Constructeur de la classe, specifiant
 * @param username nom de l'utilisateur, String
 * @param pwd mot de passe, String
 * @param type type d'utilisateur, String
 */
	public User(String username, String pwd, String type) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.type = type;
	}

	
	/**
	 * Constructeur de la classe, specifiant
	 * @param username nom de l'utilisateur, String
	  */
	public User(String username) {
		super();
		this.username = username;
	}
	
	/**
	 * Constructeur de la classe, specifiant
	 * @param username nom d'utilisateur
	 * @param pwd mot de passe
	 */
	
	
	public User(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}

	/**
	 * Prendre la valeur de la propriete username
	 * @return String username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Assigner la valeur de la propriete username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Prendre la valeur de la propriete pawd
	 * @return String du mot de passe
	 */
	public String getPwd() {
		return pwd;
	}
	
	/**
	 * Assigner la valeur de la propriete mot de passe
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
/**
 * Prendre la valeur de la propriete type d'utilisateur
 * @return String specifiant le type d'utilisateur
 */
	public String getType() {
		return type;
	}

	/**
	 * Assigner la valeur de la propriete type d'utilisateur
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
/**
 * Prendre la valeur de la propriete numero identification user
 * @return entier
 */
	public int getUsrid() {
		return usrid;
	}

	/**
	 * Assigner la valeur de la propriete numero identification user
	 * @param usrid
	 */
	public void setUsrid(int usrid) {
		this.usrid = usrid;
	}
	
	

}
