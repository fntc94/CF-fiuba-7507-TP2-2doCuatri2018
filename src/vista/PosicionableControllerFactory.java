package vista;

import modelo.IPosicionable;
import modelo.edificios.Castillo;
import modelo.edificios.PlazaCentral;
import modelo.unidades.Aldeano;
import modelo.unidades.Espadachin;
import vista.controladores.*;
import vista.controles.JuegoControl;
import vista.controles.MapaControl;

public class PosicionableControllerFactory {


    private JuegoControl juegoControl;
    private MapaControl mapaControl;
    private String color;

    public PosicionableControllerFactory(JuegoControl juegoControl, MapaControl mapaControl, String color){

        this.juegoControl = juegoControl;
        this.mapaControl = mapaControl;
        this.color = color;
    }


    public IPosicionableController crearControlador(Aldeano aldeano){
        return new AldeanoController(aldeano, this.color, this.mapaControl, this.juegoControl);

    }

    public IPosicionableController crearControlador(Castillo castillo){
        return new CastilloController(castillo, this.color);
    }

    public IPosicionableController crearControlador(PlazaCentral plazaCentral){
        return new PlazaCentralController(plazaCentral, this.color);
    }

    public IPosicionableController crearControlador(Espadachin espadachin){
        return new EspadachinController(espadachin, this.color, this.mapaControl, this.juegoControl);
    }

}
