package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Bibliotheque;
import fr.afpa.tumulte.entites.Livre;
import fr.afpa.tumulte.entites.Theme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Utile.
 */
public class Utile {
    private static final String TOUTES_BIB = "Toutes les Bibliotèques";
    private static final AccesLivre accesLivre = new AccesLivre();

    /**
     * Exit app.
     *
     * @param message the message
     */
    public static void exitApp(final String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quitter ?");
        alert.setHeaderText(message);
        alert.setContentText("Êtes-vous sur de vouloir quitter l'application ?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.exit(0);
        }

    }

    /**
     * Lire bib array list.
     *
     * @return the array list
     */
    public static ArrayList<String> lireBib() {
        ArrayList<String> lstNomBib = new ArrayList<String>();
        List<Bibliotheque> lstBib = AccesStat.listBib();
        lstNomBib.add(TOUTES_BIB);
        lstBib.forEach(bibliotheque -> lstNomBib.add(bibliotheque.getLibelBibliotheque()));

        return lstNomBib;
    }

    /**
     * Lire thème dans la BDD.
     * lit la BDD contenant les thèmes
     * et renvoie un ObservableList de tous les thèmes
     *
     * @return the observable list
     */

    public static ObservableList<Theme> lireTheme(String nomBib) {
        try {
            List<Theme> listTheme = AccesStat.listTheme(nomBib);
            return FXCollections.observableArrayList(listTheme);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Une erreur inattendue s'est produite, veuillez réessayer plus tard");
            alert.setTitle("Erreur");
            alert.showAndWait();
        }
        return null;
    }

    /**
     * Lire livre dans la BDD..
     * lit la BDD contenant les livres
     * et renvoie un ObservableList de tous les livres
     *
     * @return the observable list
     */
    public static ObservableList<Livre> lireLivre(String nomBib) {
        try {
            List<Livre> listLivre = accesLivre.listLivres(nomBib);
            return FXCollections.observableArrayList(listLivre);
        } catch (Exception e) {
            System.out.println(e);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Une erreur inattendue s'est produite, veuillez réessayer plus tard");
            alert.setTitle("Erreur");
            alert.showAndWait();
        }
        return null;
    }

    public static ObservableList<Livre> updateLireLivre(String requete) {
        try {
            List<Livre> listLivre = accesLivre.filteredListLivres(requete);
            return FXCollections.observableArrayList(listLivre);
        } catch (Exception e) {
            System.out.println(e);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Impossible de mettre à jour la liste des livres");
            alert.setTitle("Erreur");
            alert.showAndWait();
        }
        return null;
    }

    /**
     * Gets date time.
     *
     * @return the date time
     */
    public static LocalDateTime getDateTime() {
        return LocalDateTime.now();

    }

    /**
     * Gets date time string.
     *
     * @return the date time string
     */
    public static String getDateTimeString() {
        final String DATE_FORMATTER_JOUR = "dd/MM/yyyy";
        final String DATE_FORMATTER_HEURE = "HH'h'mm";
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatterJ = DateTimeFormatter.ofPattern(DATE_FORMATTER_JOUR);
        DateTimeFormatter formatterH = DateTimeFormatter.ofPattern(DATE_FORMATTER_HEURE);
        String formatDateTimeJ = localDateTime.format(formatterJ);
        String formatDateTimeH = localDateTime.format(formatterH);
        return String.format("Le %s à %s ", formatDateTimeJ, formatDateTimeH);

    }

    public static LocalDate calcDateRetour() {

        return LocalDate.now().plusDays(15);


    }


}