package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.NullEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;

class AldeanoReparadorState implements IAldeanoState {

    private Aldeano contexto;
    private IEdificioReparable edificioEnReparacion;
    private final int ORO_RECOLECTADO = 0;

    AldeanoReparadorState(IEdificioReparable edificioReparable, Aldeano contexto){
        this.contexto = contexto;
        this.edificioEnReparacion = edificioReparable;
    }

    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void trabajar(){
        this.edificioEnReparacion.recibirReparador(this);
    }

    @Override
    public int obtenerOroRecolectado() {
        return this.ORO_RECOLECTADO;
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        this.edificioEnReparacion = new NullEdificioReparable();
        this.contexto.establecerEstado(new AldeanoRecolectorState(this.contexto));
    }

}
