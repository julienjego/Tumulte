module fr.afpa.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires org.apache.commons.lang3;



    opens fr.afpa.tumulte.app to javafx.fxml;
    opens fr.afpa.tumulte.controllers;
    opens fr.afpa.tumulte.entites;
    opens fr.afpa.tumulte.outils;
    exports fr.afpa.tumulte.app;
}