package org.phoenixgriffon.JobIsep;
// Generated 2 mai 2017 15:53:06 by Hibernate Tools 5.2.1.Final

/**
 * ValideStage generated by hbm2java
 */
public class ValideStage implements java.io.Serializable {

	private Integer id;
	private Stage stage;
	private Utilisateur utilisateur;

	public ValideStage() {
	}

	public ValideStage(Stage stage, Utilisateur utilisateur) {
		this.stage = stage;
		this.utilisateur = utilisateur;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Stage getStage() {
		return this.stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}