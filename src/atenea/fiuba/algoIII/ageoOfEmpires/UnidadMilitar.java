package atenea.fiuba.algoIII.ageoOfEmpires;

public abstract class UnidadMilitar extends Unidad implements IAtacante {

    private final int DANIO_A_UNIDAD ;
    private final int DANIO_A_EDIFICIO ;
    private final int RANGO_DE_ATAQUE;

    public UnidadMilitar(Posicion posicion, int vida, int danioAUnidad, int danioAEdificio, int rangoDeAtaque){
        super(posicion, vida);
        this.DANIO_A_EDIFICIO = danioAEdificio;
        this.DANIO_A_UNIDAD = danioAUnidad;
        this.RANGO_DE_ATAQUE = rangoDeAtaque;

    }

    // IAtacante
    @Override
    public void atacar(IAtacable unidad){

        if(!estaDentroDelRangoDeAtaque(unidad)){
            throw new UnidadFueraDeRangoDeAtaqueExcepcion();
        }
        unidad.recibirAtaque(this);
    }

    @Override
    public int obtenerDanio(Unidad unidad) {
        return DANIO_A_UNIDAD;
    }

    @Override
    public int obtenerDanio(Edificio edificio) {
        return DANIO_A_EDIFICIO;
    }
    // fin IAtacante

    private boolean estaDentroDelRangoDeAtaque(IPosicionable unidad){
        return this.getPosicion().distanciaA(unidad.getPosicion()) <= RANGO_DE_ATAQUE;
    }


}
