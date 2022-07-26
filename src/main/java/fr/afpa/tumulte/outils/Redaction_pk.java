package fr.afpa.tumulte.outils;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Redaction_pk implements Serializable {
    @Column(name = "IsbnLivre", insertable = false, updatable = false)
    private String IsbnLivre;
    @Column(name = "codAuteur", insertable = false, updatable = false)
    private int codAuteur;

    public String getIsbnLivre() {
        return IsbnLivre;
    }

    public void setIsbnLivre(String isbnLivre) {
        IsbnLivre = isbnLivre;
    }

    public int getCodAuteur() {
        return codAuteur;
    }

    public void setCodAuteur(int codAuteur) {
        this.codAuteur = codAuteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Redaction_pk pk = (Redaction_pk) o;
        return Objects.equals(IsbnLivre, pk.IsbnLivre) &&
                       Objects.equals(codAuteur, pk.codAuteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IsbnLivre, codAuteur);
    }
}
