package atenea.fiuba.algoIII.ageoOfEmpires;

public class Castillo extends EdificioReparable implements IEdificioReparable {

    private final int VELOCIDAD_DE_REPARACION = 15;
    private UnidadesFabrica _fabricaDeUnidades;

    public Castillo(int vidaMaxima, int vidaInicial, UnidadesFabrica fabricaDeUnidades) {
        super(vidaMaxima, vidaInicial);
        _fabricaDeUnidades = fabricaDeUnidades;
    }

    public Castillo(int vidaMaxima, UnidadesFabrica fabricaDeUnidades){
        this(vidaMaxima, vidaMaxima, fabricaDeUnidades);
    }

    @Override
    protected int getVelocidadDeReparacion() {
        return VELOCIDAD_DE_REPARACION;
    }

    public int obtenerCostoArmaDeAsedio(){
        return _fabricaDeUnidades.obtenerCostoArmaDeAsedio();
    }

    public ArmaDeAsedio crearArmaDeAsedio(){
        return _fabricaDeUnidades.crearArmaDeAsedio();
    }
}
