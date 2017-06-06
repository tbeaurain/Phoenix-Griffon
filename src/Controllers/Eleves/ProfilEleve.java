package Controllers.Eleves;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phoenixgriffon.JobIsep.*;

/**
 * Servlet implementation class ProfilEleve
 */
@WebServlet(name="/ProfilEleve", urlPatterns={"/ProfilEleve"})
public class ProfilEleve extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/ProfilEleve.jsp";
	
	public static final String ATT_UTILISATEUR = "utilisateur";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilEleve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Utilisateur user = Utilisateur_BDD.affichageUtilisateur(id);
		request.setAttribute("utilisateurID", user);
		this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO On va rajouter dans le post la recherche d'un utilisateur
		doGet(request, response);
	}

}
