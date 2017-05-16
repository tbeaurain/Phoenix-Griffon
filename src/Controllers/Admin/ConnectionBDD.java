package Controllers.Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.phoenixgriffon.JobIsep.*;

public class ConnectionBDD {

	private Connection connection(){
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
			System.out.println(e);
		}

		String url = "jdbc:mysql://localhost:3306/jobisep";
		String utilisateur = "root";
		String motDePasse = "";
		Connection connexion = null;

		try {
			connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
			System.out.println("ok");
		} catch ( SQLException e ) {
			System.out.println(e);
		} 
		return connexion;
	}

	public void addUtilisateur(Utilisateur utilisateur){

		StatutUtilisateur statutUtilisateur = utilisateur.getStatutUtilisateur();
		String prenom = utilisateur.getPrenom();
		String nom = utilisateur.getNom();
		Date dateDeNaisssance = (Date) utilisateur.getDateNaissance() ;
		String identifiant = utilisateur.getIdentifiant();
		String mdp = utilisateur.getMotdepasse();

		int idStatutUtilisateur = IdStatutUtilisateur(statutUtilisateur.getLibelle());

		if ( idStatutUtilisateur == 0){
			addStatutUtilisateur(statutUtilisateur);
			idStatutUtilisateur = IdStatutUtilisateur(statutUtilisateur.getLibelle());
		}

		String sql = "INSERT INTO utilisateur (id_statut, prenom, nom, date_naissance, identifiant, motdepasse) "
				+ "VALUES ('"+ idStatutUtilisateur +"','" + prenom +"','" + nom + "','" + 
				dateDeNaisssance +"','"+ identifiant +"','"+ mdp +"');" ;

		try (Connection conn = this.connection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int IdStatutUtilisateur(String libelle){
		int id = 0;
		String sql = "SELECT id FROM statut_utilisateur WHERE libelle = '" + libelle + "';" ;

		try (Connection conn = this.connection();
				PreparedStatement pstmt  = conn.prepareStatement(sql)){

			ResultSet rs  = pstmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id"); 
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return id;
	}

	public void addStatutUtilisateur(StatutUtilisateur statutUtilisateur){
		String statut = statutUtilisateur.getLibelle();

		String sql ="INSERT INTO statut_utilisateur (libelle) "
				+ "VALUES ('"+ statut + "')" ;
		try (Connection conn = this.connection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void addOffre(Offre offre){
		String titre = offre.getTitre();
		String description = offre.getDescription();
		String date = offre.getDates();
		String contact = offre.getContact();
		Utilisateur utilisateur = offre.getUtilisateur();
		int idUtilisateur = utilisateur.getId();

		String sql ="INSERT INTO offre (titre, description, dates, contact, id_utilisateur_propose) "
				+ "VALUES ('"+ titre + "','" + description +"','" + date + "','" + contact + "','" + idUtilisateur + "')" ;

		try (Connection conn = this.connection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void addEntreprise(Entreprise entreprise){

		String nom = entreprise.getNom();
		String siret = entreprise.getSiret();
		String codeApe =  entreprise.getCodeApe();
		String adresseSiege =entreprise.getAdresseSiege();
		String villeSiege = entreprise.getVilleSiege();
		String codePostal = entreprise.getCodePostalSiege();
		String tel = entreprise.getTelephoneSiege();

		String sql =  "INSERT INTO entreprise (nom, siret, code_ape, adresse_siege, ville_siege,"
				+ " code_postal_siege, telephone_siege) "
				+ "VALUES ('"+ nom +"','" + siret +"','" + codeApe +"','" + adresseSiege + 
				"','" + villeSiege +"','"+ codePostal +"','"+ tel +"');" ;
		try (Connection conn = this.connection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Entreprise entreprise(int id){
		String nom = null;
		String siret = null;
		String codeApe = null;
		String adresseSiege = null;
		String villeSiege = null;
		String codePostalSiege = null;
		String telephoneSiege = null;

		String sql = "SELECT * FROM entreprise where ID ='" + id +"';";

		try (Connection conn = this.connection(); Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){

			while (rs.next()) {
				nom = rs.getString("nom");
				siret = rs.getString("siret");
				codeApe = rs.getString("code_ape");
				adresseSiege = rs.getString("adresse_siege");
				villeSiege = rs.getString("ville_siege");
				codePostalSiege = rs.getString("code_postal_siege");
				telephoneSiege = rs.getString("telephone_siege");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		Entreprise entreprise= new Entreprise (nom, siret, codeApe, adresseSiege, 
				villeSiege, codePostalSiege, telephoneSiege);
		return entreprise;
	}

	public Offre offre(int idOffre, Utilisateur utilisateur){
		String titre = null;
		String description = null;
		Date miseEnLigne = null;
		String dates = null;
		String contact = null;
		String lieu = null;

		String sql = "SELECT * FROM offre where ID ='" + idOffre +"';";

		try (Connection conn = this.connection(); Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){

			while (rs.next()) {
				titre = rs.getString("titre");
				description = rs.getString("description");
				miseEnLigne = rs.getDate("miseEnLigne");
				dates = rs.getString("dates");
				contact = rs.getString("contact");
				lieu = rs.getString("lieu");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}


		Offre offre= new Offre (utilisateur, titre, description, miseEnLigne, dates, contact, lieu);
		return offre;
	}

	public Utilisateur utilisateur(String identifiant, String mdp){
		int idStatutUtilisateur = 0 ;
		String prenom = null;
		String nom = null;
		Date dateNaissance = null;
		String sql = "SELECT * FROM utilisateur WHERE "
				+ "identifiant = '" + identifiant +"' AND motdepasse = '" + mdp + "';";

		try (Connection conn = this.connection(); Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){

			while (rs.next()) {
				prenom = rs.getString("prenom");
				nom = rs.getString("nom");
				dateNaissance = rs.getDate("date_naissance");
				idStatutUtilisateur = rs.getInt("id_statut");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		StatutUtilisateur statutUtilisateur = statutUtilisateur(idStatutUtilisateur);

		Utilisateur utilisateur = new Utilisateur(statutUtilisateur,  prenom,  nom,  dateNaissance,
				identifiant,  mdp);
		return utilisateur;
	}

	public StatutUtilisateur statutUtilisateur(int id){
		String libelle = " ";
		String sql = "SELECT * FROM statut_utilisateur where id = '" + id +"';";

		try (Connection conn = this.connection(); Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){

			while (rs.next()) {
				libelle = rs.getString("libelle");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		StatutUtilisateur statutUtilisateur= new StatutUtilisateur (libelle);
		return statutUtilisateur;
	}

	public void updateUtilisateur(int id, String mdp, Date DateDeNaissance, String nom, String prenom ){
		String sql = "UPDATE utilisateur "
				+ "SET prenom = ? , nom = ?, date_naissance = ?, motdepasse = ? "
				+ "WHERE id = ? ;";

		try (Connection conn = this.connection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, prenom);
			pstmt.setString(2, nom);
			pstmt.setDate(3, (java.sql.Date) DateDeNaissance);
			pstmt.setString(4, mdp);
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args){

		ConnectionBDD bdd = new ConnectionBDD();

		Utilisateur util = new Utilisateur();
		util.setId(1);

		int years = 1995;
		int month = 10;
		int jour = 15;

		Date dateDeNaissance = new Date (years, month, jour);;
		java.sql.Date date_sql = new java.sql.Date(dateDeNaissance.getTime());

		StatutUtilisateur statut = new StatutUtilisateur("eleve");
		//	Utilisateur utilisateur = new Utilisateur(statut, "thibaut", "beaurain", date_sql, "tibo", "mdp");


		bdd.addStatutUtilisateur(statut);

		System.out.println("fini");
	}

}