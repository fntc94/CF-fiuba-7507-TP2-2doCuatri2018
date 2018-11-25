package atenea.fiuba.algoIII.ageoOfEmpires.modelo;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Aldeano;

public interface IEdificioReparable {

    void recibirReparador(Aldeano reparador);
    void onReparacionTerminada(Runnable action);

}
