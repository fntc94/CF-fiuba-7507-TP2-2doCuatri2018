package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.function.Consumer;

  public class EstadoAldeanoConstructor<TEdificioTerminado> implements IEstadoAldeano {

    private Aldeano _contexto;
    private IEdificioEnConstruccion<TEdificioTerminado> _edificioEnConstruccion;
    private Consumer<TEdificioTerminado> _accionAlTerminarConstruccion;

    public EstadoAldeanoConstructor(IEdificioEnConstruccion<TEdificioTerminado> edificioEnConstruccion, Consumer<TEdificioTerminado> accionAlTerminarConstruccion, Aldeano contexto){

        _edificioEnConstruccion = edificioEnConstruccion;
        _accionAlTerminarConstruccion = accionAlTerminarConstruccion != null ? accionAlTerminarConstruccion : edificioTerminado -> {};
        _contexto = contexto;
    }

    public void iniciarConstruccion(){
        _edificioEnConstruccion.avanzarConstruccion();
    }

    public void continuarConstruyendo(){

        _edificioEnConstruccion.avanzarConstruccion();

        if(_edificioEnConstruccion.estaTerminado()){

            _accionAlTerminarConstruccion.accept(_edificioEnConstruccion.obtenerEdificioTerminado());
            _contexto.establecerEstado(new EstadoAldeanoRecolector());

        }

    }

    public boolean estaConstruyendo(){
        return true;
    }


      @Override
      public boolean estaRecolectandoOro() {
          return false;
      }

      @Override
    public int recolectarOro() {
        return 0;
    }

    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable) {

    }

    @Override
    public void continuarReparacion() {

    }

    @Override
    public void darPorTerminadaLaReparacion() {

    }

      @Override
      public boolean estaReparando() {
          return false;
      }
  }
