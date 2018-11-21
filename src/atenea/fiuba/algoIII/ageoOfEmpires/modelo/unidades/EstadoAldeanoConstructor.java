package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.EdificioEnConstruccion;

import java.util.function.Consumer;

public class EstadoAldeanoConstructor<TEdificioTerminado> implements IEstadoAldeano {

    private Aldeano contexto;
    private EdificioEnConstruccion<TEdificioTerminado> edificioEnConstruccion;
    private Consumer<TEdificioTerminado> accionAlTerminarConstruccion;

    public EstadoAldeanoConstructor(EdificioEnConstruccion<TEdificioTerminado> edificioEnConstruccion, Consumer<TEdificioTerminado> accionAlTerminarConstruccion, Aldeano contexto) {

        this.edificioEnConstruccion = edificioEnConstruccion;
        this.accionAlTerminarConstruccion = accionAlTerminarConstruccion != null ? accionAlTerminarConstruccion : edificioTerminado -> {
        };
        this.contexto = contexto;
    }

    //IRecolectorDeOro
    @Override
    public int recolectarOro() {
        return 0;
    }

    public boolean estaRecolectandoOro() {
        return false;
    }
    //fin IRecolectorDeOro

    //IConstructor
    @Override
    public void iniciarConstruccion() {
        this.edificioEnConstruccion.avanzarConstruccion();
    }

    @Override
    public boolean estaConstruyendo() {
        return true;
    }

    @Override
    public void continuarConstruyendo() {

        this.edificioEnConstruccion.avanzarConstruccion();

        if (this.edificioEnConstruccion.estaTerminado()) {

            this.accionAlTerminarConstruccion.accept(this.edificioEnConstruccion.obtenerEdificioTerminado());
            this.contexto.establecerEstado(new EstadoAldeanoRecolector());

        }

    }
    // fin IConstructor


    //IReparador
    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public boolean estaReparando() {
        return false;
    }

    @Override
    public void continuarReparando() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }
    //fin IReparador
}
