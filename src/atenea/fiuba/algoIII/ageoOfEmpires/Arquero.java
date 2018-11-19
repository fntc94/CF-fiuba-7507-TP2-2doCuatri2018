package atenea.fiuba.algoIII.ageoOfEmpires;

public class Arquero extends UnidadMilitar implements IPosicionable, IAtacable, IAtacante {

    private static final int VIDA_MAXIMA = 75;
    private static final int DANIO_A_UNIDAD = 15;
    private static final int DANIO_A_EDIFICIO = 10;
    private static final int RANGO_DE_ATAQUE = 3;

    public Arquero(Posicion posicion){
        super(posicion, VIDA_MAXIMA, DANIO_A_UNIDAD, DANIO_A_EDIFICIO, RANGO_DE_ATAQUE);
    }

//    // IAtacante
//    @Override
//    public void atacar(IAtacable unidad){
//
//        if(!estaDentroDelRangoDeAtaque(unidad)){
//            throw new UnidadFueraDeRangoDeAtaqueExcepcion();
//        }
//        unidad.recibirAtaque(this);
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
//    // fin IAtacante
//
//    private boolean estaDentroDelRangoDeAtaque(IPosicionable unidad){
//        return this.getPosicion().distanciaA(unidad.getPosicion()) <= RANGO_DE_ATAQUE;
//    }

}
