package Controllers.Forms;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.phoenixgriffon.JobIsep.*;

import Controllers.DAO.DAO;
import Controllers.DAO.OffreDAO;
/**
 * Servlet implementation class FormRecherche
 */
@WebServlet("/FormRecherche")
public class FormRecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static final String ATT_UTILISATEUR = "utilisateur"; // Nom de l'élément Représentant l'utilisateur disponible dans les JSP
	public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant
    public static final String ATT_USER_TYPE = "typeUtilisateur"; // Variable qui servira à identifier le type d'utilisateur (élève ou admin) dans la BDD
    
	
	public static final String ATT_RECHERCHE = "recherche";
	
	public static final String VUE_SUCCES = "/WEB-INF/Commun/RechercheOffre.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormRecherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
		int typeUtilisateur = user.getStatutUtilisateur().getId();
		request.setAttribute(ATT_USER_TYPE, typeUtilisateur);
		request.setCharacterEncoding("utf-8");
		String recherche = request.getParameter("titre");
		ArrayList<Offre> liste_offres = null;
		OffreDAO bddOffre = new OffreDAO();
		liste_offres =bddOffre.recherche(recherche);
		request.setAttribute("liste_offres", liste_offres);
		response.setCharacterEncoding("utf-8");
		this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}
}