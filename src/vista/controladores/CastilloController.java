package vista.controladores;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import modelo.IAtacante;
import modelo.IPosicionable;
import modelo.edificios.Castillo;
import modelo.posicion.Posicion;
import vista.controles.Botonera;
import vista.controles.CastilloBotonera;
import vista.controles.MapaControl;

public class CastilloController extends EdificioController<Castillo, CastilloBotonera> {

    private CastilloBotonera botonera;

    public CastilloController(Castillo edificio, String color, MapaControl mapaControl, IJuegoController juegoController) {
        super(edificio, color, mapaControl, juegoController);

        this.botonera = new CastilloBotonera(edificio, mapaControl);
    }

    @Override
    Botonera getBotonera() {
        return this.botonera;
    }
}

