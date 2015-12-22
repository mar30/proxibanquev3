package fr.gtm.proxibanque3.metier;

import java.util.ArrayList;

/**
 * Interface de gestion des operations sur les clients
 * @author Adminl
 *
 */

public interface IGestionClient {
	
	/**
	 * Creer un nouveau client
	 * @param client
	 * @return numero des client crees
	 */
	public int createClient(Client client);
	
	/**
	 * Lire les infos du client a partir de son numero d'identification
	 * @param idcli
	 * @return objet Client correspondant
	 */
	public Client readCliByIdCli(int idcli); 

	/**
	 * Mise a jour d'un client
	 * @param client
	 * @return
	 */
	public int updateClient(Client client);
	
	/**
	 * Supprimer un client
	 * @param idcli
	 * @return
	 */
	public int deleteClient(int idcli);
	
	/**
	 * Trouver tous les clients associes au conseiller identifie par le numero idcn
	 * @param idcn
	 * @return liste des objets Client
	 */
	public ArrayList<Client> findAllClientCn(int idcn);

	/**
	 * Mettre a jour un client, a partir de son idcli
	 * @param idcli
	 * @param client client mis a jour
	 * @return
	 */
	int updateClientById(int idcli, Client client);

}
