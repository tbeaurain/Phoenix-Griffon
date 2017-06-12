package Controllers.Eleves;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.phoenixgriffon.JobIsep.EffectueStage;
import org.phoenixgriffon.JobIsep.Stage;
import org.phoenixgriffon.JobIsep.Utilisateur;

import Controllers.DAO.StageDAO;
import Controllers.DAO.DAO;

/**
 * Servlet implementation class AfficherMaConvention
 */
@WebServlet(name="/AfficherMaConvention", urlPatterns={"/AfficherMaConvention"})
public class AfficherMaConvention extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/AfficherMaConvention.jsp";
	
	public static final String ATT_UTILISATEUR = "utilisateur"; // Nom de l'élément Représentant l'utilisateur disponible dans les JSP
	public static final String ATT_SESSION_USER = "sessionUtilisateur"; // Identifiant de la variable de Session contenant l'utilisateur courant
    public static final String ATT_USER_TYPE = "typeUtilisateur"; // Variable qui servira à identifier le type d'utilisateur (élève ou admin) dans la BDD
    public static final String ATT_ERROR = "erreur";
    public static final String ATT_ERROR_MESSAGE = "messageErreur";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherMaConvention() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
		
		boolean erreur = false;
		String messageErreur = "";
		
		Set<EffectueStage> stages = user.getEffectueStages();
		int stageNb = stages.size();
		if(stageNb==0){
			erreur = true;
			messageErreur = "Vous n'avez pas encore rempli de convention de stage.";
		}else if(stageNb>=1){
			if(stageNb>1){
				messageErreur = "Il semble que vous ayez rempli plusieurs conventions de stage. Veuillez contacter un adminisrateur. Affichage de votre première convention de stage uniquement.";
			}
			Iterator<EffectueStage> iter = stages.iterator();
			EffectueStage stageInfos = iter.next();
			int idStage = stageInfos.getId_stage();
			//DAO<Stage> stageDAO = new StageDAO();
			//Stage stage = stageDAO.find(idStage);
		}
		request.setAttribute(ATT_ERROR, erreur);
		request.setAttribute(ATT_ERROR_MESSAGE, messageErreur);
		
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
