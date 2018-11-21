package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.IEdificioAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;

public class EstadoArmaDeAsedioDesmontada implements IEstadoArmaDeAsedio {

    @Override
    public boolean estaMontada() {
        return false;
    }

    @Override
    public void atacar() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void mover() {
        // TODO: implementar movimiento!
    }

    @Override
    public void atacar(IEdificioAtacable edificioAtacable) {
        this.atacar();
    }


}
