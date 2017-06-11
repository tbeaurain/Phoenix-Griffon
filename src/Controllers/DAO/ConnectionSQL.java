package Controllers.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.phoenixgriffon.JobIsep.Offre;
import org.phoenixgriffon.JobIsep.Stage;
import org.phoenixgriffon.JobIsep.Utilisateur;

public class ConnectionSQL {

	private static String url = "jdbc:mysql://localhost:3306/jobisep";
	private static String user = "root";
	private static String passwd = "";
	
	private static Connection connect;

	public static Connection getInstance(){
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
			System.out.println(e);
		}
		if(connect == null){
			try {
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return connect;	
	}	
	public static void main(String[] args){

		DAO<Offre> test = new OffreDAO();
		DAO<Stage> stage = new StageDAO();
		DAO<Utilisateur> utilisateur = new UtilisateurDAO();
		Date dateNaissance = new Date (2017 - 1900, 1, 1 );
		
		Stage toto = new Stage();
		toto.setDateDebut(dateNaissance);
		toto.setDateFin(dateNaissance);
		
		toto = new Stage ("adresseLieu", "villeLieu", " codePosta", " nomService",
			"telephon", " nomContactConvention", " adresseContactConvention",
			"codePos", "villeContactConvention", "telC",
			"nomMaitreStage", "teleph", "mailMaitreStage", "fonctionMaitreStage",
			"mailContactConvention", 1234, dateNaissance,  dateNaissance, " description");
		
		
		
	}
}