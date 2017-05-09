package Controllers.Admin;

import java.sql.*;

import org.phoenixgriffon.JobIsep.*;

public class ConnectionBDD {

	public static Connection connection(){

		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
			System.out.println(e);
		}


		String url = "jdbc:mysql://localhost:8889/jobisep";
		String utilisateur = "root";
		String motDePasse = "root";
		Connection connexion = null;

		try {
			connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		} catch ( SQLException e ) {
			System.out.println(e);
		} finally {
			if ( connexion != null )
				try {
					connexion.close();
				} catch ( SQLException ignore ) {
				}
		}
		return connexion;
	}
	
	public static void addOffre(Offre offre){
		Connection conn = connection();
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate( "INSERT INTO offre (titre, description, dates, contact, utilisateur) "
					+ "VALUES ('"+ offre.getTitre() +"', " + offre.getDescription() +", " + offre.getDates() + 
					", " + offre.getContact() +","+ offre.getUtilisateur() +";" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addUtilisateur(Utilisateur utilisateur){
		Connection conn = connection();
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate( "INSERT INTO utilisateur (statutUtilisateur, prenom, nom, dateNaissance, identifiant, motdepasse) "
					+ "VALUES ('"+ utilisateur.getStatutUtilisateur() +"', " + utilisateur.getPrenom() +", " + utilisateur.getNom() + 
					", " + utilisateur.getDateNaissance() +","+ utilisateur.getIdentifiant() +","+ utilisateur.getMotdepasse() +";" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addEntreprise(Entreprise entreprise){
		Connection conn = connection();
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate( "INSERT INTO offre (nom, siret, codeApe, adresseSiege, villeSiege, codePostalSiege, telephoneSiege) "
					+ "VALUES ('"+ entreprise.getNom() +"', " + entreprise.getSiret() +", " + entreprise.getCodeApe() +"," + entreprise.getAdresseSiege() + 
					", " + entreprise.getVilleSiege() +","+ entreprise.getCodePostalSiege() +","+ entreprise.getTelephoneSiege() +";" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args){
		connection();
	}

}