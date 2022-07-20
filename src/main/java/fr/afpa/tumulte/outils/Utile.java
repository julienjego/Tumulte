package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Auteur;
import fr.afpa.tumulte.entites.Livre;
import fr.afpa.tumulte.entites.Theme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * The type Utile.
 */
public class Utile {

    /**
     * Exit app.
     *
     * @param message the message
     */
    public static void exitApp(final String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quitter ?");
        alert.setHeaderText(message);
        alert.setContentText("Êtes-vous sur de vouloir quitter l'application");

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
        ArrayList<String> lstBib = new ArrayList<String>();
        lstBib.add("Toutes les Bibliotèques");
        lstBib.add("Bibliotèques de Marmusot");
        lstBib.add("Bibliotèques à la con");
        return lstBib;
    }

    /**
     * Lire livre dans le fichier csv.
     * lit le fichier csv contenant les livres
     * et renvoie un ObservableList de tous les livres
     *
     * @return the observable list
     */
    public static ObservableList<Livre> lireLivre() {
        try {
            FileReader fileReader = new FileReader(
                    "src/main/resources/csv/lstLivre.csv");
            LineNumberReader lineNumberReader
                    = new LineNumberReader(fileReader);
            String ligneLue;
            String isbnLivre;
            String codTheme;
            String titreLivre;
            Auteur auteur;
            int nbExemplaire;
            int nbEmprunt;

            Livre livre;
            ArrayList<Livre> listLivre = new ArrayList<>();
            do {
                ligneLue = lineNumberReader.readLine();
                if (ligneLue != null) {
                    isbnLivre = ligneLue.substring(0, ligneLue.indexOf(","));

                    ligneLue = ligneLue.substring(ligneLue.indexOf(",") + 1);
                    titreLivre = ligneLue.substring(0, ligneLue.indexOf(","));

                    ligneLue = ligneLue.substring(ligneLue.indexOf(",") + 1);
                    auteur = new Auteur(ligneLue.substring(0, ligneLue.indexOf(",")));

                    ligneLue = ligneLue.substring(ligneLue.indexOf(",") + 1);
                    codTheme = ligneLue.substring(0, ligneLue.indexOf(","));

                    ligneLue = ligneLue.substring(ligneLue.indexOf(",") + 1);
                    nbExemplaire = Integer.parseInt(
                            ligneLue.substring(0, ligneLue.indexOf(",")));

                    ligneLue = ligneLue.substring(ligneLue.indexOf(",") + 1);
                    nbEmprunt = Integer.parseInt(ligneLue);

                    livre = new Livre(isbnLivre,
                            codTheme,
                            titreLivre,
                            auteur,
                            nbExemplaire,
                            nbEmprunt);
                    listLivre.add(livre);
                }
            } while (ligneLue != null);

            return FXCollections.observableArrayList(listLivre);
        } catch (NullPointerException npe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(npe.getMessage());
            alert.showAndWait();
        } catch (FileNotFoundException fnfe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(fnfe.getMessage());
            alert.setContentText("fichier non trouvé !");
            alert.showAndWait();

        } catch (IOException ioe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.setTitle("Erreur");
            alert.showAndWait();
        }
        return null;

    }

    /**
     * Lire thème dans le fichier csv.
     * lit le fichier csv contenant les thèmes
     * et renvoie un ObservableList de tous les thèmes
     *
     * @return the observable list
     */
    public static ObservableList<Theme> lireTheme() {
        try {
            FileReader fileReader = new FileReader(
                    "src/main/resources/csv/lstThemes.csv");
            LineNumberReader lineNumberReader
                    = new LineNumberReader(fileReader);
            String ligneLue;
            String codeTheme;
            String lTheme;
            String description;
            int nbEmprunt;
            Theme theme;
            ArrayList<Theme> listTheme = new ArrayList<>();
            do {
                ligneLue = lineNumberReader.readLine();
                if (ligneLue != null) {
                    codeTheme = ligneLue.substring(0, ligneLue.indexOf(","));
                    ligneLue = ligneLue.substring(ligneLue.indexOf(",") + 1);
                    lTheme = ligneLue.substring(0, ligneLue.indexOf(","));
                    ligneLue = ligneLue.substring(ligneLue.indexOf(",") + 1);
                    description = ligneLue.substring(0, ligneLue.indexOf(","));
                    ligneLue = ligneLue.substring(ligneLue.indexOf(",") + 1);
                    nbEmprunt = Integer.parseInt(ligneLue);
                    theme = new Theme(codeTheme,
                            lTheme,
                            description,
                            nbEmprunt);
                    listTheme.add(theme);
                }
            } while (ligneLue != null);
            return FXCollections.observableArrayList(listTheme);
        } catch (NullPointerException npe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(npe.getMessage());
            alert.showAndWait();
        } catch (FileNotFoundException fnfe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(fnfe.getMessage());
            alert.setContentText("fichier non trouvé !");
            alert.showAndWait();

        } catch (IOException ioe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
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
}