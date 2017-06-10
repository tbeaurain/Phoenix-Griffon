package Controllers.Eleves;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phoenixgriffon.JobIsep.Utilisateur;

import Controllers.DAO.DAO;
import Controllers.DAO.UtilisateurDAO;

/**
 * Servlet implementation class ModifierMotdepasseEleve
 */
@WebServlet(name="/ModifierMotdepasseEleve", urlPatterns={"/ModifierMotdepasseEleve"})
public class ModifierMotdepasseEleve extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/ModifierMotdepasseEleve.jsp";
	public static final String ATT_UTILISATEUR 	= "utilisateur";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierMotdepasseEleve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
