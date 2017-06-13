package Controllers.Forms.FormsCheckers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.phoenixgriffon.JobIsep.Message;
import org.phoenixgriffon.JobIsep.Utilisateur;

@WebServlet("/FormOffreChecker")
public class FormMessageChecker{
	private static final long serialVersionUID = 1L;

	private static final String CHAMP_UTILISATEUR      = "utilisateur";
	private static final String CHAMP_DESTINATAIREN    = "nom_recv"; // mettre l'utilisatieur qui cr�� l'action quand on aura des sessions
	private static final String CHAMP_DESTINATAIREP    = "prenom_recv";
	private static final String CHAMP_OBJET            = "titre";
	private static final String CHAMP_MESSAGE          = "message"; // A r�cup�rer par la date actuelle
	private static final String CHAMP_DATE             = "date";
	private static final String CHAMP_TIME             = "time";

	private String resultat;

	private Map<String, String> erreurs         = new HashMap<String, String>();
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	public String getResultat() {
		return resultat;
	}

	public Message creerMessage( HttpServletRequest request ) {
		/*R�cup�ration du contenu du formulaire*/
		String expe = getValeurChamp( request, CHAMP_UTILISATEUR );
		String nomRecv = getValeurChamp( request, CHAMP_DESTINATAIREN );
		String prenomRecv = getValeurChamp( request, CHAMP_DESTINATAIREP );
		String objet = getValeurChamp( request, CHAMP_OBJET );
		String message = getValeurChamp( request, CHAMP_MESSAGE );

		/*Cr�ation de bean Offre*/
		Message msg = new Message();

		/*Appel des fonctions de validation des donn�es et ajout des donn�es au bean
		 *	
		 *>Si une erreur est d�tect�e lors de la vaidation, ajout du message d'erreur dans la variable "erreurs"
		 */
		try {
			validationObjet( objet );
		} catch ( Exception e ) {
			setErreur( CHAMP_OBJET, e.getMessage() );
		}
		msg.setObj( objet );

		try {
			validationMessage( message );
		} catch ( Exception e ) {
			setErreur( CHAMP_MESSAGE, e.getMessage() );
		}
		msg.setMessage(message );

		/*try {
			validationDestN( nomRecv );
		} catch ( Exception e ) {
			setErreur( CHAMP_DESTINATAIREN, e.getMessage() );
		}

		try {
			validationDestP( prenomRecv );
		} catch ( Exception e ) {
			setErreur( CHAMP_DESTINATAIREP, e.getMessage() );
		}*/
		
		Utilisateur user = new Utilisateur();
		
		
		
		int idRecv = 40;
		msg.setIdRecv(idRecv);

		/*try {
			validationContact( contact );
		} catch ( Exception e ) {
			setErreur( CHAMP_CONTACT, e.getMessage() );
		}
		offre.setContact( contact );*/



		if ( erreurs.isEmpty() ) {
			resultat = "Succ�s Le message a bien �t� envoy�.";
		} else {
			resultat = "Echec, veuillez compl�ter correctement les champs du formulaire et r�ssayer.";
		}

		return msg;
	}

	private void validationObjet( String objet ) throws Exception {
		if ( objet == null ) {
			throw new Exception( "Merci d'entrer un objet pour ce message." );
		}
	}

	private void validationMessage( String message ) throws Exception {
		if ( message != null ) {
			if ( message.length() < 10 ) {
				throw new Exception( "Le messege doit contenir au moins 10 caract�res." );
			}
		} else {
			throw new Exception( "Merci d'entrer un message." );
		}
	}




	/*
	 * Ajoute un message correspondant au champ sp�cifi� à la map des erreurs.
	 */
	private void setErreur( String champ, String message ) {
		erreurs.put( champ, message );
	}

	/*
	 * M�thode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {
			return null;
		} else {
			return valeur;
		}
	}
}


