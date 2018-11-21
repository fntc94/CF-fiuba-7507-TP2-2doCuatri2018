package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.movimiento.IDireccion;

import java.util.function.Consumer;

class ArmaDeAsedioMontadaState implements IArmaDeAsedioState {

    private Consumer<IAtacable> atacarFunc;

    ArmaDeAsedioMontadaState(Consumer<IAtacable> atacarFunc){
        this.atacarFunc = atacarFunc;
    }

    @Override
    public void atacar(IAtacable atacable){
        this.atacarFunc.accept(atacable);
    }

    @Override
    public void mover(IDireccion direccion){
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

}
