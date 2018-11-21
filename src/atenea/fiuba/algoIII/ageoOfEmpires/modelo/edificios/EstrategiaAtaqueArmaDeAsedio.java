package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.EstrategiaAtaque;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.ArmaDeAsedio;

public class EstrategiaAtaqueArmaDeAsedio extends EstrategiaAtaque<ArmaDeAsedio> {

    private final static int DANIO_A_UNIDAD = 0;
    private final static int DANIO_A_EDIFICIO = 75;
    private final static int RANGO_DE_ATAQUE = 5;


    public EstrategiaAtaqueArmaDeAsedio(){
        super(RANGO_DE_ATAQUE, DANIO_A_UNIDAD, DANIO_A_EDIFICIO);
    }

//    @Override
//    public void ejecutarAtaque(ArmaDeAsedio armaDeAsedio, IAtacable atacado){
//
//        if(!armaDeAsedio.estaMontada()){
//            throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
//        }
//        super.ejecutarAtaque(armaDeAsedio, atacado);
//
//    }

}
