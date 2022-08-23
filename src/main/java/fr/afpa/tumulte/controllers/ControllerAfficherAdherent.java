package fr.afpa.tumulte.controllers;

import fr.afpa.tumulte.app.App;
import fr.afpa.tumulte.entites.Exemplaire;
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
import java.util.ResourceBundle;

public class ControllerAfficherAdherent implements Initializable {

    public Label lblDate;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button btnImpreimerTicket;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnRetour;
    @FXML
    private TableColumn<Exemplaire, String> colTtlBbl;
    @FXML
    private TableColumn<Exemplaire, String> colTtlCodeExemplaire;
    @FXML
    private TableColumn<Exemplaire, String> colTtlDatepret;
    @FXML
    private TableColumn<Exemplaire, String> colTtlIsbn;
    @FXML
    private TableColumn<Exemplaire, String> colTtlTitre;
    @FXML
    private TableColumn<Exemplaire, String> colTtldateRetour;
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
    private TableView<Exemplaire> tblPretEnCours;
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

    /**
     * @param event
     */
    @FXML
    void imprimerTicket(ActionEvent event) {
        imprimer();

    }

    /**
     * @param event
     */
    @FXML
    void modifierAdherent(ActionEvent event) {

    }

    /**
     * @param event coucou
     */
    @FXML
    void retourVersRechercherAdherent(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/rechercherAdherent.fxml"));
        stage = (Stage) (menuBar.getScene().getWindow());
        scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.setTitle("Emprunter");
        stage.setScene(scene);
        stage.show();

    }

    private void imprimer() {
        try {
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
            System.out.println("Impossible d'ouvrir la fenetre");
        }

    }

    /**
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DateTimeFormatter frformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lblDate.setText(LocalDate.now().format(frformat));

       // @TODO"taper ds la bdd pour avoir livre + exemplaire + emprunt"
        final ObservableList<?> data = FXCollections.observableArrayList(
       );

        tblPretEnCours.setEditable(true);

        colTtlTitre.setCellValueFactory(new PropertyValueFactory<Exemplaire, String>("titre"));

        colTtlBbl.setCellValueFactory(new PropertyValueFactory<Exemplaire, String>("codBibliotheque"));

        colTtlDatepret.setCellValueFactory(new PropertyValueFactory<Exemplaire, String>("datePret"));
        colTtlIsbn.setCellValueFactory(new PropertyValueFactory<Exemplaire, String>("IsbnLivre"));
        colTtldateRetour.setCellValueFactory(new PropertyValueFactory<Exemplaire, String>("dateRetour"));
        colTtlCodeExemplaire.setCellValueFactory(new PropertyValueFactory<Exemplaire, String>("numExemplaire"));

        //@todo remettre le nouveau tableau à la place de data ------------ >>>   tblPretEnCours.setItems(data);   <<<------------------//
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
