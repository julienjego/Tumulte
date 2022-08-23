package fr.afpa.tumulte.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "emplacement")
public class Emplacement {
    @ManyToOne
    private String codBibliotheque;
    @Id
    private String CodEmplacement;
    @OneToOne
    private String codTheme;
    private String LibelEmplacement;

    public Emplacement(String codBibliotheque, String codEmplacement, String codTheme, String libelEmplacement) {
        this.codBibliotheque = codBibliotheque;
        CodEmplacement = codEmplacement;
        this.codTheme = codTheme;
        LibelEmplacement = libelEmplacement;
    }

    public Emplacement() {
    }

    public String getCodBibliotheque() {
        return codBibliotheque;
    }

    public void setCodBibliotheque(String codBibliotheque) {
        this.codBibliotheque = codBibliotheque;
    }

    public String getCodEmplacement() {
        return CodEmplacement;
    }

    public void setCodEmplacement(String codEmplacement) {
        CodEmplacement = codEmplacement;
    }

    public String getCodTheme() {
        return codTheme;
    }

    public void setCodTheme(String codTheme) {
        this.codTheme = codTheme;
    }

    public String getLibelEmplacement() {
        return LibelEmplacement;
    }

    public void setLibelEmplacement(String libelEmplacement) {
        LibelEmplacement = libelEmplacement;
    }

    @Override
    public String toString() {
        return "Emplacement{" +
                "codBibliotheque='" + codBibliotheque + '\'' +
                ", CodEmplacement='" + CodEmplacement + '\'' +
                ", codTheme='" + codTheme + '\'' +
                ", LibelEmplacement='" + LibelEmplacement + '\'' +
                '}';
    }
}
