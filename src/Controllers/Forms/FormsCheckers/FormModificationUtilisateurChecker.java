package Controllers.Forms.FormsCheckers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.phoenixgriffon.JobIsep.Utilisateur;

/**
 * Servlet implementation class FormModificationUtilisateurChecker
 */
@WebServlet("/FormModificationUtilisateurChecker")
public class FormModificationUtilisateurChecker{
	private static final long serialVersionUID = 1L;
	
	private static final String CHAMP_PRENOM    			= "prenom";
	private static final String CHAMP_NOM          			= "nom";
    private static final String CHAMP_DATENAISSANCE    		= "dateNaissance";
    
    private static final String FORMAT_DATE            = "dd/MM/yyyy";
        
    private String              resultat;
    private Map<String, String> erreurs         = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public String getResultat() {
        return resultat;
    }
    
    public Utilisateur updateUtilisateur( HttpServletRequest request ) {
    	/*Récupération du contenu du formulaire*/
    	/*Première partie du formulaire*/
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        String nom = getValeurChamp( request, CHAMP_NOM );
        String dateNaissance = getValeurChamp( request, CHAMP_DATENAISSANCE );
        
        /*Deuxième partie du formulaire*/
        
        /*Chargement du bean de l'Utilisateur courant*/
       Utilisateur  utilisateur = new Utilisateur();
        
        /*Appel des fonctions de validation des données et ajout des données au bean
         *	>Si une erreur est détectée lors de la vaidation, ajout du message d'erreur dans la variable "erreurs"
         */
        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        utilisateur.setPrenom( prenom );

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( nom );
        
        try {
            validationDateNaissance( dateNaissance );
        } catch ( Exception e ) {
            setErreur( CHAMP_DATENAISSANCE, e.getMessage() );
        }
        Date dt = validDate(dateNaissance);
        utilisateur.setDateNaissance(dt);

        /* Appel des fonctions rejoutants les valeurs indépendantes du formulaire, ici : 
         * 		>date de création de l'offre
         * 		>utilisateur ayant créé l'offre
         */
        //offre.setUtilisateur( getUtilisateur() );
        

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la création de l'offre de stage. Elle sera visible par les autres utilisateurs lorsqu'un administrateur l'aura validée.";
        } else {
            resultat = "Échec de la création de l'offre. Veuillez compléter correctement les champs du formulaire et réssayer.";
        }

        return utilisateur;
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null ) {
            if ( prenom.length() < 2 ) {
                throw new Exception( "Le nom doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer votre prénom" );
        }
    }

    private void validationNom( String nom ) throws Exception {
    	if ( nom != null ) {
            if ( nom.length() < 10 ) {
                throw new Exception( "Le nom doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer votre nom." );
        }
    }

    private void validationDateNaissance( String dateNaissance ) throws Exception {
    	if ( dateNaissance != null ) {
            if ( dateNaissance.length() != 10 ) {
                throw new Exception( "La date de naissance doit contenir exactement 10 caractères : DD/MM/YYYY." );
            }else if(!isValidDate(dateNaissance)){
            	throw new Exception( "Impossible de traiter la date entrée, merci de bien la rentrer au format : DD/MM/YYYY." );
            }
        }
    }
    
    /**
     * Sert à tester une première fois si on peut bien convertir en date la chaine de caractère fournie.
     * Si non, l'exception est levée.
     * @param dateString
     * @return
     */
    public Boolean isValidDate(String dateString) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            df.parse(dateString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Sert à convertie une chaine de caractère en date.
     * On ne peut pas le faire dsans le mécanisle de try/catch.
     * Mais normalemet si on a déjà testé la fonction ci-dessous et qu'aucune exception n'apparait, comme on fait
     * exactement la même chose ici, on ne devrait pas avoir de problème.
     * @param dateString
     * @return
     */
    public Date validDate(String dateString) {
    	Date dt = null;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dt = df.parse(dateString);
            return dt;
        } catch (Exception e) {
            return dt;
        }
    }
    
    /**
     * Checks if the date is matching with the format : DD/MM/YYYY .
     * Une ancienne fonction permettant de vérifier un format avec un regex.
     * On la gardr quand même au cas où pour l'exemple, ça peut être utile.
     * @param date
     * @return
     */
    private boolean dateIsValid(String date){
    	return date.matches("(\\d{2}\\/){2}\\d{4}");  
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
    
    /*
     * Ajout de la fonction de récupération de l'utilisateur atuel
     */
    /*private Date getUtilisateur(){
    	
    }*/
    
}
