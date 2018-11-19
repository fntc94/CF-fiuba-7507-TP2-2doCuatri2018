package atenea.fiuba.algoIII.ageoOfEmpires;

public class Castillo extends EdificioReparable implements IEdificioReparable, IAtacable {

    private static final int VIDA_MAXIMA = 1000;
    private static final int VELOCIDAD_DE_REPARACION = 15;
    private UnidadesFabrica _fabricaDeUnidades;

    public Castillo(UnidadesFabrica fabricaDeUnidades) {
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

    @Override // IEdificioAtacable
    public void recibirAtaque(IAtacante atacante) {

        int danio = atacante.obtenerDanio(this);
        this.vidaActual -= danio;
    }

    @Override
    public Posicion getPosicion() {
        return null;
    }
}
