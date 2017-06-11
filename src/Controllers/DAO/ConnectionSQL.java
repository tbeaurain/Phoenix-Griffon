package Controllers.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.phoenixgriffon.JobIsep.EffectueStage;
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
		DAO<Utilisateur> uti = new UtilisateurDAO();
		DAO<Stage> st = new StageDAO();
		DAO<EffectueStage> es = new EffectueStageDAO();
		
		Utilisateur user = uti.find(1);
		Stage stage = st.find(25);
		EffectueStage efec = new EffectueStage(stage,user);
		
		es.create(efec);
		
	}
}
