package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.function.Consumer;

public class EstadoAldeanoConstructor<TEdificioTerminado> implements IEstadoAldeano {

    private Aldeano _contexto;
    private EdificioEnConstruccion<TEdificioTerminado> _edificioEnConstruccion;
    private Consumer<TEdificioTerminado> _accionAlTerminarConstruccion;

    public EstadoAldeanoConstructor(EdificioEnConstruccion<TEdificioTerminado> edificioEnConstruccion, Consumer<TEdificioTerminado> accionAlTerminarConstruccion, Aldeano contexto) {

        _edificioEnConstruccion = edificioEnConstruccion;
        _accionAlTerminarConstruccion = accionAlTerminarConstruccion != null ? accionAlTerminarConstruccion : edificioTerminado -> {
        };
        _contexto = contexto;
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
        _edificioEnConstruccion.avanzarConstruccion();
    }

    @Override
    public boolean estaConstruyendo() {
        return true;
    }

    @Override
    public void continuarConstruyendo() {

        _edificioEnConstruccion.avanzarConstruccion();

        if (_edificioEnConstruccion.estaTerminado()) {

            _accionAlTerminarConstruccion.accept(_edificioEnConstruccion.obtenerEdificioTerminado());
            _contexto.establecerEstado(new EstadoAldeanoRecolector());

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
