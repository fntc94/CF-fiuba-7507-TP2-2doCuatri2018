package atenea.fiuba.algoIII.ageoOfEmpires;

public class Arquero {

    private int _vida = 75;
    private int _costo = 75;

    public Arquero(int vidaMaxima){
        _vida = vidaMaxima;
    }

    public int getVida() {
        return _vida;
    }

    public int getCosto() {
        return _costo;
    }

    @Override
    public String toString(){
        return "Arquero con vida=" + this._vida + " y costo=" + this._costo;
    }
}
