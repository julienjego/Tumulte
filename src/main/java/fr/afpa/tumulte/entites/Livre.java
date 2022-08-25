package fr.afpa.tumulte.entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "redaction",
            joinColumns = @JoinColumn(name = "IsbnLivre"),
            inverseJoinColumns = @JoinColumn(name = "codAuteur"))
    private List<Auteur> auteur = new ArrayList<>();

    /**
     * nombre d'emprunts de ce livre.
     */
    private int nbEmprunt;

    /**
     * nombre d'exemplaires de ce livre.
     */
    private int nbExemplaires;

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
    public Livre(String isbnLivre, Theme theme, String titreLivre, List<Auteur> auteur) {
        this.IsbnLivre = isbnLivre;
        this.theme = theme;
        this.titreLivre = titreLivre;
        this.auteur = auteur;
    }

    public Livre(String isbnLivre, Theme theme, String titreLivre, List<Auteur> auteur, int nbEmprunt, int nbExemplaires) {
        IsbnLivre = isbnLivre;
        this.theme = theme;
        this.titreLivre = titreLivre;
        this.auteur = auteur;
        this.nbEmprunt = nbEmprunt;
        this.nbExemplaires = nbExemplaires;
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

    public List<Auteur> getAuteur() {
        return auteur;
    }

    public void setAuteur(List<Auteur> auteur) {
        this.auteur = auteur;
    }

    public int getNbEmprunt() {
        return nbEmprunt;
    }

    public void setNbEmprunt(int nbEmprunt) {
        this.nbEmprunt = nbEmprunt;
    }

    public int getNbExemplaires() {
        return nbExemplaires;
    }

    public void setNbExemplaires(int nbExemplaires) {
        this.nbExemplaires = nbExemplaires;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "IsbnLivre='" + IsbnLivre + '\'' +
                ", theme=" + theme +
                ", titreLivre='" + titreLivre + '\'' +
                ", auteur=" + auteur +
                ", nbEmprunt=" + nbEmprunt +
                ", nbExemplaires=" + nbExemplaires +
                '}';
    }
}