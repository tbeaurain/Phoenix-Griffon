package Controllers.Commun;

import java.io.IOException;
import java.util.ArrayList;

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

/**
 * Servlet implementation class RechercheOffre
 */
@WebServlet(name="/RechercheOffre", urlPatterns={"/RechercheOffre"})
public class RechercheOffre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_SUCCES = "/WEB-INF/Commun/RechercheOffre.jsp";
	
	public static final String ATT_UTILISATEUR = "utilisateur"; // Nom de l'élément Représentant l'utilisateur disponible dans les JSP
	public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant
    public static final String ATT_USER_TYPE = "typeUtilisateur"; // Variable qui servira à identifier le type d'utilisateur (élève ou admin) dans la BDD
    

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercheOffre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
		int typeUtilisateur = user.getId();
		request.setAttribute(ATT_USER_TYPE, typeUtilisateur);
		
		ArrayList<Offre> liste_offres = new ArrayList<>();

		DAO<Offre> offreBDD = new OffreDAO();
		for (int i = 1; i<10; i++){
			if (offreBDD.find(i).getDescription() != null){
				liste_offres.add(offreBDD.find(i));
			}
		}
		request.setAttribute("liste_offres", liste_offres);
		this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}

}
