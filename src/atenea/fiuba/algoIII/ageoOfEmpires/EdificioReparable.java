package atenea.fiuba.algoIII.ageoOfEmpires;

public abstract class EdificioReparable implements IEdificioReparable {

    private int _vidaMaxima;
    private int _vidaActual;
    private IEstadoReparador _reparadorActivo;

    public EdificioReparable(int vidaMaxima, int vidaInicial) {
        _vidaMaxima = vidaMaxima;
        _vidaActual = vidaInicial;
    }

    public int getVida() {
        return _vidaActual;
    }

    @Override
    public void recibirReparador(IEstadoReparador reparador) {

        if(_reparadorActivo == null){
            _reparadorActivo = reparador;
        }

        else if (_reparadorActivo != reparador){
            return;
        }

        this._vidaActual += getVelocidadDeReparacion();

        if(_vidaActual > _vidaMaxima){
            _vidaActual = _vidaMaxima;
            _reparadorActivo.darPorTerminadaLaReparacion();
        }
    }

    protected abstract int getVelocidadDeReparacion();

}
