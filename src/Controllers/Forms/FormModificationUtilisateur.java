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
import Controllers.Forms.FormsCheckers.FormModificationUtilisateurChecker;

/**
 * Servlet implementation class FormModificationUtilisateur
 */
@WebServlet(name="/FormModificationUtilisateur", urlPatterns={"/FormModificationUtilisateur"})
public class FormModificationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_UTILISATEUR = "utilisateur"; // Variable servant à identifienr le nom des informations sur l'utilisateur à afficher dans des formulaires ou des pages sur les iformations d'un utilisateur
    public static final String ATT_FORM   = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant
    public static final String ATT_USER_TYPE = "typeUtilisateur"; // Variable qui servira à identifier le type d'utilisateur (élève ou admin) dans la BDD
	
	public static final String VUE_SUCCES = "/WEB-INF/Commun/Profil.jsp";
	public static final String VUE_FORM   = "/WEB-INF/Commun/ModifierProfil.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormModificationUtilisateur() {
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
        
        DAO<Utilisateur> bddUtilisateur = new UtilisateurDAO();
        
        HttpSession session = request.getSession();
		Utilisateur usr = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
        /* Préparation de l'objet formulaire */
        FormModificationUtilisateurChecker form = new FormModificationUtilisateurChecker();
        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.updateUtilisateur( request, usr );
        
        

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_UTILISATEUR, utilisateur );
        request.setAttribute( ATT_FORM, form );
        
        int typeUtilisateur = usr.getId();
		request.setAttribute(ATT_USER_TYPE, typeUtilisateur);

        if ( form.getErreurs().isEmpty() ) {
        	bddUtilisateur.update(utilisateur);
        	session.setAttribute( ATT_SESSION_USER , utilisateur);
        	// On rerécupère les infos de l'utilisateur depuis la BDD de manière à avoir la date correctement formatée
        	request.setAttribute( ATT_UTILISATEUR, bddUtilisateur.find(utilisateur.getId()));
            /* Si aucune erreur, alors affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
	}

}
