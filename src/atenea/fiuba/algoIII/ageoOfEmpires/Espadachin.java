package atenea.fiuba.algoIII.ageoOfEmpires;

public class Espadachin extends UnidadMilitar implements IPosicionable, IAtacable, IAtacante {

    private final static int VIDA_MAXIMA = 100;
    private final static int DANIO_A_UNIDAD = 25;
    private final static int DANIO_A_EDIFICIO = 15;
    private final static int RANGO_DE_ATAQUE = 1;


    public Espadachin(Posicion posicion){
        super(posicion, VIDA_MAXIMA, DANIO_A_UNIDAD, DANIO_A_EDIFICIO, RANGO_DE_ATAQUE);
    }

}
