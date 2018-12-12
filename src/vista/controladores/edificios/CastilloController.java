package vista.controladores.edificios;

import modelo.edificios.Castillo;
import vista.controladores.IJuegoController;
import vista.controles.Botonera;
import vista.controles.CastilloBotonera;
import vista.controles.MapaControl;

public class CastilloController extends EdificioController<Castillo> {

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

