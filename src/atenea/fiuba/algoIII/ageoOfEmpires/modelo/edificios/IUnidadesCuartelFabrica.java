package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Arquero;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Espadachin;

public interface IUnidadesCuartelFabrica {

    int obtenerCostoArquero();
    Arquero crearArquero();

    int obtenerCostoEspadachin();
    Espadachin crearEspadachin();

}
