package atenea.fiuba.algoIII.ageoOfEmpires;

public class Espadachin {

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

    public void atacar(Arquero arquero){
        arquero.recibirAtaque(DANIO_A_UNIDAD);
    }

    public void atacar(Espadachin espadachin){
        espadachin.recibirAtaque(DANIO_A_UNIDAD);
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
