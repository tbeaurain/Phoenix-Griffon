package Controllers.Commun;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


/**
 * Servlet implementation class Connexion
 */
@WebServlet(name="/Connexion", urlPatterns={"/Accueil"})
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String SERVLET_ADMIN = "/AccueilAdmin";
	public static final String SERVLET_ELEVE = "/AccueilEleve";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ReceivedLogin=request.getParameter("login");
		//String ReceivedPWD=request.getParameter("password");
		
		//redirecting to the appropriate page
		if(ReceivedLogin.equals("admin")){
			this.getServletContext().getRequestDispatcher( SERVLET_ADMIN ).forward( request, response );
		}
		else if(ReceivedLogin.equals("eleve")){
			this.getServletContext().getRequestDispatcher( SERVLET_ELEVE ).forward( request, response );
		}
		else{
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Connexion.html");
			dispatcher.include(request, response);
		}
	}

}
