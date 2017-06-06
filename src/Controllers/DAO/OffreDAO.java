package Controllers.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.phoenixgriffon.JobIsep.Offre;
import org.phoenixgriffon.JobIsep.Utilisateur;

public class OffreDAO extends DAO<Offre> {

	public Offre find(int id) {
		Offre obj = new Offre();
		String sql = "select * from offre WHERE id = " + id;
		try {
			PreparedStatement pstmt  = this.connect.prepareStatement(sql);
			ResultSet rs  = pstmt.executeQuery();
			if(rs.first()){
				obj.setId(id);
				obj.setTitre(rs.getString("titre"));
				obj.setDescription(rs.getString("description"));
				obj.setMiseEnLigne(rs.getDate("miseEnLigne"));
				obj.setDates(rs.getString("dates"));
				obj.setContact(rs.getString("contact"));
				obj.setLieu(rs.getString("lieu"));
				obj.setUtilisateur(new UtilisateurDAO().find(rs.getInt("id_utilisateur_propose")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Offre create(Offre obj) {
		String sql ="INSERT INTO offre (titre, description, dates, contact, id_utilisateur_propose) "
				+ "VALUES (?,?,?,?,?)" ;
		try {
			PreparedStatement pstmt = this.connect.prepareStatement(sql);
			pstmt.setString(1, obj.getTitre());
			pstmt.setString(2, obj.getDescription());
			pstmt.setString(3, obj.getDates());
			pstmt.setString(4, obj.getContact());
			pstmt.setInt(5, obj.getUtilisateur().getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Offre update(Offre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Offre obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Offre> recherche(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
