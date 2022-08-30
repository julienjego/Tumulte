package fr.afpa.tumulte.controllers;

import fr.afpa.tumulte.app.App;
import fr.afpa.tumulte.entites.Adherent;
import fr.afpa.tumulte.entites.TableViewEmpruntsEnCours;
import fr.afpa.tumulte.outils.AccesImpression;
import fr.afpa.tumulte.outils.ListSommeEmprunt;
import fr.afpa.tumulte.outils.ProjectionTableauEmprunt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerAfficherAdherent implements Initializable {

    final ObservableList<TableViewEmpruntsEnCours> data = FXCollections.observableArrayList();
    public Label lblDate;
    public Adherent adherent;
    ProjectionTableauEmprunt projectionTableauEmprunt = new ProjectionTableauEmprunt();
    private Adherent adherentAff;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button btnImpreimerTicket;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnRetour;
    @FXML
    private TableColumn colTtlBbl;
    @FXML
    private TableColumn colTtlCodeExemplaire;
    @FXML
    private TableColumn colTtlDatepret;
    @FXML
    private TableColumn colTtlIsbn;
    @FXML
    private TableColumn colTtlTitre;
    @FXML
    private TableColumn colTtldateRetour;
    @FXML
    private Label lblAdresse;
    @FXML
    private Label lblNbPretEnCours;
    @FXML
    private Label lblNom;
    @FXML
    private Label lblNumAdherent;
    @FXML
    private Label lblPrenom;
    @FXML
    private Label lblPretRetard;
    @FXML
    private Label lblRole;
    @FXML
    private Label lblTel;
    @FXML
    private TableView<TableViewEmpruntsEnCours> tblPretEnCours;
    @FXML
    private Font x3;
    @FXML
    private Font x31;
    @FXML
    private Color x4;
    @FXML
    private Color x41;
    @FXML
    private MenuBar menuBar;


    @FXML
    void imprimerTicket(ActionEvent event) {
        imprimer();

    }


    @FXML
    void modifierAdherent(ActionEvent event) {
        /** @TODO prévoir d'ajouter le code */

    }

    /**
     * @param event coucou
     */
    @FXML
    void retourVersRechercherAdherent(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/rechercherAdherent.fxml"));
        stage = (Stage) (menuBar.getScene().getWindow());
        scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());
        stage.setTitle("Emprunter");
        stage.setScene(scene);
        ControllerRechercherAdherent ctrlRechAdh = fxmlLoader.getController();
        ctrlRechAdh.taxiAdherent(adherentAff);
        stage.show();

    }

    private void imprimer() {
        try {
            String numAdherent = lblNumAdherent.getText();
            ListSommeEmprunt listSommeEmprunt = new ListSommeEmprunt();
            listSommeEmprunt.listEmpruntImpression(Integer.valueOf(numAdherent));
            AccesImpression.setListSommeEmprunt(listSommeEmprunt);



            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/impressionTicket.fxml"));

            Scene scene2 = new Scene(fxmlLoader.load());
            Stage stage2 = new Stage();
            stage2.setTitle("Imprimer");
            stage2.setScene(scene2);

            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.initOwner(stage);
            stage2.setResizable(false);
            stage2.show();

        } catch (IOException e) {
            System.out.println("Impossible d'ouvrir la fenêtre");
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DateTimeFormatter frformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lblDate.setText(LocalDate.now().format(frformat));

        tblPretEnCours.setEditable(true);

        colTtlTitre.setCellValueFactory(
                new PropertyValueFactory<TableViewEmpruntsEnCours, String>("titreLivre"));
        colTtlBbl.setCellValueFactory(
                new PropertyValueFactory<TableViewEmpruntsEnCours, String>("nomBibliotheque"));
        colTtlDatepret.setCellValueFactory(
                new PropertyValueFactory<TableViewEmpruntsEnCours, String>("datEmprunt"));
        colTtlIsbn.setCellValueFactory(
                new PropertyValueFactory<TableViewEmpruntsEnCours, String>("isbn"));
        colTtldateRetour.setCellValueFactory(
                new PropertyValueFactory<TableViewEmpruntsEnCours, String>("datRetour"));
        colTtlCodeExemplaire.setCellValueFactory(
                new PropertyValueFactory<TableViewEmpruntsEnCours, String>("numExemplaire"));
        tblPretEnCours.setItems(data);
    }

    public void taxiAdherent(Adherent adherent) {
        adherentAff = adherent;
        lblNom.setText(adherentAff.getNomAdherent());
        lblPrenom.setText(adherentAff.getPrenomAdherent());
        lblTel.setText(adherentAff.getTeleAdherent());
        lblAdresse.setText(adherentAff.getAdrAdherent());
        lblNumAdherent.setText(String.valueOf(adherentAff.getNumAdherent()));
        creerTableauEmprunts(adherent);
        lblNbPretEnCours.setText(String.valueOf(data.size()));
        lblPretRetard.setText(String.valueOf(projectionTableauEmprunt.nbEmpruntsEnRetard(adherentAff.getNumAdherent())));
    }

    private void creerTableauEmprunts(Adherent adherent) {
        data.clear();
        data.addAll(
                projectionTableauEmprunt.tableViewEmpruntsEnCours(adherent.getNumAdherent()));

    }

    @FXML
    void openAbout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("À propos");
        alert.setHeaderText("À propos de l'application");
        alert.setContentText("L'appli Mégathèque a été réalisée par Jérôme Chaput, Damien Gruffeille, Julien Jégo et Romain Benejam à l'Afpa de Beaumont.\rElle est vachement bien.\rIcônes : © max.icons\r© Afpa 2022 ");
        alert.showAndWait();
    }

}
