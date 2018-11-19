package atenea.fiuba.algoIII.ageoOfEmpires;

public class Espadachin implements IAtacable, IPosicionable {

    private final int VIDA_MAXIMA = 100;
    private int _vida = VIDA_MAXIMA;

    private final int DANIO_A_UNIDAD = 25;
    private final int DANIO_A_EDIFICIO = 15;
    private final int RANGO_DE_ATAQUE = 1;

    private Posicion _posicion;

    public Espadachin(Posicion posicion){
        _posicion = posicion;
    }

    public int getVida() {
        return _vida;
    }

    public void atacar(IAtacable unidad){

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
