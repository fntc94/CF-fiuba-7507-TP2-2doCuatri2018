package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;

class AldeanoRecolectorState implements IAldeanoState {

    private Aldeano contexto;
    private final int ORO_RECOLECTADO = 20;

    AldeanoRecolectorState(Aldeano contexto){
        this.contexto = contexto;
    }

    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        IAldeanoState estadoReparador = new AldeanoReparadorState(edificioReparable, this.contexto);
        estadoReparador.trabajar();
        this.contexto.establecerEstado(estadoReparador);
    }

    public void trabajar(){
        // hace nada
    }

    @Override
    public int obtenerOroRecolectado() {
        return this.ORO_RECOLECTADO;
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }
}
