package vista.controladores;

import modelo.unidades.Aldeano;
import vista.controles.AldeanoBotonera;
import vista.controles.Botonera;
import vista.controles.MapaControl;


public class AldeanoController extends UnidadController<Aldeano>{


    private AldeanoBotonera botonera;

    public AldeanoController(Aldeano unidad, String color, MapaControl mapaControl, IJuegoController juegoController) {
        super(unidad, color, mapaControl, juegoController);

        this.botonera = new AldeanoBotonera(unidad, mapaControl);
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

