package Controllers.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {

	private static String url = "jdbc:mysql://localhost:3306/jobisep";
	private static String user = "root";
	private static String passwd = "root";

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
		UtilisateurDAO ut = new UtilisateurDAO();
		StatutUtilisateurDAO st = new StatutUtilisateurDAO();
		System.out.println(st.find(1).getUtilisateurs());
	}
}
