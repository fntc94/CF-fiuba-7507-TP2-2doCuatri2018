package atenea.fiuba.algoIII.ageoOfEmpires;

public abstract class Unidad implements IPosicionable, IAtacable {

    protected int _vida;
    private Posicion _posicion;

    protected Unidad(Posicion posicion, int vida){
        _posicion = posicion;
        this._vida = vida;
    }



    @Override
    public Posicion getPosicion() {
        return _posicion;
    }

    @Override // IAtacable
    public void recibirAtaque(IAtacante atacante) {

        int danio = atacante.obtenerDanio(this);

        if(this._vida <= danio){
            this._vida = 0;
            return;
        }

        this._vida -= danio;
    }

    @Override
    public int getVida() {
        return _vida;
    }
    // fin IAtacable

}
