package modelo.unidades;

import modelo.IAtacante;
import modelo.IEstrategiaAtaque;
import modelo.posicion.Posicion;
import modelo.IAtacable;
import modelo.IPosicionable;

public class Espadachin extends UnidadMilitar {

    private final static int VIDA_MAXIMA = 100;

    public Espadachin(Posicion posicion, IEstrategiaAtaque estrategiaAtaque){
        super(posicion, VIDA_MAXIMA, estrategiaAtaque);
    }


}
