package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.NullEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;

class AldeanoReparadorState implements IAldeanoState {

    private Aldeano contexto;
    private IEdificioReparable edificioEnReparacion;

    AldeanoReparadorState(IEdificioReparable edificioReparable, Aldeano contexto){
        this.contexto = contexto;
        this.edificioEnReparacion = edificioReparable;
    }

    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    //IRecolectorDeOro
    @Override
    public int recolectarOro() {
        return 0;
    }

    //fin IRecolectorDeOro

    //IConstructor
    @Override
    public void construir() {
//        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    //fin IConstructor

    // IReparador
    @Override
    public void reparar(){
        this.edificioEnReparacion.recibirReparador(this);
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        this.edificioEnReparacion = new NullEdificioReparable();
        this.contexto.establecerEstado(new AldeanoRecolectorState(this.contexto));
    }
    //fin IReparador

}
