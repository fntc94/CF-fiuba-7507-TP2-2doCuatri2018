package atenea.fiuba.algoIII.ageoOfEmpires.modelo;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.IEstadoReparador;

public interface IEdificioReparable {

    void recibirReparador(IEstadoReparador reparador);
    void onReparacionTerminada(Runnable action);

}
