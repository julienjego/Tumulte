package fr.afpa.tumulte.entites;

import java.time.LocalDate;
import java.util.List;

public class TableViewEmpruntsEnCours {

    private String titreLivre;
    private LocalDate datEmprunt;
    private String nomsAuteurs;
    private String nomBibliotheque;
    private String isbn;
    private LocalDate datRetour;
    private String numExemplaire;


    public void format (List<Auteur> auteurs) {
        nomsAuteurs = "";
        for (Auteur auteur : auteurs) {
            if (nomsAuteurs != "") {
                nomsAuteurs += ", " + auteur.getNomAuteur();
            } else {
                nomsAuteurs += auteur.getNomAuteur();
            }
        }

    }

    public TableViewEmpruntsEnCours(String titreLivre,
                                    LocalDate datEmprunt,
                                    List<Auteur> nomAuteur,
                                    String nomBibliotheque,
                                    String isbn,
                                    LocalDate datRetour,
                                    String numExemplaire) {
        this.titreLivre = titreLivre;
        this.datEmprunt = datEmprunt;
        format(nomAuteur);
        this.nomBibliotheque = nomBibliotheque;
        this.isbn = isbn;
        this.datRetour = datRetour;
        this.numExemplaire = numExemplaire;
    }


    public String getTitreLivre() {
        return titreLivre;
    }

    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }

    public String getNomsAuteurs() {
        return nomsAuteurs;
    }

    public void setNomsAuteurs(String nomsAuteurs) {
        this.nomsAuteurs = nomsAuteurs;
    }

    public LocalDate getDatEmprunt() {
        return datEmprunt;
    }

    public void setDatEmprunt(LocalDate datEmprunt) {
        this.datEmprunt = datEmprunt;
    }

    @Override
    public String toString() {
        return "TableViewEmpruntsEnCours{" +
                "titreLivre='" + titreLivre + '\'' +
                ", nomAuteur='" + nomsAuteurs + '\'' +
                ", datEmprunt=" + datEmprunt +
                '}';
    }
}
