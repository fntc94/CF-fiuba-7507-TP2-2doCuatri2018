package atenea.fiuba.algoIII.ageoOfEmpires;

public class Aldeano {

    private int _vida = 50;
    private int _costo = 25;

    public Aldeano(){
    }

    public int getVida() {
        return _vida;
    }

    public int getCosto() {
        return _costo;
    }

    @Override
    public String toString(){
        return "Aldeano con vida=" + this._vida + " y costo=" + this._costo;
    }
}
