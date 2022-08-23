package fr.afpa.tumulte.entites;

import jakarta.persistence.*;

import java.util.ArrayList;

/**
 * The type Livre.
 */
@Entity
@Table(name = "livre")
public class Livre {
    /**
     * l'isbn du livre.
     */
    @Id
    private String IsbnLivre;
    /**
     * code du thème du livre.
     */
    @ManyToOne
    private String codTheme;
    /**
     * Titre du livre.
     */
    private String titreLivre;
    /**
     * Auteur du livre.
     */
    @ManyToMany
    @JoinTable(name = "Redaction",
            joinColumns = @JoinColumn(name = "IsbnLivre"),
            inverseJoinColumns = @JoinColumn(name = "codAuteur"))
    private ArrayList<Auteur> auteur;
//    /**
//     * nombre d'exemplaire de ce livre.
//     */
//    private int nbExemplaire;
//    /**
//     * nombre d'emprunt de ce livre.
//     */
//    private int nbEmprunt;

    public Livre() {
    }

    /**
     * Instantiates a new Livre.
     *
     * @param isbnLivre  the isbn livre
     * @param codTheme   the cod theme
     * @param titreLivre the titre livre
     * @param auteur     the auteur
     */
    public Livre(String isbnLivre, String codTheme, String titreLivre, ArrayList<Auteur> auteur) {
        IsbnLivre = isbnLivre;
        this.codTheme = codTheme;
        this.titreLivre = titreLivre;
        this.auteur = auteur;
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
    public ArrayList<Auteur> getAuteur() {
        return auteur;
    }

    /**
     * Sets auteur.
     *
     * @param auteur the auteur
     */
    public void setAuteur(ArrayList<Auteur> auteur) {
        this.auteur = auteur;
    }

}