package fr.gtm.proxibanque3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe qui instancie la connexion a la base des donnes.
 * Contient les proprietes statiques qui definissent le pilote utilise, l'adresse de connexion a la base,
 * le username et le mot de passe.
 * @author Adminl
 *
 */
public class ConnectionBDD {
    public static String pilote = "oracle.jdbc.OracleDriver";
    public static String urlDB = "jdbc:oracle:thin:@localhost:1521:XE";
    public static String user ="user6";
    public static String pwd = "user6";
   
    /**
     * Se connecter a la base des donnees.
     * Charge le pilote, lance la connexion par la classe DriverManager, avec les proprietes qui definissent url de la base,
     * username et mot de passe.
     * @return objet Connection
     */
    public static Connection seConnecter(){
        try{
          Class.forName(pilote);
        }catch(ClassNotFoundException e){
            
        }
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(urlDB, user, pwd);
        } catch (SQLException ex) {
        	    Logger.getLogger(ConnectionBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }
    
    /**
     * Se deconnecter de la base des donnees
     * @param cn
     */
      public static void deconnect(Connection cn){
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
	
	}


