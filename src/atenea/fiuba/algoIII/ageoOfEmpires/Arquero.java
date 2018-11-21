package atenea.fiuba.algoIII.ageoOfEmpires;

public class Arquero extends Unidad implements IPosicionable, IAtacable, IAtacante {

    private static final int VIDA_MAXIMA = 75;
    private static final int DANIO_A_UNIDAD = 15;
    private static final int DANIO_A_EDIFICIO = 10;

    public Arquero(Posicion posicion){
        super(posicion, VIDA_MAXIMA);
    }

    // IAtacante
    @Override
    public void atacar(IAtacable unidad){
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


}
