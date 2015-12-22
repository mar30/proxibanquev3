package fr.gtm.proxibanque3.presentation.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.proxibanque3.metier.Client;
import fr.gtm.proxibanque3.metier.Compte;
import fr.gtm.proxibanque3.service.ClientService;
import fr.gtm.proxibanque3.service.CompteService;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/gestionCompteserv")
public class GestionCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		traitement(request, response);
	}
	
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupération des informations et instanciation
		int idcli=Integer.parseInt(request.getParameter("idcli"));
		
		ClientService clis = new ClientService();
		CompteService cs = new CompteService();
		Client client = new Client();
		ArrayList<Compte> listeCompte = new ArrayList<Compte>();
		listeCompte = cs.findAllCompteCli(idcli);
		client = clis.readCliByIdCli(idcli);
		
		
		//Création de session Http à partir de l'Objet request
		HttpSession maSession=request.getSession();
		
		//Mise en attribut de session des paramètres de requête
		maSession.setAttribute("client", client);
		maSession.setAttribute("listeCompte", listeCompte);
						
		//Réponse à l'utilisateur
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("gestionCompte.jsp");
		dispatcher.forward(request, response);
		
}

}
