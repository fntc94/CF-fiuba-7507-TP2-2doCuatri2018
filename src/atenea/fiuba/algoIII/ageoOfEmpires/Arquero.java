package atenea.fiuba.algoIII.ageoOfEmpires;

public class Arquero {

    private final int _vidaMaxima;
    private int _vida;

    private final int DANIO_A_UNIDAD = 15;
    private final int DANIO_A_EDIFICIO = 10;

    public Arquero(int vidaMaxima, int vidaInicial){
        _vidaMaxima = vidaMaxima;
        _vida = vidaInicial;
    }

    public Arquero(int vidaMaxima){
        _vidaMaxima = vidaMaxima;
        _vida = vidaMaxima;
    }

    public int getVida() {
        return _vida;
    }

    public void atacar(Espadachin espadachin){
       espadachin.recibirAtaque(DANIO_A_UNIDAD);
    }

    public void atacar(Arquero arquero){
        arquero.recibirAtaque(DANIO_A_UNIDAD);
    }

    public void recibirAtaque(int danio){

        if(danio >= this._vida){
            _vida = 0;
            return;
        }

        this._vida -= danio;
    }

    public void atacar(IEdificioAtacable edificioAtacable) {
        edificioAtacable.recibirAtaque(DANIO_A_EDIFICIO);
    }
}
