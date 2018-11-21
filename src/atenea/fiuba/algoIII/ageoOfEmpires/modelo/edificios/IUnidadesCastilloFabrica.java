package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.ArmaDeAsedio;

public interface IUnidadesCastilloFabrica {

    int obtenerCostoArmaDeAsedio();
    ArmaDeAsedio crearArmaDeAsedio();

}
