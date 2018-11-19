package atenea.fiuba.algoIII.ageoOfEmpires;

public class Espadachin extends Unidad implements IPosicionable, IAtacable, IAtacante {

    private final static int VIDA_MAXIMA = 100;
    private final static int DANIO_A_UNIDAD = 25;
    private final static int DANIO_A_EDIFICIO = 15;
    private final static int RANGO_DE_ATAQUE = 1;


    public Espadachin(Posicion posicion){
        super(posicion, VIDA_MAXIMA);
    }

    // IAtacante
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
    public int obtenerDanio(Edificio edificioReparable) {
        return DANIO_A_EDIFICIO;
    }
    // fin IAtacante

    private boolean estaDentroDelRangoDeAtaque(IPosicionable unidad){
        return this.getPosicion().distanciaA(unidad.getPosicion()) <= RANGO_DE_ATAQUE;
    }
}
