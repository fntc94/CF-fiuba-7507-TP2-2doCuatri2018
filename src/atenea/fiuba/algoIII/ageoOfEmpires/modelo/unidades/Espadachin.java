package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacante;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEstrategiaAtaque;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IPosicionable;

public class Espadachin extends UnidadMilitar implements IPosicionable, IAtacable, IAtacante {

    private final static int VIDA_MAXIMA = 100;
    private final static int DANIO_A_UNIDAD = 25;
    private final static int DANIO_A_EDIFICIO = 15;
    private final static int RANGO_DE_ATAQUE = 1;


    public Espadachin(Posicion posicion, IEstrategiaAtaque estrategiaAtaque){
        super(posicion, VIDA_MAXIMA, estrategiaAtaque);
    }


}
