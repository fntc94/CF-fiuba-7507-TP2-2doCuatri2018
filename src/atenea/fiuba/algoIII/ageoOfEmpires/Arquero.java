package atenea.fiuba.algoIII.ageoOfEmpires;

public class Arquero implements IAtacable {

    private final int VIDA_MAXIMA = 75;
    private int _vida = VIDA_MAXIMA;

    private final int DANIO_A_UNIDAD = 15;
    private final int DANIO_A_EDIFICIO = 10;

    private Posicion _posicion;

    public Arquero(Posicion posicion){
        _posicion = posicion;
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
