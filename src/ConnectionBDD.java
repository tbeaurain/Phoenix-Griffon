import java.sql.*;

public class ConnectionBDD {

	public static Connection connection(){

		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
			System.out.println(e);
		}

		String url = "jdbc:mysql://localhost:8889/lisa";
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

	public static void main(String[] args){
		connection();
	}

}
