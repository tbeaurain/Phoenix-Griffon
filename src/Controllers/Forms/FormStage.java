package Controllers.Forms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phoenixgriffon.JobIsep.Stage;

import Controllers.Admin.ConnectionBDD;
import Controllers.Forms.FormsCheckers.FormStageChecker;


/**
 * Servlet implementation class FormStage
 */
@WebServlet(name="/FormStage", urlPatterns={"/FormStage"})
public class FormStage extends HttpServlet {
	
	
	public static final String VUE_FORM   = "/WEB-INF/Eleves/PropositionStage.jsp";
	
	public static final String ATT_Stage = "stage";
    public static final String ATT_FORM   = "form";
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
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConnectionBDD bdd = new ConnectionBDD();
		FormStageChecker form = new FormStageChecker();
		
		Stage stage = form.creerStage(request);
		
		bdd.addStage(stage);
		
		System.out.println(stage.getDescription());
		 /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_Stage, stage );
        request.setAttribute( ATT_FORM, form );

        if ( form.getErreurs().isEmpty() ) {
            /* Si aucune erreur, alors affichage de la fiche récapitulative */
           // this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
        
	}

}
