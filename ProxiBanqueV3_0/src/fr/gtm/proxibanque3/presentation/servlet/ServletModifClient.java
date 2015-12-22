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
 * Servlet implementation class LoginServlet.
 * Recupere les infos du client, a partir de son id.
 */
@WebServlet("/modifClientserv")
public class ServletModifClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifClient() {
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
		int idcli=Integer.parseInt(request.getParameter("idcli"));
		//Client cl=new Client(idcli);
		ClientService cls=new ClientService();
		Client cl=new Client();
		cl=cls.readCliByIdCli(idcli);
		
		//Création de session Http à partir de l'Objet request
		HttpSession maSession=request.getSession();
		
		//Mise en attribut de session des paramètres de requête
		maSession.setAttribute("cl", cl);
						
		//Réponse à l'utilisateur
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("modifClient.jsp");
		dispatcher.forward(request, response);
		
}

}
