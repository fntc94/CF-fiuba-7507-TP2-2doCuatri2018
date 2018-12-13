package modelo.unidades;

import modelo.IAtacante;
import modelo.IEstrategiaAtaque;
import modelo.posicion.Posicion;
import modelo.IAtacable;
import modelo.IPosicionable;

public class Arquero extends UnidadMilitar {

    private static final int VIDA_MAXIMA = 75;

    public Arquero(Posicion posicion, IEstrategiaAtaque estrategiaAtaque){
        super(posicion, VIDA_MAXIMA, estrategiaAtaque);
    }

}
