package fr.afpa.tumulte.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bibliotheque")
public class Bibliotheque {
    @Id
    private String codBibliotheque;
    private String libelBibliotheque;
    private String adrBibliotheque;

    public Bibliotheque(String codBibliotheque, String libelBibliotheque, String adrBibliotheque) {
        this.codBibliotheque = codBibliotheque;
        this.libelBibliotheque = libelBibliotheque;
        this.adrBibliotheque = adrBibliotheque;
    }

    public Bibliotheque() {
    }

    public String getCodBibliotheque() {
        return codBibliotheque;
    }

    public void setCodBibliotheque(String codBibliotheque) {
        this.codBibliotheque = codBibliotheque;
    }

    public String getLibelBibliotheque() {
        return libelBibliotheque;
    }

    public void setLibelBibliotheque(String libelBibliotheque) {
        this.libelBibliotheque = libelBibliotheque;
    }

    public String getAdrBibliotheque() {
        return adrBibliotheque;
    }

    public void setAdrBibliotheque(String adrBibliotheque) {
        this.adrBibliotheque = adrBibliotheque;
    }

    @Override
    public String toString() {
        return "Bibliotheque{" +
                       "codBiblio='" + codBibliotheque + '\'' +
                       ", libelBibliotheque='" + libelBibliotheque + '\'' +
                       ", adrBibliotheque='" + adrBibliotheque + '\'' +
                       '}';
    }
}
