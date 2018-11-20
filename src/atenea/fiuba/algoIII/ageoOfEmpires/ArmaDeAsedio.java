package atenea.fiuba.algoIII.ageoOfEmpires;

public class ArmaDeAsedio extends Unidad implements IPosicionable, IAtacable, IAtacante {

    private final static int VIDA_MAXIMA = 150;
    private final static int DANIO_A_UNIDADES = 0;
    private final static int DANIO_A_EDIFICIOS = 75;
    private final int RANGO_DE_ATAQUE = 5;

    private IEstadoArmaDeAsedio _estado = new EstadoArmaDeAsedioDesmontada();


    public ArmaDeAsedio(Posicion posicion){
        super(posicion, VIDA_MAXIMA);
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

    @Override
    public void atacar(IAtacable atacable) {
        if(!estaDentroDelRangoDeAtaque(atacable)){
            throw new UnidadFueraDeRangoDeAtaqueExcepcion();
        }
        atacable.recibirAtaque(this);
    }

    @Override
    public int obtenerDanio(Unidad unidad) {
        return DANIO_A_UNIDADES;
    }

    @Override
    public int obtenerDanio(Edificio edificio) {
        return DANIO_A_EDIFICIOS;
    }

    private boolean estaDentroDelRangoDeAtaque(IPosicionable unidad){
        return this.getPosicion().distanciaA(unidad.getPosicion()) <= RANGO_DE_ATAQUE;
    }

}
