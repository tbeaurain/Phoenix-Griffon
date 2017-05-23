package Controllers.Forms;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.phoenixgriffon.JobIsep.*;

import Model.Commun.RechercheOffre_BDD;
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
		String recherche = request.getParameter("titre");
		System.out.println("mot tapé : " + recherche);
		ArrayList<Offre> liste_offres = null;
		
		liste_offres = RechercheOffre_BDD.rechercheOffre(recherche);
		request.setAttribute("liste_offres", liste_offres);
		this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}
}