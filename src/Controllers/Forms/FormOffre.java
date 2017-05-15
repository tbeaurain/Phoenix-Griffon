package Controllers.Forms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;
import org.phoenixgriffon.JobIsep.*;

import Controllers.Admin.ConnectionBDD;
import Controllers.Forms.FormsCheckers.FormOffreChecker;

/**
 * Servlet implementation class FormStage
 */
@WebServlet(name="/FormOffre", urlPatterns={"/FormOffre"})
public class FormOffre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_OFFRE = "offre";
    public static final String ATT_FORM   = "form";
	
	public static final String VUE_SUCCES = "/WEB-INF/Eleves/OffresProposees.jsp";
	public static final String VUE_FORM   = "/WEB-INF/Eleves/PropositionOffre.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormOffre() {
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
        FormOffreChecker form = new FormOffreChecker();

        /* Traitement de la requête et récupération du bean en résultant */
        Offre offre = form.creerOffre( request );
        
        
        
        Utilisateur utilisateur = new Utilisateur ();
        utilisateur.setId(1);
        
        offre.setUtilisateur(utilisateur);
        
        ConnectionBDD bdd = new ConnectionBDD();
        
        bdd.addOffre(offre);
        
        

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_OFFRE, offre );
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
