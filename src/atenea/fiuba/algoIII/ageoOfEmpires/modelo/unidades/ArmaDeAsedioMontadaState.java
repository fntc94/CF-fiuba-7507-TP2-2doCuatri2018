package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.movimiento.IDireccion;

import java.util.function.Consumer;

public class ArmaDeAsedioMontadaState implements IArmaDeAsedioState {

    private final int DANIO_A_EDIFICIOS = 75;
    private Consumer<IAtacable> atacarFunc;

    public ArmaDeAsedioMontadaState(Consumer<IAtacable> atacarFunc){
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
