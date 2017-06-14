package Controllers.Admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.phoenixgriffon.JobIsep.Utilisateur;
import org.phoenixgriffon.JobIsep.ValideStage;

import Controllers.DAO.DAO;
import Controllers.DAO.UtilisateurDAO;

/**
 * Servlet implementation class ConventionAValider
 */
@WebServlet(name="/ConventionAValider", urlPatterns={"/ConventionAValider"})
public class ConventionAValider extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_SUCCES = "/WEB-INF/Admin/ConventionAValider.jsp";
	public static final String ATT_UTILISATEUR = "utilisateur"; // Nom de l'élément Représentant l'utilisateur disponible dans les JSP
	public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant
    public static final String ATT_USER_TYPE = "typeUtilisateur"; // Variable qui servira à identifier le type d'utilisateur (élève ou admin) dans la BDD
   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConventionAValider() {
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
		
		ArrayList<Utilisateur> liste_utilisateurs = new ArrayList<>();

		DAO<Utilisateur> bddUtilisateur = new UtilisateurDAO();
		for (int i = 1; i<6; i++){
			if (bddUtilisateur.find(i).getNom() != null){
				Utilisateur u = bddUtilisateur.find(i);
				ArrayList<ValideStage> stagesValidesListe = new ArrayList<>(u.getValideStages());
				if(stagesValidesListe.size()==0){
					liste_utilisateurs.add(u);
				}
			}
		}
		request.setAttribute("liste_utilisateurs", liste_utilisateurs);
		this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
