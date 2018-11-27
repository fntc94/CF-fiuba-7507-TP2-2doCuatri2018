package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Aldeano;

public class NullEdificioReparable implements IEdificioReparable {

    @Override
    public void recibirReparador(Aldeano reparador) {
        //hace nada.
    }

    @Override
    public void onReparacionTerminada(Runnable action) {
        action.run();
    }
}
