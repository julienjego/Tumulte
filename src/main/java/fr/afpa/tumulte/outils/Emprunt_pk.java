package fr.afpa.tumulte.outils;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class Emprunt_pk implements Serializable {
    //@ManyToOne
    Integer numAdherent;
    String numExemplaire;
    LocalDate datEmprunt;

    public Emprunt_pk(Integer numAdherent, String numExemplaire, LocalDate datEmprunt) {
        this.numAdherent = numAdherent;
        this.numExemplaire = numExemplaire;
        this.datEmprunt = datEmprunt;
    }

    private Emprunt_pk() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Emprunt_pk emprunt_pk = (Emprunt_pk) o;
        return Objects.equals(numAdherent, emprunt_pk.numAdherent) &&
                Objects.equals(numExemplaire, emprunt_pk.numExemplaire) &&
                Objects.equals(datEmprunt, emprunt_pk.datEmprunt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAdherent, numExemplaire, datEmprunt);
    }
}
