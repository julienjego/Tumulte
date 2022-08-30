package fr.afpa.tumulte.entites;

import fr.afpa.tumulte.outils.Emprunt_pk;
import jakarta.persistence.*;

import java.time.LocalDate;

@IdClass(Emprunt_pk.class)
@Entity
@Table(name = "emprunt")
public class Emprunt {

    @Id
    @ManyToOne
    @JoinColumn(name = "numAdherent")
    public Adherent numAdherent;

    @Id
    @ManyToOne
    @JoinColumn(name = "numExemplaire")
    public Exemplaire numExemplaire;
    @Id
    public LocalDate datEmprunt;
    public LocalDate datRestitutionPrev;
    public LocalDate datRestitutionEff;

    public Emprunt() {
    }

    public Emprunt(Adherent numAdherent, Exemplaire numExemplaire, LocalDate datEmprunt, LocalDate datRestitutionPrev, LocalDate datRestitutionEff) {
        this.numAdherent = numAdherent;
        this.numExemplaire = numExemplaire;
        this.datEmprunt = datEmprunt;
        this.datRestitutionPrev = datRestitutionPrev;
        this.datRestitutionEff = datRestitutionEff;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "numAdherent=" + numAdherent +
                ", numExemplaire=" + numExemplaire +
                ", datEmprunt=" + datEmprunt +
                ", datRestitutionPrev=" + datRestitutionPrev +
                ", datRestitutionEff=" + datRestitutionEff +
                '}';
    }

    public Emprunt_pk getId() {
        return new Emprunt_pk(numAdherent.getNumAdherent(), numExemplaire.getNumExemplaire(), datEmprunt);
    }

    public Adherent getNumAdherent() {
        return numAdherent;
    }

    public void setNumAdherent(Adherent numAdherent) {
        this.numAdherent = numAdherent;
    }

    public Exemplaire getNumExemplaire() {
        return numExemplaire;
    }

    public void setNumExemplaire(Exemplaire numExemplaire) {
        this.numExemplaire = numExemplaire;
    }

    public LocalDate getDatEmprunt() {
        return datEmprunt;
    }

    public void setDatEmprunt(LocalDate datEmprunt) {
        this.datEmprunt = datEmprunt;
    }

    public LocalDate getDatRestitutionPrev() {
        return datRestitutionPrev;
    }

    public void setDatRestitutionPrev(LocalDate datRestitutionPrev) {
        this.datRestitutionPrev = datRestitutionPrev;
    }

    public LocalDate getDatRestitutionEff() {
        return datRestitutionEff;
    }

    public void setDatRestitutionEff(LocalDate datRestitutionEff) {
        this.datRestitutionEff = datRestitutionEff;
    }
}
