package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PosicionTest {

    @Test
    public void testDevuelveTrueSiLasPosicionesSonIguales(){
        Posicion posicion = new Posicion(3,3);
        Posicion otraPosicion = new Posicion(3,3);

        boolean sonIguales = posicion.equals(otraPosicion);

        assertEquals(true, sonIguales);
    }

    @Test
    public void testDevuelveFalseSiLasPosicionesSonDiferentes(){
        Posicion posicion = new Posicion(3,3);
        Posicion otraPosicion = new Posicion(10,70);

        boolean sonIguales = posicion.equals(otraPosicion);

        assertEquals(false, sonIguales);
    }
}
