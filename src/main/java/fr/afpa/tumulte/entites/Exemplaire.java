package fr.afpa.tumulte.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "exemplaire")
public class Exemplaire {

    @Id
    private String numExemplaire;
    @ManyToOne
    @JoinColumn(name = "codBibliotheque")
    private Bibliotheque bibliotheque;
    @ManyToOne
    @JoinColumn(name = "codEmplacement")
    private Emplacement emplacement;

    @ManyToOne
    @JoinColumn(name = "IsbnLivre")
    private Livre IsbnLivre;
    @Basic(fetch = FetchType.LAZY)
    private String commentExemplaire;
    private boolean disponible = true;

    public Exemplaire(String numExemplaire, Bibliotheque bibliotheque, Emplacement emplacement, Livre IsbnLivre, String commentExemplaire, boolean disponible) {
        this.numExemplaire = numExemplaire;
        this.bibliotheque = bibliotheque;
        this.emplacement = emplacement;
        this.IsbnLivre = IsbnLivre;
        this.commentExemplaire = commentExemplaire;
        this.disponible = disponible;
    }

    public Exemplaire() {
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }

    public void setIsbnLivre(Livre IsbnLivre) {
        this.IsbnLivre = IsbnLivre;
    }

    public String getNumExemplaire() {
        return numExemplaire;
    }

    public void setNumExemplaire(String numExemplaire) {
        this.numExemplaire = numExemplaire;
    }

    public Bibliotheque getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public Emplacement getemplacement() {
        return emplacement;
    }

    public Livre getlivre() {
        return IsbnLivre;
    }

    public String getCommentExemplaire() {
        return commentExemplaire;
    }

    public void setCommentExemplaire(String commentExemplaire) {
        this.commentExemplaire = commentExemplaire;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                       "numExemplaire='" + numExemplaire + '\'' +
                       ", Bibliotheque='" + bibliotheque + '\'' +
                       ", emplacement=" + emplacement +
                       ", livre=" + IsbnLivre +
                       ", commentExemplaire='" + commentExemplaire + '\'' +
                       ", disponible=" + disponible +
                       '}';
    }
}
