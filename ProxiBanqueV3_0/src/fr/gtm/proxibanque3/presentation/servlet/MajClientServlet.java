package fr.gtm.proxibanque3.presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.proxibanque3.metier.Client;
import fr.gtm.proxibanque3.service.ClientService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="/MajClientServlet", urlPatterns = { "/MajClient" })
public class MajClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}
	
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupération des informations et instanciation
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String adresse=request.getParameter("adresse");
		int codePostal=Integer.parseInt(request.getParameter("codePostal"));
		String ville=request.getParameter("ville");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		int idcli=Integer.parseInt(request.getParameter("idcli"));
		
		//Client cl=new Client(idcli);
		ClientService cls=new ClientService();
		Client cl=new Client(idcli,nom,prenom,adresse,codePostal,ville,tel, email);
		
		int n = cls.updateClientById(idcli, cl);
		
		//Création de session Http à partir de l'Objet request
		HttpSession maSession=request.getSession();
		
		//Mise en attribut de session des paramètres de requête
		cl = cls.readCliByIdCli(idcli);
		maSession.setAttribute("client", cl);
						
		//Réponse à l'utilisateur
		RequestDispatcher dispatcher=request.getRequestDispatcher("ValiderMaj.jsp");
		
		
		dispatcher.forward(request, response);
		
}

}
