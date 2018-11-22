package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;

class AldeanoRecolectorState implements IAldeanoState {

    private Aldeano contexto;

    AldeanoRecolectorState(Aldeano contexto){
        this.contexto = contexto;
    }

    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        IAldeanoState estadoReparador = new AldeanoReparadorState(edificioReparable, this.contexto);
        estadoReparador.reparar();
        this.contexto.establecerEstado(estadoReparador);
    }

    //IRecolectorDeOro
    @Override
    public int recolectarOro() {
        return 20;
    }

    @Override
    public boolean estaRecolectandoOro() {
        return true;
    }
    //fin IRecolectorDeOro

    @Override
    public boolean estaReparando() {
        return false;
    }

    @Override
    public void reparar() {
//        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }
    //fin IReparador

    //IConstructor
    @Override
    public void construir() {
//        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public boolean estaConstruyendo() {
        return false;
    }

    // fin IConstructor
}
