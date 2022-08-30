package fr.afpa.tumulte.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "emplacement")
public class Emplacement {

    @ManyToOne
    @JoinColumn(name = "codBibliotheque")
    @MapsId("codBibliotheque")
    private Bibliotheque bibliotheque;

    //    @MapsId("codEmplacement")
    @Id
    private String codEmplacement;
    @ManyToOne
    @JoinColumn(name = "codTheme")
    private Theme theme;
    private String libelEmplacement;

    public Emplacement(Bibliotheque codBibliotheque, String codEmplacement, Theme codTheme, String libelEmplacement) {
        this.bibliotheque = codBibliotheque;
        this.codEmplacement = codEmplacement;
        this.theme = codTheme;
        this.libelEmplacement = libelEmplacement;
    }

    public Emplacement() {
    }

    public Bibliotheque getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public String getCodEmplacement() {
        return codEmplacement;
    }

    public void setCodEmplacement(String codEmplacement) {
        this.codEmplacement = codEmplacement;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getLibelEmplacement() {
        return libelEmplacement;
    }

    public void setLibelEmplacement(String libelEmplacement) {
        this.libelEmplacement = libelEmplacement;
    }

    @Override
    public String toString() {
        return "Emplacement{" +
                       "codBibliotheque='" + bibliotheque + '\'' +
                       ", CodEmplacement='" + codEmplacement + '\'' +
                       ", codTheme='" + theme + '\'' +
                       ", LibelEmplacement='" + libelEmplacement + '\'' +
                       '}';
    }
}
