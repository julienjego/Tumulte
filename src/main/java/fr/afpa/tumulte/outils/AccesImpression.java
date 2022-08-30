package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Adherent;

public class AccesImpression {

    public static ListSommeEmprunt listSommeEmprunt;
    public static Adherent adherent;

    public static Adherent getAdherent() {
        return adherent;
    }

    public static void setAdherent(Adherent adherent) {
        AccesImpression.adherent = adherent;
    }

    public static ListSommeEmprunt getListSommeEmprunt() {
        return listSommeEmprunt;
    }

    public static void setListSommeEmprunt(ListSommeEmprunt listSommeEmprunt) {
        AccesImpression.listSommeEmprunt = listSommeEmprunt;
    }
}
