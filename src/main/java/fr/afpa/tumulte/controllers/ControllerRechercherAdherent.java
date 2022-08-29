package fr.afpa.tumulte.controllers;

import fr.afpa.tumulte.app.App;
import fr.afpa.tumulte.entites.Adherent;
import fr.afpa.tumulte.entites.Emprunt;
import fr.afpa.tumulte.entites.TableViewEmpruntsEnCours;
import fr.afpa.tumulte.outils.DaoAdherent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * The type Controller rechercher adherent.
 */
public class ControllerRechercherAdherent implements Initializable {
public Adherent adherent;
    public Label lblDate;
    /**
     * The Stage.
     */
    Stage stage;
    Scene scene;
    final ObservableList<TableViewEmpruntsEnCours> data = FXCollections.observableArrayList();
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
    private TableView<TableViewEmpruntsEnCours> tablePretsEnCours;
    @FXML
    private TableColumn columnAuteur;
    @FXML
    private TableColumn columnTitre;
    @FXML
    private TableColumn columnDateEmprunt;
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
    void activerBoutons(KeyEvent e) {
        activerBoutons();
        if (e.getCode().equals(KeyCode.ENTER) ) {
            rechercherAdherent();
        }

    }
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
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.setTitle("Menu principal");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Rechercher adherent.
     */
    @FXML
    void rechercherAdherent() {

        try {
            DaoAdherent daoAdherent = new DaoAdherent();
            afficherInfoAdherent(daoAdherent.showAdherent(Integer.valueOf(txtNumAdherent.getText())));
            adherent = daoAdherent.showAdherent(Integer.valueOf(txtNumAdherent.getText()));
        } catch (Exception e) {
            System.out.println(e);
            String headerTxt = "Ce numéro d'adhérent est inconnu !";
            String contentTxt = "Merci de vérifier et saisir un nouveau numéro d'adhérent.";
            fenetreErreur(headerTxt, contentTxt);
            txtNumAdherent.setText("");
        }

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
        ControllerEmpruntLivre ctrlEMprLivre = fxmlLoader.getController();
        ctrlEMprLivre.taxiAdherent(adherent);
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.setTitle("Menu principal");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        DateTimeFormatter frformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lblDate.setText(LocalDate.now().format(frformat));
        btnRechercherAdherent.setDisable(true);
        btnConsulterFicheAdherent.setDisable(true);
        btnValiderAdherent.setDisable(true);
        lblCotisation.setVisible(false);
        lblDateFinCotisation.setVisible(false);
        //méthode fléchée qui permet d'activer les boutons dès que le texte change
        txtNumAdherent.textProperty().addListener(observable -> activerBoutons());

        columnTitre.setCellValueFactory(new PropertyValueFactory<TableViewEmpruntsEnCours, String>("titreLivre"));
        columnDateEmprunt.setCellValueFactory(new PropertyValueFactory<TableViewEmpruntsEnCours, String>("datEmprunt"));
        columnAuteur.setCellValueFactory(new PropertyValueFactory<TableViewEmpruntsEnCours, String>("nomsAuteurs"));

        tablePretsEnCours.setItems(data);
    }

    private void afficherInfoAdherent(Adherent adherent) {
        if (numAdherentEstConnu(adherent)) {
            lblNomAdherent.setText(adherent.getNomAdherent());
            lblPrenomAdherent.setText(adherent.getPrenomAdherent());
            creerTableauEmprunts(adherent);

            if (abonnementEstPerime(adherent)) {
                lblCotisationAJour.setText("Non");
                lblCotisation.setVisible(true);
                lblDateFinCotisation.setVisible(true);
                lblDateFinCotisation.setText(String.valueOf(adherent.getPerimeLe()));
            } else {
                lblCotisationAJour.setText("Oui");
                lblCotisation.setVisible(false);
                lblDateFinCotisation.setVisible(false);
            }

        }
//        else {
//            String headerTxt = "Ce numéro d'adhérent est inconnu !";
//            String contentTxt = "Merci de vérifier et saisir un nouveau numéro d'adhérent.";
//            fenetreErreur(headerTxt, contentTxt);
//            txtNumAdherent.setText("");
//        }
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

    private void creerTableauEmprunts(Adherent adherent) {
        data.clear();

        for (Emprunt emprunt : adherent.getLstEmpruntsEnCours()) {
            TableViewEmpruntsEnCours tv = new TableViewEmpruntsEnCours (emprunt.getNumExemplaire().getlivre().getTitreLivre(), emprunt.getNumExemplaire().getlivre().getAuteur(), emprunt.getDatEmprunt());
            data.add(tv);

        }

    }

    private boolean idAdherentEstValide() {
        return !txtNumAdherent.getText().equals("") && txtNumAdherent.getLength() < 11;
    }

    private boolean abonnementEstPerime(Adherent adherent) {
        return adherent.getPerimeLe().isBefore(LocalDate.now());
    }

    private boolean numAdherentEstConnu(Adherent adherent) {
        return Integer.parseInt(txtNumAdherent.getText()) == (adherent.getNumAdherent());
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



