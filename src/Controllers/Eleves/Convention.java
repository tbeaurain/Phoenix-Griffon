package Controllers.Eleves;

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

/**
 * Servlet implementation class Convention
 */
@WebServlet(name="/Convention", urlPatterns={"/Convention"})
public class Convention extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/Convention.jsp";
	public static final String ATT_ERROR = "erreur";
    public static final String ATT_ERROR_MESSAGE = "messageErreur";
    public static final String ATT_STAGE = "stage";
    public static final String ATT_STAGE_VALIDE_FLAG = "stage_valide_flag";
	public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Convention() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
		
		ArrayList<EffectueStage> stagesEffectuesListe = new ArrayList<>(user.getEffectueStages());
		ArrayList<ValideStage> stagesValidesListe = new ArrayList<>(user.getValideStages());
		
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
