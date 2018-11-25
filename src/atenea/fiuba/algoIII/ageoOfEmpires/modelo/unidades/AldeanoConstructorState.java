package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.IConstruccion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;

class AldeanoConstructorState<TEdificioTerminado> implements IAldeanoState {

    private Aldeano aldeano;
    private IConstruccion<TEdificioTerminado> edificioEnConstruccion;
    private final int ORO_RECOLECTADO = 0;

    AldeanoConstructorState(IConstruccion<TEdificioTerminado> edificioEnConstruccion, Aldeano contexto) {
        this.edificioEnConstruccion = edificioEnConstruccion;
        this.edificioEnConstruccion.onConstruccionTerminada((edificio) -> {
            this.aldeano.setEstado(new AldeanoRecolectorState(this.aldeano));
        });

        this.aldeano = contexto;
    }

    @Override
    public void iniciarConstruccion(IConstruccion edificioEnConstruccion){
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void trabajar() {
        this.construir();
        this.aldeano.setOro(ORO_RECOLECTADO);
    }

    private void construir(){
        this.edificioEnConstruccion.recibirConstructor(this.aldeano);
    }

}
