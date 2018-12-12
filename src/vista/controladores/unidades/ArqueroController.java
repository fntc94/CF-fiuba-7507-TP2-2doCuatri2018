package vista.controladores.unidades;

import modelo.unidades.Arquero;
import vista.controladores.IJuegoController;
import vista.controles.ArqueroBotonera;
import vista.controles.Botonera;
import vista.controles.MapaControl;


public class ArqueroController extends UnidadController<Arquero> {

    private ArqueroBotonera botonera;

    public ArqueroController(Arquero unidad, String color, MapaControl mapaControl, IJuegoController juegoController) {
        super(unidad, color, mapaControl, juegoController);

        this.botonera = new ArqueroBotonera(unidad, mapaControl);
    }

    @Override
    Botonera getBotonera() {
        return this.botonera;
    }

    @Override
    String getWavFile(){
        return "recibir_ataque_asedio.wav";
    }
}

