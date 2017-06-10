package Controllers.Eleves;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phoenixgriffon.JobIsep.Utilisateur;

import Controllers.DAO.DAO;
import Controllers.DAO.UtilisateurDAO;

/**
 * Servlet implementation class ModifierProfilEleve
 */
@WebServlet(name="/ModifierProfilEleve", urlPatterns={"/ModifierProfilEleve"})
public class ModifierProfilEleve extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_SUCCES 		= "/WEB-INF/Eleves/ModifierProfilEleve.jsp";
	public static final String ATT_UTILISATEUR 	= "utilisateur";
	
    public static final String ATT_DATE   		= "date";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProfilEleve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// création du Bean de l'utilisateur courant
		DAO<Utilisateur> bddUtilisateur = new UtilisateurDAO();
        //Juste pour la création d'un utilisateur en attendant qu'il soit stocké dans la session
        //-------------------------------------------------------------------------------------
        Utilisateur utilisateur_courant = bddUtilisateur.find(1);
        // Envoi à la JSP du bean de l'utilisateur courant permettant le préremplossage des champs du formulaire avec
        // les valeurs atuelles
        request.setAttribute( ATT_UTILISATEUR, utilisateur_courant );
        // On rajoute aussi un String correspondant au format permettant de préafficher la date.
        //String formated_date = utilisateur_courant.getDateNaissance().getDay()+"-"+utilisateur_courant.getDateNaissance().getMonth()+"-"+utilisateur_courant.getDateNaissance().getYear();
        //request.setAttribute( ATT_DATE, formated_date );
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
