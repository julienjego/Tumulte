package fr.afpa.tumulte.entites;

import fr.afpa.tumulte.outils.Redaction_pk;
import jakarta.persistence.*;

@Entity
@Table(name = "redaction")
@IdClass(Redaction_pk.class)
public class Redaction {
    @EmbeddedId
    private Redaction_pk id = new Redaction_pk();

    @ManyToOne
    @JoinColumn(name = "IsbnLivre", insertable = false, updatable = false)
    private Livre IsbnLivre;

    @ManyToOne
    @JoinColumn(name = "codAuteur", insertable = false, updatable = false)
    private Auteur codAuteur;

    public Livre getIsbnLivre() {
        return IsbnLivre;
    }

    public void setIsbnLivre(Livre isbnLivre) {
        IsbnLivre = isbnLivre;
    }

    public Auteur getCodAuteur() {
        return codAuteur;
    }

    public void setCodAuteur(Auteur codAuteur) {
        this.codAuteur = codAuteur;
    }

}
