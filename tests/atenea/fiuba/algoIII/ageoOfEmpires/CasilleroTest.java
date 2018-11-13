package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CasilleroTest {

    @Test
    public void testDevuelveFalseSiQuieroComparaUnaPosicionConOtroObjeto(){
        Casillero casillero = new Casillero(10,10);

        assertEquals(false, casillero.equals(new PosicionDeUnCasillero(2,2)));
    }

    @Test
    public void testDevuelveTrueSiSeComparaConElMismoCasilleroObjeto(){
        Casillero casillero = new Casillero(10,10);

        assertEquals(true, casillero.equals(casillero));
    }
}
