package atenea.fiuba.algoIII.ageoOfEmpires;

public class Cuartel extends Edificio implements IPosicionable, IEdificioReparable, IAtacable {

    private static final int VIDA_MAXIMA = 250;
    private static final int VELOCIDAD_DE_REPARACION = 50;
    private UnidadesFabrica _fabricaDeUnidades;

    public Cuartel(UnidadesFabrica fabricaDeUnidades) {
        super(VIDA_MAXIMA, VELOCIDAD_DE_REPARACION);
        _fabricaDeUnidades = fabricaDeUnidades;
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