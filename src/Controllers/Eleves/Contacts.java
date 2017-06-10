package Controllers.Eleves;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phoenixgriffon.JobIsep.Utilisateur;

import Controllers.DAO.DAO;
import Controllers.DAO.UtilisateurDAO;

/**
 * Servlet implementation class Contacts
 */
@WebServlet(name="/Contacts", urlPatterns={"/Contacts"})
public class Contacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/Contacts.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contacts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Utilisateur> liste_utilisateurs = new ArrayList<>();

		DAO<Utilisateur> bddUtilisateur = new UtilisateurDAO();
		for (int i = 1; i<10; i++){
			if (bddUtilisateur.find(i).getNom() != null){
				liste_utilisateurs.add(bddUtilisateur.find(i));
			}
		}
		request.setAttribute("liste_utilisateurs", liste_utilisateurs);
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
