package atenea.fiuba.algoIII.ageoOfEmpires;

public class PlazaCentral extends EdificioReparable implements IEdificioReparable {

    private final int VELOCIDAD_DE_REPARACION = 25;
    private UnidadesFabrica _fabricaDeUnidades;

    public PlazaCentral(int vidaMaxima, int vidaInicial, UnidadesFabrica fabricaDeUnidades) {
        super(vidaMaxima, vidaInicial);
        _fabricaDeUnidades = fabricaDeUnidades;

    }

    public PlazaCentral(int vidaMaxima, UnidadesFabrica fabricaDeUnidades) {
        this(vidaMaxima, vidaMaxima, fabricaDeUnidades);
    }

    @Override
    protected int getVelocidadDeReparacion() {
        return VELOCIDAD_DE_REPARACION;
    }

    public int obtenerCostoAldeano(){
        return _fabricaDeUnidades.obtenerCostoEnOroAldeano();
    }

    public Aldeano construirAldeano() {
        return _fabricaDeUnidades.crearAldeano();
    }

    void recibirAtaque(int danio) {
        this._vidaActual -= danio;
    }
}
