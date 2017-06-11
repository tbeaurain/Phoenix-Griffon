package Controllers.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.phoenixgriffon.JobIsep.ValideStage;

public class ValideStageDAO extends DAO<ValideStage>{

	public ValideStage find(int id) {
		ValideStage obj = new ValideStage();
		String sql =  "select * from ValideStage where id = " + id;
		try {
			PreparedStatement pstmt  = this.connect.prepareStatement(sql);
			ResultSet rs  = pstmt.executeQuery();

			if(rs.first()){
				obj.setId(id);
				obj.setStage(new StageDAO().find(rs.getInt("id_stage")));
				obj.setUtilisateur(new UtilisateurDAO().find(rs.getInt("id_utilisateur")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public ValideStage create(ValideStage obj) {
		String sql = "INSERT INTO ValideStage (id_utilisateur, id_stage) "
				+ "VALUES (?,?)";
		try {
			PreparedStatement pstmt = this.connect.prepareStatement(sql);
			pstmt.setInt(1, obj.getUtilisateur().getId());
			pstmt.setInt(2, obj.getStage().getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public ValideStage update(ValideStage obj) {
		String sql = "UPDATE ValideStage "
				+ "SET id_utilisateur = ? , id_stage = ?"
				+ "WHERE id = ? ";
		try {
			PreparedStatement pstmt = this.connect.prepareStatement(sql);
			pstmt.setInt(1, obj.getUtilisateur().getId());
			pstmt.setInt(2, obj.getStage().getId());
			pstmt.setInt(3, obj.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public void delete(ValideStage obj) {
		try {
			this.connect.createStatement().executeUpdate("DELETE FROM ValideStage WHERE id = " + obj.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
