package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.EdificioEnConstruccion;

import java.util.function.Consumer;

class AldeanoConstructorState<TEdificioTerminado> implements IAldeanoState {

    private Aldeano contexto;
    private EdificioEnConstruccion<TEdificioTerminado> edificioEnConstruccion;
    private Consumer<TEdificioTerminado> accionAlTerminarConstruccion;
    private final int ORO_RECOLECTADO = 0;

    AldeanoConstructorState(EdificioEnConstruccion<TEdificioTerminado> edificioEnConstruccion, Consumer<TEdificioTerminado> accionAlTerminarConstruccion, Aldeano contexto) {

        this.edificioEnConstruccion = edificioEnConstruccion;
        this.accionAlTerminarConstruccion = accionAlTerminarConstruccion != null ? accionAlTerminarConstruccion : edificioTerminado -> {
        };
        this.contexto = contexto;
    }

    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void trabajar() {

        this.edificioEnConstruccion.avanzarConstruccion();

        if (this.edificioEnConstruccion.estaTerminado()) {

            this.accionAlTerminarConstruccion.accept(this.edificioEnConstruccion.obtenerEdificioTerminado());
            this.contexto.establecerEstado(new AldeanoRecolectorState(this.contexto));

        }

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
