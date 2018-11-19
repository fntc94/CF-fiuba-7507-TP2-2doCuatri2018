package atenea.fiuba.algoIII.ageoOfEmpires;

public class ArmaDeAsedio extends UnidadMilitar implements IPosicionable, IAtacable, IAtacante {

    private final static int VIDA_MAXIMA = 150;
    private final static int DANIO_A_UNIDAD = 0;
    private final static int DANIO_A_EDIFICIO = 75;
    private final static int RANGO_DE_ATAQUE = 5;

    private IEstadoArmaDeAsedio _estado = new EstadoArmaDeAsedioDesmontada();


    public ArmaDeAsedio(Posicion posicion){
        super(posicion, VIDA_MAXIMA, DANIO_A_UNIDAD, DANIO_A_EDIFICIO, RANGO_DE_ATAQUE);
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

//    @Override
//    public void atacar(IAtacable atacable) {
//        if(!estaDentroDelRangoDeAtaque(atacable)){
//            throw new UnidadFueraDeRangoDeAtaqueExcepcion();
//        }
//        atacable.recibirAtaque(this);
//    }
//
//    @Override
//    public int obtenerDanio(Unidad unidad) {
//        return DANIO_A_UNIDAD;
//    }
//
//    @Override
//    public int obtenerDanio(Edificio edificio) {
//        return DANIO_A_EDIFICIO;
//    }
//
//    private boolean estaDentroDelRangoDeAtaque(IPosicionable unidad){
//        return this.getPosicion().distanciaA(unidad.getPosicion()) <= RANGO_DE_ATAQUE;
//    }

}
