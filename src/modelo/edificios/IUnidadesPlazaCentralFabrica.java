package modelo.edificios;

import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;

public interface IUnidadesPlazaCentralFabrica {

    int obtenerCostoAldeano();
    Aldeano crearAldeano(Posicion posicion);

}
