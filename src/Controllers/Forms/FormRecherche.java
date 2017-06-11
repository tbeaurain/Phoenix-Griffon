package Controllers.Forms;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.phoenixgriffon.JobIsep.*;

import Controllers.DAO.DAO;
import Controllers.DAO.OffreDAO;
/**
 * Servlet implementation class FormRecherche
 */
@WebServlet("/FormRecherche")
public class FormRecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	public static final String ATT_RECHERCHE = "recherche";
	
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/RechercheOffre.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormRecherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String recherche = request.getParameter("titre");
		ArrayList<Offre> liste_offres = null;
		OffreDAO bddOffre = new OffreDAO();
		liste_offres =bddOffre.recherche(recherche);
		request.setAttribute("liste_offres", liste_offres);
		response.setCharacterEncoding("utf-8");
		this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}
}