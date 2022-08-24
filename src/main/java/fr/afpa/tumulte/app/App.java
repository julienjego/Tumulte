package fr.afpa.tumulte.app;

import fr.afpa.tumulte.outils.DaoAdherent;
import fr.afpa.tumulte.outils.Utile;
import fr.afpa.tumulte.outils.doa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/menuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.setMinHeight(600);
        stage.setMinWidth(900);
        stage.setTitle("TUMULTE");
        Image icon = new Image(App.class.getResource("/image/livreicone.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            Utile.exitApp("Êtes-vous sûr ?");
        });

    }

}
