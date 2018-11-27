package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IPosicionable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.*;
import org.junit.Test;

public class PosicionarUnidadesEnMapaTest {

    private Mapa mapa = new Mapa(20,30);

    @Test
    public void testColocarUnidadDentroDelMapaNoLanzaException(){
        Posicion posAldeano = new PosicionDeUnCasillero(mapa,5,5);
        IPosicionable aldeano = new Aldeano(posAldeano);

        mapa.posicionar(aldeano);
    }

    @Test (expected = NoPuedeColocarPosicionablesFueraDelMapaException.class)
    public void testColocarUnidadFueraDelMapaLanzaException(){
        Posicion posArquero = new PosicionDeUnCasillero(mapa,31,25);
        IPosicionable arquero = new Aldeano(posArquero);

        mapa.posicionar(arquero);
    }

    @Test
    public void testColocarUnidadEnEsquinaDelMapaNoLanzaException(){
        Posicion posArquero = new PosicionDeUnCasillero(mapa,0,0);
        IPosicionable arquero = new Aldeano(posArquero);

        mapa.posicionar(arquero);
    }

    @Test (expected = NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class)
    public void testPosicionarUnidadEnUnaPosicionOcupadaPorOtraUnidadLanzaException(){
        Posicion posArmaDeAsedio = new PosicionDeUnCasillero(mapa,7,7);
        Posicion posEspadachin = new PosicionDeUnCasillero(mapa,7,7);

        IPosicionable armaDeAsedio = new ArmaDeAsedio(posArmaDeAsedio, new EstrategiaAtaqueArmaDeAsedio());
        IPosicionable espadachin = new Espadachin(posEspadachin, new EstrategiaAtaqueEspadachin());

        mapa.posicionar(armaDeAsedio);
        mapa.posicionar(espadachin);
    }


    @Test (expected = NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class)
    public void testPosicionarUnidadEnUnaPosicionOcupadaPorUnEdificioLanzaException(){
        Posicion posArmaDeAsedio = new PosicionDeUnCasillero(mapa,6,4);
        Posicion posCuartel = new PosicionCuadrado(5,5,6,4);

        IPosicionable armaDeAsedio = new ArmaDeAsedio(posArmaDeAsedio, new EstrategiaAtaqueArmaDeAsedio());
        IPosicionable cuartel = new Cuartel(posCuartel, new UnidadesFabrica());

        mapa.posicionar(armaDeAsedio);
        mapa.posicionar(cuartel);
    }

    @Test (expected = NoPuedeColocarPosicionablesFueraDelMapaException.class)
    public void testColocarCastilloDejando2FilasDeCasillerosAFueraDelMapaLanzaException(){
        Posicion posCastillo = new PosicionCuadrado(29,6,32,3);

        IPosicionable castillo = new Castillo(posCastillo, new UnidadesFabrica(), new EstrategiaAtaqueCastillo());

        mapa.posicionar(castillo);
    }
}
