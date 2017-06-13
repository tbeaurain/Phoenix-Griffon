package Controllers.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.phoenixgriffon.JobIsep.*;

public class UtilisateurDAO extends DAO <Utilisateur>{

	public Connection connect = ConnectionSQL.getInstance();

	public Utilisateur find(int id) {
		Utilisateur obj = new Utilisateur();
		String sql =  "select * from utilisateur where id = " + id;
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
				obj.setOffres(new OffreDAO().findUtilisateur(id));
				obj.setValideStages(new ValideStageDAO().findUtilisateur(id));
				obj.setEffectueStages(new EffectueStageDAO().findUtilisateur(id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Utilisateur find(String prenom, String nom) {
		Utilisateur obj = new Utilisateur();
		String sql =  "select * from utilisateur where prenom = ? and nom = ?" ;
		try {
			PreparedStatement pstmt  = this.connect.prepareStatement(sql);
			pstmt.setString(1, prenom);
			pstmt.setString(2, nom);
			ResultSet rs  = pstmt.executeQuery();
			if(rs.first()){
				int id = rs.getInt("id");
				obj.setId(id);
				obj.setPrenom(rs.getString("prenom"));
				obj.setNom(rs.getString("nom"));
				obj.setDateNaissance(rs.getDate("date_naissance"));
				obj.setIdentifiant(rs.getString("identifiant"));
				obj.setMotdepasse(rs.getString("motdepasse"));
				StatutUtilisateur su =  new StatutUtilisateurDAO().find(rs.getInt("id_statut"));
				obj.setStatutUtilisateur(su);	
				obj.setOffres(new OffreDAO().findUtilisateur(id));
				obj.setValideStages(new ValideStageDAO().findUtilisateur(id));
				obj.setEffectueStages(new EffectueStageDAO().findUtilisateur(id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public Utilisateur connexion(String Pseudo, String mdp) {
		Utilisateur obj = new Utilisateur();
		String sql =  "select * from utilisateur where identifiant = ? and motdepasse = ?" ;
		try {
			PreparedStatement pstmt  = this.connect.prepareStatement(sql);
			pstmt.setString(1, Pseudo);
			pstmt.setString(2, mdp);
			ResultSet rs  = pstmt.executeQuery();
			if(rs.first()){
				int id = rs.getInt("id");
				obj.setId(id);
				obj.setPrenom(rs.getString("prenom"));
				obj.setNom(rs.getString("nom"));
				obj.setDateNaissance(rs.getDate("date_naissance"));
				obj.setIdentifiant(rs.getString("identifiant"));
				obj.setMotdepasse(rs.getString("motdepasse"));
				StatutUtilisateur su =  new StatutUtilisateurDAO().find(rs.getInt("id_statut"));
				obj.setStatutUtilisateur(su);	
				obj.setOffres(new OffreDAO().findUtilisateur(id));
				obj.setValideStages(new ValideStageDAO().findUtilisateur(id));
				obj.setEffectueStages(new EffectueStageDAO().findUtilisateur(id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Set<Utilisateur> findUtilisateur(int idStatut){
		Set<Utilisateur> allUtilisateurStatus = new HashSet<Utilisateur>(0);
		String sql = "select * from utilisateur WHERE id_statut = " + idStatut;
		try {
			PreparedStatement pstmt  = this.connect.prepareStatement(sql);
			ResultSet rs  = pstmt.executeQuery();
			while(rs.next()){
				Utilisateur obj = new Utilisateur();
				obj.setPrenom(rs.getString("prenom"));
				obj.setNom(rs.getString("nom"));
				obj.setDateNaissance(rs.getDate("date_naissance"));
				obj.setIdentifiant(rs.getString("identifiant"));
				obj.setMotdepasse(rs.getString("motdepasse"));
				allUtilisateurStatus.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUtilisateurStatus;
	}

	public Utilisateur createNewUtilisateur(Utilisateur obj) {
		String sql = "INSERT INTO utilisateur (id_statut, prenom, nom, date_naissance, identifiant, motdepasse) "
				+ "VALUES (?,?,?,?,?,?)";
		try {
			Date dateDeNaissance = new Date(0,0,0);
			PreparedStatement pstmt = this.connect.prepareStatement(sql);
			pstmt.setInt(1, obj.getStatutUtilisateur().getId());
			pstmt.setString(2, " ");
			pstmt.setString(3, " ");
			pstmt.setDate(4, dateDeNaissance);
			pstmt.setString(5, obj.getIdentifiant());
			pstmt.setString(6, obj.getMotdepasse());
			pstmt.executeUpdate();
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



	@SuppressWarnings("deprecation")
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

	public Utilisateur updateMotdepasse(Utilisateur obj){
		String sql = "UPDATE utilisateur "
				+ "SET motdepasse = ? WHERE id = ? ;";
		try {
			PreparedStatement pstmt = this.connect.prepareStatement(sql);
			pstmt.setString(1, obj.getMotdepasse());
			pstmt.setInt(2, obj.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public void delete(Utilisateur obj) {
		try {
			this.connect.createStatement().executeUpdate("DELETE FROM utilisateur WHERE id = " + obj.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Utilisateur> recherche(String name) {
		ArrayList<Utilisateur> liste = new ArrayList<Utilisateur>();
		String sql = "SELECT * FROM utilisateur where prenom LIKE '%" + name + "%' OR nom LIKE '%" + name + 
				"%' OR identifiant LIKE '%" + name + "%'";
		try {
			Statement st = this.connect.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Utilisateur obj = new Utilisateur();
				obj.setId(rs.getInt("id"));
				obj.setNom(rs.getString("nom"));
				obj.setPrenom(rs.getString("prenom"));
				obj.setDateNaissance(rs.getDate("date_naissance"));
				obj.setIdentifiant(rs.getString("identifiant"));
				obj.setMotdepasse(rs.getString("motdepasse"));
				StatutUtilisateur su =  new StatutUtilisateurDAO().find(rs.getInt("id_statut"));
				obj.setStatutUtilisateur(su);
				liste.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
}