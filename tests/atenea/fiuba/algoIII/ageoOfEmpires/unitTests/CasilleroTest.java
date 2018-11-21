package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Casillero;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.PosicionDeUnCasillero;
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
