package Controllers.Forms.FormsCheckers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.phoenixgriffon.JobIsep.Offre;

/**
 * Servlet implementation class FormStageChecker
 */
@WebServlet("/FormOffreChecker")
public class FormOffreChecker{
	private static final long serialVersionUID = 1L;
	
	private static final String CHAMP_UTILISATEUR    = "utilisateur"; // mettre l'utilisatieur qui cr�� l'action quand on aura des sessions
	private static final String CHAMP_TITRE          = "titre";
    private static final String CHAMP_DESCRIPTION    = "description";
    private static final String CHAMP_MISE_EN_LIGNE  = "mise_en_ligne"; // A r�cup�rer par la date actuelle
    private static final String CHAMP_DATES          = "dates";
    private static final String CHAMP_CONTACT        = "contact";
    private static final String CHAMP_LIEU           = "lieu";
       
    private String              resultat;
    private Map<String, String> erreurs         = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Offre creerOffre( HttpServletRequest request ) {
    	/*R�cup�ration du contenu du formulaire*/
        String titre = getValeurChamp( request, CHAMP_TITRE );
        String description = getValeurChamp( request, CHAMP_DESCRIPTION );
        String lieu = getValeurChamp( request, CHAMP_LIEU );
        String dates = getValeurChamp( request, CHAMP_DATES );
        String contact = getValeurChamp( request, CHAMP_CONTACT );
        
        /*Cr�ation de bean Offre*/
        Offre offre = new Offre();
        
        /*Appel des fonctions de validation des donn�es et ajout des donn�es au bean
         *	>Si une erreur est d�tect�e lors de la vaidation, ajout du message d'erreur dans la variable "erreurs"
         */
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
            resultat = "Succès de la création de l'offre de stage. Elle sera visible par les autres utilisateurs lorsqu'un administrateur l'aura validée.";
        } else {
            resultat = "Echec de la création de l'offre. Veuillez compléter correctement les champs du formulaire et réssayer.";
        }

        return offre;
    }

    private void validationTitre( String titre ) throws Exception {
        if ( titre != null ) {
            if ( titre.length() < 5 ) {
                throw new Exception( "Le nom titre doit contenir au moins 5 caract�res." );
            }
        } else {
            throw new Exception( "Merci d'entrer un titre pour cette offre." );
        }
    }

    private void validationDescription( String description ) throws Exception {
    	if ( description != null ) {
            if ( description.length() < 10 ) {
                throw new Exception( "La description doit contenir au moins 10 caract�res." );
            }
        } else {
            throw new Exception( "Merci d'entrer une descritpion." );
        }
    }

    private void validationLieu( String lieu ) throws Exception {
        if ( lieu != null ) {
            if ( lieu.length() < 2 ) {
                throw new Exception( "Le lieu doit contenir au moins 2 caract�res." );
            }
        } else {
            throw new Exception( "Merci d'entrer un lieu de d�roulement du stage." );
        }
    }

    private void validationDates( String dates ) throws Exception {
    	if ( dates != null && dates.length() < 5 ) {
            throw new Exception( "La description de la date doit contenir au moins 5 caract�res." );
        }
    }

    private void validationContact( String contact ) throws Exception {
    	if ( contact != null ) {
            if ( contact.length() < 5 ) {
                throw new Exception( "Le contact doit contenir au moins 5 caract�res." );
            }
        } else {
            throw new Exception( "Merci d'entrer un contact." );
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
