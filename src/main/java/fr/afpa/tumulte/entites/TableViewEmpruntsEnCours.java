package fr.afpa.tumulte.entites;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TableViewEmpruntsEnCours {

    private String titreLivre;
    private LocalDate datEmprunt;
    private String nomsAuteurs;


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

    public TableViewEmpruntsEnCours(String titreLivre, List<Auteur> nomAuteur, LocalDate datEmprunt) {
        this.titreLivre = titreLivre;
        format(nomAuteur);
        this.datEmprunt = datEmprunt;
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
