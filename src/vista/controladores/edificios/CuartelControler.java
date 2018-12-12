package vista.controladores.edificios;

import modelo.edificios.Cuartel;
import vista.controladores.IJuegoController;
import vista.controles.Botonera;
import vista.controles.CuartelBotonera;
import vista.controles.MapaControl;

public class CuartelControler extends EdificioController<Cuartel> {

    private Botonera botonera = null;

    public CuartelControler(Cuartel edificio, String color, MapaControl mapaControl, IJuegoController juegoController) {
        super(edificio, color, mapaControl, juegoController);

        this.botonera = new CuartelBotonera(edificio, mapaControl);
    }

    @Override
    Botonera getBotonera() {
        return this.botonera;
    }
}
