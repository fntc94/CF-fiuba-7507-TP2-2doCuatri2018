package atenea.fiuba.algoIII.ageoOfEmpires;

public class Castillo implements IEdificioReparable, IPosicionable {

    private int _vidaMaxima;
    private int _vidaActual;
    private IReparadorDeEdificios _reparadorActivo;

    public Castillo(int vidaMaxima, int vidaInicial) {

        _vidaMaxima = vidaMaxima;
        _vidaActual = vidaInicial;
    }

    public int getVida() {
        return _vidaActual;
    }

    private int getRecuperoDeVida() {
        return 15;
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
        }
    }

}
