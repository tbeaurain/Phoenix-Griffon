package Controllers.Forms.FormsCheckers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.phoenixgriffon.JobIsep.Offre;

/**
 * Servlet implementation class FormStageChecker
 */
@WebServlet("/FormStageChecker")
public class FormStageChecker{
	private static final long serialVersionUID = 1L;
	
	private static final String CHAMP_TITRE          = "titre";
    private static final String CHAMP_DESCRIPTION    = "description";
    private static final String CHAMP_LIEU           = "lieu";
    private static final String CHAMP_MISE_EN_LIGNE  = "mise_en_ligne";
    private static final String CHAMP_DATES          = "dates";
    private static final String CHAMP_CONTACT        = "contact";
       

    private String              resultat;
    private Map<String, String> erreurs         = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Offre creerOffre( HttpServletRequest request ) {
        String titre = getValeurChamp( request, CHAMP_TITRE );
        String description = getValeurChamp( request, CHAMP_DESCRIPTION );
        String lieu = getValeurChamp( request, CHAMP_LIEU );
        String dates = getValeurChamp( request, CHAMP_DATES );
        String contact = getValeurChamp( request, CHAMP_CONTACT );

        Offre offre = new Offre();

        try {
            validationTitre( titre );
        } catch ( Exception e ) {
            setErreur( CHAMP_TITRE, e.getMessage() );
        }
        offre.setTitre( titre );

        try {
            validationDescription( description );
        } catch ( Exception e ) {
            setErreur( CHAMP_DESCRIPTION, e.getMessage() );
        }
        offre.setDescription( description );

        try {
            validationLieu( lieu );
        } catch ( Exception e ) {
            setErreur( CHAMP_LIEU, e.getMessage() );
        }
        offre.setLieu( lieu );

        try {
            validationDates( dates );
        } catch ( Exception e ) {
            setErreur( CHAMP_DATES, e.getMessage() );
        }
        offre.setDates( dates );

        try {
            validationContact( contact );
        } catch ( Exception e ) {
            setErreur( CHAMP_CONTACT, e.getMessage() );
        }
        offre.setContact( contact );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la création du client.";
        } else {
            resultat = "Échec de la création du client.";
        }

        return offre;
    }

    private void validationTitre( String titre ) throws Exception {
        if ( titre != null ) {
            if ( titre.length() < 5 ) {
                throw new Exception( "Le nom titre doit contenir au moins 5 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un titre pour cette offre." );
        }
    }

    private void validationDescription( String description ) throws Exception {
    	if ( description != null ) {
            if ( description.length() < 10 ) {
                throw new Exception( "La description doit contenir au moins 10 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer une descritpion." );
        }
    }

    private void validationLieu( String lieu ) throws Exception {
        if ( lieu != null ) {
            if ( lieu.length() < 2 ) {
                throw new Exception( "Le lieu doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer une lieu de déroulement du stage." );
        }
    }

    private void validationDates( String dates ) throws Exception {
    	if ( dates != null && dates.length() < 5 ) {
            throw new Exception( "La description de la date doit contenir au moins 5 caractères." );
        }
    }

    private void validationContact( String contact ) throws Exception {
    	if ( contact != null ) {
            if ( contact.length() < 5 ) {
                throw new Exception( "Le contact doit contenir au moins 5 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un contact." );
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
