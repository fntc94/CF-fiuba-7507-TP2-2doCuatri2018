package atenea.fiuba.algoIII.ageoOfEmpires;

public class PlazaCentral implements IEdificioReparable {

    private int _vidaMaxima;
    private int _vidaActual;
    private IReparadorDeEdificios _reparadorActivo = null;

    private IUnidadFabrica<Aldeano> _fabricaDeAldeanos = new AldeanoFabrica();

    public PlazaCentral(int vidaMaxima, int vidaInicial) {

        _vidaMaxima = vidaMaxima;
        _vidaActual = vidaInicial;
    }

    public int getVida() {
        return _vidaActual;
    }

    private int getRecuperoDeVida() {
        return 25;
    }

    @Override
    public void recibirReparador(IReparadorDeEdificios reparador) {

        if(_reparadorActivo == null){
            _reparadorActivo = reparador;
        }

        else if (_reparadorActivo != reparador){
            return;
        }

        this._vidaActual += getRecuperoDeVida();

        if(_vidaActual > _vidaMaxima){
            _vidaActual = _vidaMaxima;
            _reparadorActivo.darPorTerminadaLaReparacion();
        }
    }

    public int obtenerCostoAldeano(){

        return _fabricaDeAldeanos.obtenerCosto();
    }

    public Aldeano construirAldeano() {

        return _fabricaDeAldeanos.crear();

    }
}
