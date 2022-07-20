package fr.afpa.tumulte.entites;

/**
 * The type Livre.
 */
public class Livre {
    /**
     * l'isbn du livre.
     */
    private String IsbnLivre;
    /**
     * code du thème du livre.
     */
    private String codTheme;
    /**
     * Titre du livre.
     */
    private String titreLivre;
    /**
     * Auteur du livre.
     */
    private Auteur auteur;
    /**
     * nombre d'exemplaire de ce livre.
     */
    private int nbExemplaire;
    /**
     * nombre d'emprunt de ce livre.
     */
    private int nbEmprunt;

    /**
     * Instantiates a new Livre.
     *
     * @param isbnLivre    the isbn livre
     * @param codTheme     the cod theme
     * @param titreLivre   the titre livre
     * @param auteur       the auteur
     * @param nbExemplaire the nb exemplaire
     * @param nbEmprunt    the nb emprunt
     */
    public Livre(String isbnLivre, String codTheme, String titreLivre, Auteur auteur, int nbExemplaire, int nbEmprunt) {
        IsbnLivre = isbnLivre;
        this.codTheme = codTheme;
        this.titreLivre = titreLivre;
        this.auteur = auteur;
        this.nbExemplaire = nbExemplaire;
        this.nbEmprunt = nbEmprunt;
    }

    /**
     * Gets nb exemplaire.
     *
     * @return the nb exemplaire
     */
    public int getNbExemplaire() {
        return nbExemplaire;
    }

    /**
     * Sets nb exemplaire.
     *
     * @param nbExemplaire the nb exemplaire
     */
    public void setNbExemplaire(int nbExemplaire) {
        this.nbExemplaire = nbExemplaire;
    }

    /**
     * Gets nb emprunt.
     *
     * @return the nb emprunt
     */
    public int getNbEmprunt() {
        return nbEmprunt;
    }

    /**
     * Sets nb emprunt.
     *
     * @param nbEmprunt the nb emprunt
     */
    public void setNbEmprunt(int nbEmprunt) {
        this.nbEmprunt = nbEmprunt;
    }

    /**
     * Gets isbn livre.
     *
     * @return the isbn livre
     */
    public String getIsbnLivre() {
        return IsbnLivre;
    }

    /**
     * Sets isbn livre.
     *
     * @param isbnLivre the isbn livre
     */
    public void setIsbnLivre(String isbnLivre) {
        IsbnLivre = isbnLivre;
    }

    /**
     * Gets cod theme.
     *
     * @return the cod theme
     */
    public String getCodTheme() {
        return codTheme;
    }

    /**
     * Sets cod theme.
     *
     * @param codTheme the cod theme
     */
    public void setCodTheme(String codTheme) {
        this.codTheme = codTheme;
    }

    /**
     * Gets titre livre.
     *
     * @return the titre livre
     */
    public String getTitreLivre() {
        return titreLivre;
    }

    /**
     * Sets titre livre.
     *
     * @param titreLivre the titre livre
     */
    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }

    /**
     * Gets auteur.
     *
     * @return the auteur
     */
    public Auteur getAuteur() {
        return auteur;
    }

    /**
     * Sets auteur.
     *
     * @param auteur the auteur
     */
    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

}