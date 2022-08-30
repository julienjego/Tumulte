package fr.afpa.tumulte.controllers;

import fr.afpa.tumulte.app.App;
import fr.afpa.tumulte.entites.Livre;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

import static fr.afpa.tumulte.outils.Utile.lireLivre;
import static fr.afpa.tumulte.outils.Utile.updateLireLivre;

public class ControllerRechercherLivre implements Initializable {
    private static final String TOUTES_BIB = "Toutes les Bibliotèques";
    @FXML
    private Button btnAnnuler;

    @FXML
    private Button btnMenuPrincipal;

    @FXML
    private Button btnRecherche;

    @FXML
    private TableColumn colAuteur;

    @FXML
    private TableColumn colISBN;

    @FXML
    private TableColumn colNbEmpruntLivre;

    @FXML
    private TableColumn colNbExemplaire;

    @FXML
    private TableColumn colThemeLivre;

    @FXML
    private TableColumn colTitre;

    @FXML
    private MenuItem itmAbout;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblRole;

    @FXML
    private MenuBar menuBar;

    @FXML
    private AnchorPane panResu;

    @FXML
    private TableView<Livre> tabLivres;

    @FXML
    private TextField txtRecherche;

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        init();
        tabLivres.setVisible(true);
        ObservableList<Livre> listLivre = lireLivre(TOUTES_BIB, "toutes");
        colISBN.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("IsbnLivre"));
        colTitre.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("titreLivre"));
        colAuteur.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("auteur"));
        colThemeLivre.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("theme"));
        colNbExemplaire.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("nbExemplaires"));
        colNbEmpruntLivre.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("nbEmprunt"));
        tabLivres.setItems(listLivre);

    }

    private void init() {
        DateTimeFormatter frformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lblDate.setText(LocalDate.now().format(frformat));

        btnRecherche.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onClickRecherche();
            }
        });

        txtRecherche.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    onClickRecherche();
                }
            }
        });
    }

    @FXML
    void onClickRecherche() {
        ObservableList<Livre> listLivre = updateLireLivre(txtRecherche.getText());
        colISBN.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("IsbnLivre"));
        colTitre.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("titreLivre"));
        colAuteur.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("auteur"));
        colThemeLivre.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("theme"));
        colNbExemplaire.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("nbExemplaires"));
        colNbEmpruntLivre.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("nbEmprunt"));
        tabLivres.setItems(listLivre);

    }

    @FXML
    void onClickRestartListe(ActionEvent event) {

        ObservableList<Livre> listLivre = lireLivre(TOUTES_BIB, "toutes");
        colISBN.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("IsbnLivre"));
        colTitre.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("titreLivre"));
        colAuteur.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("auteur"));
        colThemeLivre.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("theme"));
        colNbExemplaire.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("nbExemplaires"));
        colNbEmpruntLivre.setCellValueFactory(
                new PropertyValueFactory<Livre, String>("nbEmprunt"));
        tabLivres.setItems(listLivre);

    }

    @FXML
    public void onClickMenuPrincipal() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("/fxml/menuPrincipal.fxml"));
        Stage stage = (Stage) (menuBar.getScene().getWindow());
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());
        stage.setTitle("Emprunter");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onClickPrint() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Impression en cours");
        alert.setHeaderText("Impression en cours");
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
