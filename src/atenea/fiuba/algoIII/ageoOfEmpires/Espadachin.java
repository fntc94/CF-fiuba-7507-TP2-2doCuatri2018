package atenea.fiuba.algoIII.ageoOfEmpires;

public class Espadachin implements IUnidadAtacable, IPosicionable {

    private final int _vidaMaxima;
    private int _vida;
    private Posicion _posicion;

    private final int DANIO_A_UNIDAD = 25;
    private final int DANIO_A_EDIFICIO = 15;
    private final int RANGO_DE_ATAQUE = 1;

    public Espadachin(int vidaMaxima, int vidaInicial, Posicion posicion){
        _vidaMaxima = vidaMaxima;
        _vida = vidaInicial;
        _posicion = posicion;
    }

    public Espadachin(int vidaMaxima, Posicion posicion){
        this(vidaMaxima, vidaMaxima, posicion);
    }

    public Espadachin(int vidaMaxima, int vidaInicial){
        this(vidaMaxima, vidaInicial, null);
    }

    public Espadachin(int vidaMaxima){
        this(vidaMaxima, vidaMaxima, null);
    }

    public int getVida() {
        return _vida;
    }

    public void atacar(IUnidadAtacable unidad){

        if(!estaDentroDelRangoDeAtaque(unidad)){
            throw new UnidadFueraDeRangoDeAtaqueExcepcion();
        }
        unidad.recibirDanio(DANIO_A_UNIDAD);
    }
    private boolean estaDentroDelRangoDeAtaque(IPosicionable unidad){
        return this._posicion.distanciaA(unidad.getPosicion()) <= RANGO_DE_ATAQUE;
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

    @Override
    public Posicion getPosicion() {
        return this._posicion;
    }
}
