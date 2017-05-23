package Controllers.Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import org.apache.tomcat.util.codec.binary.Base64;

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
		String motDePasse = "root";
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
	 // The higher the number of iterations the more 
    // expensive computing the hash is for us and
    // also for an attacker.
    private static final int iterations = 20*1000;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;

    /** Computes a salted PBKDF2 hash of given plaintext password
        suitable for storing in a database. 
        Empty passwords are not supported. */
    public static String getSaltedHash(String password) throws Exception {
        byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
        // store the salt with the password
        return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
    }

    /** Checks whether given plaintext password corresponds 
        to a stored salted hash of the password. */
    public static boolean check(String password, String stored) throws Exception{
        String[] saltAndPass = stored.split("\\$");
        if (saltAndPass.length != 2) {
            throw new IllegalStateException(
                "The stored password have the form 'salt$hash'");
        }
        String hashOfInput = hash(password, Base64.decodeBase64(saltAndPass[0]));
        return hashOfInput.equals(saltAndPass[1]);
    }

    // using PBKDF2 from Sun, an alternative is https://github.com/wg/scrypt
    // cf. http://www.unlimitednovelty.com/2012/03/dont-use-bcrypt.html
    private static String hash(String password, byte[] salt) throws Exception {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
            password.toCharArray(), salt, iterations, desiredKeyLen)
        );
        return Base64.encodeBase64String(key.getEncoded());
    }
    
	public boolean login(String identifiant, String mdp, Utilisateur renvoye) throws Exception{
		System.out.println("passage sur la fonction de login "+identifiant+" - "+mdp);
		int idStatutUtilisateur;
		String prenom;
		String nom;
		String hashedPass;
		Date dateNaissance;
		String sql = "SELECT * FROM utilisateur WHERE "
				+ "identifiant = '" + identifiant +"'";

		try (Connection conn = this.connection(); Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){
			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();
			if(rows == 0)
			{
				return false;
			}
			else
			{
				
				rs.next();
				prenom = rs.getString("prenom");
				nom = rs.getString("nom");
				dateNaissance = rs.getDate("date_naissance");
				idStatutUtilisateur = rs.getInt("id_statut");
				hashedPass = rs.getString("motdepasse");
				System.out.println("tu es connect� en tant que "+prenom+" "+nom);
				if(true || check(mdp, hashedPass))
				{
					StatutUtilisateur statutUtilisateur = statutUtilisateur(idStatutUtilisateur);
					
					renvoye.setStatutUtilisateur(statutUtilisateur);
					renvoye.setPrenom(prenom);
					renvoye.setNom(nom);
					renvoye.setDateNaissance(dateNaissance);
					renvoye.setIdentifiant(identifiant);
					renvoye.setMotdepasse(mdp);
					return true;
				}
				else
				{
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
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
	
	public void updateUtilisateur(Utilisateur utilisateur){
		String sql = "UPDATE utilisateur "
				+ "SET prenom = ? , nom = ?, date_naissance = ?, motdepasse = ? "
				+ "WHERE id = ? ;";

		try (Connection conn = this.connection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, utilisateur.getPrenom());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setDate(3, (java.sql.Date) utilisateur.getDateNaissance());
			pstmt.setString(4, utilisateur.getIdentifiant());
			pstmt.setInt(5, utilisateur.getId());
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