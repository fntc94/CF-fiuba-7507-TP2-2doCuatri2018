package atenea.fiuba.algoIII.ageoOfEmpires;

public class Castillo extends Edificio implements IEdificioReparable, IAtacable {

    private static final int VIDA_MAXIMA = 1000;
    private static final int VELOCIDAD_DE_REPARACION = 15;
    private IUnidadesCastilloFabrica _fabricaDeUnidades;

    public Castillo(IUnidadesCastilloFabrica fabricaDeUnidades) {
        super(VIDA_MAXIMA, VELOCIDAD_DE_REPARACION);
        _fabricaDeUnidades = fabricaDeUnidades;
    }

    public int obtenerCostoArmaDeAsedio(){
        return _fabricaDeUnidades.obtenerCostoArmaDeAsedio();
    }

    public ArmaDeAsedio crearArmaDeAsedio()
    {
        return _fabricaDeUnidades.crearArmaDeAsedio();
    }


}
