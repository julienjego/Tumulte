package fr.afpa.tumulte.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bibliotheque")
public class Bibliotheque {
    @Id
    private String codBiblio;
    private String libelBibliotheque;
    private String adrBibliotheque;

    public Bibliotheque(String codBiblio, String libelBibliotheque, String adrBibliotheque) {
        this.codBiblio = codBiblio;
        this.libelBibliotheque = libelBibliotheque;
        this.adrBibliotheque = adrBibliotheque;
    }

    public Bibliotheque() {
    }

    public String getCodBiblio() {
        return codBiblio;
    }

    public void setCodBiblio(String codBiblio) {
        this.codBiblio = codBiblio;
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
                "codBiblio='" + codBiblio + '\'' +
                ", libelBibliotheque='" + libelBibliotheque + '\'' +
                ", adrBibliotheque='" + adrBibliotheque + '\'' +
                '}';
    }
}
