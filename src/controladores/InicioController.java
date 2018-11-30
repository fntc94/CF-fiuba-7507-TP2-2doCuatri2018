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

    public InicioController(Stage stage){
        this.stage = stage;
    }

    public void handleAceptarButtonClicked(MouseEvent mouseEvent) throws Exception {

        FXMLLoader juegoView = new FXMLLoader(getClass().getResource("/vistas/JuegoView.fxml"));
        JuegoController juegoController = new JuegoController();
        juegoView.setController(juegoController);
        Parent root = juegoView.load();

        String nombreJugador1 = this.nombreJugador1.getText();
        String nombreJugador2 = this.nombreJugador2.getText();

        juegoController.setNombreJugador1(nombreJugador1);
        juegoController.setNombreJugador2(nombreJugador2);

        this.stage.setScene(new Scene(root));

    }

    public void handleCancelarButtonClicked(MouseEvent mouseEvent) {
        Platform.exit();
    }
}
