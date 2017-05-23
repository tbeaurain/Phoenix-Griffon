package Controllers.Commun;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import org.phoenixgriffon.JobIsep.*;

import Controllers.Admin.ConnectionBDD;


/**
 * Servlet implementation class Connexion
 */
@WebServlet(name="/Connexion", urlPatterns={"/Accueil"})
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String SERVLET_ADMIN = "/AccueilAdmin";
	public static final String SERVLET_ELEVE = "/AccueilEleve";
	public static final String ECHEC = "/Connexion.html";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
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
		
		this.getServletContext().getRequestDispatcher( SERVLET_ELEVE ).forward( request, response );
		
		HttpSession s=request.getSession( true );
		if(s.isNew())
		{
			Controllers.Admin.ConnectionBDD db = new Controllers.Admin.ConnectionBDD();
			Utilisateur util = new Utilisateur();
			boolean logged;
			try {
				System.out.println("login : " + request.getParameter("login"));
				System.out.println(request.getParameter("password"));
				logged = db.login(request.getParameter("login"),request.getParameter("password"),util);
				
				if(logged)
				{
					System.out.println(util.getStatutUtilisateur().getLibelle());
					s.setAttribute("utilisateur", util);
					if(util.getStatutUtilisateur().getLibelle().equals("admin")){
						this.getServletContext().getRequestDispatcher( SERVLET_ADMIN ).forward( request, response );
					}
					else if(util.getStatutUtilisateur().getLibelle().equals("eleve")){
						this.getServletContext().getRequestDispatcher( SERVLET_ELEVE ).forward( request, response );
					}
				}
				else{
					System.out.println("passage par le else");
					RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Connexion.html");
					dispatcher.include(request, response);
				}
			}
			catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		/*else
		{
			String statut = ((Utilisateur) s.getAttribute("utilisateur")).getStatutUtilisateur().getLibelle();
			if(statut.equals("admin")){
				this.getServletContext().getRequestDispatcher( SERVLET_ADMIN ).forward( request, response );
			}
			else if(statut.equals("eleve")){
				this.getServletContext().getRequestDispatcher( SERVLET_ELEVE ).forward( request, response );
			}
		}*/
		
	}

}
