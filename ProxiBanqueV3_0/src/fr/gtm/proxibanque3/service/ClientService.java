package fr.gtm.proxibanque3.service;

import java.util.ArrayList;

import fr.gtm.proxibanque3.dao.ClientDao;
import fr.gtm.proxibanque3.metier.Client;
import fr.gtm.proxibanque3.metier.IGestionClient;

/**
 * Classe de la couche service, implementation de l'interface de la gestion clients. 
 * Liee a une instance del la classe ClientDao.
 * @author Adminl
 *
 */
public class ClientService implements IGestionClient{

	ClientDao clientDao;

	/**
	 * Constructeur
	 */
public ClientService() {
		
		this.clientDao = new ClientDao();
	}
	
	@Override
	public int createClient(Client client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Client readCliByIdCli(int idcli) {
		
		return clientDao.readCliByIdCli(idcli);
	}
	
	@Override
	public int updateClientById(int idcli, Client client){
		return clientDao.updateClientById(idcli, client);
		
	};

	@Override
	public int updateClient(Client client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteClient(int idcli) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Client> findAllClientCn(int idcn) {
		
		return clientDao.findAllClientCn(idcn);
	}

}
