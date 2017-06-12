package Controllers.Forms;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.phoenixgriffon.JobIsep.EffectueStage;
import org.phoenixgriffon.JobIsep.Stage;
import org.phoenixgriffon.JobIsep.Utilisateur;
import org.phoenixgriffon.JobIsep.ValideStage;

import Controllers.DAO.DAO;
import Controllers.DAO.EffectueStageDAO;
import Controllers.DAO.StageDAO;
import Controllers.DAO.UtilisateurDAO;
import Controllers.DAO.ValideStageDAO;
import Controllers.Forms.FormsCheckers.FormStageChecker;


/**
 * Servlet implementation class FormStage
 */
@WebServlet(name="/FormStage", urlPatterns={"/FormStage"})
public class FormStage extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String VUE_FORM   = "/WEB-INF/Eleves/PropositionStage.jsp";
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/AfficherMaConvention.jsp";

	public static final String ATT_Stage = "stage";
	public static final String ATT_FORM   = "form";
	
	public static final String ATT_UTILISATEUR = "utilisateur"; // Nom de l'élément Représentant l'utilisateur disponible dans les JSP
	public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant
    public static final String ATT_USER_TYPE = "typeUtilisateur"; // Variable qui servira à identifier le type d'utilisateur (élève ou admin) dans la BDD
    public static final String ATT_ERROR = "erreur";
    public static final String ATT_ERROR_MESSAGE = "messageErreur";
    public static final String ATT_STAGE = "stage";
    public static final String ATT_STAGE_VALIDE_FLAG = "stage_valide_flag";
    
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
		// Création de l'objet Stage correspondant aux informations entrées dans le formulaire
		FormStageChecker form = new FormStageChecker();
		Stage stage = form.creerStage(request);
		
		// Récupération de l'utilisateur de la session
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
		
		// Récupération du type d'utilisateur (élève ou admin) et transmission à la JSP
		int typeUtilisateur = user.getId();
		request.setAttribute(ATT_USER_TYPE, typeUtilisateur);

		/* Ajout du bean et de l'objet métier à l'objet requête */
		request.setAttribute( ATT_Stage, stage );
		request.setAttribute( ATT_FORM, form );

		if ( form.getErreurs().isEmpty() ) {
			// Dans tous les cas, si il y a une erreur dans les valeurs entrées on ne fait aucune action 
			// et on renvoie ce qui a été complété au formulaire pour que l'utilisateur le corrige
			
			// si il n'y a pas d'erreur
			// Il faut : Vérifier que l'utilisateur n'a pas déjà un stage Effectué
			// si oui on modifie ce stage et on garde l'objet stageEffectue existant
			//		Par contre on supprime l'objet valideStage associé
			// Si non on créé un nouveau stage et l'objet stageEffectue associé
			
			// Ensuite on update la session de l'utilisateur pour que nos modificay=tions/ ajouts soient pris en compte
			ArrayList<EffectueStage> stagesEffectuesListe = new ArrayList<>(user.getEffectueStages());
			ArrayList<ValideStage> stagesValidesListe = new ArrayList<>(user.getValideStages());
			
			boolean stageEffectueFlag = false;
			boolean stageValideFlag = false;
			String messageErreur = "";
			boolean erreur = false;
			int stagesEffectuesNb = stagesEffectuesListe.size();
			int stagesValidesNb = stagesValidesListe.size();
			if(stagesEffectuesNb==0){
				StageDAO bddStage = new StageDAO();
				DAO<EffectueStage> EffectueStageBDD = new EffectueStageDAO();
				
				bddStage.create(stage);
				//Update de l'ID du stage qui vient d'être créé
				stage = bddStage.find(stage);
				EffectueStage effectueStage = new EffectueStage(stage, user);
				EffectueStageBDD.create(effectueStage);
			}else{
				if(stagesEffectuesNb>1){
					messageErreur = "Il semble que vous ayez rempli plusieurs conventions de stage. Veuillez contacter un adminisrateur. Affichage d'une convention de stage uniquement.";
				}
				stageEffectueFlag=true;
				Stage stageEffectue = stagesEffectuesListe.get(0).getId_stage();
				StageDAO bddStage = new StageDAO();
				stage.setId(stageEffectue.getId());
				bddStage.update(stage);
				if(stagesValidesNb>0){
					if(stagesValidesNb>1){
						messageErreur = messageErreur+" Il semble que vous ayez plusieurs stages validés. Veuillez contacter un administrateur.";
					}
					Stage stageValide = stagesValidesListe.get(0).getStage();
					if(stageEffectue.getId()==stageValide.getId()){
						stageValideFlag=true;
						ValideStageDAO VSDAO = new ValideStageDAO();
						VSDAO.delete(stagesValidesListe.get(0));
					}
				}
			}
			request.setAttribute(ATT_STAGE, stage);
			request.setAttribute(ATT_ERROR, erreur);
			request.setAttribute(ATT_ERROR_MESSAGE, messageErreur);
			request.setAttribute(ATT_STAGE_VALIDE_FLAG, stageValideFlag);
			
			
			// On update les information sur l'utilisateur stockées dans la session
			DAO<Utilisateur> bddUtilisateur = new UtilisateurDAO();
			session.setAttribute( ATT_SESSION_USER , bddUtilisateur.find(user.getId()));
			this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
		} else {
			/* Sinon, ré-affichage du formulaire de création avec les erreurs */
			this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
		}

	}

}
