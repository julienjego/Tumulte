package fr.afpa.tumulte.entites;

import fr.afpa.tumulte.outils.Emplacement_pk;
import jakarta.persistence.*;

@IdClass(Emplacement_pk.class)
@Entity
@Table(name = "emplacement")
public class Emplacement {
    @Id
    @ManyToOne
    @JoinColumn(name = "codBibliotheque")
    private Bibliotheque bibliotheque;
    @Id
    private String codEmplacement;
    @ManyToOne
    @JoinColumn(name = "codTheme")
    private Theme theme;
    private String libelEmplacement;

    public Emplacement(Bibliotheque codBibliotheque, String codEmplacement, Theme codTheme, String libelEmplacement) {
        this.bibliotheque = codBibliotheque;
        codEmplacement = codEmplacement;
        this.theme = codTheme;
        libelEmplacement = libelEmplacement;
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
        codEmplacement = codEmplacement;
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
        libelEmplacement = libelEmplacement;
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
