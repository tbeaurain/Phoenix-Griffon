package Controllers.Eleves;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phoenixgriffon.JobIsep.Offre;

import Controllers.DAO.DAO;
import Controllers.DAO.OffreDAO;

/**
 * Servlet implementation class RechercheOffre
 */
@WebServlet(name="/RechercheOffre", urlPatterns={"/RechercheOffre"})
public class RechercheOffre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/RechercheOffre.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercheOffre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Offre> liste_offres = new ArrayList<>();

		DAO<Offre> offreBDD = new OffreDAO();
		for (int i = 1; i<10; i++){
			if (offreBDD.find(i).getDescription() != null){
				liste_offres.add(offreBDD.find(i));
			}
		}
		//liste_offres = RechercheOffre_BDD.listeOffres();
		request.setAttribute("liste_offres", liste_offres);
		this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}

}
