package Controllers.Commun;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.phoenixgriffon.JobIsep.EffectueStage;
import org.phoenixgriffon.JobIsep.Offre;
import org.phoenixgriffon.JobIsep.Utilisateur;

/**
 * Servlet implementation class OffresProposees
 */
@WebServlet(name="/OffresProposees", urlPatterns={"/OffresProposees"})
public class OffresProposees extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String VUE_SUCCES = "/WEB-INF/Commun/OffresProposees.jsp";
	
	public static final String ATT_UTILISATEUR = "utilisateur"; // Nom de l'élément Représentant l'utilisateur disponible dans les JSP
	public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant
    public static final String ATT_USER_TYPE = "typeUtilisateur"; // Variable qui servira à identifier le type d'utilisateur (élève ou admin) dans la BDD
    public static final String ATT_AFFICHER_OFFRE = "afficherOffre";
    public static final String ATT_OFFRE_LISTE = "listeOffres";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OffresProposees() {
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
		
		int typeUtilisateur = user.getId();
		request.setAttribute(ATT_USER_TYPE, typeUtilisateur);
		
		ArrayList<Offre> offresListe = new ArrayList<>(user.getOffres());
		
		int offresListeNb = offresListe.size();
		boolean afficherOffres = false;
		if(offresListeNb>1){
			afficherOffres = true;
			request.setAttribute(ATT_OFFRE_LISTE, offresListe);
		}
		request.setAttribute(ATT_AFFICHER_OFFRE, afficherOffres);
		
		
		
		
		this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
