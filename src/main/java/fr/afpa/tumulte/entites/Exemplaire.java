package fr.afpa.tumulte.entites;

import jakarta.persistence.*;


@Entity
public class Exemplaire {

    @Id
    private String numExemplaire;
    @ManyToOne
    @JoinColumn(name = "codBibliotheque")
    private Bibliotheque codBibliotheque;
    @ManyToOne
    @JoinColumn(name = "codEmplacement")
    private Emplacement codEmplacement;

    @ManyToOne
    @JoinColumn(name = "IsbnLivre")
    private Livre IsbnLivre;
    @Basic(fetch = FetchType.LAZY)
    private String commentExemplaire;
    private boolean disponible = true;


    public void setNumExemplaire(String numExemplaire) {
        this.numExemplaire = numExemplaire;
    }

    public void setCodBibliotheque(Bibliotheque codBibliotheque) {
        this.codBibliotheque = codBibliotheque;
    }

    public void setCodEmplacement(Emplacement emplacement) {
        this.codEmplacement = emplacement;
    }

    public void setIsbnLivre(Livre IsbnLivre) {
        this.IsbnLivre = IsbnLivre;
    }

    public void setCommentExemplaire(String commentExemplaire) {
        this.commentExemplaire = commentExemplaire;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNumExemplaire() {
        return numExemplaire;
    }

    public Bibliotheque getCodBibliotheque() {
        return codBibliotheque;
    }

    public Emplacement getemplacement() {
        return codEmplacement;
    }

    public Livre getlivre() {
        return IsbnLivre;
    }

    public String getCommentExemplaire() {
        return commentExemplaire;
    }

    public boolean isDisponible() {
        return disponible;
    }


    @Override
    public String toString() {
        return "Exemplaire{" +
                "numExemplaire='" + numExemplaire + '\'' +
                ", Bibliotheque='" + codBibliotheque + '\'' +
                ", emplacement=" + codEmplacement +
                ", livre=" + IsbnLivre +
                ", commentExemplaire='" + commentExemplaire + '\'' +
                ", disponible=" + disponible +
                '}';
    }

    public Exemplaire(String numExemplaire, Bibliotheque codBibliotheque, Emplacement emplacement, Livre IsbnLivre, String commentExemplaire, boolean disponible) {
        this.numExemplaire = numExemplaire;
        this.codBibliotheque = codBibliotheque;
        this.codEmplacement = emplacement;
        this.IsbnLivre = IsbnLivre;
        this.commentExemplaire = commentExemplaire;
        this.disponible = disponible;
    }

    public Exemplaire() {
    }
}
