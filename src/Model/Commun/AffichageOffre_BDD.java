package Model.Commun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.phoenixgriffon.JobIsep.*;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class AffichageOffre_BDD {

	public static Offre afficheOffre(String id){
		String url = "jdbc:mysql://localhost/jobisep";
		String login = "root";
		String passwd = "root";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Offre offre = null;
		
		try{
			//Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			//Etape 2: r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			//Etape 3: cr�ation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM offre where id='" + id + "';";
			//Etape 4: execution de la requ�te
			rs = st.executeQuery(sql);
			
			//Etape 5: (parcours du ResultSet)
			while(rs.next()){
				offre = new Offre(rs.getInt("id_utilisateur_propose"), rs.getString("titre"), rs.getString("description"), rs.getDate("mise_en_ligne"), rs.getString("dates"), rs.getString("contact"), rs.getString("lieu"));
				System.out.println("==================================\n"
						+ "On r�cup�re l'offre :\n" + rs.getString("titre") + " " + rs.getString("description") +
						"\n==================================");
			}
		} catch(SQLException e){
			e.printStackTrace();
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} finally {
			try{
				//Etape 5: lib�rer ressources de la m�moire
				cn.close();
				st.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return offre;
	}
	
	
	public static Utilisateur afficheUtilisateur(Integer id){
		String url = "jdbc:mysql://localhost/jobisep";
		String login = "root";
		String passwd = "root";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Utilisateur user = null;
		
		try{
			//Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			//Etape 2: r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			//Etape 3: cr�ation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM utilisateur where id='" + id + "';";
			//Etape 4: execution de la requ�te
			rs = st.executeQuery(sql);
			
			//Etape 5: (parcours du ResultSet)
			while(rs.next()){
				user = new Utilisateur();
				user.setIdentifiant(rs.getString("identifiant"));
				user.setPrenom(rs.getString("prenom"));
				user.setNom(rs.getString("nom"));
				System.out.println("==================================\n"
						+ "On r�cup�re l'utilisateur :\n" + rs.getString("prenom") + " " + rs.getString("nom") +
						"\n==================================");
			}
		} catch(SQLException e){
			e.printStackTrace();
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} finally {
			try{
				//Etape 5: lib�rer ressources de la m�moire
				cn.close();
				st.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return user;
	}
}
