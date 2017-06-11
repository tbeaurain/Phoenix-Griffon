package Controllers.Forms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.phoenixgriffon.JobIsep.Utilisateur;

import Controllers.DAO.DAO;
import Controllers.DAO.UtilisateurDAO;
import Controllers.Forms.FormsCheckers.FormModificationMotdepasseUtilisateurChecker;
import Controllers.Forms.FormsCheckers.FormModificationUtilisateurChecker;

/**
 * Servlet implementation class FormModificationMotdepasseUtilisateur
 */
@WebServlet(name="/FormModificationMotdepasseUtilisateur", urlPatterns={"/FormModificationMotdepasseUtilisateur"})
public class FormModificationMotdepasseUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public static final String ATT_FORM   = "form";
    public static final String ATT_UTILISATEUR = "utilisateur"; // Nom de l'élément Représentant l'utilisateur disponible dans les JSP
	public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant
    public static final String ATT_USER_TYPE = "typeUtilisateur"; // Variable qui servira à identifier le type d'utilisateur (élève ou admin) dans la BDD
	
	public static final String VUE_SUCCES = "/WEB-INF/Commun/Profil.jsp";
	public static final String VUE_FORM   = "/WEB-INF/Commun/ModifierMotdepasse.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormModificationMotdepasseUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* À la réception d'une requête GET, simple affichage du formulaire */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO<Utilisateur> bddUtilisateur = new UtilisateurDAO();
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
		request.setAttribute(ATT_UTILISATEUR, user);
		int typeUtilisateur = user.getId();
		request.setAttribute(ATT_USER_TYPE, typeUtilisateur);
        /* Préparation de l'objet formulaire */
        FormModificationMotdepasseUtilisateurChecker form = new FormModificationMotdepasseUtilisateurChecker();
        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.updateUtilisateur( request, user );

        request.setAttribute( ATT_FORM, form );

        if ( form.getErreurs().isEmpty() ) {
        	UtilisateurDAO bddu = new UtilisateurDAO();
        	bddu.updateMotdepasse(utilisateur);
        	session.setAttribute( ATT_SESSION_USER , utilisateur);
            /* Si aucune erreur, alors affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
	}

}
