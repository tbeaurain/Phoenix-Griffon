package Model.Commun;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.phoenixgriffon.JobIsep.*;

public class RechercheOffre_BDD {

	public static ArrayList<Offre> listeOffres(){
		String url = "jdbc:mysql://localhost/jobisep";
		String login = "root";
		String passwd = "root";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Offre> liste = new ArrayList<Offre>();
		
		try{
			//Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			//Etape 2: récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			//Etape 3: création d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM offre;";
			//Etape 4: execution de la requête
			rs = st.executeQuery(sql);
			
			Boolean hasRows = false;
			//Etape 5: (parcours du ResultSet)
			while(rs.next()){
				hasRows = true;
				Offre offre = new Offre();
				offre.setTitre(rs.getString("titre"));
				offre.setDescription(rs.getString("description"));
				offre.setId(rs.getInt("id"));
				offre.setLieu(rs.getString("lieu"));
				//TODO changer les classes JAVA POJO pour pouvoir 
				liste.add(offre);
				System.out.println(rs.getString("titre") + " " + rs.getString("description"));
			}
			
			if(!hasRows){
				liste = null;
			}
		} catch(SQLException e){
			e.printStackTrace();
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} finally {
			try{
				//Etape 5: libérer ressources de la mémoire
				cn.close();
				st.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return liste;
	}
	
	
	public static ArrayList<Offre> rechercheOffre(String recherche){
		String url = "jdbc:mysql://localhost/jobisep";
		String login = "root";
		String passwd = "root";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Offre> liste = new ArrayList<Offre>();
		
		try{
			//Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			//Etape 2: récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			//Etape 3: création d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM offre where titre LIKE '%" + recherche + "%' OR description LIKE'%" + recherche + "%'OR lieu LIKE'%" + recherche + "%';";
			//Etape 4: execution de la requête
			rs = st.executeQuery(sql);
			
			//Etape 5: (parcours du ResultSet)
			while(rs.next()){
				Offre offre = new Offre();
				offre.setTitre(rs.getString("titre"));
				offre.setDescription(rs.getString("description"));
				offre.setId(rs.getInt("id"));
				offre.setLieu(rs.getString("lieu"));
				//TODO changer les classes JAVA POJO pour pouvoir 
				liste.add(offre);
				System.out.println(rs.getString("titre") + " " + rs.getString("description"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} finally {
			try{
				//Etape 5: libérer ressources de la mémoire
				cn.close();
				st.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return liste;
	}
}
