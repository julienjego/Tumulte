package fr.afpa.tumulte.controllers;

import fr.afpa.tumulte.entites.Adherent;
import fr.afpa.tumulte.entites.EmpruntTicketImpression;
import fr.afpa.tumulte.outils.AccesImpression;
import fr.afpa.tumulte.outils.ListSommeEmprunt;
import fr.afpa.tumulte.outils.Utile;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;

/**
 * The type Controller impression ticket.
 */
public class ControllerImpressionTicket implements Initializable {

    public Adherent adherentImpression;

    public ListSommeEmprunt listSommeEmprunt;
    @FXML
    private Label lblDatePret1;
    @FXML
    private Label lblBibliotheque2;
    @FXML
    private Label lblBibliotheque3;
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
    private Label lblBibliotheque1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listSommeEmprunt = AccesImpression.getListSommeEmprunt();
        adherentImpression = AccesImpression.getAdherent();
        lblQuand.setText(Utile.getDateTimeString());

        lblNumAdherent.setText(String.valueOf(adherentImpression.getNumAdherent()));
        lblPrenomNom.setText(adherentImpression.getPrenomAdherent() + " " + adherentImpression.getNomAdherent());
        lblDateValidite.setText(adherentImpression.getPerimeLe().format(DateTimeFormatter
                                                                                .ofLocalizedDate(FormatStyle.SHORT)));
        lblNumeroExemplaire1.setText("#3");

        ListSommeEmprunt lstEmp = new ListSommeEmprunt();
        pane1.setVisible(false);
        pane2.setVisible(false);
        pane3.setVisible(false);
        if (((lstEmp.listEmpruntImpression(adherentImpression.getNumAdherent())).size()) >= 1) {
            pane1.setVisible(true);
            pane0.setMaxHeight(380);
            pane0.setMinHeight(379);
            EmpruntTicketImpression emprunt1;
            emprunt1 = (lstEmp.listEmpruntImpression(adherentImpression.getNumAdherent())).get(0);
            lblIsbn1.setText(emprunt1.getIsbn());
            lblTitre1.setText(emprunt1.getTitre());
            lblBibliotheque1.setText(emprunt1.getBibliotheque());
            lblDatePret1.setText(emprunt1.getDateDePret().format(DateTimeFormatter
                                                                         .ofLocalizedDate(FormatStyle.SHORT)));
            lblDateRetour1.setText(emprunt1.getDeteDeRetourLimite().format(DateTimeFormatter
                                                                                   .ofLocalizedDate(FormatStyle.SHORT)));
            lblNumeroExemplaire1.setText("#" + emprunt1.getNumExemplaire().substring(14));
        }

        if (((lstEmp.listEmpruntImpression(adherentImpression.getNumAdherent())).size()) >= 2) {
            pane2.setVisible(true);
            pane0.setMaxHeight(500);
            pane0.setMinHeight(499);
            EmpruntTicketImpression emprunt2;
            emprunt2 = (lstEmp.listEmpruntImpression(adherentImpression.getNumAdherent())).get(1);
            lblIsbn2.setText(emprunt2.getIsbn());
            lblTitre2.setText(emprunt2.getTitre());
            lblBibliotheque2.setText(emprunt2.getBibliotheque());
            lblDatePret2.setText(emprunt2.getDateDePret().format(DateTimeFormatter
                                                                         .ofLocalizedDate(FormatStyle.SHORT)));
            lblDateRetour2.setText(emprunt2.getDeteDeRetourLimite().format(DateTimeFormatter
                                                                                   .ofLocalizedDate(FormatStyle.SHORT)));
            lblNumeroExemplaire2.setText("#" + emprunt2.getNumExemplaire().substring(14));

        }
        if (((lstEmp.listEmpruntImpression(adherentImpression.getNumAdherent())).size()) >= 3) {
            pane3.setVisible(true);
            pane0.setMaxHeight(600);
            pane0.setMinHeight(599);
            EmpruntTicketImpression emprunt3;
            emprunt3 = (lstEmp.listEmpruntImpression(adherentImpression.getNumAdherent())).get(2);
            lblIsbn3.setText(emprunt3.getIsbn());
            lblTitre3.setText(emprunt3.getTitre());
            lblBibliotheque3.setText(emprunt3.getBibliotheque());
            lblDatePret3.setText(emprunt3.getDateDePret().format(DateTimeFormatter
                                                                         .ofLocalizedDate(FormatStyle.SHORT)));
            lblDateRetour3.setText(emprunt3.getDeteDeRetourLimite().format(DateTimeFormatter
                                                                                   .ofLocalizedDate(FormatStyle.SHORT)));
            lblNumeroExemplaire3.setText("#" + emprunt3.getNumExemplaire().substring(14));

        }

    }

}