package Controllers.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.phoenixgriffon.JobIsep.*;

public class UtilisateurDAO extends DAO <Utilisateur>{
	
	public Connection connect = ConnectionSQL.getInstance();
	
	public Utilisateur find(int id) {
		Utilisateur obj = new Utilisateur();
		String sql = "select * from utilisateur WHERE id = " + id;
		try {
			PreparedStatement pstmt  = this.connect.prepareStatement(sql);
			ResultSet rs  = pstmt.executeQuery();
			if(rs.first()){
				obj.setId(id);
				obj.setPrenom(rs.getString("prenom"));
				obj.setNom(rs.getString("nom"));
				obj.setDateNaissance(rs.getDate("date_naissance"));
				obj.setIdentifiant(rs.getString("identifiant"));
				obj.setMotdepasse(rs.getString("motdepasse"));
				StatutUtilisateur su =  new StatutUtilisateurDAO().find(rs.getInt("id_statut"));
				obj.setStatutUtilisateur(su);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public Utilisateur create(Utilisateur obj) {
		String sql = "INSERT INTO utilisateur (id_statut, prenom, nom, date_naissance, identifiant, motdepasse) "
				+ "VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = this.connect.prepareStatement(sql);
			pstmt.setInt(1, obj.getStatutUtilisateur().getId());
			pstmt.setString(2, obj.getPrenom());
			pstmt.setString(3, obj.getNom());
			pstmt.setDate(4, (Date) obj.getDateNaissance());
			pstmt.setString(5, obj.getIdentifiant());
			pstmt.setString(6, obj.getMotdepasse());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Utilisateur update(Utilisateur obj) {
		String sql = "UPDATE utilisateur "
				+ "SET prenom = ? , nom = ?, date_naissance = ?, motdepasse = ? "
				+ "WHERE id = ? ;";
		try {
			PreparedStatement pstmt = this.connect.prepareStatement(sql);
			int year = obj.getDateNaissance().getYear();
			int month = obj.getDateNaissance().getMonth();
			int day = obj.getDateNaissance().getDay();
			java.sql.Date date_naissance = new java.sql.Date(year, month, day);
			pstmt.setString(1, obj.getPrenom());
			pstmt.setString(2, obj.getNom());
			pstmt.setDate(3, date_naissance);
			pstmt.setString(4, obj.getIdentifiant());
			pstmt.setInt(5, obj.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public void delete(Utilisateur obj) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Utilisateur> recherche(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
