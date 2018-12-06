package vista.controladores;

import javafx.scene.input.MouseEvent;
import modelo.IPosicionable;
import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;
import vista.controles.AldeanoBotonera;
import vista.controles.MapaControl;


public class AldeanoController implements IPosicionableController {

    private Aldeano aldeano;
    private String color;
    private MapaControl mapaControl;
    private IJuegoController juegoController;

    public AldeanoController(Aldeano aldeano, String color, MapaControl mapaControl, IJuegoController juegoController){
        this.aldeano = aldeano;
        this.color = color;
        this.mapaControl = mapaControl;
        this.juegoController = juegoController;
    }

    @Override
    public IPosicionable getPosicionable() {
        return this.aldeano;
    }

    @Override
    public Posicion getPosicion() {
        return aldeano.getPosicion();
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public void handleClick(MouseEvent mouseEvent) {
        AldeanoBotonera botonera = new AldeanoBotonera(aldeano, mapaControl);
        this.juegoController.setBotonera(botonera);
    }

}
