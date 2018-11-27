package modelo.edificios;

import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;

public interface IUnidadesCuartelFabrica {

    int obtenerCostoArquero();
    Arquero crearArquero();

    int obtenerCostoEspadachin();
    Espadachin crearEspadachin();

}
