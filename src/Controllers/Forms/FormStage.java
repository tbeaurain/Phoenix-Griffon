package Controllers.Forms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.phoenixgriffon.JobIsep.EffectueStage;
import org.phoenixgriffon.JobIsep.Stage;
import org.phoenixgriffon.JobIsep.Utilisateur;

import Controllers.DAO.DAO;
import Controllers.DAO.EffectueStageDAO;
import Controllers.DAO.StageDAO;
import Controllers.Forms.FormsCheckers.FormStageChecker;


/**
 * Servlet implementation class FormStage
 */
@WebServlet(name="/FormStage", urlPatterns={"/FormStage"})
public class FormStage extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String VUE_FORM   = "/WEB-INF/Eleves/PropositionStage.jsp";
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/StagesProposses.jsp";

	public static final String ATT_Stage = "stage";
	public static final String ATT_FORM   = "form";
	
	public static final String ATT_UTILISATEUR = "utilisateur"; // Nom de l'élément Représentant l'utilisateur disponible dans les JSP
	public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant
    public static final String ATT_USER_TYPE = "typeUtilisateur"; // Variable qui servira à identifier le type d'utilisateur (élève ou admin) dans la BDD
   
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormStage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FormStageChecker form = new FormStageChecker();

		Stage stage = form.creerStage(request);
		
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
		int typeUtilisateur = user.getId();
		request.setAttribute(ATT_USER_TYPE, typeUtilisateur);
		
		StageDAO bddStage = new StageDAO();
		DAO<EffectueStage> EffectueStageBDD = new EffectueStageDAO();
		
		EffectueStage effectueStage = new EffectueStage(stage, user);
		
		bddStage.create(stage);
		stage = bddStage.find(stage);
		
		EffectueStageBDD.create(effectueStage);
		
		/* Ajout du bean et de l'objet métier à l'objet requête */
		request.setAttribute( ATT_Stage, stage );
		request.setAttribute( ATT_FORM, form );

		if ( form.getErreurs().isEmpty() ) {
			/* Si aucune erreur, alors affichage de la fiche récapitulative */
			this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
		} else {
			/* Sinon, ré-affichage du formulaire de création avec les erreurs */
			this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
		}

	}

}
