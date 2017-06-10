package Controllers.Forms.FormsCheckers;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.phoenixgriffon.JobIsep.Utilisateur;


/**
 * Servlet implementation class FormModificationMotdepasseUtilisateurChecker
 */
@WebServlet("/FormModificationMotdepasseUtilisateurChecker")
public class FormModificationMotdepasseUtilisateurChecker{
	private static final long serialVersionUID = 1L;
	
	private static final String CHAMP_ANCIEN_MDP    			= "motdepasse";
	private static final String CHAMP_NOUVEAU_MDP          			= "nouveau_motdepasse";
    private static final String CHAMP_CONFIRMATION_NOUVEAU_MDP    		= "confirmation_motdepasse";
    
    private String              resultat;
    private Map<String, String> erreurs         			= new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public String getResultat() {
        return resultat;
    }
    
    public Utilisateur updateUtilisateur( HttpServletRequest request, Utilisateur user ) {
    	/*Récupération du contenu du formulaire*/
    	/*Première partie du formulaire*/
        String ancien_mdp = getValeurChamp( request, CHAMP_ANCIEN_MDP );
        String nouveau_mdp = getValeurChamp( request, CHAMP_NOUVEAU_MDP );
        String confirm_nouveau_mdp = getValeurChamp( request, CHAMP_CONFIRMATION_NOUVEAU_MDP );
        
        /*Deuxième partie du formulaire*/
        
        /*Chargement du bean de l'Utilisateur courant*/
       Utilisateur  utilisateur = user;
        
        /*Appel des fonctions de validation des données et ajout des données au bean
         *	>Si une erreur est détectée lors de la vaidation, ajout du message d'erreur dans la variable "erreurs"
         */
        try {
            validationAncienMDP( ancien_mdp, user );
        } catch ( Exception e ) {
            setErreur( CHAMP_ANCIEN_MDP, e.getMessage() );
        }

        try {
            validationNouveauMDP( nouveau_mdp );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOUVEAU_MDP, e.getMessage() );
        }
        
	    try {
	        validationConfirmationNouveauMDP( nouveau_mdp, confirm_nouveau_mdp );
	    } catch ( Exception e ) {
	        setErreur( CHAMP_CONFIRMATION_NOUVEAU_MDP, e.getMessage() );
	    }
        
                

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la modification de votre mot de passe.";
            utilisateur.setMotdepasse(nouveau_mdp);
        } else {
            resultat = "Échec de la modification des votre mot de passe."
            		+ "Veuillez compléter les champs du formulaire correctement et réessayer.";
        }

        return utilisateur;
    }
    
    private void validationAncienMDP( String ancien_mdp, Utilisateur usr ) throws Exception {
        if ( ancien_mdp != null ) {
        	String mdp = usr.getMotdepasse();
            if ( !ancien_mdp.equals(mdp) ) {
                throw new Exception( "Le mot de passe doit correspondre avec le mot de passe déjà stocké dans la base de données." );
            }
        } else {
            throw new Exception( "Merci d'entrer votre ancien mot de passe" );
        }
    }
    
    private void validationNouveauMDP( String nouveau_mdp ) throws Exception {
        if ( nouveau_mdp != null ) {
            if ( nouveau_mdp.length() < 6 ) {
                throw new Exception( "Le nouveau mot de passe doit contenir au moins 6 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un nouveau mot de passe." );
        }
    }
    
    private void validationConfirmationNouveauMDP( String nouveau_mdp, String conf_nouveau_MDP ) throws Exception {
        if ( conf_nouveau_MDP != null ) {
            if ( nouveau_mdp != null ) {
            	if( !conf_nouveau_MDP.equals(nouveau_mdp) ){
            		throw new Exception( "La confirmation ne correspond pas au nouveau mot de passe que vous avez entré." );
            	}
            }else{
            	throw new Exception( "Comparaison au nouveau mot de passe impossible car celui-ci est nul." );
            }
        } else {
            throw new Exception( "Merci d'entrer la confirmation de votre nouveau mot de passe." );
        }
    }
    
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
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
