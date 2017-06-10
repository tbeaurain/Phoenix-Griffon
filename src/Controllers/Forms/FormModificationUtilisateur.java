package Controllers.Forms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phoenixgriffon.JobIsep.Utilisateur;

import Controllers.Admin.ConnectionBDD;
import Controllers.DAO.DAO;
import Controllers.DAO.UtilisateurDAO;
import Controllers.Forms.FormsCheckers.FormModificationUtilisateurChecker;

/**
 * Servlet implementation class FormModificationUtilisateur
 */
@WebServlet(name="/FormModificationUtilisateur", urlPatterns={"/FormModificationUtilisateur"})
public class FormModificationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_UTILISATEUR = "utilisateur";
    public static final String ATT_FORM   = "form";
	
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/ProfilEleve.jsp";
	public static final String VUE_FORM   = "/WEB-INF/Eleves/ModifierProfilEleve.jsp";
       
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
        //Juste pour la création d'un utilisateur en attendant qu'il soit stocké dans la session
        //-------------------------------------------------------------------------------------
        Utilisateur moi2 = bddUtilisateur.find(1);
 
        //-------------------------------------------------------------------------------------
        
        /* Préparation de l'objet formulaire */
        FormModificationUtilisateurChecker form = new FormModificationUtilisateurChecker();
        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.updateUtilisateur( request, moi2 );
        
        

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_UTILISATEUR, utilisateur );
        request.setAttribute( ATT_FORM, form );

        if ( form.getErreurs().isEmpty() ) {
        	bddUtilisateur.update(utilisateur);
            /* Si aucune erreur, alors affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
	}

}
