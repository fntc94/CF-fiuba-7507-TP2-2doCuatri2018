package atenea.fiuba.algoIII.ageoOfEmpires;

public class Arquero extends UnidadMilitar implements IPosicionable, IAtacable, IAtacante {

    private static final int VIDA_MAXIMA = 75;

    public Arquero(Posicion posicion, IEstrategiaAtaque estrategiaAtaque){
        super(posicion, VIDA_MAXIMA, estrategiaAtaque);
    }

}
