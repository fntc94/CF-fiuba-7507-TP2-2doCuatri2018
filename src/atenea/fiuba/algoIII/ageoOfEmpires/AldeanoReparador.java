package atenea.fiuba.algoIII.ageoOfEmpires;

public class AldeanoReparador  implements IEstadoAldeano {

    private IEdificioReparable _edificioReparable;

    private Aldeano _contexto;

    AldeanoReparador(IEdificioReparable edificioReparable, Aldeano contexto){
        _edificioReparable = edificioReparable;
        _contexto = contexto;
    }

    @Override
    public void reparar(IEdificioReparable edificioReparable){
        this._edificioReparable = edificioReparable;
        _edificioReparable.recibirReparador(this);
    }

    @Override
    public void reparar(){
        _edificioReparable.recibirReparador(this);
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        _edificioReparable = new NullEdificioReparable();
        _contexto.establecerEstado(new AldeanoRecolector());
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
