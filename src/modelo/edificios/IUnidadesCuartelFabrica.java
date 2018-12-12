package modelo.edificios;

import modelo.posicion.Posicion;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;

public interface IUnidadesCuartelFabrica {

    int obtenerCostoArquero();
    Arquero crearArquero(Posicion posicion);

    int obtenerCostoEspadachin();
    Espadachin crearEspadachin(Posicion posicion);

}
