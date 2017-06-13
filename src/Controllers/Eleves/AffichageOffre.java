package Controllers.Eleves;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phoenixgriffon.JobIsep.Offre;
import org.phoenixgriffon.JobIsep.Utilisateur;

import Controllers.DAO.DAO;
import Controllers.DAO.OffreDAO;

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
		int id = Integer.parseInt(request.getParameter("id"));
		
		DAO<Offre> offreBDD = new OffreDAO();
		
		Offre offre = offreBDD.find(id);
		Utilisateur user = offre.getUtilisateur();
		
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
