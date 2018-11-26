package controladores;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class InicioController {

    @FXML
    private TextField nombreJugador1;

    @FXML
    private TextField nombreJugador2;

    @FXML
    private Button aceptarButton;

    private Stage stage;

    public void init(Stage stage){
        this.stage = stage;
    }

    public void handleAceptarButtonClicked(MouseEvent mouseEvent) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/JuegoView.fxml"));
        Parent root = loader.load();

        JuegoController juegoController = loader.getController();
        juegoController.init(nombreJugador1.getText(), nombreJugador2.getText());

        Scene scene = new Scene(root);
        this.stage.setScene(scene);

    }

    public void handleCancelarButtonClicked(MouseEvent mouseEvent) {
        Platform.exit();
    }

}
