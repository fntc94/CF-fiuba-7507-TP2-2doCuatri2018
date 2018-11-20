package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PosicionTest {

    private Mapa mapa = new Mapa(20,30);

    @Test
    public void testDevuelveTrueSiPosicionEstaDentroDeUnAreaDefinidaPorAltoAncho(){
        Posicion pos = new PosicionDeUnCasillero(mapa,5,5);
        boolean estaDentro = pos.estaDentroDelArea(10,10);

        assertEquals(true, estaDentro);
    }

    @Test
    public void testDevuelveFalseSiPosicionEstaFueraDeUnAreaDefinidaPorAltoAncho(){
        Posicion pos = new PosicionDeUnCasillero(mapa,20,20);
        boolean estaDentro = pos.estaDentroDelArea(10,10);

        assertEquals(false, estaDentro);
    }

    @Test
    public void testIncrementaCoordenadaEnX(){
        Posicion pos = new PosicionDeUnCasillero(mapa,1,1);
        Posicion otraPos = pos.modificarCoordenada(1,0);

        assertEquals(true, otraPos.seSuperponeCon(new PosicionDeUnCasillero(mapa,2,1)));
    }

    @Test
    public void testIncrementaCoordenadaEnY(){
        Posicion pos = new PosicionDeUnCasillero(mapa,1,1);
        Posicion otraPos = pos.modificarCoordenada(0,1);

        assertEquals(true, otraPos.seSuperponeCon(new PosicionDeUnCasillero(mapa,1,2)));
    }
}
