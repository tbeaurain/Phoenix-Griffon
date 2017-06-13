package Controllers.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;
import java.time.*;

import org.phoenixgriffon.JobIsep.Message;

public class MessageDAO extends DAO<Message>{

		public Connection connect = ConnectionSQL.getInstance();

		public Message findMsgRecv(int idRecv) {
			Message obj = new Message();
			String sql = "select * from message WHERE idRecv = " + idRecv;
			try {
				PreparedStatement pstmt  = this.connect.prepareStatement(sql);
				ResultSet rs  = pstmt.executeQuery();
				if(rs.first()){
					obj.setIdExpe(rs.getInt("idExpe"));
					obj.setIdRecv(idRecv);
					obj.setObj(rs.getString("objet"));
					obj.setMessage(rs.getString("message"));
					obj.setDate(rs.getDate("date_msg"));
					obj.setDate(rs.getDate("time_msg"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return obj;
		}

		public Set<Message> findExpe(int idExpe){
			Set<Message> message = new HashSet<Message>(0);
			String sql = "select * from offre WHERE id_utilisateur_propose = " + idExpe;
			try {
				PreparedStatement pstmt  = this.connect.prepareStatement(sql);
				ResultSet rs  = pstmt.executeQuery();
				while(rs.next()){
					Message obj = new Message();
					obj.setIdExpe(rs.getInt("id"));
					message.add(obj);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return message;
		}

		public Message create(Message obj) {
			String sql ="INSERT INTO offre (idExpe, idRecv, objet, message, date, time) "
					+ "VALUES (?,?,?,?,?,?)" ;
			try {
				PreparedStatement pstmt = this.connect.prepareStatement(sql);
				pstmt.setInt(1, obj.getIdExpe());
				pstmt.setInt(2, obj.getIdRecv());
				pstmt.setString(3, obj.getObj());
				pstmt.setString(4, obj.getMessage());
				pstmt.setDate(5, (java.sql.Date) obj.getDate());
				pstmt.setDate(6, (java.sql.Date) obj.getTime());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return obj;
		}

		public Message update(Message obj) {
			// TODO Auto-generated method stub
			return null;
		}

		public void delete(Message obj) {
			try {
				this.connect.createStatement().executeUpdate("DELETE FROM offre WHERE id = " + obj.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public Message find(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		/*public ArrayList<Offre> recherche(String name) {
			ArrayList<Offre> liste = new ArrayList<Offre>();
			String sql = "SELECT * FROM offre where titre LIKE '%" + name + "%' OR description LIKE '%" + name + 
					"%' OR lieu LIKE '%" + name + "%'";
			try {
				Statement st = this.connect.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					Offre obj = new Offre();
					obj.setId(rs.getInt("id"));
					obj.setTitre(rs.getString("titre"));
					obj.setDescription(rs.getString("description"));
					obj.setMiseEnLigne(rs.getDate("mise_En_Ligne"));
					obj.setDates(rs.getString("dates"));
					obj.setContact(rs.getString("contact"));
					obj.setLieu(rs.getString("lieu"));
					obj.setUtilisateur(new UtilisateurDAO().find(rs.getInt("id_utilisateur_propose")));
					liste.add(obj);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return liste;
		}

		@Override
		public Object create(Object obj) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object update(Object obj) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void delete(Object obj) {
			// TODO Auto-generated method stub
			
		}

	}*/


}
