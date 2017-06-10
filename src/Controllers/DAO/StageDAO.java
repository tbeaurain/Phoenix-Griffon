package Controllers.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.phoenixgriffon.JobIsep.Stage;

public class StageDAO extends DAO<Stage>{

	@Override
	public Stage find(int id) {
		Stage obj = new Stage();
		String sql = "select * from stage WHERE id = " + id;
		try {
			PreparedStatement pstmt  = this.connect.prepareStatement(sql);
			ResultSet rs  = pstmt.executeQuery();
			if(rs.first()){
				obj.setId(id);
				obj.setDateCreation(rs.getDate("date_creation"));
				obj.setAdresseLieu(rs.getString("adresse_lieu"));
				obj.setVilleLieu(rs.getString("ville_lieu"));
				obj.setCodePostalLieu(rs.getString("code_postal_lieu"));
				obj.setNomService(rs.getString("nom_service"));
				obj.setTelephoneStandardLieu(rs.getString("telephone_standard_lieu"));
				obj.setNomContactConvention(rs.getString("nom_contact_convention"));
				obj.setAdresseContactConvention(rs.getString("adresse_contact_convention"));
				obj.setCodePostalContactConvention(rs.getString("code_postal_contact_convention"));
				obj.setVilleContactConvention(rs.getString("ville_contact_convention"));
				obj.setTelContactConvention(rs.getString("tel_contact_convention"));
				obj.setNomMaitreStage(rs.getString("nom_maitre_stage"));
				obj.setTelephoneMaitreStage(rs.getString("telephone_maitre_stage"));
				obj.setMailMaitreStage(rs.getString("mail_maitre_stage"));
				obj.setFonctionMaitreStage(rs.getString("fonction_maitre_stage"));
				obj.setMailContactConvention(rs.getString("mail_contact_convention"));
				obj.setRemuneration(rs.getDouble("remuneration"));
				obj.setDateDebut(rs.getDate("date_debut"));
				obj.setDateFin(rs.getDate("date_fin"));
				obj.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Stage create(Stage obj) {
		
		//java.sql.Date sqlDateDebut = new java.sql.Date(obj.getDateDebut().getTime());
		//java.sql.Date sqlDateFin = new java.sql.Date(obj.getDateFin().getTime());
		
		System.out.println(" date  est  " + obj.getDateDebut()) ;
		String sql = "INSERT INTO stage (adresse_lieu,ville_lieu,code_postal_lieu,nom_service, "
				+ "telephone_standard_lieu,nom_contact_convention,adresse_contact_convention,"
				+ "code_postal_contact_convention,ville_contact_convention,tel_contact_convention,nom_maitre_stage,"
				+ "telephone_maitre_stage,mail_maitre_stage,fonction_maitre_stage,mail_contact_convention,"
				+ "remuneration,date_debut,date_fin,description) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;

		try {
			PreparedStatement pstmt = this.connect.prepareStatement(sql);
			pstmt.setString(1, obj.getAdresseLieu());
			pstmt.setString(2, obj.getVilleLieu());
			pstmt.setString(3, obj.getCodePostalLieu());
			pstmt.setString(4, obj.getNomService());
			pstmt.setString(5, obj.getTelephoneStandardLieu());
			pstmt.setString(6, obj.getNomContactConvention());
			pstmt.setString(7, obj.getAdresseContactConvention());
			pstmt.setString(8, obj.getCodePostalContactConvention());
			pstmt.setString(9, obj.getVilleContactConvention());
			pstmt.setString(10, obj.getTelContactConvention());
			pstmt.setString(11, obj.getNomMaitreStage());
			pstmt.setString(12, obj.getTelephoneMaitreStage());
			pstmt.setString(13, obj.getMailMaitreStage());
			pstmt.setString(14, obj.getFonctionMaitreStage());
			pstmt.setString(15, obj.getMailContactConvention());
			pstmt.setDouble(16, obj.getRemuneration());
			pstmt.setDate(17, new java.sql.Date(obj.getDateDebut().getTime()));
			pstmt.setDate(18, new java.sql.Date(obj.getDateFin().getTime()));
			pstmt.setString(19, obj.getDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Stage update(Stage obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Stage obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Stage> recherche(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
