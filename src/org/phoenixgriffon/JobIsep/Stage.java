package org.phoenixgriffon.JobIsep;
// Generated 2 mai 2017 15:53:06 by Hibernate Tools 5.2.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Stage generated by hbm2java
 */
public class Stage implements java.io.Serializable {

	private Integer id;
	private Date dateCreation;
	private String adresseLieu;
	private String villeLieu;
	private String codePostalLieu;
	private String nomService;
	private String telephoneStandardLieu;
	private String nomContactConvention;
	private String adresseContactConvention;
	private String codePostalContactConvention;
	private String villeContactConvention;
	private String telContactConvention;
	private String nomMaitreStage;
	private String telephoneMaitreStage;
	private String mailMaitreStage;
	private String fonctionMaitreStage;
	private String mailContactConvention;
	private double remuneration;
	private Date dateDebut;
	private Date dateFin;
	private String description;
	private Set<EffectueStage> effectueStages = new HashSet<EffectueStage>(0);
	private Set<ValideStage> valideStages = new HashSet<ValideStage>(0);

	public Stage() {
	}

	public Stage(String adresseLieu, String villeLieu, String codePostalLieu, String nomService,
			String telephoneStandardLieu, String nomContactConvention, String adresseContactConvention,
			String codePostalContactConvention, String villeContactConvention, String telContactConvention,
			String nomMaitreStage, String telephoneMaitreStage, String mailMaitreStage, String fonctionMaitreStage,
			String mailContactConvention, double remuneration, Date dateDebut, Date dateFin, String description) {
		this.adresseLieu = adresseLieu;
		this.villeLieu = villeLieu;
		this.codePostalLieu = codePostalLieu;
		this.nomService = nomService;
		this.telephoneStandardLieu = telephoneStandardLieu;
		this.nomContactConvention = nomContactConvention;
		this.adresseContactConvention = adresseContactConvention;
		this.codePostalContactConvention = codePostalContactConvention;
		this.villeContactConvention = villeContactConvention;
		this.telContactConvention = telContactConvention;
		this.nomMaitreStage = nomMaitreStage;
		this.telephoneMaitreStage = telephoneMaitreStage;
		this.mailMaitreStage = mailMaitreStage;
		this.fonctionMaitreStage = fonctionMaitreStage;
		this.mailContactConvention = mailContactConvention;
		this.remuneration = remuneration;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
	}

	public Stage(Date dateCreation, String adresseLieu, String villeLieu, String codePostalLieu, String nomService,
			String telephoneStandardLieu, String nomContactConvention, String adresseContactConvention,
			String codePostalContactConvention, String villeContactConvention, String telContactConvention,
			String nomMaitreStage, String telephoneMaitreStage, String mailMaitreStage, String fonctionMaitreStage,
			String mailContactConvention, double remuneration, Date dateDebut, Date dateFin, String description,
			Set<EffectueStage> effectueStages, Set<ValideStage> valideStages) {
		this.dateCreation = dateCreation;
		this.adresseLieu = adresseLieu;
		this.villeLieu = villeLieu;
		this.codePostalLieu = codePostalLieu;
		this.nomService = nomService;
		this.telephoneStandardLieu = telephoneStandardLieu;
		this.nomContactConvention = nomContactConvention;
		this.adresseContactConvention = adresseContactConvention;
		this.codePostalContactConvention = codePostalContactConvention;
		this.villeContactConvention = villeContactConvention;
		this.telContactConvention = telContactConvention;
		this.nomMaitreStage = nomMaitreStage;
		this.telephoneMaitreStage = telephoneMaitreStage;
		this.mailMaitreStage = mailMaitreStage;
		this.fonctionMaitreStage = fonctionMaitreStage;
		this.mailContactConvention = mailContactConvention;
		this.remuneration = remuneration;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.effectueStages = effectueStages;
		this.valideStages = valideStages;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getAdresseLieu() {
		return this.adresseLieu;
	}

	public void setAdresseLieu(String adresseLieu) {
		this.adresseLieu = adresseLieu;
	}

	public String getVilleLieu() {
		return this.villeLieu;
	}

	public void setVilleLieu(String villeLieu) {
		this.villeLieu = villeLieu;
	}

	public String getCodePostalLieu() {
		return this.codePostalLieu;
	}

	public void setCodePostalLieu(String codePostalLieu) {
		this.codePostalLieu = codePostalLieu;
	}

	public String getNomService() {
		return this.nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public String getTelephoneStandardLieu() {
		return this.telephoneStandardLieu;
	}

	public void setTelephoneStandardLieu(String telephoneStandardLieu) {
		this.telephoneStandardLieu = telephoneStandardLieu;
	}

	public String getNomContactConvention() {
		return this.nomContactConvention;
	}

	public void setNomContactConvention(String nomContactConvention) {
		this.nomContactConvention = nomContactConvention;
	}

	public String getAdresseContactConvention() {
		return this.adresseContactConvention;
	}

	public void setAdresseContactConvention(String adresseContactConvention) {
		this.adresseContactConvention = adresseContactConvention;
	}

	public String getCodePostalContactConvention() {
		return this.codePostalContactConvention;
	}

	public void setCodePostalContactConvention(String codePostalContactConvention) {
		this.codePostalContactConvention = codePostalContactConvention;
	}

	public String getVilleContactConvention() {
		return this.villeContactConvention;
	}

	public void setVilleContactConvention(String villeContactConvention) {
		this.villeContactConvention = villeContactConvention;
	}

	public String getTelContactConvention() {
		return this.telContactConvention;
	}

	public void setTelContactConvention(String telContactConvention) {
		this.telContactConvention = telContactConvention;
	}

	public String getNomMaitreStage() {
		return this.nomMaitreStage;
	}

	public void setNomMaitreStage(String nomMaitreStage) {
		this.nomMaitreStage = nomMaitreStage;
	}

	public String getTelephoneMaitreStage() {
		return this.telephoneMaitreStage;
	}

	public void setTelephoneMaitreStage(String telephoneMaitreStage) {
		this.telephoneMaitreStage = telephoneMaitreStage;
	}

	public String getMailMaitreStage() {
		return this.mailMaitreStage;
	}

	public void setMailMaitreStage(String mailMaitreStage) {
		this.mailMaitreStage = mailMaitreStage;
	}

	public String getFonctionMaitreStage() {
		return this.fonctionMaitreStage;
	}

	public void setFonctionMaitreStage(String fonctionMaitreStage) {
		this.fonctionMaitreStage = fonctionMaitreStage;
	}

	public String getMailContactConvention() {
		return this.mailContactConvention;
	}

	public void setMailContactConvention(String mailContactConvention) {
		this.mailContactConvention = mailContactConvention;
	}

	public double getRemuneration() {
		return this.remuneration;
	}

	public void setRemuneration(double remuneration) {
		this.remuneration = remuneration;
	}

	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<EffectueStage> getEffectueStages() {
		return this.effectueStages;
	}

	public void setEffectueStages(Set<EffectueStage> effectueStages) {
		this.effectueStages = effectueStages;
	}

	public Set<ValideStage> getValideStages() {
		return this.valideStages;
	}

	public void setValideStages(Set<ValideStage> valideStages) {
		this.valideStages = valideStages;
	}

}
