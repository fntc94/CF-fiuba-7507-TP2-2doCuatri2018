package modelo.unidades;

import modelo.IEdificioReparable;
import modelo.edificios.IConstruccion;

class AldeanoRecolectorState implements IAldeanoState {

    private Aldeano aldeano;
    private final int ORO_RECOLECTADO = 20;

    AldeanoRecolectorState(Aldeano contexto){
        this.aldeano = contexto;
    }

    @Override
    public void iniciarConstruccion(IConstruccion construccion){
        IAldeanoState estadoConstructor = new AldeanoConstructorState<>(construccion, this.aldeano);
        this.aldeano.setEstado(estadoConstructor);
        estadoConstructor.trabajar();
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
