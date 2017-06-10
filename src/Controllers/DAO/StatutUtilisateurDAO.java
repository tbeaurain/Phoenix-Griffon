package Controllers.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.phoenixgriffon.JobIsep.StatutUtilisateur;

public class StatutUtilisateurDAO extends DAO <StatutUtilisateur>{
	
	public Connection connect = ConnectionSQL.getInstance();
	
	public StatutUtilisateur find(int id) {
		StatutUtilisateur obj = new StatutUtilisateur();
		String sql = "select * from statut_utilisateur WHERE id = " + id;
		try {
			PreparedStatement pstmt  = this.connect.prepareStatement(sql);
			ResultSet rs  = pstmt.executeQuery();
			if(rs.first())
				obj = new StatutUtilisateur(rs.getString("libelle"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;

	}

	@Override
	public StatutUtilisateur create(StatutUtilisateur statutUtilisateur) {
		String statut = statutUtilisateur.getLibelle();

		String sql ="INSERT INTO statut_utilisateur (libelle) VALUES(?)" ;
		try {
			PreparedStatement pstmt = this.connect.prepareStatement(sql);
			pstmt.setString(1, statut);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statutUtilisateur;
	}

	public StatutUtilisateur update(StatutUtilisateur obj) {
		return null;
	}

	public void delete(StatutUtilisateur obj) {
	}

	public ArrayList<StatutUtilisateur> recherche(String name) {
		return null;
	}

}
