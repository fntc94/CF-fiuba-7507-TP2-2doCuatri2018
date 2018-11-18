package atenea.fiuba.algoIII.ageoOfEmpires;

public class Espadachin implements IUnidadAtacable {

    private final int _vidaMaxima;
    private int _vida;

    private final int DANIO_A_UNIDAD = 25;
    private final int DANIO_A_EDIFICIO = 15;

    public Espadachin(int vidaMaxima, int vidaInicial){
        _vidaMaxima = vidaMaxima;
        _vida = vidaInicial;
    }

    public Espadachin(int vidaMaxima){
        _vidaMaxima = vidaMaxima;
        _vida = vidaMaxima;
    }

    public int getVida() {
        return _vida;
    }

    public void atacar(IUnidadAtacable unidad){
        unidad.recibirDanio(DANIO_A_UNIDAD);
    }

    public void atacar(IEdificioAtacable edificioAtacable) {
        edificioAtacable.recibirDanio(DANIO_A_EDIFICIO);
    }

    @Override
    public void recibirDanio(int danio){

        if(danio >= this._vida){
            _vida = 0;
            return;
        }

        this._vida -= danio;
    }


}
