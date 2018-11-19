package atenea.fiuba.algoIII.ageoOfEmpires;

public class Arquero extends UnidadMilitar implements IPosicionable, IAtacable, IAtacante {

    private static final int VIDA_MAXIMA = 75;
    private static final int DANIO_A_UNIDAD = 15;
    private static final int DANIO_A_EDIFICIO = 10;
    private static final int RANGO_DE_ATAQUE = 3;

    public Arquero(Posicion posicion){
        super(posicion, VIDA_MAXIMA, DANIO_A_UNIDAD, DANIO_A_EDIFICIO, RANGO_DE_ATAQUE);
    }

}
