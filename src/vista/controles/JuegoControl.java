package vista.controles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelo.juego.Juego;

import java.io.IOException;

public class JuegoControl extends BorderPane {


    private Stage primaryStage;

    @FXML private GridPane bottom;

    JuegoControl(Stage primaryStage, String nombreJugador1, String nombreJugador2) {

        this.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistas/Juego.fxml"));
        loader.setRoot(this);
//        loader.setController(new JuegoController(nombreJugador1, nombreJugador2));
        loader.setController(this);


        try {
            loader.load();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }


        Juego juego = new Juego(nombreJugador1, nombreJugador2);
        MapaControl mapaControl = new MapaControl(this, juego.getMapa(), juego.getJugador1(), juego.getJugador2());
        mapaControl.dibujar();
        this.centerProperty().setValue(mapaControl);

    }

    public void setBotonera(Node node){

        this.bottom.getChildren().clear();
        this.bottom.add(node, 0, 0);
    }

}
