package modelo.unidades;

import modelo.EstrategiaAtaque;

public class EstrategiaAtaqueEspadachin extends EstrategiaAtaque<Espadachin> {

    private final static int DANIO_A_UNIDAD = 25;
    private final static int DANIO_A_EDIFICIO = 15;
    private final static int RANGO_DE_ATAQUE = 1;

    public EstrategiaAtaqueEspadachin(){
        super(RANGO_DE_ATAQUE, DANIO_A_UNIDAD, DANIO_A_EDIFICIO);
    }
}
