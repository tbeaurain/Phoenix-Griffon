package Controllers.Forms;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phoenixgriffon.JobIsep.Utilisateur;

import Controllers.DAO.UtilisateurDAO;

/**
 * Servlet implementation class FormContact
 */
@WebServlet("/FormContact")
public class FormContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	public static final String ATT_RECHERCHE = "recherche";
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/Contacts.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormContact() {
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
		request.setCharacterEncoding("utf-8");
		String recherche = request.getParameter("titre");
		ArrayList<Utilisateur> liste_utilisateurs = null;
		UtilisateurDAO bddUtilisateur = new UtilisateurDAO();
		liste_utilisateurs =bddUtilisateur.recherche(recherche);
		request.setAttribute("liste_utilisateurs", liste_utilisateurs);
		response.setCharacterEncoding("utf-8");
		this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}

}
