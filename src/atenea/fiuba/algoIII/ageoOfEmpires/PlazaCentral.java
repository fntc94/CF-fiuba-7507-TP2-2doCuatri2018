package atenea.fiuba.algoIII.ageoOfEmpires;

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
