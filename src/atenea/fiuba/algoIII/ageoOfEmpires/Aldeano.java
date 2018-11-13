package atenea.fiuba.algoIII.ageoOfEmpires;

public class Aldeano implements IReparadorDeEdificios {

    private int _vida = 50;
    private int _costo = 25;

    private IReparadorDeEdificios _reparador = new NullAledeanoReparador();

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


    @Override
    public void reparar(IEdificioReparable edificioReparable){
        _reparador = new AldeanoReparador(edificioReparable);
        _reparador.reparar(edificioReparable);
    }

    @Override
    public void reparar(){
        _reparador.reparar();
    }
}
