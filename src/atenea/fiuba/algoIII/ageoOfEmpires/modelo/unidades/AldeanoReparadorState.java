package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.NullEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;

class AldeanoReparadorState implements IAldeanoState {

    private Aldeano aldeano;
    private IEdificioReparable edificioEnReparacion;
    private final int ORO_RECOLECTADO = 0;

    AldeanoReparadorState(IEdificioReparable edificioReparable, Aldeano contexto){
        this.aldeano = contexto;
        this.edificioEnReparacion = edificioReparable;

        this.edificioEnReparacion.onReparacionTerminada(() -> {
                this.edificioEnReparacion = new NullEdificioReparable();
                this.aldeano.setEstado(new AldeanoRecolectorState(this.aldeano));
            ;});
    }

    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void trabajar(){
        this.reparar();
        this.aldeano.setOro(ORO_RECOLECTADO);
    }

    private void reparar(){
        this.edificioEnReparacion.recibirReparador(this);
    }

}
