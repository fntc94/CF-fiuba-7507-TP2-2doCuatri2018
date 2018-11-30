package controladores;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class InicioController {

    @FXML
    private BorderPane layout;

    @FXML
    private TextField nombreJugador1;

    @FXML
    private TextField nombreJugador2;

    @FXML
    private Button aceptarButton;

    private Stage stage;

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void handleAceptarButtonClicked(MouseEvent mouseEvent) throws Exception {

        FXMLLoader juegoView = new FXMLLoader(getClass().getResource("/vistas/JuegoView.fxml"));
        Parent root = juegoView.load();

        this.stage.setScene(new Scene(root));

    }

    public void handleCancelarButtonClicked(MouseEvent mouseEvent) {
        Platform.exit();
    }
}
