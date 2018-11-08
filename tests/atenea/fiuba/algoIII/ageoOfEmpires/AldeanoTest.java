package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AldeanoTest {

    @Test
    public void getVida_Devuelve50(){

        Aldeano aldeano = new Aldeano();
        assertEquals(50, aldeano.getVida());
    }

    @Test
    public void getCosto_Devuelve25(){

        Aldeano aldeano = new Aldeano();
        assertEquals(25, aldeano.getCosto());
    }

}