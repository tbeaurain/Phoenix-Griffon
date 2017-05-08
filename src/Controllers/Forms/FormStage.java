package Controllers.Forms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Stage;
import Controllers.Forms.FormsCheckers.FormStageChecker;

/**
 * Servlet implementation class FormStage
 */
@WebServlet(name="/FormStage", urlPatterns={"/FormStage"})
public class FormStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_STAGE = "stage";
    public static final String ATT_FORM   = "form";
	
	public static final String VUE_SUCCES = "/WEB-INF/Forms/FormStage.jsp";
	public static final String VUE_FORM   = "/WEB-INF/Forms/FormStage.jsp";
       
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
		/* Préparation de l'objet formulaire */
        FormStageChecker form = new FormStageChecker();

        /* Traitement de la requête et récupération du bean en résultant */
        Stage stage = form.creerStage( request );

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_STAGE, stage );
        request.setAttribute( ATT_FORM, form );

        if ( form.getErreurs().isEmpty() ) {
            /* Si aucune erreur, alors affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
	}

}
