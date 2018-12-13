package modelo.edificios;

import modelo.Edificio;
import modelo.IAtacable;
import modelo.IEdificioReparable;
import modelo.IPosicionable;
import modelo.posicion.Posicion;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;

public class Cuartel extends Edificio implements IPosicionable, IEdificioReparable, IAtacable {

    private static final int VIDA_MAXIMA = 250;
    private static final int VELOCIDAD_DE_REPARACION = 50;
    private IUnidadesCuartelFabrica fabricaDeUnidades;

    public Cuartel(Posicion posicion, IUnidadesCuartelFabrica fabricaDeUnidades) {
        super(posicion, VIDA_MAXIMA, VELOCIDAD_DE_REPARACION);
        this.fabricaDeUnidades = fabricaDeUnidades;
    }

    public int obtenerCostoArquero(){
        return this.fabricaDeUnidades.obtenerCostoArquero();
    }

    public Arquero crearArquero(Posicion posicion){
        return this.fabricaDeUnidades.crearArquero(posicion);
    }

    public int obtenerCostoEspadachin(){
        return this.fabricaDeUnidades.obtenerCostoEspadachin();
    }

    public Espadachin crearEspadachin(Posicion posicion){
        return this.fabricaDeUnidades.crearEspadachin(posicion);
    }

}