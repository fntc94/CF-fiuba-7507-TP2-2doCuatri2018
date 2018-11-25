package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;

class AldeanoRecolectorState implements IAldeanoState {

    private Aldeano aldeano;
    private final int ORO_RECOLECTADO = 20;

    AldeanoRecolectorState(Aldeano contexto){
        this.aldeano = contexto;
    }

    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        IAldeanoState estadoReparador = new AldeanoReparadorState(edificioReparable, this.aldeano);
        this.aldeano.setEstado(estadoReparador);
        estadoReparador.trabajar();
    }

    @Override
    public void trabajar(){
        this.aldeano.setOro(ORO_RECOLECTADO);
    }

}
