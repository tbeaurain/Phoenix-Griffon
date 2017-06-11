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
import Controllers.DAO.DAO;
import Controllers.DAO.UtilisateurDAO;


/**
 * Servlet implementation class Connexion
 */
@WebServlet(name="/Connexion", urlPatterns={"/Accueil"})
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String SERVLET_ADMIN = "/AccueilAdmin";
	public static final String SERVLET_ELEVE = "/AccueilEleve";
	public static final String ECHEC = "/Phoenix-Griffon/Connexion.html";
	
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
       
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
		/* TEST -----------------------------------------------------------------------------------*/
		DAO<Utilisateur> utilisateurBDD = new UtilisateurDAO();
		int id = 1;
		Utilisateur user = utilisateurBDD.find(id);
		HttpSession session = request.getSession();
		session.setAttribute( ATT_SESSION_USER , user);
		
		
		if( session.getAttribute( ATT_SESSION_USER ) != null ){
			Utilisateur usr = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
		    int idStatutUtilisateur = usr.getStatutUtilisateur().getId();
			if(idStatutUtilisateur==1){ // StatutUtilisateur = 1 : l'utilisateur est un élève
				this.getServletContext().getRequestDispatcher( SERVLET_ELEVE ).forward( request, response );
			}else if(idStatutUtilisateur==2){ // StatutUtilisateur = 2 : l'utilisateur est un administrateur (prof, ...)
				this.getServletContext().getRequestDispatcher( SERVLET_ADMIN ).forward( request, response );
			}
		}else{
			response.sendRedirect( ECHEC );
		}
		
		
		/* TEST -----------------------------------------------------------------------------------*/
		
		/*
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
					System.out.println("Passe par la boucle if : "+util.getStatutUtilisateur().getLibelle());
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
					System.out.println("On est dans l'exception.");
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}*/
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
