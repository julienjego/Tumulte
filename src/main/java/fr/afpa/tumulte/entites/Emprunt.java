package fr.afpa.tumulte.entites;

import fr.afpa.tumulte.outils.Emprunt_pk;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

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
    public Date datEmprunt;

    public Date datRestitutionPrev;
    public Date datRestitutionEff;

    public Emprunt() {
    }

    public Emprunt(Adherent numAdherent, Exemplaire numExemplaire, Date datEmprunt, Date datRestitutionPrev, Date datRestitutionEff) {
        this.numAdherent = numAdherent;
        this.numExemplaire = numExemplaire;
        this.datEmprunt = datEmprunt;
        this.datRestitutionPrev = datRestitutionPrev;
        this.datRestitutionEff = datRestitutionEff;
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

    public Date getDatEmprunt() {
        return datEmprunt;
    }

    public void setDatEmprunt(Date datEmprunt) {
        this.datEmprunt = datEmprunt;
    }

    public Date getDatRestitutionPrev() {
        return datRestitutionPrev;
    }

    public void setDatRestitutionPrev(Date datRestitutionPrev) {
        this.datRestitutionPrev = datRestitutionPrev;
    }

    public Date getDatRestitutionEff() {
        return datRestitutionEff;
    }

    public void setDatRestitutionEff(Date datRestitutionEff) {
        this.datRestitutionEff = datRestitutionEff;
    }
}
