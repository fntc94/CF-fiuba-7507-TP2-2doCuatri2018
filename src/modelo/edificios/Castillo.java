package modelo.edificios;

import modelo.posicion.Posicion;
import modelo.unidades.ArmaDeAsedio;
import modelo.*;

public class Castillo extends Edificio implements IEdificioReparable, IAtacable, IAtacante {

    private static final int VIDA_MAXIMA = 1000;
    private static final int VELOCIDAD_DE_REPARACION = 15;

    private IUnidadesCastilloFabrica fabricaDeUnidades;
    private final IEstrategiaAtaque estrategiaAtaque;

    public Castillo(Posicion posicion, IUnidadesCastilloFabrica fabricaDeUnidades, IEstrategiaAtaque estrategiaAtaque) {
        super(posicion, VIDA_MAXIMA, VELOCIDAD_DE_REPARACION);
        this.fabricaDeUnidades = fabricaDeUnidades;
        this.estrategiaAtaque = estrategiaAtaque;
    }

    public int obtenerCostoArmaDeAsedio() {
        return this.fabricaDeUnidades.obtenerCostoArmaDeAsedio();
    }

    public ArmaDeAsedio crearArmaDeAsedio() {
        return this.fabricaDeUnidades.crearArmaDeAsedio();
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

