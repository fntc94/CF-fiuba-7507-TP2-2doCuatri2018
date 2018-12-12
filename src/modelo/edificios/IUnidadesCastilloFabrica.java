package modelo.edificios;

import modelo.posicion.Posicion;
import modelo.unidades.ArmaDeAsedio;

public interface IUnidadesCastilloFabrica {

    int obtenerCostoArmaDeAsedio();
    ArmaDeAsedio crearArmaDeAsedio(Posicion posicion);

}
