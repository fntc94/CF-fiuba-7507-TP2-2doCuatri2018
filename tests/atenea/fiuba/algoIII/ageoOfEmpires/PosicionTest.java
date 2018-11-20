package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PosicionTest {

    @Test
    public void testDevuelveTrueSiPosicionEstaDentroDeUnAreaDefinidaPorAltoAncho(){
        Posicion pos = new PosicionDeUnCasillero(5,5);
        boolean estaDentro = pos.estaDentroDelArea(10,10);

        assertEquals(true, estaDentro);
    }

    @Test
    public void testDevuelveFalseSiPosicionEstaFueraDeUnAreaDefinidaPorAltoAncho(){
        Posicion pos = new PosicionDeUnCasillero(20,20);
        boolean estaDentro = pos.estaDentroDelArea(10,10);

        assertEquals(false, estaDentro);
    }

    @Test
    public void testIncrementaCoordenadaEnX(){
        Posicion pos = new PosicionDeUnCasillero(1,1);
        pos.setMapa(new Mapa(20,30));
        Posicion otraPos = pos.modificarCoordenada(1,0);

        assertEquals(true, otraPos.seSuperponeCon(new PosicionDeUnCasillero(2,1)));
    }

    @Test
    public void testIncrementaCoordenadaEnY(){
        Posicion pos = new PosicionDeUnCasillero(1,1);
        pos.setMapa(new Mapa(20,30));
        Posicion otraPos = pos.modificarCoordenada(0,1);

        assertEquals(true, otraPos.seSuperponeCon(new PosicionDeUnCasillero(1,2)));
    }
}
