package vista.controladores.edificios;

import modelo.edificios.PlazaCentral;
import vista.controladores.IJuegoController;
import vista.controladores.edificios.EdificioController;
import vista.controles.Botonera;
import vista.controles.MapaControl;
import vista.controles.PlazaCentralBotonera;


public class PlazaCentralController extends EdificioController<PlazaCentral> {


    private PlazaCentralBotonera botonera;

    public PlazaCentralController(PlazaCentral edificio, String color, MapaControl mapaControl, IJuegoController juegoController) {
        super(edificio, color, mapaControl, juegoController);

        this.botonera = new PlazaCentralBotonera(edificio, mapaControl);
    }

    @Override
    Botonera getBotonera() {
        return this.botonera;
    }
}
