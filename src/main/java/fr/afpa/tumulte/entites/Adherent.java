package fr.afpa.tumulte.entites;

/**
 * The type Adherent.
 */
public class Adherent {
    private String numAdherent;
    private String nomAdherent;
    private String prenomAdherent;
    private String adrAdherent;
    private String teleAdherent;
    private String perimeLe;
    private String pwdAdherent;

    /**
     * Instantiates a new Adherent.
     *
     * @param numAdherent    the num adherent
     * @param nomAdherent    the nom adherent
     * @param prenomAdherent the prenom adherent
     * @param adrAdherent    the adr adherent
     * @param teleAdherent   the tele adherent
     * @param perimeLe       the perime le
     */
    public Adherent(final String numAdherent,
                    final String nomAdherent,
                    final String prenomAdherent,
                    final String adrAdherent,
                    final String teleAdherent,
                    final String perimeLe) {
        this.numAdherent = numAdherent;
        this.nomAdherent = nomAdherent;
        this.prenomAdherent = prenomAdherent;
        this.adrAdherent = adrAdherent;
        this.teleAdherent = teleAdherent;
        this.perimeLe = perimeLe;
    }

    /**
     * Gets num adherent.
     *
     * @return the num adherent
     */
    public String getNumAdherent() {
        return numAdherent;
    }

    /**
     * Sets num adherent.
     *
     * @param numAdherent the num adherent
     */
    public void setNumAdherent(final String numAdherent) {
        this.numAdherent = numAdherent.trim();
    }

    /**
     * Gets nom adherent.
     *
     * @return the nom adherent
     */
    public String getNomAdherent() {
        return nomAdherent;
    }

    /**
     * Sets nom adherent.
     *
     * @param nomAdherent the nom adherent
     */
    public void setNomAdherent(final String nomAdherent) {
        this.nomAdherent = nomAdherent;
    }

    /**
     * Gets prenom adherent.
     *
     * @return the prenom adherent
     */
    public String getPrenomAdherent() {
        return prenomAdherent;
    }

    /**
     * Sets prenom adherent.
     *
     * @param prenomAdherent the prenom adherent
     */
    public void setPrenomAdherent(final String prenomAdherent) {
        this.prenomAdherent = prenomAdherent;
    }

    /**
     * Gets adr adherent.
     *
     * @return the adr adherent
     */
    public String getAdrAdherent() {
        return adrAdherent;
    }

    /**
     * Sets adr adherent.
     *
     * @param adrAdherent the adr adherent
     */
    public void setAdrAdherent(final String adrAdherent) {
        this.adrAdherent = adrAdherent;
    }

    /**
     * Gets tele adherent.
     *
     * @return the tele adherent
     */
    public String getTeleAdherent() {
        return teleAdherent;
    }

    /**
     * Sets tele adherent.
     *
     * @param teleAdherent the tele adherent
     */
    public void setTeleAdherent(final String teleAdherent) {
        this.teleAdherent = teleAdherent;
    }

    /**
     * Gets perime le.
     *
     * @return the perime le
     */
    public String getPerimeLe() {
        return perimeLe;
    }

    /**
     * Sets perime le.
     *
     * @param perimeLe the perime le
     */
    public void setPerimeLe(final String perimeLe) {
        this.perimeLe = perimeLe;
    }

    /**
     * Gets pwd adherent.
     *
     * @return the pwd adherent
     */
    public String getPwdAdherent() {
        return pwdAdherent;
    }

    /**
     * Sets pwd adherent.
     *
     * @param pwdAdherent the pwd adherent
     */
    public void setPwdAdherent(final String pwdAdherent) {
        this.pwdAdherent = pwdAdherent;
    }
}