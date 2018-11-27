package modelo.unidades;

import modelo.IAtacable;
import modelo.movimiento.IDireccion;

interface IArmaDeAsedioState {

    void atacar(IAtacable atacable);
    void mover(IDireccion direccion);

}
