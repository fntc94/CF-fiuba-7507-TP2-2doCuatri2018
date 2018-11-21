package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.movimiento.IDireccion;

import java.util.function.Consumer;

class ArmaDeAsedioDesmontadaState implements IArmaDeAsedioState {

    private Consumer<IDireccion> moverFunc;

    ArmaDeAsedioDesmontadaState(Consumer<IDireccion> moverFunc){
        this.moverFunc = moverFunc;
    }

    @Override
    public void atacar(IAtacable atacable) {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void mover(IDireccion direccion) {
        this.moverFunc.accept(direccion);
    }

}
