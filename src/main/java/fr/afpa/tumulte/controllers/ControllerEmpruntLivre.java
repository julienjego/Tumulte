package fr.afpa.tumulte.controllers;

import fr.afpa.tumulte.app.App;
import fr.afpa.tumulte.entites.Adherent;
import fr.afpa.tumulte.entites.Exemplaire;
import fr.afpa.tumulte.outils.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;


/**
 * The type Controller emprunt livre.
 */
public class ControllerEmpruntLivre implements Initializable {

    Adherent adherent;

    public Label lblDate;

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public Adherent adherentEmprunt;

    private Integer empruntsEncours = 0;
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

    public void taxiAdherent(Adherent adherentT) {
        lblNumAdherent.setText(String.valueOf(adherentT.getNumAdherent()));
        lblNomAdherent.setText(String.valueOf(adherentT.getNomAdherent()));
        lblPrenomAdherent.setText(String.valueOf(adherentT.getPrenomAdherent()));
        adherent = adherentT;


    }

    public  void demanderConfirmation() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Encore ?");
        alert.setHeaderText("Le livre est emprunté.");
        alert.setContentText("Voulez-vous enregistrer un autre emprunt ?");
        ButtonType oui = new ButtonType("Oui");
        ButtonType non = new ButtonType("Non");
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll( oui, non);
        Window window = alert.getDialogPane().getScene().getWindow();
        window.setOnCloseRequest(e -> alert.hide());
        Optional<ButtonType> option = alert.showAndWait();


        if (option.get() == non) {

            imprimer();

            retourVersPageEmprunt();


        }effacer();


    }

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
    void emprunterLivre() throws IOException {

        confEmpruntLivre();

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
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
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
        if (e.getCode().equals(KeyCode.ENTER)) {
            rechercherLivre();
        }
    }

    /**
     * Désactive le btn rechercher à l'initialisation.
     */
    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        init();

        // Autorise seulement l'insertion de chiffre dans le txtfield
        txtCodeExemplaire.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"0123456789-".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });
    }

    private void init() {
        DateTimeFormatter frformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lblDate.setText(LocalDate.now().format(frformat));
        btnRechercherLivre.setDisable(true);
        btnEmprunter.setDisable(true);
    }

    /**
     * Affiche les valeurs du livre lors du click sur
     * le bouton rechercher.
     */
    private void afficherLabels() {
        DaoEmprunt daoE = new DaoEmprunt();
        afficherInfoExemplaire(daoE.showExemplaire(txtCodeExemplaire.getText()));

    }

    private void afficherInfoExemplaire(Exemplaire exemplaire) {

        try {
            if (numExemplaireEstConnu(exemplaire)) {
                lblTitreExemplaire.setText(exemplaire.getlivre().getTitreLivre());
                //lblAuteur.setText(StringUtils.join(exemplaire.getlivre().getAuteur().get(0).getNomAuteur() +" "+ exemplaire.getlivre().getAuteur().get(0).getPrenomAuteur(), " "));
                lblAuteur.setText((StringUtils.join(exemplaire.getlivre().getAuteur(), " | ")));
                lblTheme.setText(exemplaire.getlivre().getTheme().getLibelTheme());
                lblEtat.setText(exemplaire.getCommentExemplaire());
                lblDisponible.setText(exemplaire.isDisponible() ? "Oui" : "Non");
                lblISBN.setText(exemplaire.getlivre().getIsbnLivre());
                lblISSN.setText("NC");
                lblEmplacement.setText(exemplaire.getemplacement().getCodEmplacement());
                btnEmprunter.setDisable(false);

            } else {
                System.out.println("exemplaire inconnu");
                afficherMessageErreur("Erreur de letcure", "Exemplaire non reconnu");

            }
        } catch (Exception e) {
            afficherMessageErreur("Erreur de letcure", "Exemplaire non reconnu");

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

    private void confEmpruntLivre() throws IOException {
        DaoEmprunt daoE = new DaoEmprunt();

        if (!(daoE.showExemplaire(txtCodeExemplaire.getText()).isDisponible())) {
            String messageErreur1 = "Le livre n'est pas disponible.";
            String messageErreur2 = "Le Livre " + (daoE.showExemplaire(txtCodeExemplaire.getText())).getlivre().getTitreLivre() + " est déjà emprunté\r"
                    + "Vous pouvez passer au suivant ou quitter";
            afficherMessageErreur(messageErreur1, messageErreur2);
        } else {

            daoE.validerEmprunt(Integer.valueOf(lblNumAdherent.getText()), txtCodeExemplaire.getText());
            empruntsEncours += 1;
            btnEmprunter.setDisable(nbMaxEmpruntsEstAtteint(empruntsEncours));
            if(empruntsEncours >= 3){
                alertEmpruntMax();
                imprimer();
                retourVersPageEmprunt();
            }else {

                demanderConfirmation();
            }
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

    private boolean numExemplaireEstConnu(Exemplaire exemplaire) {
        return Objects.equals(txtCodeExemplaire.getText(), exemplaire.getNumExemplaire());
    }

    public Integer getEmpruntsEncours() {
        return empruntsEncours;
    }

    public void setEmpruntsEncours(Integer empruntsEncours) {
        this.empruntsEncours = empruntsEncours;
    }

    public boolean nbMaxEmpruntsEstAtteint(Integer nbEmpruntsEnCours) {

        if (nbEmpruntsEnCours < 3) {
            return false;
        } else {
            return true;
        }
    }

    public void taxiEmprunts(Integer nbEmpruntsEnCours) {
        this.empruntsEncours = nbEmpruntsEnCours;
    }

    public void retourVersPageEmprunt() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/rechercherAdherent.fxml"));
        Stage stage = (Stage) (menuBar.getScene().getWindow());
        stage.setMinHeight(600);
        stage.setMinWidth(900);
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.setTitle("Emprunter");
        stage.setScene(scene);
        stage.show();
    }

    void retourRechercherAdherent() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/rechercherAdherent.fxml"));
        Stage stage = (Stage) (menuBar.getScene().getWindow());
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.setTitle("Emprunter");
        stage.setScene(scene);

        stage.show();

    }

    private void imprimer() {
        try {
            String numAdherent = String.valueOf(adherent.getNumAdherent());
            AccesImpression.setAdherent(adherent);

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
            Window stage = null;
            stage2.initOwner(stage);
            stage2.setResizable(false);
            stage2.show();

        } catch (IOException e) {
            System.out.println("Impossible d'ouvrir la fenetre");
        }

    }

    private void alertEmpruntMax(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Maximum d'emprunt atteint.");
        alert.setHeaderText("Le livre est emprunté.");
        alert.setContentText("Le nombre maximum d'emprunt à était atteint.");
        alert.showAndWait();
    }



}

