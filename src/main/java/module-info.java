module fr.afpa.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.afpa.tumulte.app to javafx.fxml;
    opens fr.afpa.tumulte.controllers;
    opens fr.afpa.tumulte.entites;
    opens fr.afpa.tumulte.outils;
    exports fr.afpa.tumulte.app;
}