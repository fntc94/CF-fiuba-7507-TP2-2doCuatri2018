package atenea.fiuba.algoIII.ageoOfEmpires;

public class Arquero implements IAtacable {

    private final int _vidaMaxima;
    private int _vida;
    private Posicion _posicion;

    private final int DANIO_A_UNIDAD = 15;
    private final int DANIO_A_EDIFICIO = 10;

    public Arquero(int vidaMaxima, int vidaInicial){
        _vidaMaxima = vidaMaxima;
        _vida = vidaInicial;
    }

    public Arquero(int vidaMaxima, Posicion posicion){
        _vidaMaxima = vidaMaxima;
        _vida = vidaMaxima;
        _posicion = posicion;
    }

    public Arquero(int vidaMaxima){
        _vidaMaxima = vidaMaxima;
        _vida = vidaMaxima;
        _posicion = null;
    }

    public int getVida() {
        return _vida;
    }

    public void atacar(IAtacable unidad){
        unidad.recibirDanio(DANIO_A_UNIDAD);
    }

    public void atacar(IEdificioAtacable edificioAtacable) {
        edificioAtacable.recibirDanio(DANIO_A_EDIFICIO);
    }

    @Override // IAtacable
    public void recibirDanio(int danio){

        if(danio >= this._vida){
            _vida = 0;
            return;
        }

        this._vida -= danio;
    }

    @Override
    public Posicion getPosicion() {
        return _posicion;
    }
}
