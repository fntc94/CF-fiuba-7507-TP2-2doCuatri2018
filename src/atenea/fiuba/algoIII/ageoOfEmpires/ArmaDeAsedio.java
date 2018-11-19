package atenea.fiuba.algoIII.ageoOfEmpires;

public class ArmaDeAsedio implements IAtacable, IAtacante {

    private final int VIDA_MAXIMA = 150;
    private final int DANIO_A_EDIFICIOS = 75;
    private int _vidaActual = VIDA_MAXIMA;
    private Posicion _posicion;
    private IEstadoArmaDeAsedio _estado = new EstadoArmaDeAsedioDesmontada();


    public ArmaDeAsedio(Posicion posicion){
        _posicion = posicion;
    }

    public int getVida(){
        return _vidaActual;
    }

    public boolean estaMontada() {
        return _estado.estaMontada();
    }

    public void montar() {
      _estado = new EstadoArmaDeAsedioMontada();
    }

    public void desmontar() {
       _estado = new EstadoArmaDeAsedioDesmontada();
    }

    public void atacar() {
        _estado.atacar();
    }

    public void mover() {
        _estado.mover();
    }

//    public void atacar(IEdificioAtacable edificioAtacable) {
//        _estado.atacar(edificioAtacable);
//
//    }

    @Override
    public Posicion getPosicion() {
        return _posicion;
    }

    @Override
    public void recibirAtaque(IAtacante atacante) {

        int danio = atacante.obtenerDanio(this);

        if(danio >= this._vidaActual){
            _vidaActual = 0;
            return;
        }

        this._vidaActual -= danio;
    }

    @Override
    public void atacar(IAtacable atacable) {
        atacable.recibirAtaque(this);
    }

    @Override
    public int obtenerDanio(Aldeano aldeano) {
        throw new ArmaDeAsedioNoPuedeAtacarUnidadesException();
    }

    @Override
    public int obtenerDanio(Espadachin espadachin) {
        throw new ArmaDeAsedioNoPuedeAtacarUnidadesException();
    }

    @Override
    public int obtenerDanio(Arquero arquero) {
        throw new ArmaDeAsedioNoPuedeAtacarUnidadesException();
    }

    @Override
    public int obtenerDanio(ArmaDeAsedio armaDeAsedio) {
        throw new ArmaDeAsedioNoPuedeAtacarUnidadesException();
    }

    @Override
    public int obtenerDanio(PlazaCentral plazaCentral) {
        return DANIO_A_EDIFICIOS;
    }

    @Override
    public int obtenerDanio(Cuartel cuartel) {
        return DANIO_A_EDIFICIOS;
    }

    @Override
    public int obtenerDanio(Castillo castillo) {
        return DANIO_A_EDIFICIOS;
    }
}
