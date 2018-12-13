package modelo.edificios;

import modelo.Edificio;
import modelo.IEdificioReparable;
import modelo.posicion.Posicion;
import modelo.IAtacable;
import modelo.IPosicionable;
import modelo.unidades.Aldeano;

public class PlazaCentral extends Edificio implements IPosicionable, IEdificioReparable, IAtacable {

    private static final int VIDA_MAXIMA = 450;
    private static final int VELOCIDAD_DE_REPARACION = 25;
    private IUnidadesPlazaCentralFabrica fabricaDeUnidades;

    public PlazaCentral(Posicion posicion, IUnidadesPlazaCentralFabrica fabricaDeUnidades) {
        super(posicion, VIDA_MAXIMA, VELOCIDAD_DE_REPARACION);
        this.fabricaDeUnidades = fabricaDeUnidades;
    }

    public int obtenerCostoAldeano(){
        return this.fabricaDeUnidades.obtenerCostoAldeano();
    }

    public Aldeano construirAldeano(Posicion posicion) {
        return this.fabricaDeUnidades.crearAldeano(posicion);
    }

}
