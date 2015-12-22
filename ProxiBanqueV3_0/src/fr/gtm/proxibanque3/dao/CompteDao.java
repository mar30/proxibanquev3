package fr.gtm.proxibanque3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.gtm.proxibanque3.metier.Compte;
import fr.gtm.proxibanque3.metier.CompteCourant;
import fr.gtm.proxibanque3.util.ConnectionBDD;

/**
 * Classe de la couche DAO, operations CRUD associes aux comptes Compte
 * @author Adminl
 *
 */
public class CompteDao {
	
	 Connection cn = null;
	    
     Statement st = null;
    ResultSet rs = null;
 
	
   /**
    * Trouver tous les comptes courants de la base 
    * @return liste des comptes
    */
    //trouver tous les comptes courants de la base
	public ArrayList<Compte> findAllCompteCourant(){
        
		ArrayList<Compte> liste = new ArrayList<Compte>();
       
        cn = ConnectionBDD.seConnecter();
        
        String req = "SELECT * FROM COMPTECOURANT";
        
             
    
    try {
           st = cn.createStatement();                       
        ResultSet rs = st.executeQuery(req);
        
            
           
        while(rs.next()){
       	
        Compte c = new Compte();
       	c.setIdcompte(rs.getInt("idcompte"));
       	c.setSolde(rs.getFloat("solde"));
       	c.setDateOuverture(rs.getString("dateouverture"));
            	
      
       	liste.add(c);
       	
        }
    } catch (SQLException ex) {
        Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    
          
        
        ConnectionBDD.deconnect(cn);
                    
        
        return liste;
  }
	
	 /**
	    * Trouver tous les comptes epargne de la base 
	    * @return liste des comptes
	    */
	    //trouver tous les comptes epargne de la base
		public ArrayList<Compte> findAllCompteEpargne(){
	        
			ArrayList<Compte> liste = new ArrayList<Compte>();
	       
	        cn = ConnectionBDD.seConnecter();
	        
	        String req = "SELECT * FROM COMPTEPARGNE";
	        
	             
	    
	    try {
	           st = cn.createStatement();                       
	        ResultSet rs = st.executeQuery(req);
	        
	            
	           
	        while(rs.next()){
	       	
	        Compte c = new Compte();
	       	c.setIdcompte(rs.getInt("idcompte"));
	       	c.setSolde(rs.getFloat("solde"));
	       	c.setDateOuverture(rs.getString("dateouverture"));
	            	
	      
	       	liste.add(c);
	       	
	        }
	    } catch (SQLException ex) {
	        Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    
	          
	        
	        ConnectionBDD.deconnect(cn);
	                    
	        
	        return liste;
	  }

	//trouver le compte courant associés au client
	/**
	 * Trouver le compte courant associes au client, a partir de son numero d'identification	
	 * @param idcli entier du numero d'identificatrion client
	 * @return arraylist des objets Compte
	 */
	public ArrayList<Compte> findCCourantClient(int idcli){
	        
	        
	        cn = ConnectionBDD.seConnecter();
	        
	        String req = "SELECT * FROM COMPTECOURANT WHERE IDCLI = "+idcli;
	        
	             
	    
	    ArrayList<Compte> liste = new ArrayList<Compte>();
	    
		try {
	           st = cn.createStatement();                       
	        ResultSet rs = st.executeQuery(req);
	        	    
	        Compte c = new Compte();
	        while(rs.next()){
	        	
	            
		       	c.setIdcompte(rs.getInt("idcompte"));
		       	c.setSolde(rs.getFloat("solde"));
		       	c.setDateOuverture(rs.getString("dateouverture"));
		       			      
		       	liste.add(c);
	       	
	        }
	    } catch (SQLException ex) {
	        Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
	    }
		
			        
	        ConnectionBDD.deconnect(cn);
	                    
	        
	        return liste;
	  }
	

	//trouver le compte epargne associé au client
	/**
	 * Trouver le compte epargne associé au client, a partir de son numero d'identification	
	 * @param idcli entier du numero d'identificatrion client
	 * @return arraylist des objets Compte
	 */
	public ArrayList<Compte> findCEpargneClient(int idcli){
	        
	        
	        cn = ConnectionBDD.seConnecter();
	        
	        String req = "SELECT * FROM COMPTEPARGNE WHERE IDCLI = "+idcli;
	        
	             
	    
	    ArrayList<Compte> liste = new ArrayList<Compte>();
	    
		try {
	           st = cn.createStatement();                       
	        ResultSet rs = st.executeQuery(req);
	        	    
	        Compte c = new Compte();
	        while(rs.next()){
	        	
	            
		       	c.setIdcompte(rs.getInt("idcompte"));
		       	c.setSolde(rs.getFloat("solde"));
		       	c.setDateOuverture(rs.getString("dateouverture"));
		       			      
		       	liste.add(c);
	       	
	        }
	    } catch (SQLException ex) {
	        Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
	    }
		
			        
	        ConnectionBDD.deconnect(cn);
	                    
	        
	        return liste;
	  }
	//Read compte
	
	/**
	 * Lire un objet Compte a partir de son numero d'identification
	 * @param idcompte
	 * @return objet compte associe au numero d'identification
	 */
	public Compte readCompteIdcompte(int idcompte){
	    
		Compte c = new Compte();
	    
	    cn = ConnectionBDD.seConnecter();
	    
	    
	    	String req = "SELECT * FROM COMPTECOURANT WHERE IDCOMPTE ="+idcompte;
	    	    
	    
	    	try {
	 	       st = cn.createStatement();                       
	 	    ResultSet rs = st.executeQuery(req);
	 	    
	 	   c = new CompteCourant();
	 	       
	 	    while(rs.next()){
	 	    	
	 	    	c.setIdcompte(idcompte);
	 	    	c.setSolde(rs.getFloat("solde"));
	 	    	c.setDateOuverture(rs.getString("dateouverture"));
	 	        
	 	       
	 			
	 	       
	 	    }
	 	} catch (SQLException ex) {
	 	    Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
	 	}
	 	    
	 	    ConnectionBDD.deconnect(cn);
	 	                
	 	    
	 	    return c;
	
	}
	
	//update solde
	/**
	 * Mise a jour du solde du compte
	 * @param idcompte
	 * @param solde
	 * @return numero des elements modifies, zero si le solde n'a pas ete modifie
	 */
	public int updateCompteSolde(int idcompte, float solde){
		
		
		int n=0;
	    
			
	    
	    cn = ConnectionBDD.seConnecter();
	    
	    String req = "UPDATE COMPTE SET SOLDE = "+solde+" WHERE IDCOMPTE ="+idcompte;
	     
	    
	try {
	                           
	             
	       st = cn.createStatement(); 
	       
	       
	       n = st.executeUpdate(req);
	       
	       

	} catch (SQLException ex) {
	    Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
	}
	    
	    ConnectionBDD.deconnect(cn);
	    return n;           
	            
	}
	


}
