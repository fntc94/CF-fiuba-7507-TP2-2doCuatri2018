package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArqueroTest {

    @Test
    public void getVida_Devuelve75(){

        Arquero arquero = new Arquero();
        assertEquals(75, arquero.getVida());
    }

    @Test
    public void getCosto_Devuelve75(){

        Arquero arquero = new Arquero();
        assertEquals(75, arquero.getCosto());

    }
}
