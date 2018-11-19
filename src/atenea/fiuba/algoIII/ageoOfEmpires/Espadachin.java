package atenea.fiuba.algoIII.ageoOfEmpires;

public class Espadachin implements IPosicionable, IAtacable, IAtacante {

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
        unidad.recibirAtaque(this);
    }

    public void atacar(IEdificioAtacable edificioAtacable) {
        edificioAtacable.recibirDanio(DANIO_A_EDIFICIO);
    }

    private boolean estaDentroDelRangoDeAtaque(IPosicionable unidad){
        return this._posicion.distanciaA(unidad.getPosicion()) <= RANGO_DE_ATAQUE;
    }

    public void recibirAtaque(IAtacante atacante){

        int danio = atacante.obtenerDanio(this);

        if(danio >= this._vida){
            _vida = 0;
            return;
        }

        this._vida -= danio;

    }

    @Override
    public int obtenerDanio(Aldeano aldeano) {
        return this.DANIO_A_UNIDAD;
    }

    public int obtenerDanio(Espadachin espadachin){
        return this.DANIO_A_UNIDAD;
    }

    @Override
    public int obtenerDanio(Arquero arquero) {
        return this.DANIO_A_UNIDAD;
    }

    @Override
    public int obtenerDanio(ArmaDeAsedio armaDeAsedio) {
        return this.DANIO_A_UNIDAD;
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

//    @Override
//    public void recibirDanio(int danio){
//
//        if(danio >= this._vida){
//            _vida = 0;
//            return;
//        }
//
//        this._vida -= danio;
//    }

    @Override
    public Posicion getPosicion() {
        return this._posicion;
    }
}
