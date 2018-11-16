package atenea.fiuba.algoIII.ageoOfEmpires;

public class EstadoAldeanoReparador implements IEstadoAldeano {

    private Aldeano _contexto;
    private IEdificioReparable _edificioReparable;

    EstadoAldeanoReparador(IEdificioReparable edificioReparable, Aldeano contexto){
        _contexto = contexto;
        _edificioReparable = edificioReparable;
    }

    //IRecolectorDeOro
    @Override
    public int recolectarOro() {
        return 0;
    }

    @Override
    public boolean estaRecolectandoOro() {
        return false;
    }
    //fin IRecolectorDeOro

    //IConstructor
    @Override
    public void iniciarConstruccion() {
        throw new OperacionInvalidaExcepcion();
    }

    @Override
    public boolean estaConstruyendo() {
        return false;
    }

    @Override
    public void continuarConstruyendo() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }
    //fin IConstructor

    //IReparador
    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable){
        this._edificioReparable = edificioReparable;
        _edificioReparable.recibirReparador(this);
    }

    @Override
    public boolean estaReparando() {
        return true;
    }

    @Override
    public void continuarReparando(){
        _edificioReparable.recibirReparador(this);
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        _edificioReparable = new NullEdificioReparable();
        _contexto.establecerEstado(new EstadoAldeanoRecolector());
    }
    //fin IReparador

}
