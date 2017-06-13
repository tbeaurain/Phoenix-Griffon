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
import Controllers.DAO.UtilisateurDAO;
import Controllers.Forms.FormsCheckers.FormOffreChecker;

/**
 * Servlet implementation class FormStage
 */
@WebServlet(name="/FormOffre", urlPatterns={"/FormOffre"})
public class FormOffre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ATT_OFFRE = "offre";
	public static final String ATT_FORM   = "form";

	public static final String VUE_SUCCES = "/WEB-INF/Commun/OffresProposees.jsp";
	public static final String VUE_FORM   = "/WEB-INF/Commun/ProposerOffre.jsp";
	
	public static final String ATT_UTILISATEUR = "utilisateur"; // Nom de l'élément Représentant l'utilisateur disponible dans les JSP
	public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant
    public static final String ATT_USER_TYPE = "typeUtilisateur"; // Variable qui servira à identifier le type d'utilisateur (élève ou admin) dans la BDD
    public static final String ATT_AFFICHER_OFFRE = "afficherOffre";
    public static final String ATT_OFFRE_LISTE = "listeOffres";
       

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormOffre() {
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
		
		/* Préparation de l'objet formulaire */
		FormOffreChecker form = new FormOffreChecker();

		/* Traitement de la requête et récupération du bean en résultant */
		Offre offre = form.creerOffre( request );

		
		
		DAO<Offre> bddOffre = new OffreDAO();   
		DAO<Utilisateur> bddUtilisateur = new UtilisateurDAO();
		
		
		offre.setUtilisateur(user);

		/* Ajout du bean et de l'objet métier à l'objet requête */
		request.setAttribute( ATT_OFFRE, offre );
		request.setAttribute( ATT_FORM, form );
		
		
		
		

		if ( form.getErreurs().isEmpty() ) {
			/* Si aucune erreur, alors affichage de la fiche récapitulative */
				bddOffre.create(offre);
				session.setAttribute( ATT_SESSION_USER , bddUtilisateur.find(user.getId()));
			this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
		} else {
			/* Sinon, ré-affichage du formulaire de création avec les erreurs */
			this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
		}
	}

}
