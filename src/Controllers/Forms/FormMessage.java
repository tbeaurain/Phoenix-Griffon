package Controllers.Forms;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.phoenixgriffon.JobIsep.*;

import Controllers.DAO.DAO;
import Controllers.DAO.MessageDAO;
import Controllers.DAO.UtilisateurDAO;
import Controllers.Forms.FormsCheckers.FormMessageChecker;

@WebServlet(name="/FormMessage", urlPatterns={"/FormMessage"})
public class FormMessage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String ATT_MESSAGE = "message";
	public static final String ATT_FORM   = "form";

	public static final String VUE_SUCCES = "/WEB-INF/Eleves/AccueilEleve.jsp";
	public static final String VUE_FORM   = "/WEB-INF/Eleves/EcrireMessages.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormMessage() {
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
		FormMessageChecker form = new FormMessageChecker();

		/* Traitement de la requête et récupération du bean en résultant */
		Message msg = form.creerMessage( request );



		DAO<Message> bddMessage = new MessageDAO();   
		DAO<Utilisateur> bddUtilisateur = new UtilisateurDAO();

		Utilisateur user = bddUtilisateur.find(1);
		msg.setIdExpe(user.getId());;

		/* Ajout du bean et de l'objet métier à l'objet requête */
		request.setAttribute( ATT_MESSAGE, msg );
		request.setAttribute( ATT_FORM, form );

		if ( form.getErreurs().isEmpty() ) {
			/* Si aucune erreur, alors affichage de la fiche récapitulative */
			bddMessage.create(msg);
			this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
		} else {
			/* Sinon, ré-affichage du formulaire de création avec les erreurs */
			this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
		}
	}



}
