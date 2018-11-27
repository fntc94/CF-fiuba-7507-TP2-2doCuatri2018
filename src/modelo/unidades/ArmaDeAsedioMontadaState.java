package modelo.unidades;

import modelo.IAtacable;
import modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import modelo.movimiento.IDireccion;

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
