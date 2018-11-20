package atenea.fiuba.algoIII.ageoOfEmpires;

public class EstrategiaAtaqueArquero extends EstrategiaAtaque {

    private static final int DANIO_A_UNIDAD = 15;
    private static final int DANIO_A_EDIFICIO = 10;
    private static final int RANGO_DE_ATAQUE = 3;

    public EstrategiaAtaqueArquero() {
        super(RANGO_DE_ATAQUE, DANIO_A_UNIDAD, DANIO_A_EDIFICIO);
    }
}
