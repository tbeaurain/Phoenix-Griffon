package Controllers.Commun;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.phoenixgriffon.JobIsep.*;

import Controllers.DAO.StatutUtilisateurDAO;
import Controllers.DAO.UtilisateurDAO;
import IdentifiantIsep.ldap.LDAPAccess;
import IdentifiantIsep.ldap.LDAPObject;


/**
 * Servlet implementation class Connexion
 */
@WebServlet(name="/Connexion", urlPatterns={"/Accueil"})
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String SERVLET_ADMIN = "/AccueilAdmin";
	public static final String SERVLET_ELEVE = "/AccueilEleve";
	public static final String ECHEC = "/Connexion.html";

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
		UtilisateurDAO utilisateurBDD = new UtilisateurDAO();
		StatutUtilisateurDAO statutUtilisateurBDD = new StatutUtilisateurDAO();

		Utilisateur user = new Utilisateur();
		StatutUtilisateur statutUtilisateur = new StatutUtilisateur();
		
		request.setCharacterEncoding("utf-8");
		String pseudo = request.getParameter("login");
		String mdp = request.getParameter("password");
		response.setCharacterEncoding("utf-8");
		
		user = utilisateurBDD.connexion(pseudo, mdp);
		
		if ( user.getId() == null) {
			LDAPAccess access = new LDAPAccess();
			try {
				LDAPObject test = access.LDAPget(pseudo, mdp);
				user.setIdentifiant(pseudo);
				user.setMotdepasse(mdp);
				statutUtilisateur = statutUtilisateurBDD.findConnexion(test.getType());
				user.setStatutUtilisateur(statutUtilisateur);
				user = utilisateurBDD.createNewUtilisateur(user);
				user = utilisateurBDD.connexion(pseudo, mdp);
			}
			catch(Exception e) {
				this.getServletContext().getRequestDispatcher( "/Connexion.html" ).forward( request, response );
				System.out.println("login invalide");
				return;
			} 
		}
		
		if ( user.getId() != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute( ATT_SESSION_USER , user);
			
			System.out.println("ok");
			
			if( session.getAttribute( ATT_SESSION_USER ) != null ){
				Utilisateur usr = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
				if(usr.getStatutUtilisateur().getId()==1){ // StatutUtilisateur = 1 : l'utilisateur est un élève
					this.getServletContext().getRequestDispatcher( SERVLET_ELEVE ).forward( request, response );
				}else { // StatutUtilisateur = 2 : l'utilisateur est un administrateur (prof, ...)
					this.getServletContext().getRequestDispatcher( SERVLET_ADMIN ).forward( request, response );
				}
			}else{
				response.sendRedirect( ECHEC );
			}
		}
	}
}
