package fr.afpa.tumulte.entites;

import jakarta.persistence.*;

/**
 * The type Theme.
 */
@Entity
@Table(name = "theme")
public class Theme {
    /**
     * Code du thème.
     */
    @Id
    private String codTheme;
    /**
     * Nom du thème.
     */
    private String libelTheme;
    /**
     * Description du thème.
     */
    private String descripTheme;
    /**
     * nombre d'emprunt de ce thème.
     */
    @Transient
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
        this.codTheme = codeTheme;
        this.libelTheme = theme;
        this.descripTheme = descripTheme;
        this.nbEmprunt = nbEmprunt;
    }

    public Theme() {

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
    public String getCodTheme() {
        return codTheme;
    }

    /**
     * Sets code theme.
     *
     * @param codTheme the code theme
     */
    public void setCodTheme(String codTheme) {
        this.codTheme = codTheme;
    }

    /**
     * Gets theme.
     *
     * @return the theme
     */
    public String getLibelTheme() {
        return libelTheme;
    }

    /**
     * Sets theme.
     *
     * @param libelTheme the theme
     */
    public void setLibelTheme(String libelTheme) {
        this.libelTheme = libelTheme;
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
        return String.format("code : %s %n theme : %s %n description : %s %n nbemprunt : %s %n", codTheme, libelTheme, descripTheme, nbEmprunt);
    }
}