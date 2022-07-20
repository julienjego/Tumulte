package fr.afpa.tumulte.entites;

public class Exemplaire {

    private String titre;
    private String codBibliotheque;
    private String codEmplacement;
    private String isbnLivre;
    private String codExemplaire;
    private String disponible;
    private String dateRetour;

    /**
     * @return String
     */
    public String getDateRetour() {
        return dateRetour;
    }

    /**
     * @param dateRetour
     */
    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Exemplaire(String titre, String codBibliotheque, String codEmplacement, String isbnLivre,
            String codExemplaire, String disponible, String dateRetour) {
        this.titre = titre;
        this.codBibliotheque = codBibliotheque;
        this.codEmplacement = codEmplacement;
        this.isbnLivre = isbnLivre;
        this.codExemplaire = codExemplaire;
        this.disponible = disponible;
        this.dateRetour = dateRetour;
    }

    /**
     * @return String
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return String
     */
    public String getCodBibliotheque() {
        return codBibliotheque;
    }

    /**
     * @param codBibliotheque
     *                        coucou
     */
    public void setCodBibliotheque(String codBibliotheque) {
        this.codBibliotheque = codBibliotheque;
    }

    /**
     * @return String
     */
    public String getCodEmplacement() {
        return codEmplacement;
    }

    /**
     * @param codEmplacement
     */
    public void setCodEmplacement(String codEmplacement) {
        this.codEmplacement = codEmplacement;
    }

    /**
     * @return String
     */
    public String getisbnLivre() {
        return isbnLivre;
    }

    /**
     * @param isbnLivre
     */
    public void setIsbnLivre(String isbnLivre) {
        this.isbnLivre = isbnLivre;
    }

    /**
     * @return String
     */
    public String getCodExemplaire() {
        return codExemplaire;
    }

    /**
     * @param codExemplaire
     */
    public void setCodExemplaire(String codExemplaire) {
        this.codExemplaire = codExemplaire;
    }

    /**
     * @return String
     */
    public String isDisponible() {
        return disponible;
    }

    /**
     * @param disponible
     */
    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Exemplaire [codBibliotheque=" + codBibliotheque + ", codEmplacement=" + codEmplacement
                + ", codExemplaire=" + codExemplaire + ", disponible=" + disponible + ", isbnLivre=" + isbnLivre
                + ", titre=" + titre + "]";
    }

}
