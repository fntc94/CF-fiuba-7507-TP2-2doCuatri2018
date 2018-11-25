package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.EdificioEnConstruccion;

import java.util.function.Consumer;

class AldeanoConstructorState<TEdificioTerminado> implements IAldeanoState {

    private Aldeano contexto;
    private EdificioEnConstruccion<TEdificioTerminado> edificioEnConstruccion;
    private Consumer<TEdificioTerminado> accionAlTerminarConstruccion;

    AldeanoConstructorState(EdificioEnConstruccion<TEdificioTerminado> edificioEnConstruccion, Consumer<TEdificioTerminado> accionAlTerminarConstruccion, Aldeano contexto) {

        this.edificioEnConstruccion = edificioEnConstruccion;
        this.accionAlTerminarConstruccion = accionAlTerminarConstruccion != null ? accionAlTerminarConstruccion : edificioTerminado -> {
        };
        this.contexto = contexto;
    }

    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    //IRecolectorDeOro
    @Override
    public int recolectarOro() {
        return 0;
    }

    //IConstructor
    @Override
    public void construir() {

        this.edificioEnConstruccion.avanzarConstruccion();

        if (this.edificioEnConstruccion.estaTerminado()) {

            this.accionAlTerminarConstruccion.accept(this.edificioEnConstruccion.obtenerEdificioTerminado());
            this.contexto.establecerEstado(new AldeanoRecolectorState(this.contexto));

        }
    }
    // fin IConstructor

    @Override
    public void reparar() {
//        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }
    //fin IReparador
}
