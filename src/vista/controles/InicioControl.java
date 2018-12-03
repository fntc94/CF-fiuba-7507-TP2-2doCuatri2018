package vista.controles;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioControl extends BorderPane {

    private Stage primaryStage;

    @FXML private TextField nombreJugador1;
    @FXML private TextField nombreJugador2;


    public InicioControl(Stage primaryStage){

        super();
        this.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/Inicio.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    @FXML
    private void handleAceptar(MouseEvent mouseEvent) throws Exception {

        String nombreJugador1 = this.nombreJugador1.getText();
        String nombreJugador2 = this.nombreJugador2.getText();
        JuegoControl juegoControl = new JuegoControl(this.primaryStage, nombreJugador1, nombreJugador2);
        this.primaryStage.setScene(new Scene(juegoControl));

    }

    @FXML
    private void handleCancelar(MouseEvent mouseEvent) {
        Platform.exit();
    }

}
