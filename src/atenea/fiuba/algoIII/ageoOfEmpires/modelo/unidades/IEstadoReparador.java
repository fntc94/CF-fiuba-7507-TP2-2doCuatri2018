package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;

public interface IEstadoReparador {

    void iniciarReparacion(IEdificioReparable edificioReparable);
    void reparar();
    void darPorTerminadaLaReparacion();

}
