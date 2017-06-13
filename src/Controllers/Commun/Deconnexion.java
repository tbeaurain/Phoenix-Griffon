package Controllers.Commun;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Deconnexion
 */
@WebServlet(name="/Deconnexion", urlPatterns={"/Deconnexion"})
public class Deconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_SUCCESS = "/Phoenix-Griffon/Connexion.html";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deconnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Connexion.html");
		dispatcher.include(request, response);*/
		
		/* Récupération et destruction de la session en cours*/
		HttpSession session = request.getSession();
		session.invalidate();
		
		/*redirection vers la page de connexion*/
		response.sendRedirect( VUE_SUCCESS );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
