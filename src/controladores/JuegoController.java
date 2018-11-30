package controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;
import modelo.posicion.*;

import java.awt.event.MouseEvent;
import java.io.IOException;


public class JuegoController {

    @FXML
    private Label nombreJugador1;

    @FXML
    private Label nombreJugador2;

    @FXML
    private GridPane mapa;

    private MapaController mapaController;

    @FXML
    private BorderPane contenedorPrincipal;

    @FXML
    private Label botonera;

    private Parent vistaAldeano;

    public void init(String nombreJugador1, String nombreJugador2) throws IOException {

       this.nombreJugador1.setText(nombreJugador1);
       this.nombreJugador2.setText(nombreJugador2);

       this.setCentro();
       this.agregarAldeanoAlMapa();
    }

    private void agregarAldeanoAlMapa() throws IOException {

        Posicion posicion = new PosicionDeUnCasillero(2,2);
        Aldeano aldeano = new Aldeano(posicion);

        FXMLLoader aldeanoLoader = new FXMLLoader(getClass().getResource("/vistas/AldeanoView.fxml"));
        Parent vistaAldeano = aldeanoLoader.load();

        AldeanoController aldeanoController = aldeanoLoader.getController();
        aldeanoController.init(this);

        this.mapaController.agregarUnidadAlMapa(aldeano, vistaAldeano);
    }

    // Agrega el mapa
    public void setCentro(){
        this.mapaController = new MapaController();
        mapaController.init(this.mapa);
    }

    public void setBotonera(String text){
        this.botonera.setText("");

        GridPane contenedorBotones = new GridPane();

        // CREO LOS BOTONES
        Button botonArriba = new Button("⬆");
        Button botonArribaIzq = new Button("↖");
        Button botonArribaDer = new Button("↗");

        Button botonAbajo = new Button("⬇");
        Button botonAbajoIzq = new Button("↙");
        Button botonAbajoDer = new Button("↘");

        Button botonIzquierda = new Button("⬅");
        Button botonDerecha = new Button("➡");

        // LOS POSICIONO
        contenedorBotones.add(botonArriba,1,0);
        contenedorBotones.add(botonArribaIzq,0,0);
        contenedorBotones.add(botonArribaDer,2,0);
        contenedorBotones.add(botonAbajoIzq,0,2);
        contenedorBotones.add(botonAbajoDer,2,2);
        contenedorBotones.add(botonIzquierda,0,1);
        contenedorBotones.add(botonDerecha,2,1);
        contenedorBotones.add(botonAbajo,1,2);

        // AGREGO LOS BOTONES AL CONTENEDOR
        this.contenedorPrincipal.setCenter(contenedorBotones);
    }
}
