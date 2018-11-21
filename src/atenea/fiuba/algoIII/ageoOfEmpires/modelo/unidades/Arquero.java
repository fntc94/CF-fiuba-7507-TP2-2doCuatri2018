package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacante;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEstrategiaAtaque;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IPosicionable;

public class Arquero extends UnidadMilitar implements IPosicionable, IAtacable, IAtacante {

    private static final int VIDA_MAXIMA = 75;

    public Arquero(Posicion posicion, IEstrategiaAtaque estrategiaAtaque){
        super(posicion, VIDA_MAXIMA, estrategiaAtaque);
    }

}
