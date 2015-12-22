package fr.gtm.proxibanque3.presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.proxibanque3.exception.DebitException;
import fr.gtm.proxibanque3.service.CompteService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/virementServ")
public class VirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VirementServlet() {
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
		int idCompteDepart=Integer.parseInt(request.getParameter("idCompteDepart"));
		int idCompteArrivee=Integer.parseInt(request.getParameter("idCompteArrivee"));
		float montant=Float.parseFloat(request.getParameter("montant"));
		
		//Création de session Http à partir de l'Objet request
		HttpSession maSession=request.getSession();
		RequestDispatcher dispatcher;
		
		
		CompteService cps=new CompteService();
		
		
		
		try {
			cps.effectuerVirement(idCompteArrivee, idCompteDepart, montant);
			
			dispatcher = request.getRequestDispatcher("ValiderVirement.jsp");
		} catch (DebitException e) {
			maSession.setAttribute("exception", e);
			dispatcher = request.getRequestDispatcher("erreur.jsp");
				e.printStackTrace();
		}
		
		
		
			
		
						
		//Réponse à l'utilisateur
		
		
		dispatcher.forward(request, response);
		
}

}
