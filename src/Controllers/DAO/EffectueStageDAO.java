package Controllers.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.phoenixgriffon.JobIsep.EffectueStage;

public class EffectueStageDAO extends DAO<EffectueStage>{

	public EffectueStage find(int id) {
		EffectueStage obj = new EffectueStage();
		String sql =  "select * from effectue_stage where id = " + id;
		try {
			PreparedStatement pstmt  = this.connect.prepareStatement(sql);
			ResultSet rs  = pstmt.executeQuery();

			if(rs.first()){
				obj.setId(id);
				obj.setId_stage(new StageDAO().find(rs.getInt("id_stage")));
				obj.setId_utilisateur(new UtilisateurDAO().find(rs.getInt("id_utilisateur")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public EffectueStage create(EffectueStage obj) {
		String sql = "INSERT INTO effectue_stage (id_utilisateur, id_stage) "
				+ "VALUES (?,?)";
		try {
			PreparedStatement pstmt = this.connect.prepareStatement(sql);
			pstmt.setInt(1, obj.getId_utilisateur().getId());
			pstmt.setInt(2, obj.getId_stage().getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public EffectueStage update(EffectueStage obj) {
		String sql = "UPDATE effectue_stage "
				+ "SET id_utilisateur = ? , id_stage = ?"
				+ "WHERE id = ? ";
		try {
			PreparedStatement pstmt = this.connect.prepareStatement(sql);
			pstmt.setInt(1, obj.getId_utilisateur().getId());
			pstmt.setInt(2, obj.getId_stage().getId());
			pstmt.setInt(3, obj.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public void delete(EffectueStage obj) {
		try {
			this.connect.createStatement().executeUpdate("DELETE FROM effectue_stage WHERE id = " + obj.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}