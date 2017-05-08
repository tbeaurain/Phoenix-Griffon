package org.phoenixgriffon.JobIsep;
// Generated 2 mai 2017 15:53:06 by Hibernate Tools 5.2.1.Final

import java.util.Date;

/**
 * Offre generated by hbm2java
 */
public class Offre implements java.io.Serializable {

	private Integer id;
	private Utilisateur utilisateur;
	private String titre;
	private String description;
	private Date miseEnLigne;
	private String dates;
	private String contact;

	public Offre() {
	}

	public Offre(Utilisateur utilisateur, String titre, String description, Date miseEnLigne, String contact) {
		this.utilisateur = utilisateur;
		this.titre = titre;
		this.description = description;
		this.miseEnLigne = miseEnLigne;
		this.contact = contact;
	}

	public Offre(Utilisateur utilisateur, String titre, String description, Date miseEnLigne, String dates,
			String contact) {
		this.utilisateur = utilisateur;
		this.titre = titre;
		this.description = description;
		this.miseEnLigne = miseEnLigne;
		this.dates = dates;
		this.contact = contact;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getMiseEnLigne() {
		return this.miseEnLigne;
	}

	public void setMiseEnLigne(Date miseEnLigne) {
		this.miseEnLigne = miseEnLigne;
	}

	public String getDates() {
		return this.dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}