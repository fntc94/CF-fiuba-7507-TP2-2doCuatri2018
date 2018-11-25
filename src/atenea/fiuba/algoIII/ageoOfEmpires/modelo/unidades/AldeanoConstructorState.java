package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.EdificioEnConstruccion;

import java.util.function.Consumer;

class AldeanoConstructorState<TEdificioTerminado> implements IAldeanoState {

    private Aldeano aldeano;
    private EdificioEnConstruccion<TEdificioTerminado> edificioEnConstruccion;
    private Consumer<TEdificioTerminado> accionAlTerminarConstruccion;
    private final int ORO_RECOLECTADO = 0;

    AldeanoConstructorState(EdificioEnConstruccion<TEdificioTerminado> edificioEnConstruccion, Consumer<TEdificioTerminado> accionAlTerminarConstruccion, Aldeano contexto) {

        this.edificioEnConstruccion = edificioEnConstruccion;
        this.accionAlTerminarConstruccion = accionAlTerminarConstruccion != null ? accionAlTerminarConstruccion : edificioTerminado -> {
        };
        this.aldeano = contexto;
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
        this.edificioEnConstruccion.avanzarConstruccion();

        if (this.edificioEnConstruccion.estaTerminado()) {

            this.accionAlTerminarConstruccion.accept(this.edificioEnConstruccion.obtenerEdificioTerminado());
            this.aldeano.setEstado(new AldeanoRecolectorState(this.aldeano));

        }
    }

}
