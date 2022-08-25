package fr.afpa.tumulte.entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Auteur.
 */
@Entity
@Table(name = "auteur")
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codAuteur;

    private String nomAuteur;

    private String prenomAuteur;

    @ManyToMany
    @JoinTable(name = "redaction",
            joinColumns = @JoinColumn(name = "codAuteur"),
            inverseJoinColumns = @JoinColumn(name = "IsbnLivre"))
    private List<Livre> livres = new ArrayList<>();

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    public Auteur(int codAuteur, String nomAuteur, String prenomAuteur, List<Livre> livres) {
        this.codAuteur = codAuteur;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
        this.livres = livres;
    }

    public Auteur() {
    }

    /**
     * Instantiates a new Auteur.
     *
     * @param nomPrenomAuteur the nom prenom auteur
     */
    public Auteur(String nomPrenomAuteur) {
        prenomAuteur = nomPrenomAuteur.substring(0, nomPrenomAuteur.indexOf(" "));
        nomAuteur = nomPrenomAuteur.substring(nomPrenomAuteur.indexOf(" "));
    }

    /**
     * Instantiates a new Auteur.
     *
     * @param codAuteur    the code auteur
     * @param nomAuteur    the nom auteur
     * @param prenomAuteur the prenom auteur
     */
    public Auteur(int codAuteur, String nomAuteur, String prenomAuteur) {
        this.codAuteur = codAuteur;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
    }

    /**
     * Gets code auteur.
     *
     * @return the code auteur
     */
    public int getCodAuteur() {
        return codAuteur;
    }

    /**
     * Sets code auteur.
     *
     * @param codAuteur the code auteur
     */
    public void setCodAuteur(int codAuteur) {
        this.codAuteur = codAuteur;
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

        return String.format( "%s %s", nomAuteur, prenomAuteur);
    }
}