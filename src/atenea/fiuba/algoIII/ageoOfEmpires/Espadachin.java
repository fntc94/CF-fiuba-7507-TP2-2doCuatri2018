package atenea.fiuba.algoIII.ageoOfEmpires;

public class Espadachin extends Unidad implements IPosicionable, IAtacable, IAtacante {

    private final static int VIDA_MAXIMA = 100;
    private final static int DANIO_A_UNIDAD = 25;
    private final static int DANIO_A_EDIFICIO = 15;
    private final static int RANGO_DE_ATAQUE = 1;


    public Espadachin(Posicion posicion){
        super(posicion, VIDA_MAXIMA);
    }


    public void atacar(IAtacable unidad){

        if(!estaDentroDelRangoDeAtaque(unidad)){
            throw new UnidadFueraDeRangoDeAtaqueExcepcion();
        }
        unidad.recibirAtaque(this);
    }


    private boolean estaDentroDelRangoDeAtaque(IPosicionable unidad){
        return this.getPosicion().distanciaA(unidad.getPosicion()) <= RANGO_DE_ATAQUE;
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

    @Override
    public int obtenerDanio(Unidad unidad) {
        return DANIO_A_UNIDAD;
    }

}
