import java.sql.*;

public class ConnectionBDD {

	public static Connection connection(){
		String url = "";
		String utilisateur = "root";
		String motDePasse = "root";
		Connection connexion = null;
		try {
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		} catch ( SQLException e ) {
		} finally {
		    if ( connexion != null )
		        try {
		            connexion.close();
		        } catch ( SQLException ignore ) {
		        }
		}
		return connexion;
	}

}
