package vista.controladores;

import modelo.unidades.Espadachin;
import vista.controles.Botonera;
import vista.controles.EspadachinBotonera;
import vista.controles.MapaControl;

public class EspadachinController extends UnidadController<Espadachin> {

    private EspadachinBotonera botonera;

    public EspadachinController(Espadachin unidad, String color, MapaControl mapaControl, IJuegoController juegoController) {
        super(unidad, color, mapaControl, juegoController);

        this.botonera = new EspadachinBotonera(unidad, mapaControl);
    }

    @Override
    Botonera getBotonera() {
        return this.botonera;
    }

    @Override
    String getWavFile() {
        return "recibir_ataque_asedio.wav";
    }
}
