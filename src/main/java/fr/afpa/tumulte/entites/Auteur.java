package fr.afpa.tumulte.entites;

/**
 * The type Auteur.
 */
public class Auteur {
    private String codeAuteur;
    private String nomAuteur;
    private String prenomAuteur;

    /**
     * Instantiates a new Auteur.
     *
     * @param nomPrenomAuteur the nom prenom auteur
     */
    public Auteur(String nomPrenomAuteur) {
        codeAuteur = " ";
        prenomAuteur = nomPrenomAuteur.substring(0, nomPrenomAuteur.indexOf(" "));
        nomAuteur = nomPrenomAuteur.substring(nomPrenomAuteur.indexOf(" "));
    }

    /**
     * Instantiates a new Auteur.
     *
     * @param codeAuteur   the code auteur
     * @param nomAuteur    the nom auteur
     * @param prenomAuteur the prenom auteur
     */
    public Auteur(String codeAuteur, String nomAuteur, String prenomAuteur) {
        this.codeAuteur = codeAuteur;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
    }

    /**
     * Gets code auteur.
     *
     * @return the code auteur
     */
    public String getCodeAuteur() {
        return codeAuteur;
    }

    /**
     * Sets code auteur.
     *
     * @param codeAuteur the code auteur
     */
    public void setCodeAuteur(String codeAuteur) {
        this.codeAuteur = codeAuteur;
    }

    /**
     * Gets nom auteur.
     *
     * @return the nom auteur
     */
    public String getNomAuteur() {
        return nomAuteur;
    }

    /**
     * Sets nom auteur.
     *
     * @param nomAuteur the nom auteur
     */
    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    /**
     * Gets prenom auteur.
     *
     * @return the prenom auteur
     */
    public String getPrenomAuteur() {
        return prenomAuteur;
    }

    /**
     * Sets prenom auteur.
     *
     * @param prenomAuteur the prenom auteur
     */
    public void setPrenomAuteur(String prenomAuteur) {
        this.prenomAuteur = prenomAuteur;
    }

    @Override
    public String toString() {

        return String.format("%s %s %s", codeAuteur, nomAuteur, prenomAuteur);
    }
}