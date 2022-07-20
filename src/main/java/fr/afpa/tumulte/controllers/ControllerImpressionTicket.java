package fr.afpa.tumulte.controllers;

import fr.afpa.tumulte.outils.Utile;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Controller impression ticket.
 */
public class ControllerImpressionTicket implements Initializable {

    @FXML
    private Label lblDatePret1;

    @FXML
    private Label lblDatePret2;

    @FXML
    private Label lblDatePret3;

    @FXML
    private Label lblDateRetour1;

    @FXML
    private Label lblDateRetour2;

    @FXML
    private Label lblDateRetour3;

    @FXML
    private Label lblDateValidite;

    @FXML
    private Label lblIsbn1;

    @FXML
    private Label lblIsbn2;

    @FXML
    private Label lblIsbn3;

    @FXML
    private Label lblNumAdherent;

    @FXML
    private Label lblNumeroExemplaire1;

    @FXML
    private Label lblNumeroExemplaire2;

    @FXML
    private Label lblNumeroExemplaire3;

    @FXML
    private Label lblPrenomNom;

    @FXML
    private Label lblQuand;

    @FXML
    private Label lblTitre1;

    @FXML
    private Label lblTitre2;

    @FXML
    private Label lblTitre3;

    @FXML
    private Pane pane0;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblQuand.setText(Utile.getDateTimeString());

    }

}