package fr.afpa.tumulte.controllers;

import fr.afpa.tumulte.app.App;
import fr.afpa.tumulte.entites.Adherent;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * The type Controller rechercher adherent.
 */
public class ControllerRechercherAdherent implements Initializable {


    /**
     * The Stage.
     */
    Stage stage;
    Scene scene;
    @FXML
    private Button btnConsulterFicheAdherent;
    @FXML
    private Button btnMenuPrincipal;
    @FXML
    private Button btnRechercherAdherent;
    @FXML
    private Button btnValiderAdherent;
    @FXML
    private Label lblCotisationAJour;
    @FXML
    private Label lblDateFinCotisation;
    @FXML
    private Label lblNomAdherent;
    @FXML
    private Label lblPrenomAdherent;
    @FXML
    private Label lblRole;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Label lblCotisation;
    @FXML
    private TableView<String[]> tablePretsEnCours;
    @FXML
    private TableColumn<String[], String> columnAuteur;
    @FXML
    private TableColumn<String[], String> columnTitre;
    @FXML
    private TableColumn<String[], String> columnDateEmprunt;
    @FXML
    private TitledPane titledPaneAdherent;
    @FXML
    private TextField txtNumAdherent;
    @FXML
    private Font x3;

    /* Activation des boutons Recherche, Consulter la fiche de l'adhérent
    et Valider lorsqu'un numéro d'adhérent est saisi
    * */
    @FXML
    private Color x4;

    /**
     * Activer boutons.
     */
    @FXML
    void activerBoutons() {
        btnRechercherAdherent.setDisable(!idAdherentEstValide());
        btnConsulterFicheAdherent.setDisable(!idAdherentEstValide());
        btnValiderAdherent.setDisable(!idAdherentEstValide());
    }

    /**
     * Consulter fiche adherent.
     */
    @FXML
    void consulterFicheAdherent() {
        afficherFicheAdherent();
    }

    /**
     * On click menu principal.
     */
    @FXML
    void onClickMenuPrincipal() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/menuPrincipal.fxml"));
        stage = (Stage) (menuBar.getScene().getWindow());
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menu principal");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Rechercher adherent.
     */
    @FXML
    void rechercherAdherent() {

        Adherent jean = new Adherent(
                "1234",
                "Neymar",
                "Jean",
                "1 rue du four - 59000 Marmusots",
                "06.01.02.03.04",
                "2022-07-17");

        afficherInfoAdherent(jean);

    }

    /**
     * Valider adherent.
     */
    @FXML
    void validerAdherent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("/fxml/EmprunterLivre.fxml"));
        Stage stage = (Stage) (menuBar.getScene().getWindow());
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.setTitle("Menu principal");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        btnRechercherAdherent.setDisable(true);
        btnConsulterFicheAdherent.setDisable(true);
        btnValiderAdherent.setDisable(true);
        lblCotisation.setVisible(false);
        lblDateFinCotisation.setVisible(false);

    }

    private boolean idAdherentEstValide() {
        return !txtNumAdherent.getText().equals("") && txtNumAdherent.getLength() < 11;
    }

    private boolean abonnementEstPerime(Adherent adherent) {
        return LocalDate.parse(adherent.getPerimeLe()).isBefore(LocalDate.now());
    }

    private boolean numAdherentEstConnu(Adherent adherent) {
        return txtNumAdherent.getText().equals(adherent.getNumAdherent());
    }

    private void afficherInfoAdherent(Adherent adherent) {
        if (numAdherentEstConnu(adherent)) {
            lblNomAdherent.setText(adherent.getNomAdherent());
            lblPrenomAdherent.setText(adherent.getPrenomAdherent());
            creerTableauEmpruntsJean();

            if (abonnementEstPerime(adherent)) {
                lblCotisationAJour.setText("Non");
                lblCotisation.setVisible(true);
                lblDateFinCotisation.setVisible(true);
                lblDateFinCotisation.setText(adherent.getPerimeLe());
            } else {
                lblCotisationAJour.setText("Oui");
                lblCotisation.setVisible(false);
            }

        } else {
            String headerTxt = "Ce numéro d'adhérent est inconnu !";
            String contentTxt = "Merci de vérifier et saisir un nouveau numéro d'adhérent.";
            fenetreErreur(headerTxt, contentTxt);
            txtNumAdherent.setText("");
        }
    }

    private void fenetreErreur(String headerTxt, String contentTxt) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Erreur !");
        alert.setHeaderText(headerTxt);
        alert.setContentText(contentTxt);
        alert.showAndWait();
    }

    @FXML
    private void afficherFicheAdherent() {
        try {
/*            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/afficherAdherent.fxml"));

            Scene scene2 = new Scene(fxmlLoader.load());
            Stage stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.initOwner(stage);

            stage2.show();*/

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/afficherAdherent.fxml"));
            Stage stage = (Stage) (menuBar.getScene().getWindow());
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Menu principal");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println("Impossible d'ouvrir la fenêtre !");
        }
    }

    private void creerTableauEmpruntsJean() {
        String[][] livresEmpruntes = {{"Java pour les nuls", "Barry Burd", "12/07/2022"},
                {"Un autre livre", "BB", "12/07/2022"}};
        ObservableList<String[]> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(livresEmpruntes));

        for (int i = 0; i < livresEmpruntes.length; i++) {
            final int colNo = i;

            columnTitre.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo - 1]));
                }
            });
            columnAuteur.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo]));
                }
            });
            columnDateEmprunt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo + 1]));
                }
            });
        }

        tablePretsEnCours.setItems(data);

    }

    @FXML
    void openAbout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("A propos");
        alert.setHeaderText("A propos de l'application");
        alert.setContentText("L'appli Mégathèque a été réalisée par Jérôme Chaput, Damien Gruffeille, Julien Jégo et Oziris à l'Afpa de Beaumont.\rElle est vachement bien.\r© Afpa 2022 ");
        alert.showAndWait();
    }

}



