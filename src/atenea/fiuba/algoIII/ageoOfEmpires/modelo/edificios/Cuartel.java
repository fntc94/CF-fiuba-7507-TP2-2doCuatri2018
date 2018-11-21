package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Edificio;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IPosicionable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Arquero;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Espadachin;

public class Cuartel extends Edificio implements IPosicionable, IEdificioReparable, IAtacable {

    private static final int VIDA_MAXIMA = 250;
    private static final int VELOCIDAD_DE_REPARACION = 50;
    private IUnidadesCuartelFabrica _fabricaDeUnidades;

    public Cuartel(Posicion posicion, IUnidadesCuartelFabrica fabricaDeUnidades) {
        super(posicion, VIDA_MAXIMA, VELOCIDAD_DE_REPARACION);
        _fabricaDeUnidades = fabricaDeUnidades;
    }

    public int obtenerCostoArquero(){
        return _fabricaDeUnidades.obtenerCostoArquero();
    }

    public Arquero crearArquero(){
        return _fabricaDeUnidades.crearArquero();
    }

    public int obtenerCostoEspadachin(){
        return _fabricaDeUnidades.obtenerCostoEspadachin();
    }

    public Espadachin crearEspadachin(){
        return _fabricaDeUnidades.crearEspadachin();
    }

}