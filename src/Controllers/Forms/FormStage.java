package Controllers.Forms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormStage
 */
@WebServlet(name="/FormStage", urlPatterns={"/FormStage"})
public class FormStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_STAGE = "stage";
    public static final String ATT_FORM   = "form";
	
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/OffresProposees.jsp";
	public static final String VUE_FORM   = "/WEB-INF/Eleves/PropositionStage.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormStage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* À la réception d'une requête GET, simple affichage du formulaire */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
