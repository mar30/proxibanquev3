package fr.gtm.proxibanque3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.gtm.proxibanque3.metier.Client;
import fr.gtm.proxibanque3.util.ConnectionBDD;
/**
 * Classe de la couche DAO, qui effectue les operations "CRUD" en interagissant avec la base des donnes
 * @author Adminl
 *
 */

public class ClientDao {
	
  Connection cn = null;
    
     Statement st = null;
    ResultSet rs = null;
    //ConseillerService conseilservice;
  
   
	/**
	 * Methode qui trouve tous les clients sur la base des donnees
	 * @return liste des objets Client
	 */
    
    //trouver tous les clients de la base
	public ArrayList<Client> findAllClient(){
        
		  ArrayList<Client> liste = new ArrayList<Client>();
        cn = ConnectionBDD.seConnecter();
        
        String req = "SELECT * FROM CLIENT";
        
             
    
    try {
           st = cn.createStatement();                       
        ResultSet rs = st.executeQuery(req);
        
            
           
        while(rs.next()){
        	
        	Client cli = new Client();
       	cli.setIdcli(rs.getInt("idcli"));
       	cli.setNom(rs.getString("nom"));
       	cli.setPrenom(rs.getString("prenom"));
       	cli.setAdresse(rs.getString("adresse"));
       	cli.setCodePostal(rs.getInt("codePostal"));
       	cli.setVille(rs.getString("ville"));
       	cli.setTel(rs.getString("tel"));
       	cli.setEmail(rs.getString("email"));
       	
       	//cli.setConseiller(conseilservice.readConsByIdCn(rs.getInt("idcn")));
      //TODO ajouter les comptes associés
      
       	liste.add(cli);
       	
        }
    } catch (SQLException ex) {
        Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        ConnectionBDD.deconnect(cn);
                    
        
        return liste;
  }

	//trouver tous les clients associés au conseiller
	/**
	 * Methode qui trouve tous les clients associes a un conseiller
	 * @return liste des objets Client
	 */
    
		
	public ArrayList<Client> findAllClientCn(int idcn){
	        
		  ArrayList<Client> liste = new ArrayList<Client>();
	        
	        cn = ConnectionBDD.seConnecter();
	        
	        String req = "SELECT * FROM CLIENT WHERE IDCN="+idcn;
	        
	             
	    
	    try {
	           st = cn.createStatement();                       
	        ResultSet rs = st.executeQuery(req);
	        
	            
	           
	        while(rs.next()){
	        	
	        	Client cli = new Client();
	       	cli.setIdcli(rs.getInt("idcli"));
	       	cli.setNom(rs.getString("nom"));
	       	cli.setPrenom(rs.getString("prenom"));
	       	cli.setAdresse(rs.getString("adresse"));
	       	cli.setCodePostal(rs.getInt("codePostal"));
	       	cli.setVille(rs.getString("ville"));
	       	cli.setTel(rs.getString("tel"));
	       	cli.setEmail(rs.getString("email"));
	       	
	       		      
	             	liste.add(cli);
	             	//System.out.println("Size"+liste.size());
	       	
	        }
	    } catch (SQLException ex) {
	        Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
	    }
	        
	        ConnectionBDD.deconnect(cn);
	                    
	        
	        return liste;
	  }

	/**
	 * Mise a jour du nom du client, a partir de son numero identifiant
	 * @param idcli
	 * @param nom
	 * @return entier, numero d'elements modifies
	 */
    
public int updateClientNomById(int idcli, String nom){
		
		
		int n=0;
        
			
        
        cn = ConnectionBDD.seConnecter();
        
        String req = "UPDATE CLIENT SET NOM = '"+nom+"' WHERE IDCLI ="+idcli;
         
        
    try {
                               
                 
           st = cn.createStatement(); 
           
           
           n = st.executeUpdate(req);
           
           
    
    } catch (SQLException ex) {
        Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        ConnectionBDD.deconnect(cn);
        return n;           
                
  }
/**
 * Mise a jour du prenom
 * @param idcli
 * @param prenom
 * @return entier, numero d'elements modifies
 */

public int updateClientByPrenom(int idcli, String prenom){
	
	
	int n=0;
    
		
    
    cn = ConnectionBDD.seConnecter();
    
    String req = "UPDATE CLIENT SET PRENOM = '"+prenom+"' WHERE IDCLI ="+idcli;
     
    
try {
                           
             
       st = cn.createStatement(); 
       
       
       n = st.executeUpdate(req);
       
       

} catch (SQLException ex) {
    Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
}
    
    ConnectionBDD.deconnect(cn);
    return n;           
            
}

/**
 * Mise a jour de la ville
 * @param idcli
 * @param ville 
 * @return
 */
public int updateClientByVille(int idcli, String ville){
	
	
	int n=0;
    
		
    
    cn = ConnectionBDD.seConnecter();
    
    String req = "UPDATE CLIENT SET VILLE = '"+ville+"' WHERE IDCLI ="+idcli;
     
    
try {
                           
             
       st = cn.createStatement(); 
       
       
       n = st.executeUpdate(req);
       
       

} catch (SQLException ex) {
    Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
}
    
    ConnectionBDD.deconnect(cn);
    return n;           
            
}

public int updateClientByAdresse(int idcli, String adresse){
	
	
	int n=0;
    
		
    
    cn = ConnectionBDD.seConnecter();
    
    String req = "UPDATE CLIENT SET ADRESSE = '"+adresse+"' WHERE IDCLI ="+idcli;
     
    
try {
                           
             
       st = cn.createStatement(); 
       
       
       n = st.executeUpdate(req);
       
       

} catch (SQLException ex) {
    Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
}
    
    ConnectionBDD.deconnect(cn);
    return n;           
            
}

public int updateClientByTel(int idcli, String tel){
	
	
	int n=0;
    
		
    
    cn = ConnectionBDD.seConnecter();
    
    String req = "UPDATE CLIENT SET TEL = '"+tel+"' WHERE IDCLI ="+idcli;
     
    
try {
                           
             
       st = cn.createStatement(); 
       
       
       n = st.executeUpdate(req);
       
       

} catch (SQLException ex) {
    Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
}
    
    ConnectionBDD.deconnect(cn);
    return n;           
            
}

public int updateClientByEmail(int idcli, String email){
	
	
	int n=0;
    
		
    
    cn = ConnectionBDD.seConnecter();
    
    String req = "UPDATE CLIENT SET EMAIL = '"+email+"' WHERE IDCLI ="+idcli;
     
    
try {
                           
             
       st = cn.createStatement(); 
       
       
       n = st.executeUpdate(req);
       
       

} catch (SQLException ex) {
    Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
}
    
    ConnectionBDD.deconnect(cn);
    return n;           
            
}

/**
 * Lire le client associe a un numero d'identification
 * @param idcli entier, numero identification client
 * @return objet de la Classe client
 */
//Read Clientb by ID
public Client readCliByIdCli(int idcli){
    
    
    cn = ConnectionBDD.seConnecter();
    
    String req = "SELECT * FROM CLIENT WHERE IDCLI ="+idcli;
    
      Client c = new Client(); 
      //CompteService compteservice = new CompteService();

try {
       st = cn.createStatement();                       
    ResultSet rs = st.executeQuery(req);
    
  
       
    while(rs.next()){
    	
    	c.setIdcli(idcli);
        c.setNom(rs.getString("nom"));
        c.setPrenom(rs.getString("prenom"));
        c.setAdresse(rs.getString("adresse"));
        c.setCodePostal(rs.getInt("codepostal"));
        c.setVille(rs.getString("ville"));
        c.setTel(rs.getString("tel"));
        c.setEmail(rs.getString("email"));
        //c.setConseiller(conseilservice.readConsByIdCn(rs.getInt("idcn")));
       
		//c.setListecomptecli(compteservice.findAllCompteCli(idcli));
       
    }
} catch (SQLException ex) {
    Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
}
    
    ConnectionBDD.deconnect(cn);
                
    
    return c;
}

/**
 * Mettre a jour un client associe a un numero identification idcli
 * @param idcli entier numero identification
 * @param client nouveau objet client a saisir
 * @return numero des elements modifies, zero si la mise a jour n'a pas ete effectue
 */
public int updateClientById(int idcli, Client client){
	
	
	int n=0;
    
	
    
    cn = ConnectionBDD.seConnecter();
    
    String req = "UPDATE CLIENT SET NOM = ?, PRENOM = ?, ADRESSE = ?, CODEPOSTAL = ?, VILLE = ?, TEL = ?, EMAIL = ? WHERE IDCLI ="+idcli;
    PreparedStatement st; 
    
try {
                           
	st = cn.prepareStatement(req);                       
    
    st.setString(1,client.getNom());
    st.setString(2,client.getPrenom());
    st.setString(3,client.getAdresse());
    st.setInt(4,client.getCodePostal());
    st.setString(5,client.getVille());
    st.setString(6,client.getTel());
    st.setString(7,client.getEmail());
    
    n = st.executeUpdate(); 
       
       
       

} catch (SQLException ex) {
    Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
}
    
    ConnectionBDD.deconnect(cn);
    return n;           
            
}

//TODO implementer ajouter compte
	
}
