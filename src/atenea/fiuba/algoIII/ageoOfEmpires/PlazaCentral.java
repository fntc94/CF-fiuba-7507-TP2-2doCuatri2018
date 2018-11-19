package atenea.fiuba.algoIII.ageoOfEmpires;

public class PlazaCentral extends EdificioReparable implements IEdificioReparable {

    private static final int VIDA_MAXIMA = 450;
    private static final int VELOCIDAD_DE_REPARACION = 25;
    private UnidadesFabrica _fabricaDeUnidades;

    public PlazaCentral(UnidadesFabrica fabricaDeUnidades) {
        super(VIDA_MAXIMA, VELOCIDAD_DE_REPARACION);
        _fabricaDeUnidades = fabricaDeUnidades;
    }

    public int obtenerCostoAldeano(){
        return _fabricaDeUnidades.obtenerCostoEnOroAldeano();
    }

    public Aldeano construirAldeano() {
        return _fabricaDeUnidades.crearAldeano();
    }

}
