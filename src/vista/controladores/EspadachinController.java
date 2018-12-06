package vista.controladores;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import modelo.IPosicionable;
import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;
import modelo.unidades.Espadachin;
import vista.controles.AldeanoBotonera;
import vista.controles.EspadachinBotonera;
import vista.controles.MapaControl;

public class EspadachinController implements IPosicionableController {

    private Espadachin espadachin;
    private String color;
    private MapaControl mapaControl;
    private IJuegoController juegoController;

    public EspadachinController(Espadachin espadachin, String color, MapaControl mapaControl, IJuegoController juegoController){
        this.espadachin = espadachin;
        this.color = color;
        this.mapaControl = mapaControl;
        this.juegoController = juegoController;
    }

    @Override
    public IPosicionable getPosicionable() {
        return this.espadachin;
    }

    @Override
    public Posicion getPosicion() {
        return espadachin.getPosicion();
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public void handleClick(MouseEvent mouseEvent) {
        Parent botonera = new EspadachinBotonera(espadachin, mapaControl);
        this.juegoController.setBotonera(botonera);
    }

}
