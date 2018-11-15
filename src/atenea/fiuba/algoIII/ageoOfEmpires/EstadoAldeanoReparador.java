package atenea.fiuba.algoIII.ageoOfEmpires;

public class EstadoAldeanoReparador implements IEstadoAldeano {

    private IEdificioReparable _edificioReparable;

    private Aldeano _contexto;

    EstadoAldeanoReparador(IEdificioReparable edificioReparable, Aldeano contexto){
        _edificioReparable = edificioReparable;
        _contexto = contexto;
    }

    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable){
        this._edificioReparable = edificioReparable;
        _edificioReparable.recibirReparador(this);
    }

    @Override
    public void continuarReparacion(){
        _edificioReparable.recibirReparador(this);
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        _edificioReparable = new NullEdificioReparable();
        _contexto.establecerEstado(new EstadoAldeanoRecolector());
    }

    @Override
    public boolean estaReparando() {
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
    public void iniciarConstruccion() {

    }

    @Override
    public void continuarConstruccion() {

    }

    @Override
    public boolean estaConstruyendo() {
        return false;
    }
}
