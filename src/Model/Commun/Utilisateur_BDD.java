package Model.Commun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.phoenixgriffon.JobIsep.*;

public class Utilisateur_BDD {

	public static Utilisateur affichageUtilisateur(String id){
		String url = "jdbc:mysql://localhost/jobisep";
		String login = "root";
		String passwd = "root";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Utilisateur user = new Utilisateur();
		
		try{
			//Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			//Etape 2: r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			//Etape 3: cr�ation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM utilisateur WHERE id='" + id + "';";
			//Etape 4: execution de la requ�te
			rs = st.executeQuery(sql);
			
			Boolean hasRows = false;
			//Etape 5: (parcours du ResultSet)
			while(rs.next()){
				hasRows = true;
				user.setId(rs.getInt("id"));
				user.setIdentifiant(rs.getString("identifiant"));
				user.setPrenom(rs.getString("prenom"));
				user.setNom(rs.getString("nom"));
				user.setDateNaissance(rs.getDate("date_naissance"));
				System.out.println(rs.getString("prenom") + " " + rs.getString("nom"));
			}
			
			if(!hasRows){
				user = null;
			}
		} catch(SQLException e){
			e.printStackTrace();
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} finally {
			try{
				//Etape 6: lib�rer ressources de la m�moire
				cn.close();
				st.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	
}
