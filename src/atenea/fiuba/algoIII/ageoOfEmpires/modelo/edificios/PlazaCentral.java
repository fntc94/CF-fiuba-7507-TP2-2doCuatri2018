package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Edificio;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IPosicionable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Aldeano;

public class PlazaCentral extends Edificio implements IPosicionable, IEdificioReparable, IAtacable {

    private static final int VIDA_MAXIMA = 450;
    private static final int VELOCIDAD_DE_REPARACION = 25;
    private IUnidadesPlazaCentralFabrica _fabricaDeUnidades;

    public PlazaCentral(Posicion posicion, IUnidadesPlazaCentralFabrica fabricaDeUnidades) {
        super(posicion, VIDA_MAXIMA, VELOCIDAD_DE_REPARACION);
        _fabricaDeUnidades = fabricaDeUnidades;
    }

    public int obtenerCostoAldeano(){
        return _fabricaDeUnidades.obtenerCostoAldeano();
    }

    public Aldeano construirAldeano() {
        return _fabricaDeUnidades.crearAldeano();
    }

}
