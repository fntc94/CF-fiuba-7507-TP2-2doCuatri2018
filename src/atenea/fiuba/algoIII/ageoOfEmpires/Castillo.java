package atenea.fiuba.algoIII.ageoOfEmpires;

public class Castillo extends Edificio implements IEdificioReparable, IAtacable, IAtacante {

    private static final int VIDA_MAXIMA = 1000;
    private static final int VELOCIDAD_DE_REPARACION = 15;

    private IUnidadesCastilloFabrica _fabricaDeUnidades;
    private final IEstrategiaAtaque estrategiaAtaque;

    public Castillo(Posicion posicion, IUnidadesCastilloFabrica fabricaDeUnidades, IEstrategiaAtaque estrategiaAtaque) {
        super(posicion, VIDA_MAXIMA, VELOCIDAD_DE_REPARACION);
        _fabricaDeUnidades = fabricaDeUnidades;
        this.estrategiaAtaque = estrategiaAtaque;
    }

    public int obtenerCostoArmaDeAsedio() {
        return _fabricaDeUnidades.obtenerCostoArmaDeAsedio();
    }

    public ArmaDeAsedio crearArmaDeAsedio() {
        return _fabricaDeUnidades.crearArmaDeAsedio();
    }


    // IAtacante
    @Override
    public void atacar(IAtacable atacable) {
        this.estrategiaAtaque.ejecutarAtaque(this, atacable);
    }

    @Override
    public int obtenerDanio(Unidad unidad) {
        return this.estrategiaAtaque.obtenerDanio(unidad);
    }

    @Override
    public int obtenerDanio(Edificio edificio) {
        return this.estrategiaAtaque.obtenerDanio(edificio);
    }
    // fin IAtacante

}

