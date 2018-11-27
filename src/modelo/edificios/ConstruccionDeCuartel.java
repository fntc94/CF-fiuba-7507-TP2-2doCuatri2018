package modelo.edificios;

import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;
import modelo.unidades.UnidadesFabrica;

public class ConstruccionDeCuartel extends Construccion<Cuartel> {

    private static final int TURNOS_EN_CONSTRUIR = 3;

    public ConstruccionDeCuartel(Posicion posicion, Aldeano constructor) {
        super(posicion, TURNOS_EN_CONSTRUIR);
    }

    @Override
    protected Cuartel crearEdificio() {
        return new Cuartel(posicion, new UnidadesFabrica());
    }

}
