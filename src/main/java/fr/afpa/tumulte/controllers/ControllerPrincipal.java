package fr.afpa.tumulte.controllers;

import fr.afpa.tumulte.app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ControllerPrincipal implements Initializable {

    @FXML
    private Button btnEmprunt;
    @FXML
    private Button btnFonds;
    @FXML
    private Button btnStat;
    @FXML
    private MenuItem itmAbout;
    @FXML
    private Label lblDate;
    @FXML
    private MenuBar menuBar;
    private Stage stage;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();

        btnEmprunt.setGraphic(new ImageView(new Image(App.class.getResource("/image/borrow.png").toExternalForm(), 72, 72, true, true)));
        btnStat.setGraphic(new ImageView(new Image(App.class.getResource("/image/report.png").toExternalForm(), 72, 72, true, true)));
        btnFonds.setGraphic(new ImageView(new Image(App.class.getResource("/image/books.png").toExternalForm(), 72, 72, true, true)));

    }

    private void init() {
        DateTimeFormatter frformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lblDate.setText(LocalDate.now().format(frformat));
    }

    @FXML
    void ouvrirPageEmprunt(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/rechercherAdherent.fxml"));
        stage = (Stage) (menuBar.getScene().getWindow());
        stage.setMinHeight(600);
        stage.setMinWidth(900);
        scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.setTitle("Emprunter");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ouvrirPageFonds(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/rechercherLivre.fxml"));
        stage = (Stage) (menuBar.getScene().getWindow());
        stage.setMinHeight(600);
        stage.setMinWidth(900);
        scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.setTitle("Consultation du fonds");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ouvrirPageStats(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/ConsulterStat.fxml"));
        stage = (Stage) (menuBar.getScene().getWindow());
        stage.setMinHeight(700);
        stage.setMinWidth(1000);
        scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.setTitle("Statistiques");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openAbout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("A propos");
        alert.setHeaderText("A propos de l'application");
        alert.setContentText("L'appli Mégathèque a été réalisée par Jérôme Chaput, Damien Gruffeille, Julien Jégo et Oziris à l'Afpa de Beaumont.\rElle est vachement bien.\rIcônes : © max.icons\r© Afpa 2022 ");
        alert.showAndWait();
    }

    @FXML
    public void exit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quitter ?");
        alert.setHeaderText("Quitter ?");
        alert.setContentText("Êtes-vous sur de vouloir quitter l'application");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.exit(0);
        }

    }

}

