package fr.gtm.proxibanque3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.gtm.proxibanque3.exception.UserLoginException;
import fr.gtm.proxibanque3.metier.User;
import fr.gtm.proxibanque3.util.ConnectionBDD;

/**
 * Classe de la couche DAO, operations CRUD sur la base des donnees des utilisateurs
 * @author Adminl
 *
 */
public class UserDao {
	
	public  Connection cn = null;
    public  User user = new User();
    public  Statement st = null;
    public  ResultSet rs = null;
	
	public User readUser(String username) throws UserLoginException{
        
        User user = new User();
             cn = ConnectionBDD.seConnecter();
             
             String req = "SELECT * FROM USERLIST WHERE USERNAME ='"+username+"'";
             
                  
         
         try {
                st = cn.createStatement();                       
             ResultSet rs = st.executeQuery(req);
                 if(rs==null)throw new UserLoginException();
        
             while(rs.next()){
            	 user.setUsrid(rs.getInt("usrid"));
            	 user.setUsername(username);
                 user.setPwd(rs.getString("pwd"));
                 user.setType(rs.getString("type"));
                             }
         } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         }
             
             ConnectionBDD.deconnect(cn);
             
                          
             return user;
         
     
 }
}
