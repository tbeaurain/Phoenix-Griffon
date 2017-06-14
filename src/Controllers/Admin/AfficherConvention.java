package Controllers.Admin;

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
import Controllers.DAO.UtilisateurDAO;

/**
 * Servlet implementation class AfficherConvention
 */
@WebServlet(name="/AfficherConvention", urlPatterns={"/AfficherConvention"})
public class AfficherConvention extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_SUCCES = "/WEB-INF/Admin/AfficherConvention.jsp";
	
	public static final String ATT_UTILISATEUR = "utilisateur"; // Nom de l'élément Représentant l'utilisateur disponible dans les JSP
	public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant
    public static final String ATT_USER_TYPE = "typeUtilisateur"; // Variable qui servira à identifier le type d'utilisateur (élève ou admin) dans la BDD
    public static final String ATT_ERROR = "erreur";
    public static final String ATT_ERROR_MESSAGE = "messageErreur";
    public static final String ATT_STAGE = "stage";
    public static final String ATT_STAGE_VALIDE_FLAG = "stage_valide_flag";
    public static final String ATT_ELEVE = "eleve";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherConvention() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eleveID =Integer.parseInt(request.getParameter("ideleve"));
		
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
		
		DAO<Utilisateur> usrbdd = new UtilisateurDAO();
		Utilisateur eleve = usrbdd.find(eleveID);
		request.setAttribute(ATT_ELEVE, eleve);
		
		
		ArrayList<EffectueStage> stagesEffectuesListe = new ArrayList<>(eleve.getEffectueStages());
		ArrayList<ValideStage> stagesValidesListe = new ArrayList<>(eleve.getValideStages());
		
		boolean stageValideFlag= false;
		boolean erreur = false;
		String messageErreur = "";
		int stagesEffectuesNb = stagesEffectuesListe.size();
		int stagesValidesNb = stagesValidesListe.size();
		if(stagesEffectuesNb==0){
			erreur = true;
			messageErreur = "Vous n'avez pas encore rempli de convention de stage.";
		}else{
			if(stagesEffectuesNb>1){
				messageErreur = "Il semble que vous ayez rempli plusieurs conventions de stage. Veuillez contacter un adminisrateur. Affichage de votre première convention de stage uniquement.";
			}
			Stage stageEffectue = stagesEffectuesListe.get(0).getId_stage();
			if(stagesValidesNb>0){
				if(stagesValidesNb>1){
					messageErreur = messageErreur+" Il semble que vous ayez plusieurs stages validés. Veuillez contacter un administrateur.";
				}
				Stage stageValide = stagesValidesListe.get(0).getStage();
				if(stageEffectue.getId()==stageValide.getId()){
					stageValideFlag=true;
				}
			}
			request.setAttribute(ATT_STAGE, stageEffectue);
		}
		request.setAttribute(ATT_ERROR, erreur);
		request.setAttribute(ATT_ERROR_MESSAGE, messageErreur);
		request.setAttribute(ATT_STAGE_VALIDE_FLAG, stageValideFlag);
		
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
