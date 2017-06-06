package Controllers.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.phoenixgriffon.JobIsep.Offre;
import org.phoenixgriffon.JobIsep.StatutUtilisateur;
import org.phoenixgriffon.JobIsep.Utilisateur;

public class ConnectionSQL {

	private static String url = "jdbc:mysql://localhost:3306/jobisep";
	private static String user = "root";
	private static String passwd = "root";
	
	private static Connection connect;

	public static Connection getInstance(){
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

		DAO<Utilisateur> test = new UtilisateurDAO();
		
		StatutUtilisateur admin = new StatutUtilisateur("eleve");
		admin.setId(1);
		
		Date dateNaissance = new Date (2017 - 1900, 1, 1 );
		
		Utilisateur users = new Utilisateur(admin, "beauté", "trop", dateNaissance, "bonne",
				"je taime");
		
		users.setId(1);
		
		Offre offre = new Offre (users, "titre", "desci", dateNaissance, "date", "contact", "lieu");
		
		
		System.out.println(test.find(1).getNom());
	}
}
