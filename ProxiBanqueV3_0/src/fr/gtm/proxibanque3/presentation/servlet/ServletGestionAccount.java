package fr.gtm.proxibanque3.presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.proxibanque3.metier.Conseiller;
import fr.gtm.proxibanque3.service.ConseillerService;

/**
 * Servlet implementation class ServletUpdateConseiller
 */
@WebServlet("/UpdateConseiller")
public class ServletGestionAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request,response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request,response);
	}
	
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//chargher les parametres du formulaire
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		
		Conseiller conseiller;
		
		HttpSession mysession = request.getSession();
		conseiller = (Conseiller) mysession.getAttribute("conseiller");//Prendre l'objet conseiller actuellement dans la session
		
		Conseiller conseiller0 = new Conseiller(conseiller.getIdCn(),nom,prenom,conseiller.getUsrid());
					
		ConseillerService cnServ = new ConseillerService();
				
		RequestDispatcher disp;
						
		int n = cnServ.updateConseiller(conseiller0);
		System.out.println(n);
		
		if(n==1){
			disp=request.getRequestDispatcher("UpdateTrue.jsp");
			conseiller = cnServ.chargherConsByUsrId(conseiller.getUsrid());
			mysession.setAttribute("conseiller", conseiller);//Le nouveau objet conseiller est pris par la session
		
		}else{
			disp=request.getRequestDispatcher("UpdateFalse.jsp");
	}
		
		
		disp.forward(request, response);
		
		
	}

}
