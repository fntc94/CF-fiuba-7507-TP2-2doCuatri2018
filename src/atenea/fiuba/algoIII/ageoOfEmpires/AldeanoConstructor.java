package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.function.Consumer;

  public class AldeanoConstructor<TEdificioTerminado> implements IEstadoAldeano {

    private Aldeano _contexto;
    private IEdificioEnConstruccion<TEdificioTerminado> _edificioEnConstruccion;
    private Consumer<TEdificioTerminado> _accionAlTerminarConstruccion;

    public AldeanoConstructor(IEdificioEnConstruccion<TEdificioTerminado> edificioEnConstruccion, Consumer<TEdificioTerminado> accionAlTerminarConstruccion, Aldeano contexto){

        _edificioEnConstruccion = edificioEnConstruccion;
        _accionAlTerminarConstruccion = accionAlTerminarConstruccion != null ? accionAlTerminarConstruccion : edificioTerminado -> {};
        _contexto = contexto;
    }

    public void iniciarConstruccion(){
        _edificioEnConstruccion.avanzarConstruccion();
    }

    public void continuarConstruccion(){

        _edificioEnConstruccion.avanzarConstruccion();

        if(_edificioEnConstruccion.estaTerminado()){

            _accionAlTerminarConstruccion.accept(_edificioEnConstruccion.obtenerEdificioTerminado());
            _contexto.establecerEstado(new AldeanoRecolector());

        }

    }

    public boolean estaConstruyendo(){
        return true;
    }


    @Override
    public int recolectarOro() {
        return 0;
    }

    @Override
    public void reparar(IEdificioReparable edificioReparable) {

    }

    @Override
    public void reparar() {

    }

    @Override
    public void darPorTerminadaLaReparacion() {

    }
}
