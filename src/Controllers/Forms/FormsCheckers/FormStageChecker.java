package Controllers.Forms.FormsCheckers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.phoenixgriffon.JobIsep.Stage;

/**
 * Servlet implementation class FormStageChecker
 */
@WebServlet("/FormStageChecker")
public class FormStageChecker{

	private static final String CHAMP_DESCRIPTION    				= "description";
	private static final String CHAMP_DATE_DEBUT 	 				= "dateDebut";
	private static final String CHAMP_DATE_FIN      				= "dateFin";
	private static final String CHAMP_ADRESSE_LIEU   				= "adresseLieu";
	private static final String CHAMP_VILLE_LIEU     				= "villeLieu";
	private static final String CHAMP_CODE_POSTAL_LIEU 				= "codePostalLieu";
	private static final String CHAMP_NOM_SERVICE 	 				= "nomService";
	private static final String CHAMP_TELEPHONE_STANDARD_LIEU 		= "telephoneStandardLieu";
	private static final String CHAMP_NOM_CONTACT_CONVENTION   		= "nomContactConvention";
	private static final String CHAMP_ADRESSE_CONTACT_CONVENTION	= "adresseContactConvention";
	private static final String CHAMP_CODE_POSTAL_CONVENTION    	= "codePostalContactConvention";
	private static final String CHAMP_VILLE_CONTATC_CONVENTION		= "villeContactConvention";
	private static final String CHAMP_TEL_CONTACT_CONVENTION   		= "telContactConvention";
	private static final String CHAMP_NOM_MAITRE_STAGE   			= "nomMaitreStage";
	private static final String CHAMP_TELEPHONE_MAITRE_STAGE    	= "telephoneMaitreStage";
	private static final String CHAMP_MAIL_MAITRE_STAGE	 			= "mailMaitreStage";
	private static final String CHAMP_FONCTION_MAITRE_STAGE   		= "fonctionMaitreStage";
	private static final String CHAMP_MAIL_CONTACT_CONVENTION  		= "mailContactConvention";
	private static final String CHAMP_REMUNERATION    				= "remuneration";



	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}

	public Stage creerStage( HttpServletRequest request ) {

		/*Récupération du contenu du formulaire*/
		String adresseLieu = getValeurChamp( request, CHAMP_ADRESSE_LIEU );
		String villeLieu = getValeurChamp( request, CHAMP_VILLE_LIEU );
		String codePostalLieu = getValeurChamp( request, CHAMP_CODE_POSTAL_LIEU );
		String nomService = getValeurChamp( request, CHAMP_NOM_SERVICE );
		String telephoneStandardLieu = getValeurChamp( request, CHAMP_TELEPHONE_STANDARD_LIEU );
		String nomContactConvention = getValeurChamp( request, CHAMP_NOM_CONTACT_CONVENTION );
		String adresseContactConvention = getValeurChamp( request, CHAMP_ADRESSE_CONTACT_CONVENTION  );
		String codePostalContactConvention = getValeurChamp( request, CHAMP_CODE_POSTAL_CONVENTION );
		String villeContactConvention = getValeurChamp( request, CHAMP_VILLE_CONTATC_CONVENTION );
		String telContactConvention = getValeurChamp( request, CHAMP_TEL_CONTACT_CONVENTION );
		String nomMaitreStage = getValeurChamp( request, CHAMP_NOM_MAITRE_STAGE );
		String telephoneMaitreStage = getValeurChamp( request, CHAMP_TELEPHONE_MAITRE_STAGE );
		String mailMaitreStage = getValeurChamp( request, CHAMP_MAIL_MAITRE_STAGE );
		String fonctionMaitreStage = getValeurChamp( request, CHAMP_FONCTION_MAITRE_STAGE );
		String mailContactConvention = getValeurChamp( request, CHAMP_MAIL_CONTACT_CONVENTION );


		String rem =getValeurChamp( request, CHAMP_REMUNERATION );
		if (rem == null) rem = "0"; 
		double remuneration = Double.parseDouble(rem);

		Date dateDebut = validDate(getValeurChamp( request, CHAMP_DATE_DEBUT ));
		Date dateFin = validDate(getValeurChamp( request, CHAMP_DATE_DEBUT ));
		
		
		String description = getValeurChamp( request, CHAMP_DESCRIPTION );

		/*Création de bean Offre*/
		Stage stage = new Stage();

		try {
			validationDescription( description );
		} catch ( Exception e ) {
			setErreur( CHAMP_DESCRIPTION, e.getMessage() );
		}
		stage.setDescription( description );

		try {
			validationAdresseLieu(adresseLieu);
		} catch ( Exception e ) {
			setErreur( CHAMP_ADRESSE_LIEU, e.getMessage() );
		}
		stage.setAdresseLieu(adresseLieu);

		try {
			validationVilleLieu(villeLieu);
		} catch ( Exception e ) {
			setErreur( CHAMP_VILLE_LIEU, e.getMessage() );
		}
		stage.setVilleLieu(villeLieu);

		try {
			validationCodePostalLieu(codePostalLieu);
		} catch ( Exception e ) {
			setErreur( CHAMP_CODE_POSTAL_LIEU, e.getMessage() );
		}
		stage.setCodePostalLieu(codePostalLieu);

		try {
			validationNomService(nomService);
		} catch ( Exception e ) {
			setErreur( CHAMP_NOM_SERVICE, e.getMessage() );
		}
		stage.setNomService(nomService);

		try {
			validationTelephoneStandardLieu(telephoneStandardLieu);
		} catch ( Exception e ) {
			setErreur( CHAMP_TELEPHONE_STANDARD_LIEU, e.getMessage() );
		}
		stage.setTelephoneStandardLieu(telephoneStandardLieu);

		try {
			validationNomContactConvention(nomContactConvention);
		} catch ( Exception e ) {
			setErreur( CHAMP_NOM_CONTACT_CONVENTION, e.getMessage() );
		}
		stage.setNomContactConvention(nomContactConvention);

		try {
			validationAdresseContactConvention(adresseContactConvention);
		} catch ( Exception e ) {
			setErreur( CHAMP_ADRESSE_CONTACT_CONVENTION , e.getMessage() );
		}
		stage.setAdresseContactConvention(adresseContactConvention);

		try {
			validationCodePostalContactConvention(codePostalContactConvention);
		} catch ( Exception e ) {
			setErreur( CHAMP_CODE_POSTAL_CONVENTION , e.getMessage() );
		}
		stage.setCodePostalContactConvention(codePostalContactConvention);

		try {
			validationVilleContactConvention(villeContactConvention);
		} catch ( Exception e ) {
			setErreur( CHAMP_VILLE_CONTATC_CONVENTION, e.getMessage() );
		}
		stage.setVilleContactConvention(villeContactConvention);

		try {
			validationTelContactConvention(telContactConvention);
		} catch ( Exception e ) {
			setErreur( CHAMP_TEL_CONTACT_CONVENTION, e.getMessage() );
		}
		stage.setTelContactConvention(telContactConvention);

		try {
			validationNomMaitreStage(nomMaitreStage);
		} catch ( Exception e ) {
			setErreur( CHAMP_NOM_MAITRE_STAGE, e.getMessage() );
		}
		stage.setNomMaitreStage(nomMaitreStage);

		try {
			validationTelephoneMaitreStage(telephoneMaitreStage);
		} catch ( Exception e ) {
			setErreur( CHAMP_TELEPHONE_MAITRE_STAGE, e.getMessage() );
		}
		stage.setTelephoneMaitreStage(telephoneMaitreStage);

		try {
			validationMailMaitreStage(mailMaitreStage);
		} catch ( Exception e ) {
			setErreur( CHAMP_MAIL_MAITRE_STAGE, e.getMessage() );
		}
		stage.setMailMaitreStage(mailMaitreStage);

		try {
			validationFonctionMaitreStage(fonctionMaitreStage);
		} catch ( Exception e ) {
			setErreur( CHAMP_FONCTION_MAITRE_STAGE, e.getMessage() );
		}
		stage.setFonctionMaitreStage(fonctionMaitreStage);

		try {
			validationMailContactConvention(mailContactConvention);
		} catch ( Exception e ) {
			setErreur( CHAMP_MAIL_CONTACT_CONVENTION, e.getMessage() );
		}
		stage.setMailContactConvention(mailContactConvention);

		stage.setRemuneration(remuneration);

		try {
			validationDateDebut(dateDebut);
		} catch ( Exception e ) {
			setErreur( CHAMP_DATE_DEBUT, e.getMessage() );
		}
		stage.setDateDebut(dateDebut);

		try {
			validationDateFin(dateFin);
		} catch ( Exception e ) {
			setErreur( CHAMP_DATE_FIN, e.getMessage() );
		}
		stage.setDateFin(dateFin);

		if ( erreurs.isEmpty() ) {
			resultat = "Succès de la création du stage.";
		} else {
			resultat = "Échec de la création du stage. Veuillez Compléter correctement les champs et réssayer.";
		}

		return stage;
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

	private void validationAdresseLieu( String adresseLieu ) throws Exception {
		if ( adresseLieu == null ) throw new Exception( "Entrez une adresse de lieu." );
	}

	private void validationVilleLieu( String villeLieu ) throws Exception {
		if ( villeLieu == null ) throw new Exception( "Entrez une ville de lieu." );
	}

	private void validationNomService( String nomService ) throws Exception {
		if ( nomService == null ) throw new Exception( "Entrez un nom de service." );
	}

	private void validationCodePostalLieu( String codePostalLieu ) throws Exception {
		if ( codePostalLieu != null ) {
			if ( codePostalLieu.length() < 5 ) {
				throw new Exception( "La code postal doit contenir au moins 5 caractères." );
			}
		} else {
			throw new Exception( "Merci d'entrer un code postal." );
		}
	}

	private void validationTelephoneStandardLieu( String telephoneStandardLieu ) throws Exception {
		if ( telephoneStandardLieu != null ) {
			if ( telephoneStandardLieu.length() < 10 ) {
				throw new Exception( "Le telephone doit contenir au moins 10 caractères." );
			}
		} else {
			throw new Exception( "Merci d'entrer un telephone." );
		}
	}

	private void validationNomContactConvention( String nomContactConvention ) throws Exception {
		if ( nomContactConvention == null ) throw new Exception( "Merci d'entrer un nom de contact." );
	}

	private void validationAdresseContactConvention( String adresseContactConvention ) throws Exception {
		if ( adresseContactConvention == null ) throw new Exception( "Merci une adresse de convention." );
	}

	private void validationVilleContactConvention( String villeContactConvention ) throws Exception {
		if ( villeContactConvention == null ) throw new Exception( "Merci d'entrer une ville." );
	}

	private void validationCodePostalContactConvention( String codePostalContactConvention ) throws Exception {
		if ( codePostalContactConvention == null ) throw new Exception( "Merci d'entrer un code postal." );
	}

	private void validationTelContactConvention( String telContactConvention ) throws Exception {
		if ( telContactConvention == null ) throw new Exception( "Merci d'entrer un telephone." );
	}

	private void validationNomMaitreStage( String nomMaitreStage ) throws Exception {
		if ( nomMaitreStage == null ) throw new Exception( "Merci d'entrer un nom de maitre apprentisage." );
	}

	private void validationTelephoneMaitreStage( String telephoneMaitreStage ) throws Exception {
		if ( telephoneMaitreStage == null ) throw new Exception( "Merci d'entrer un telphone." );
	}

	private void validationMailMaitreStage( String mailMaitreStage ) throws Exception {
		if ( mailMaitreStage == null ) throw new Exception( "Merci d'entrer un mail." );
	}

	private void validationFonctionMaitreStage( String fonctionMaitreStage ) throws Exception {
		if ( fonctionMaitreStage == null ) throw new Exception( "Merci d'entrer une fonction pour le maitre d'apprentissage." );
	}

	private void validationMailContactConvention( String mailContactConvention ) throws Exception {
		if ( mailContactConvention == null ) throw new Exception( "Merci d'entrer un mail." );
	}

	private void validationDateDebut( Date dateDebut ) throws Exception {
		if ( dateDebut == null ) throw new Exception( "La date de début n'est definie" );
	}

	private void validationDateFin( Date dateFin ) throws Exception {
		if ( dateFin == null ) throw new Exception( "Merci d'entrer une date de fin." );
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
	public Date validDate(String dateString) {
    	Date dt = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        try {
            dt = df.parse(dateString);
            return dt;
        } catch (Exception e) {
            return dt;
        }
       
    }
	
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {
			return null;
		} else {
			return valeur;
		}
	}
}
