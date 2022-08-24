package fr.afpa.tumulte.outils;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.util.Date;

@Embeddable
public class Emprunt_pk {
    int numAdherent;
    String numExemplaire;
    Date datEmprunt;

}
