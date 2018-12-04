package vista.controles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelo.juego.Juego;
import vista.controladores.MiniMapaController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JuegoControl extends BorderPane implements Initializable {


    private Stage primaryStage;

    @FXML private GridPane botonera;

    JuegoControl(Stage primaryStage, String nombreJugador1, String nombreJugador2) {

        this.primaryStage = primaryStage;

        Juego juego = new Juego(nombreJugador1, nombreJugador2);
        MiniMapaController miniMapaController = new MiniMapaController(this, juego.getMapa(), juego.getJugador1(), juego.getJugador2());
        MapaControl mapaControl = new MapaControl(this, juego.getMapa(), juego.getJugador1(), juego.getJugador2(), miniMapaController);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/Juego.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        loader.setControllerFactory(type -> {

            if(type.equals(MiniMapaController.class)){
                return miniMapaController;
            }

            else {
                // default behavior for controllerFactory:
                try {
                    return type.newInstance();
                } catch (Exception exc) {
                    exc.printStackTrace();
                    throw new RuntimeException(exc); // fatal, just bail...
                }
            }
        });


        try {
            loader.load();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }



        mapaControl.dibujar();
        this.centerProperty().setValue(mapaControl);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setBotonera(Node node){
        this.botonera.getChildren().clear();
        this.botonera.add(node, 1, 0);
    }


}
