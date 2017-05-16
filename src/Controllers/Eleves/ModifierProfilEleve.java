package Controllers.Eleves;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifierProfilEleve
 */
@WebServlet(name="/ModifierProfilEleve", urlPatterns={"/ModifierProfilEleve"})
public class ModifierProfilEleve extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/ModifierProfilEleve.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProfilEleve() {
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
