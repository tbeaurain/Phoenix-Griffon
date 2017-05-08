package Beans;

public class Stage {
    /* Propriétés du bean */
    private String titre;
    private String description;
    private String lieu;
    private String dates;
    private String contact;
    private String mise_en_ligne;

    public void setTitre( String titre ) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }
    
    public void setDescription( String description ) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public void setLieu( String lieu ) {
        this.lieu = lieu;
    }

    public String getLieu() {
        return lieu;
    }
    
    public void setDates( String dates ) {
        this.dates = dates;
    }
    
    public String getDates() {
        return dates;
    }
    
    public void setContact( String contact ) {
        this.contact = contact;
    }
    
    public String getContact() {
        return contact;
    }
    
    public void setMise_en_ligne( String mise_en_ligne ) {
        this.mise_en_ligne = mise_en_ligne;
    }

    public String getMise_en_ligne() {
        return mise_en_ligne;
    }
   
}