package fr.gtm.proxibanque3.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.gtm.proxibanque3.metier.Conseiller;
import fr.gtm.proxibanque3.util.ConnectionBDD;

/**
 * Classe de la couche DAO, CRUD des objets de type Conseiller dans la base des donnees
 * @author Adminl
 *
 */

public class ConseillerDao {
    
	Connection cn = null;
    
     Statement st = null;
     ResultSet rs = null;
     Conseiller c = new Conseiller();
   
	/**
	 * Lire un conseiller a partir de son numero d'utilisateur
	 * @param usrid
	 * @return objet Conseiller associe au numero utilisateur
	 */
	public Conseiller readConsByUsrId(int usrid){
        
        
             cn = ConnectionBDD.seConnecter();
             
             String req = "SELECT * FROM CONSEILLER WHERE USRID ="+usrid;
             
                  
         
         try {
                st = cn.createStatement();                       
             ResultSet rs = st.executeQuery(req);
             
                 
                
             while(rs.next()){
            	c.setIdCn(rs.getInt(1));
                c.setNom(rs.getString(2));
                c.setPrenom(rs.getString(3));
                c.setUsrid(usrid);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
         }
             
             ConnectionBDD.deconnect(cn);
                         
             
             return c;
       }
	
	/**
	 * Lire un conseiller associe a un numero d'identification conseiller
	 * @param idcn
	 * @return objet de type Conseiller associe au numero identification idcn
	 */
	public Conseiller readConsByIdCn(int idcn){
        
        
        cn = ConnectionBDD.seConnecter();
        
        String req = "SELECT * FROM CONSEILLER WHERE IDCN ="+idcn;
        
             
    
    try {
           st = cn.createStatement();                       
        ResultSet rs = st.executeQuery(req);
        
            
           
        while(rs.next()){
       	c.setIdCn(idcn);
           c.setNom(rs.getString(2));
           c.setPrenom(rs.getString(3));
           c.setUsrid(rs.getInt(4));
        }
    } catch (SQLException ex) {
        Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        ConnectionBDD.deconnect(cn);
                    
        
        return c;
  }

	/**
	 * Mise a jour d'un conseiller
	 * @param conseiller nouveau objet avec les parametres a modifier
	 * @return numero des elements modifies, zero si la mise a jour n'a pas ete faite
	 */
	public int updateConseiller(Conseiller conseiller){
		
		int n=0;
        
		c.setIdCn(conseiller.getIdCn());
		c.setNom(conseiller.getNom());
		c.setPrenom(conseiller.getPrenom());
		c.setUsrid(conseiller.getUsrid());
        
        cn = ConnectionBDD.seConnecter();
        
        String req = "UPDATE CONSEILLER SET NOM = ?, PRENOM = ? WHERE IDCN ="+c.getIdCn();
         PreparedStatement st; 
        
    try {
           st = cn.prepareStatement(req);                       
        
           st.setString(1,conseiller.getNom());
           st.setString(2,conseiller.getPrenom());
           
           
           n = st.executeUpdate();
           
           
    
    } catch (SQLException ex) {
        Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        ConnectionBDD.deconnect(cn);
        return n;           
                
  }
	
}
