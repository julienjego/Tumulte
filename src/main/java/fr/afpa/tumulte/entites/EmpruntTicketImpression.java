package fr.afpa.tumulte.entites;

import java.time.LocalDate;


public class EmpruntTicketImpression {

    public EmpruntTicketImpression() {
    }

    private int numAdherent;
    private String codeExemplaire;
    private String numExemplaire;
    private String titre;
    private String bibliotheque;
    private LocalDate dateDePret;
    private LocalDate deteDeRetourLimite;

    private String isbn;

    public EmpruntTicketImpression(int numAdherent, String codeExemplaire, String numExemplaire, String titre, String bibliotheque, LocalDate dateDePret, LocalDate deteDeRetourLimite, String isbn) {
        this.numAdherent = numAdherent;
        this.codeExemplaire = codeExemplaire;
        this.numExemplaire = numExemplaire;
        this.titre = titre;
        this.bibliotheque = bibliotheque;
        this.dateDePret = dateDePret;
        this.deteDeRetourLimite = deteDeRetourLimite;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "EmpruntTicketImpression{" +
                "numAdherent=" + numAdherent +
                ", codeExemplaire='" + codeExemplaire + '\'' +
                ", numExemplaire='" + numExemplaire + '\'' +
                ", titre='" + titre + '\'' +
                ", bibliotheque='" + bibliotheque + '\'' +
                ", dateDePret=" + dateDePret +
                ", deteDeRetourLimite=" + deteDeRetourLimite +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public int getNumAdherent() {
        return numAdherent;
    }

    public void setNumAdherent(int numAdherent) {
        this.numAdherent = numAdherent;
    }

    public String getCodeExemplaire() {
        return codeExemplaire;
    }

    public void setCodeExemplaire(String codeExemplaire) {
        this.codeExemplaire = codeExemplaire;
    }

    public String getNumExemplaire() {
        return numExemplaire;
    }

    public void setNumExemplaire(String numExemplaire) {
        this.numExemplaire = numExemplaire;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(String bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public LocalDate getDateDePret() {
        return dateDePret;
    }

    public void setDateDePret(LocalDate dateDePret) {
        this.dateDePret = dateDePret;
    }

    public LocalDate getDeteDeRetourLimite() {
        return deteDeRetourLimite;
    }

    public void setDeteDeRetourLimite(LocalDate deteDeRetourLimite) {
        this.deteDeRetourLimite = deteDeRetourLimite;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
