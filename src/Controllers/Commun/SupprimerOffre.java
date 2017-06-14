package Controllers.Commun;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.phoenixgriffon.JobIsep.Offre;
import org.phoenixgriffon.JobIsep.Utilisateur;

import Controllers.DAO.DAO;
import Controllers.DAO.OffreDAO;
import Controllers.DAO.UtilisateurDAO;

/**
 * Servlet implementation class SupprimerOffre
 */
@WebServlet(name="/SupprimerOffre", urlPatterns={"/SupprimerOffre"})
public class SupprimerOffre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_UTILISATEUR = "utilisateur"; // Nom de l'Ã©lÃ©ment ReprÃ©sentant l'utilisateur disponible dans les JSP
	public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant
    public static final String ATT_USER_TYPE = "typeUtilisateur"; // Variable qui servira Ã  identifier le type d'utilisateur (Ã©lÃ¨ve ou admin) dans la BDD
    
    public static final String VUE_SUCCES = "/WEB-INF/Commun/ResultatSuppressionOffre.jsp";
    public static final String VUE_MESSAGE = "message";
    public static final String VUE_SUCCES_SUPPRESSION = "succesSuppression";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerOffre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
		request.setAttribute(ATT_UTILISATEUR, user);
		
		int typeUtilisateur = user.getStatutUtilisateur().getId();
		request.setAttribute(ATT_USER_TYPE, typeUtilisateur);
		
		int idOffre = Integer.parseInt(request.getParameter("idOffre"));
		
		DAO<Offre> offreBdd = new OffreDAO();
		Offre toDelete = offreBdd.find(idOffre);
		int idCreateur = toDelete.getUtilisateur().getId();

		boolean succesSuppression = false;
		String message = "Echec de la suppression de l'offre, il faut Ãªtre un administrateur ou le crÃ©ateur de l'offre pour pouvoir la supprimer.";
		
		if ( user.getId()==idCreateur || typeUtilisateur==2 ){
			offreBdd.delete(toDelete);
			DAO<Utilisateur> bddUtilisateur = new UtilisateurDAO();
			session.setAttribute( ATT_SESSION_USER , bddUtilisateur.find(user.getId()));
			succesSuppression = true;
			message = "SuccÃ¨s de la suppression de l'offre.";
		}
		
		request.setAttribute(VUE_SUCCES_SUPPRESSION, succesSuppression);
		request.setAttribute(VUE_MESSAGE, message);
		
		
		this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
