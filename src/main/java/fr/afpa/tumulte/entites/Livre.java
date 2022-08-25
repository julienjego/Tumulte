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
    @JoinColumn(name = "codTheme")
    private Theme theme;
    /**
     * Titre du livre.
     */
    private String titreLivre;
    /**
     * Auteur du livre.
     */
    @ManyToMany
    @JoinTable(name = "redaction",
            joinColumns = @JoinColumn(name = "IsbnLivre"),
            inverseJoinColumns = @JoinColumn(name = "codAuteur"))
    private ArrayList<Auteur> auteur;

    /**
     * nombre d'emprunts de ce livre.
     */
    private int nbEmprunt;

    public Livre() {
    }

    /**
     * Instantiates a new Livre.
     *
     * @param isbnLivre  the isbn livre
     * @param theme      the cod theme
     * @param titreLivre the titre livre
     * @param auteur     the auteur
     */
    public Livre(String isbnLivre, Theme theme, String titreLivre, ArrayList<Auteur> auteur) {
        this.IsbnLivre = isbnLivre;
        this.theme = theme;
        this.titreLivre = titreLivre;
//        this.auteur = auteur;
    }

    public String getIsbnLivre() {
        return IsbnLivre;
    }

    public void setIsbnLivre(String isbnLivre) {
        this.IsbnLivre = isbnLivre;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getTitreLivre() {
        return titreLivre;
    }

    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }

    public ArrayList<Auteur> getAuteur() {
        return auteur;
    }

    public void setAuteur(ArrayList<Auteur> auteur) {
        this.auteur = auteur;
    }

}