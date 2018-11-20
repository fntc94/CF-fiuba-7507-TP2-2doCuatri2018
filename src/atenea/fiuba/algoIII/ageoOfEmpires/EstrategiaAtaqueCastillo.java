package atenea.fiuba.algoIII.ageoOfEmpires;

public class EstrategiaAtaqueCastillo extends EstrategiaAtaque<Castillo> {

    private static final int RANGO_DE_ATAQUE = 3;
    private static final int DANIO = 20;

    public EstrategiaAtaqueCastillo(){
        super(RANGO_DE_ATAQUE, DANIO, DANIO);
    }
}
