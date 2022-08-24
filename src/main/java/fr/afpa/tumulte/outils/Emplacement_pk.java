package fr.afpa.tumulte.outils;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Emplacement_pk implements Serializable {
    @Column(name = "codEmplacement")
    private String codEmplacement;
    @Column(name = "codBibliotheque")
    private String codBibliotheque;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emplacement_pk that = (Emplacement_pk) o;
        return Objects.equals(codEmplacement, that.codEmplacement) && Objects.equals(codBibliotheque, that.codBibliotheque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codEmplacement, codBibliotheque);
    }
    
}
