package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;

public interface IReparador {

    void iniciarReparacion(IEdificioReparable edificioReparable);
    void continuarReparando();
    boolean estaReparando();

}
