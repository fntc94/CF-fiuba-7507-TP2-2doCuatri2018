package atenea.fiuba.algoIII.ageoOfEmpires;

public class Cuartel extends EdificioReparable implements IEdificioReparable {

    private final int VELOCIDAD_DE_REPARACION = 50;
    private UnidadesFabrica _fabricaDeUnidades;

    public Cuartel(int vidaMaxima, int vidaInicial, UnidadesFabrica fabricaDeUnidades) {
        super(vidaMaxima, vidaInicial);
        _fabricaDeUnidades = fabricaDeUnidades;
    }

    public Cuartel(int vidaMaxima, UnidadesFabrica fabricaDeUnidades){
        this(vidaMaxima, vidaMaxima, fabricaDeUnidades);
    }

    @Override
    protected int getVelocidadDeReparacion() {
        return VELOCIDAD_DE_REPARACION;
    }

    public int obtenerCostoArquero(){
        return _fabricaDeUnidades.obtenerCostoEnOroArquero();
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