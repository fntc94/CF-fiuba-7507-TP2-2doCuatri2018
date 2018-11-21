package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.IEstadoReparador;

public class NullEdificioReparable implements IEdificioReparable {

    @Override
    public void recibirReparador(IEstadoReparador reparador) {
        //hace nada.
    }
}
