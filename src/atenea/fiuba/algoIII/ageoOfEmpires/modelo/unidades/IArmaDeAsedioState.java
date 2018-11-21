package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.IEdificioAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.movimiento.IDireccion;

interface IArmaDeAsedioState {

    void atacar(IAtacable atacable);
    void mover(IDireccion direccion);

}
