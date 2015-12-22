package fr.gtm.proxibanque3.service;

import fr.gtm.proxibanque3.dao.UserDao;
import fr.gtm.proxibanque3.exception.PwdException;
import fr.gtm.proxibanque3.exception.UserLoginException;
import fr.gtm.proxibanque3.metier.ILogin;
import fr.gtm.proxibanque3.metier.User;

/**
 * Classe de la couche service, implementation de l'interface de gestion de l'autentification du login
 * @author Adminl
 *
 */
public class UserService implements ILogin{
	
	UserDao userDao;
	User user;
	
	/**
	 * Constructeur
	 */
	//Constructeur UserService
	public UserService() {
		
		this.userDao = new UserDao();
	}

	//Methodes
	
	public User readUser(String username) throws UserLoginException{
		user = userDao.readUser(username);
		return user;
		
	}
		
	public boolean verifierUser(User user) throws UserLoginException,PwdException{
		
		User userverif = userDao.readUser(user.getUsername());
		
				
		if(userverif.getUsername()==null){
			throw new UserLoginException();
		}else if(userverif.getUsername().equals(user.getUsername())&&userverif.getPwd().equals(user.getPwd())){
			return true;
		}else{
			throw new PwdException();	
		}
				
		}
	
	
}
