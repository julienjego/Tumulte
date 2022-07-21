package fr.afpa.tumulte.controllers;

import fr.afpa.tumulte.app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.security.KeyException;
import java.util.ResourceBundle;

/**
 * The type Controller emprunt livre.
 */
public class ControllerEmpruntLivre implements Initializable {

    /**
     * Bouton annuler.
     */
    @FXML
    private Button btnAnnuler;

    /**
     * Bouton emprunter.
     */
    @FXML
    private Button btnEmprunter;

    /**
     * Bouton Menu Principal.
     */
    @FXML
    private Button btnMenuPrincipal;

    /**
     * Bouton rechercher Livre.
     */
    @FXML
    private Button btnRechercherLivre;

    /**
     * Label de l'auteur.
     */
    @FXML
    private Label lblAuteur;

    /**
     * Label de disponibilité du livre.
     */
    @FXML
    private Label lblDisponible;

    /**
     * Label de l'emplacement du livre.
     */
    @FXML
    private Label lblEmplacement;

    /**
     * Label de l'état du livre.
     */
    @FXML
    private Label lblEtat;

    /**
     * Label de l'ISBN.
     */
    @FXML
    private Label lblISBN;

    /**
     * Label de l'ISSN.
     */
    @FXML
    private Label lblISSN;

    /**
     * Label indiquant le nom de l'adhérent.
     */
    @FXML
    private Label lblNomAdherent;

    /**
     * Label indiquant le numéro de l'adhérent.
     */
    @FXML
    private Label lblNumAdherent;

    /**
     * Label indiquant le prénom de l'adhérent.
     */
    @FXML
    private Label lblPrenomAdherent;

    /**
     * Label indiquant le thème du livre.
     */
    @FXML
    private Label lblTheme;

    /**
     * Label indiquant le titre du livre.
     */
    @FXML
    private Label lblTitreExemplaire;

    /**
     * Label indiquant le code de l'exemplaire.
     */
    @FXML
    private TextField txtCodeExemplaire;

    /**
     * Barre de menu.
     */
    @FXML
    private MenuBar menuBar;

    /**
     * Font.
     */
    @FXML
    private Font x3;

    /**
     * Font.
     */
    @FXML
    private Color x4;

    /**
     * Annuler.
     */
    @FXML
    void annuler() {
        effacer();
    }

    /**
     * Emprunter livre.
     */
    @FXML
    void emprunterLivre() {
        confEmpruntLivre();
        effacer();
    }

    /**
     * Rechercher livre.
     */
    @FXML
    void rechercherLivre() {
        afficherLabels();

    }

    /**
     * Retour menu principal.
     */
    @FXML
    void retourMenuPrincipal() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("/fxml/menuPrincipal.fxml"));
        Stage stage = (Stage) (menuBar.getScene().getWindow());
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menu principal");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Activer btn rechercher.
     */
    @FXML
    void activerBtnRechercher(KeyEvent e) {

        btnRechercherLivre.setDisable(codeExemplaireIsEmpty());
        if (e.getCode().equals(KeyCode.ENTER) ) {
            rechercherLivre();
        }
    }

    /**
     * Désactive le btn rechercher à l'initialisation.
     */
    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        init();
    }

    private void init() {
        btnRechercherLivre.setDisable(true);
    }

    /**
     * Affiche les valeurs du livre lors du click sur
     * le bouton rechercher.
     */
    private void afficherLabels() {
        if (txtCodeExemplaire.getText().equals("666")){
            String messageErreur1 = "Le livre n'est pas disponible.";
            String messageErreur2 = "Le Livre JavaFX pour les nuls est déjà emprunté\r"
                    + "Vous pouvez passer au suivant ou quitter";
            afficherMessageErreur(messageErreur1, messageErreur2);
        } else if (txtCodeExemplaire.getText().equals("6666")) {
            lblTitreExemplaire.setText("JavaFX pour les nuls");
            lblAuteur.setText("Doug Lowe");
            lblTheme.setText("Autre");
            lblEtat.setText("Neuf");
            lblDisponible.setText("Non");
            lblISBN.setText("978-1-118-38534-0");
            lblISSN.setText("NC");
            lblEmplacement.setText("B1");
        } else {
            lblTitreExemplaire.setText("JavaFX pour les nuls");
            lblAuteur.setText("Doug Lowe");
            lblTheme.setText("Autre");
            lblEtat.setText("Neuf");
            lblDisponible.setText("Oui");
            lblISBN.setText("978-1-118-38534-0");
            lblISSN.setText("NC");
            lblEmplacement.setText("B1");
        }
    }

    private void effacer() {
        txtCodeExemplaire.setText("");
        lblTitreExemplaire.setText("");
        lblAuteur.setText("");
        lblTheme.setText("");
        lblEtat.setText("");
        lblDisponible.setText("");
        lblISBN.setText("");
        lblISSN.setText("");
        lblEmplacement.setText("");
    }

    private void confEmpruntLivre() {

        if (txtCodeExemplaire.getText().equals("6666")){
            String messageErreur1 = "Le livre n'est pas disponible.";
            String messageErreur2 = "Le Livre JavaFX pour les nuls est déjà emprunté\r"
                    + "Vous pouvez passer au suivant ou quitter";
            afficherMessageErreur(messageErreur1, messageErreur2);
        } else {
            String message1 = "Le livre est emprunté.";
            String message2 = "Merci de nous laisser tranquille.";
            afficherMessage(message1, message2);
        }

    }

    private void afficherMessageErreur(String messageErreur1, String messageErreur2) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Erreur");
        alert.setHeaderText(messageErreur1);
        alert.setContentText(messageErreur2);
        alert.showAndWait();
    }

    private void afficherMessage(String message1, String message2) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(message1);
        alert.setContentText(message2);
        alert.showAndWait();
    }

    private boolean codeExemplaireIsEmpty() {
        return txtCodeExemplaire.getLength() == 0;
    }

    @FXML
    void openAbout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("A propos");
        alert.setHeaderText("A propos de l'application");
        alert.setContentText("L'appli Mégathèque a été réalisée par Jérôme Chaput, Damien Gruffeille, Julien Jégo et Oziris à l'Afpa de Beaumont.\rElle est vachement bien.\rIcônes : © max.icons\r© Afpa 2022 ");
        alert.showAndWait();
    }
}