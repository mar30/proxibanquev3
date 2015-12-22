package fr.gtm.proxibanque3.service;

import java.util.ArrayList;

import fr.gtm.proxibanque3.dao.CompteDao;
import fr.gtm.proxibanque3.exception.DebitException;
import fr.gtm.proxibanque3.metier.Compte;
import fr.gtm.proxibanque3.metier.CompteCourant;
import fr.gtm.proxibanque3.metier.CompteEpargne;
import fr.gtm.proxibanque3.metier.IGestionCompte;

/**
 * Classe de la couche service, implementation des methodes de l'interface de gestion des comptes bancaires
 * @author Adminl
 *
 */
public class CompteService implements IGestionCompte{
	
	CompteDao compteDao;

	/**
	 * Constructeur
	 */
public CompteService() {
		
		this.compteDao = new CompteDao();
	}
	
	@Override
	public Compte readCompteIdcompte(int idcompte) {
		
		return compteDao.readCompteIdcompte(idcompte);
	}

	@Override
	public int updateCompte(Compte compte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCompte(int idcompte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Compte> findAllCompteCli(int idcli) {
		
		return compteDao.findAllCompteClient(idcli);
	}

	@Override
	public ArrayList<Compte> findAllCompte() {
		
		return compteDao.findAllCompte();
	}

	@Override
	public boolean effectuerVirement(int idcomptecredit, int idcomptedebit, float mt) throws DebitException {
		boolean verif;
		
		int n = debiterCompte(idcomptedebit, mt);
		if(n==1){
			crediterCompte(idcomptecredit,mt);
			verif = true;
		}else{
			verif = false;
		}
		
		
		return verif;
	}

	@Override
	public int crediterCompte(int idcompte, float mt) {
		int n = 0;
		
		 Compte c = compteDao.readCompteIdcompte(idcompte);
		 float solde = c.getSolde();
		 
		 solde = solde + mt;
		 
		 n = compteDao.updateCompteSolde(idcompte, solde);
		
		return n;
	}

	@Override
	public int debiterCompte(int idcompte, float mt) throws DebitException {
		int n = 0;
		Compte c = compteDao.readCompteIdcompte(idcompte);
		 float solde = c.getSolde();
		 float decouvert = c.getDecouvert();
		 if(solde+decouvert-mt>=0){
		 solde = solde - mt;
		 n = compteDao.updateCompteSolde(idcompte, solde);
		 }else{
			 throw new DebitException();
		 }
		 
		
		
		return n;
	}

	@Override
	public int createCompteCourant(CompteCourant compte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createCompteEpargne(CompteEpargne compte) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

	
	

}
