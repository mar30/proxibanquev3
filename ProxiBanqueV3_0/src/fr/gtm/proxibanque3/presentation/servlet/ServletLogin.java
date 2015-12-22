package fr.gtm.proxibanque3.presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.proxibanque3.exception.LoginException;
import fr.gtm.proxibanque3.exception.PwdException;
import fr.gtm.proxibanque3.exception.UserLoginException;
import fr.gtm.proxibanque3.exception.UsrTypeException;
import fr.gtm.proxibanque3.metier.Conseiller;
import fr.gtm.proxibanque3.metier.User;
import fr.gtm.proxibanque3.service.ClientService;
import fr.gtm.proxibanque3.service.CompteService;
import fr.gtm.proxibanque3.service.ConseillerService;
import fr.gtm.proxibanque3.service.UserService;

/**
 * Servlet lance au login, implementation class Servlet.
 */
@WebServlet("/servUser")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			traitement(request,response);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			traitement(request,response);
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Comparer les parametres saisis dans l'ecran de login avec les informations contenues dans la table des utilisateurs, 
	 * dans la base de donnees.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws LoginException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, LoginException {
		
		//Prende les parametres saisis dans le formulaire et construit un user0 à comparer
		String login = request.getParameter("usr");
		String pwd = request.getParameter("pwd");
		
		User user0 = new User(login,pwd);
		
		
		
		HttpSession mysession = request.getSession();
		mysession.setAttribute("thisuser", user0);
		
		
		UserService usrservice = new UserService();
		User loggeduser = new User();
		ConseillerService cnServ = new ConseillerService();
		ClientService cliServ = new ClientService();
		CompteService compteServ = new CompteService();
		Conseiller conseiller = new Conseiller();
		boolean verif;
		
		RequestDispatcher disp;
		try{
			
			verif = usrservice.verifierUser(user0);
			
			if(usrservice.verifierUser(user0)){
				
				loggeduser = usrservice.readUser(user0.getUsername());
				
				
				if(loggeduser.getType().equals("C")){
					
				conseiller = cnServ.chargherConsByUsrId(loggeduser.getUsrid());
				/**
				 * Si l'utilisateur est verifie et si il corresponde a un conseiller, 
				 * prendre en attribut de session l'objet conseiller.
				 */
				mysession.setAttribute("conseiller", conseiller);//L'objet conseiller est pris par la session
				
				
				}else if(loggeduser.getType().equals("A")){
					/**
					 * Si l'utilisateur est d'autre type, une autre solution va etre implemente.
					 */
					System.out.println("Implementer use case");
					
					}else{try {
					/**
					 * Si le type d'utilisateur ne corresponde pas a ceux presents dans la base, un message d'erreur est affiche.
					 */
					throw new UsrTypeException();
				} catch (UsrTypeException e) {mysession.setAttribute("exception", e);
					disp=request.getRequestDispatcher("erreur.jsp");		
				}
					
					
				}
			
			}
		
			mysession.setAttribute("verif", verif);
			mysession.setAttribute("login",loggeduser);
		disp=request.getRequestDispatcher("resultatLoginConseiller.jsp");
		
		
		
			
		}catch(UserLoginException|PwdException e){
			/**
			 * Au cas ou le nom utilisateur n'est pas present ou le mot de passe ne corresponde pas,
			 * l'exception correnspondante est capturee et mise en attibut a la session.
			 */
			verif = false;
			mysession.setAttribute("exception", e);
			mysession.setAttribute("verif", verif);
			disp=request.getRequestDispatcher("resultatLoginConseiller.jsp");
			
		}
	/**
	 * Le resultat boolean de l'autentification, un unstance de la classe ClientService et de la classe CompteService sont aussi
	 * prises en attribut de session.
	 */
		mysession.setAttribute("cliServ", cliServ);
		mysession.setAttribute("compteServ", compteServ);
		disp.forward(request, response);	
	}

}
