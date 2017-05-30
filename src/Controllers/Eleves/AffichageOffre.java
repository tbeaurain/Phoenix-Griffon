package Controllers.Eleves;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phoenixgriffon.JobIsep.Offre;
import org.phoenixgriffon.JobIsep.Utilisateur;

import Model.Commun.AffichageOffre_BDD;

/**
 * Servlet implementation class AffichageOffre
 */
@WebServlet("/AffichageOffre")
public class AffichageOffre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/Offre.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageOffre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println("on arrive sur le get, id = " + id);
		Offre offre = AffichageOffre_BDD.afficheOffre(id);
		Utilisateur user = AffichageOffre_BDD.afficheUtilisateur(offre.getIdUtilisateur());
		request.setAttribute("offre", offre);
		request.setAttribute("utilisateur", user);
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
