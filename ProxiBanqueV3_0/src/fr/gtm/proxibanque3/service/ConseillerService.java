package fr.gtm.proxibanque3.service;

import fr.gtm.proxibanque3.dao.ConseillerDao;
import fr.gtm.proxibanque3.metier.Conseiller;
import fr.gtm.proxibanque3.metier.IGestionAccount;


/**
 * Classe de la couche service, implementation de l'interface de gestion des informations du conseiller
 * @author Adminl
 *
 */
public class ConseillerService implements IGestionAccount{
	
	ConseillerDao consDao;
	Conseiller conseiller;
/**
 * Cosntructeur	
 */
public ConseillerService() {
		
		this.consDao = new ConseillerDao();
	}
	
	public Conseiller chargherConsByUsrId(int usrid){
		conseiller = consDao.readConsByUsrId(usrid);
		return conseiller;			
	}
	
	public Conseiller readConsByIdCn(int idcn){
		return conseiller = consDao.readConsByIdCn(idcn);
		
	}
	
	public int updateConseiller(Conseiller conseiller){
		int n;
		n = consDao.updateConseiller(conseiller);
		return n;
				
	}
}
