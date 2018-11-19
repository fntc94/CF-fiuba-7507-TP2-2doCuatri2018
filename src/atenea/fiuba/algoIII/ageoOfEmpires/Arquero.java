package atenea.fiuba.algoIII.ageoOfEmpires;

public class Arquero implements IAtacable, IAtacante {

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

    // IAtacante
    @Override
    public void atacar(IAtacable unidad){
        unidad.recibirAtaque(this);
    }

    @Override
    public int obtenerDanio(Aldeano aldeano) {
        return DANIO_A_UNIDAD;
    }

    @Override
    public int obtenerDanio(Espadachin espadachin) {
        return DANIO_A_UNIDAD;
    }

    @Override
    public int obtenerDanio(Arquero arquero) {
        return DANIO_A_UNIDAD;
    }

    @Override
    public int obtenerDanio(ArmaDeAsedio armaDeAsedio) {
        return DANIO_A_UNIDAD;
    }

    @Override
    public int obtenerDanio(PlazaCentral plazaCentral) {
        return DANIO_A_EDIFICIO;
    }

    @Override
    public int obtenerDanio(Cuartel cuartel) {
        return DANIO_A_EDIFICIO;
    }

    @Override
    public int obtenerDanio(Castillo castillo) {
        return DANIO_A_EDIFICIO;
    }
    // end IAtacante
}
