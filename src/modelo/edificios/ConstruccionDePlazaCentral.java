package modelo.edificios;

import modelo.posicion.Posicion;
import modelo.unidades.UnidadesFabrica;

public class ConstruccionDePlazaCentral extends Construccion<PlazaCentral> {

    private static final int TURNOS_EN_CONSTRUIR = 3;

    public ConstruccionDePlazaCentral(Posicion posicion){
        super(posicion, TURNOS_EN_CONSTRUIR);
    }

    @Override
    protected PlazaCentral crearEdificio() {
        return new PlazaCentral(posicion, new UnidadesFabrica());
    }
}
