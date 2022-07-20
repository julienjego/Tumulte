package fr.afpa.tumulte.entites;

/**
 * The type Theme.
 */
public class Theme {
    /**
     * Code du thème.
     */
    private String codeTheme;
    /**
     * Nom du thème.
     */
    private String theme;
    /**
     * Description du thème.
     */
    private String descripTheme;
    /**
     * nombre d'emprunt de ce thème.
     */
    private int nbEmprunt;

    /**
     * Instantiates a new Theme.
     *
     * @param codeTheme    the code theme
     * @param theme        the theme
     * @param descripTheme the descrip theme
     * @param nbEmprunt    the nb emprunt
     */
    public Theme(String codeTheme, String theme, String descripTheme, int nbEmprunt) {
        this.codeTheme = codeTheme;
        this.theme = theme;
        this.descripTheme = descripTheme;
        this.nbEmprunt = nbEmprunt;
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
     * Gets code theme.
     *
     * @return the code theme
     */
    public String getCodeTheme() {
        return codeTheme;
    }

    /**
     * Sets code theme.
     *
     * @param codeTheme the code theme
     */
    public void setCodeTheme(String codeTheme) {
        this.codeTheme = codeTheme;
    }

    /**
     * Gets theme.
     *
     * @return the theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets theme.
     *
     * @param theme the theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Gets descrip theme.
     *
     * @return the descrip theme
     */
    public String getDescripTheme() {
        return descripTheme;
    }

    /**
     * Sets descrip theme.
     *
     * @param descripTheme the descrip theme
     */
    public void setDescripTheme(String descripTheme) {
        this.descripTheme = descripTheme;
    }

    /**
     * Surcharge du toString
     */
    @Override
    public String toString() {
        return String.format("code : %s %n theme : %s %n description : %s %n nbemprunt : %s %n", codeTheme, theme, descripTheme, nbEmprunt);
    }
}