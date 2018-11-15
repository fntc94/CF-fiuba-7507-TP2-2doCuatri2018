package atenea.fiuba.algoIII.ageoOfEmpires;

public class Aldeano implements IPosicionable {

    private int _vida = 50;
    private int _costo = 25;
    private IEstadoAldeano _estado = new AldeanoRecolector();

    public Aldeano(){

    }

    void establecerEstado(IEstadoAldeano estado){
        _estado = estado;
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


    public void reparar(IEdificioReparable edificioReparable){
        _estado = new AldeanoReparador(edificioReparable, this);
        _estado.reparar(edificioReparable);
    }

    public void reparar(){
        _estado.reparar();
    }

    public int recolectarOro() {
        return _estado.recolectarOro();
    }

}
